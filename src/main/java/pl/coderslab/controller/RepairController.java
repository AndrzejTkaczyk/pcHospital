package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ComputerDao;
import pl.coderslab.dao.RepairDao;
import pl.coderslab.dao.RepairDetailsDao;
import pl.coderslab.domain.Repair;
import pl.coderslab.domain.RepairDetails;
import pl.coderslab.domain.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute("repairs", repairDao.findAll());
        return "user/repairListEmployee";
    }

    @GetMapping("/employee/repairsEmployee")
    public String repairsEmployee(Model model, HttpSession session) {
        model.addAttribute("repairsDetails", repairDetailsDao.findEmployeeRepairsByIdEmployee(((User) session.getAttribute("user")).getId()));
        return "user/repairsEmployee";
    }

    @GetMapping("/employee/repairDetailsEmployee/{id}")
    public String repairDetailsEmployee(@PathVariable long id, Model model) {
        model.addAttribute("repairsDetails", repairDetailsDao.findRepairDetailsById(id));
        return "user/repairDetailsEmployee";
    }


    @GetMapping("/employee/repairEnd/{id}")
    public String repairEnd(@PathVariable long id) {
        List<RepairDetails> list = repairDetailsDao.findRepairDetailsById(id);
        boolean check = list.stream()
                .anyMatch(result -> result.getStatus() == 1);
        if (check) {
            return "user/error";
        } else {
            Repair repair = repairDao.findById(id);
            repair.setStatus(2);
            repair.setDateOfEnd(LocalDateTime.now());
            repairDao.updateRepair(repair);
            return "redirect:/app/employee/repairListEmployee";
        }
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
        if (repairDetails.getId() != null) {
            repairDetailsDao.updateRepairDetails(repairDetails);
        } else {
            User employee = (User) session.getAttribute("user");
            repairDetails.setEmployee(employee);
            Repair byId = repairDao.findById(repairDetails.getRepair().getId());
            byId.setStatus(repairDetails.getStatus());
            repairDao.saveRepair(byId);
            repairDetailsDao.saveRepairDetails(repairDetails);
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

    @GetMapping("/user/repairList")
    public String userRepairList(Model model, HttpSession session) {
        model.addAttribute("repairs", repairDao.findUserRepairs(((User) session.getAttribute("user")).getId()));
        model.addAttribute("computers", computerDao.findUserComputers(((User) session.getAttribute("user")).getId()));
        return "user/repairList";
    }

    @GetMapping("/user/repairDetailsUser/{id}")
    public String repairDetailsUser(@PathVariable long id, Model model) {
        model.addAttribute("repairsDetails", repairDetailsDao.findRepairDetailsById(id));
        return "user/repairDetailsUser";
    }

    @GetMapping("/user/repairAdd")
    public String userRepairAdd(Model model, HttpSession session) {
        model.addAttribute("repair", new Repair());
        model.addAttribute("computers", computerDao.findUserComputers(((User) session.getAttribute("user")).getId()));
        return "user/repairAdd";
    }

    @PostMapping("/user/repairAdd")
    public String userRepairAdd(@Valid Repair repair, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "user/repairAdd";
        }
        if (repair.getId() != null) {
            repair.setDateOfOrder(LocalDateTime.now());
            repairDao.updateRepair(repair);
        } else {
            User client = (User) session.getAttribute("user");
            repair.setClient(client);
            repair.setDateOfOrder(LocalDateTime.now());
            repair.setStatus(1);
            repairDao.saveRepair(repair);
        }
        return "redirect:/app/user/repairList";
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
        return "redirect:/app/user/repairList";
    }
}
