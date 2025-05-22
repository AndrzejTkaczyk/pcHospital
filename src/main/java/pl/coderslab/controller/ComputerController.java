package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ComputerDao;
import pl.coderslab.dao.RepairDao;
import pl.coderslab.domain.Computer;
import pl.coderslab.domain.Repair;
import pl.coderslab.domain.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/app")
public class ComputerController {

    private final ComputerDao computerDao;
    private final RepairDao repairDao;

    public ComputerController(ComputerDao computerDao, RepairDao repairDao) {
        this.computerDao = computerDao;
        this.repairDao = repairDao;
    }

    @RequestMapping("/")
    public String displayHome() {
        return "user/index";
    }

    @GetMapping("/user/computerList")
    public String userComputerList(Model model, HttpSession session) {
        model.addAttribute("computers", computerDao.findUserComputers(((User) session.getAttribute("user")).getId()));
        return "user/computerList";
    }

    @GetMapping("/user/computerAdd")
    public String userComputerAdd(Model model) {
        model.addAttribute("computer", new Computer());
        return "user/computerAdd";
    }

    @PostMapping("/user/computerAdd")
    public String userComputerAdd(@Valid Computer computer, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "user/computerAdd";
        }
        computer.setStatus(1);
        if (computer.getId() != null) {
            computerDao.updateComputer(computer);
        } else {
            User client = (User) session.getAttribute("user");
            computer.setClient(client);
            computerDao.saveComputer(computer);
        }
        return "redirect:/app/user/computerList";
    }

    @GetMapping("/user/computerEdit/{id}")
    public String userComputerEdit(@PathVariable long id, Model model) {
        Computer computer = computerDao.findById(id);
        model.addAttribute("computer", computer);
        return "user/computerAdd";
    }

    @GetMapping("/user/computerDelete/{id}")
    public String userComputerDelete(@PathVariable long id) {
        for (Repair repair : repairDao.findRepairsByComputerId(id)) {
            if (repair.getStatus() == 1) {
                repairDao.deleteRepair(repair);
            }
        }
        if (repairDao.findRepairsByComputerId(id).isEmpty()) {
            computerDao.deleteComputer(computerDao.findById(id));
        } else {
            Computer computer = computerDao.findById(id);
            computer.setStatus(0);
            computerDao.updateComputer(computer);
        }
        return "redirect:/app/user/computerList";
    }
}
