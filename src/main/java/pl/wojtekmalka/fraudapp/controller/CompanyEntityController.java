package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.service.CreateService;

@Controller
@RequestMapping("/companyEntity")
public class CompanyEntityController {
    private final CreateService createService;

    public CompanyEntityController(CreateService createService) {
        this.createService = createService;
    }

    @GetMapping("/remove/{id}")
    public String removeCompany(@PathVariable long id) {
        createService.deleteAllCompaniesByCompanyId(id);
        return "redirect:/subjectsManager";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getPersonEntityEditorPage(@PathVariable long id) {
        ModelAndView mnv = new ModelAndView("personEntityEditor");
        Person personByPersonId = createService.findPersonByPersonId(id);
        PersonForm personFormWithEntityData = new PersonForm();
        personFormWithEntityData.setFirstName(personByPersonId.getFirstName());
        personFormWithEntityData.setLastName(personByPersonId.getLastName());
        personFormWithEntityData.setFraudStatus(personByPersonId.getFraudStatus());
        personFormWithEntityData.setPESEL(personByPersonId.getPESEL());
        personFormWithEntityData.setPersonID(personByPersonId.getPersonId());
        personFormWithEntityData.setPersonAddress(personByPersonId.getAddress());
        mnv.addObject("personFormWithEntityData", personFormWithEntityData);
        return mnv;
    }

    @PostMapping("/edit/{id}")
    public String editPersonEntity(@PathVariable("id") long id, @ModelAttribute("personFormWithEntityData") PersonForm form) {
        createService.updatePersonEntity(id, form);
        return "redirect:/subjectsManager";
    }
}
