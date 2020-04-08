package pl.wojtekmalka.fraudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.wojtekmalka.fraudapp.entities.Company;
import pl.wojtekmalka.fraudapp.form.CompanyForm;
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
    public ModelAndView getCompanyEntityEditorPage(@PathVariable long id) {
        ModelAndView mnv = new ModelAndView("companyEntityEditor");
        Company companyByCompanyId = createService.findCompanyByCompanyId(id);
        CompanyForm companyFormWithEntityData = new CompanyForm();
        companyFormWithEntityData.setCompanyID(companyByCompanyId.getCompanyId());
        companyFormWithEntityData.setNIP(companyByCompanyId.getNIP());
        companyFormWithEntityData.setCompanyName(companyByCompanyId.getCompanyName());
        companyFormWithEntityData.setFraudStatus(companyByCompanyId.getFraudStatus());
        companyFormWithEntityData.setCompanyAddress(companyByCompanyId.getAddress());
        mnv.addObject("companyFormWithEntityData", companyFormWithEntityData);
        return mnv;
    }

    @PostMapping("/edit/{id}")
    public String editCompanyEntity(@PathVariable("id") long id, @ModelAttribute("companyFormWithEntityData") CompanyForm form) {
        createService.updateCompanyEntity(id, form);
        return "redirect:/subjectsManager";
    }
}
