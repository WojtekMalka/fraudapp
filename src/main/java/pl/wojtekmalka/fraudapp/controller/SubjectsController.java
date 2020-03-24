package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wojtekmalka.fraudapp.form.*;
import pl.wojtekmalka.fraudapp.service.CreateService;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/subjectsManager")
public class SubjectsController {
    private final CreateService createService;

    public SubjectsController(CreateService createService) {
        this.createService = createService;
    }

    @RequestMapping
    public ModelAndView getSubcjectsManagerPage() {
        ModelAndView mnv = new ModelAndView("subjectsManager");
        mnv.addObject("subjectsManager");
        return mnv;
    }

    @GetMapping("/addPerson")
    public ModelAndView getAddPersonPage() {
        ModelAndView mnv = new ModelAndView("createPerson");
        mnv.addObject("addPerson", new PersonForm());
        return mnv;
    }

    @PostMapping("/addPerson")
    public String addPerson(@ModelAttribute("addPerson") PersonForm form) {
        createService.addPerson(form);
        return "redirect:/";
    }

    @GetMapping("/addCompany")
    public ModelAndView getAddCompanyPage() {
        ModelAndView mnv = new ModelAndView("createCompany");
        mnv.addObject("addCompany", new CompanyForm());
        return mnv;
    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute("addCompany") CompanyForm form) {
        createService.addCompany(form);
        return "redirect:/subjectsManager";
    }

    @GetMapping("/viewPersonEntities")
    public ModelAndView getViewPersonEntitiesPage() {
        ModelAndView mnv = new ModelAndView("viewPersonEntities");
        mnv.addObject("viewPersonEntities", createService.getAll());
        return mnv;
    }
}
