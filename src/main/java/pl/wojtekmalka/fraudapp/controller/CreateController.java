package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.wojtekmalka.fraudapp.form.CompanyForm;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.service.CreateService;

@Controller
@RequestMapping("/create")
public class CreateController {
    private final CreateService createService;

    public CreateController(CreateService createService) {
        this.createService = createService;
    }

    @RequestMapping
    public ModelAndView getCreatePage() {
        ModelAndView mnv = new ModelAndView("create");
        mnv.addObject("create");
        return mnv;
    }

    @GetMapping("/addPerson")
    public ModelAndView addPersonPage() {
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
    public ModelAndView addCompanyPage(){
        ModelAndView mnv = new ModelAndView("createCompany");
        mnv.addObject("addCompany", new CompanyForm());
        return mnv;
    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute("addCompany") CompanyForm form){
        createService.addCompany(form);
        return "redirect:/create";
    }
}
