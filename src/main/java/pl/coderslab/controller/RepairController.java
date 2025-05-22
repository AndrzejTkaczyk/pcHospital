package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ComputerDao;
import pl.coderslab.dao.RepairDao;
import pl.coderslab.dao.RepairDetailsDao;
import pl.coderslab.domain.Computer;
import pl.coderslab.domain.Repair;
import pl.coderslab.domain.RepairDetails;
import pl.coderslab.domain.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/app")
public class RepairController {
    private final RepairDao repairDao;
    private final ComputerDao computerDao;
    private final RepairDetailsDao repairDetailsDao;

    public RepairController(RepairDao repairDao, ComputerDao computerDao, RepairDetailsDao repairDetailsDao) {
        this.repairDao = repairDao;
        this.computerDao = computerDao;
        this.repairDetailsDao = repairDetailsDao;
    }

    @GetMapping("/employee/repairListEmployee")
    public String repairListEmployee(Model model) {
        model.addAttribute("repairs", repairDao.findAllRepairWithRepairDetails());
        return "user/repairListEmployee";
    }

    @GetMapping("/employee/repairsEmployee")
    public String repairsEmployee(Model model, HttpSession session) {
        model.addAttribute("repairsDetails", repairDetailsDao.findEmployeeRepairsByIdEmployee(((User) session.getAttribute("user")).getId()));
        return "user/repairsEmployee";
    }

    @GetMapping("/employee/repairDetailsEmployee/{id}")
    public String repairDetailsEmployee(@PathVariable long id, Model model) {
        model.addAttribute("repairsDetails", repairDetailsDao.findRepairsDetailsByRepairId(id));
        return "user/repairDetailsEmployee";
    }

    @GetMapping("/employee/repairAddEmployee/{id}")
    public String repairAddEmployee(@PathVariable long id, Model model) {
        model.addAttribute("repairDetails", new RepairDetails());
        Repair repair = repairDao.findById(id);
        model.addAttribute("repair", repair);
        return "user/repairAddEmployee";
    }

    @Transactional
    @PostMapping("/employee/repairAddEmployee")
    public String repairAddEmployeeToRepair(@Valid RepairDetails repairDetails, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "user/repairAddEmployee";
        }
        Repair repair = repairDao.findById(repairDetails.getRepair().getId());
        Computer computer = computerDao.findById(repair.getComputer().getId());
        User employee = (User) session.getAttribute("user");
        if (repairDetails.getId() != null) {
            repairDetails.setEmployee(employee);
            if (repairDetails.getStatus() == 3) {
                repair.setDateOfEnd(LocalDateTime.now());
            }
            repairDetailsDao.updateRepairDetails(repairDetails);
            repair.setStatus(repairDetails.getStatus());
            repairDao.updateRepair(repair);
            computer.setStatus(repairDetails.getStatus());
            computerDao.updateComputer(computer);
        } else {
            repairDetails.setEmployee(employee);
            repairDetailsDao.saveRepairDetails(repairDetails);
            repair.setStatus(repairDetails.getStatus());
            if (repairDetails.getStatus() == 3) {
                repair.setDateOfEnd(LocalDateTime.now());
            }
            repairDao.updateRepair(repair);
            computer.setStatus(repairDetails.getStatus());
            computerDao.updateComputer(computer);
        }
        return "redirect:/app/employee/repairListEmployee";
    }

    @GetMapping("/employee/repairEditEmployeeRepair/{id}")
    public String repairEditEmployeeRepair(@PathVariable long id, Model model) {
        model.addAttribute("repairDetails", repairDetailsDao.findOneRepairDetailsById(id));
        model.addAttribute("repair", repairDao.findById(id));
        return "user/repairAddEmployee";
    }

//    -----------------------------------

    @GetMapping("/user/repairDetailsUser/{id}")
    public String repairDetailsUser(@PathVariable long id, Model model) {
        model.addAttribute("repairsDetails", repairDetailsDao.findOneRepairDetailsById(id));
        return "user/repairDetailsUser";
    }

    @GetMapping("/user/repairAdd/{id}")
    public String userRepairAdd(@PathVariable long id, Model model) {
        Repair repair = new Repair();
        repair.setComputer(computerDao.findById(id));
        model.addAttribute("repair", repair);
        return "user/repairAdd";
    }

    @PostMapping("/user/repairAdd")
    public String userRepairAdd(@Valid Repair repair, BindingResult result) {
        if (result.hasErrors()) {
            return "user/repairAdd";
        }
        repair.setDateOfOrder(LocalDateTime.now());
        repair.setStatus(1);
        if (repair.getId() != null) {
            repairDao.updateRepair(repair);
        } else {
            repairDao.saveRepair(repair);
        }
        return "redirect:/app/user/computerList";
    }

    @GetMapping("/user/repairEdit/{id}")
    public String userRepairEdit(@PathVariable long id, Model model) {
        Repair repair = repairDao.findById(id);
        model.addAttribute("repair", repair);
        return "user/repairAdd";
    }

    @GetMapping("/user/repairDelete/{id}")
    public String userRepairDelete(@PathVariable long id) {
        repairDao.deleteRepair(repairDao.findById(id));
        return "redirect:/app/user/computerList";
    }
}
