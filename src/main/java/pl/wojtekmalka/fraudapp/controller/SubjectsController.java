package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.wojtekmalka.fraudapp.form.CompanyForm;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.service.CreateService;

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
    public String addPerson(@ModelAttribute("addPerson") @Validated PersonForm form, Errors errors) {
        if (errors.hasErrors()) {
            return "/addPerson";
        } else
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
    public String addCompany(@ModelAttribute("addCompany") @Validated CompanyForm form, Errors errors) {
        if(errors.hasErrors()){
            return "/addCompany";
        } else
        createService.addCompany(form);
        return "redirect:/subjectsManager";
    }

    @GetMapping("/viewPersonEntities")
    public ModelAndView getViewPersonEntitiesPage() {
        ModelAndView mnv = new ModelAndView("viewPersonEntities");
        mnv.addObject("viewPersonEntities", createService.getAllPersons());
        return mnv;
    }

    @GetMapping("/viewCompanyEntities")
    public ModelAndView getViewCompanyEntitiesPage() {
        ModelAndView mnv = new ModelAndView("viewCompanyEntities");
        mnv.addObject("viewCompanyEntities", createService.getAllCompanies());
        return mnv;
    }
}
