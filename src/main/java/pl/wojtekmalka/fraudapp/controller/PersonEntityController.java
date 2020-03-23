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

    @GetMapping("/{personId}/remove")
    @Transactional
    public String removePerson(@PathVariable long personId) {
        createService.deleteAllPersonsByPersonId(personId);
        return "redirect:/subjectsManager";
    }

    @GetMapping("/{personId}/edit")
    public ModelAndView getPersonEntityEditorPage(@PathVariable long personId) {
        ModelAndView mnv = new ModelAndView("personEntityEditor");
        Person personByPersonId = createService.findPersonByPersonId(personId);
        mnv.addObject("personByPersonId", personByPersonId);
        return mnv;
    }

    @PostMapping("/{personId}/edit")
    @Transactional
    public String editPersonEntity(@PathVariable long personId, @ModelAttribute("personByPersonId") PersonForm form) {
        createService.updatePersonEntity(personId, form);
        return "redirect:/subjectsManager";
    }
}
