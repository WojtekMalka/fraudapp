package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.form.PersonForm;
import pl.wojtekmalka.fraudapp.service.CreateService;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/personEntity")
public class PersonEntityController {
    private final CreateService createService;

    public PersonEntityController(CreateService createService) {
        this.createService = createService;
    }

    @GetMapping("/remove/{id}")
    public String removePerson(@PathVariable long id) {
        createService.deleteAllPersonsByPersonId(id);
        return "redirect:/subjectsManager";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getPersonEntityEditorPage(@PathVariable long id) {
        ModelAndView mnv = new ModelAndView("personEntityEditor");
        Person personByPersonId = createService.findPersonByPersonId(id);
        PersonForm personFormWithEntityData = new PersonForm();
        personFormWithEntityData.setPersonID(personByPersonId.getPersonId());
        personFormWithEntityData.setFirstName(personByPersonId.getFirstName());
        personFormWithEntityData.setLastName(personByPersonId.getLastName());
        personFormWithEntityData.setFraudStatus(personByPersonId.getFraudStatus());
        personFormWithEntityData.setPESEL(personByPersonId.getPESEL());
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
