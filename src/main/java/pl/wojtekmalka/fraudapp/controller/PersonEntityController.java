package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
