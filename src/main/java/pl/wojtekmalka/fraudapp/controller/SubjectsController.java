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

    @GetMapping("/removePerson")
    public ModelAndView getRemovePersonPage() {
        ModelAndView mnv = new ModelAndView("removePerson");
        mnv.addObject("removePerson", new RemovePersonForm());
        return mnv;
    }

    @PostMapping("/removePerson")
    @Transactional
    public String removePerson(@ModelAttribute("removePerson") RemovePersonForm form) {
        createService.deleteAllPersonsByPESEL(form.getPESEL());
        return "redirect:/subjectsManager";
    }

    @GetMapping("/removeCompany")
    public ModelAndView getRemoveCompanyPage() {
        ModelAndView mnv = new ModelAndView("removeCompany");
        mnv.addObject("removeCompany", new RemoveCompanyForm());
        return mnv;
    }

    @PostMapping("/removeCompany")
    @Transactional
    public String removePerson(@ModelAttribute("removeCompany") RemoveCompanyForm form) {
        createService.deleteAllCompanyByNIP(form.getNIP());
        return "redirect:/subjectsManager";
    }

    @GetMapping("/viewPerson")
    public ModelAndView getViewPersonPage() {
        ModelAndView mnv = new ModelAndView("viewPerson");
        mnv.addObject("viewPerson", new ViewPersonForm());
        return mnv;
    }

    @PostMapping("/viewPerson")
    public String viewPerson(@ModelAttribute("viewPerson") ViewPersonForm form) {
        return "redirect:/subjectsManager/viewPerson/" + form.getPESEL();
    }

    @GetMapping("/viewPerson/{PESEL}")
    public ModelAndView viewPersonEntities(@PathVariable int PESEL) {
        ModelAndView mnv = new ModelAndView("viewPersonEntities");
        mnv.addObject("viewPersonEntities", createService.findAllPersonsByPESEL(PESEL));
        return mnv;
    }
}
