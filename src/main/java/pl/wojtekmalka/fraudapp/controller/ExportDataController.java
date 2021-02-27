package pl.wojtekmalka.fraudapp.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wojtekmalka.fraudapp.entities.Person;
import pl.wojtekmalka.fraudapp.repository.PersonRepository;
import pl.wojtekmalka.fraudapp.service.ExportDataServiceImpl;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ExportDataController {
    private final ExportDataServiceImpl excelDataService;
    private final PersonRepository personRepository;

    public ExportDataController(ExportDataServiceImpl excelDataService, PersonRepository personRepository) {
        this.excelDataService = excelDataService;
        this.personRepository = personRepository;
    }

    @GetMapping("/excel")
    public void downloadExcel(HttpServletResponse response) throws Exception {
        String filename = "users.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");

        //create a csv writer
        StatefulBeanToCsv<Person> writer = new StatefulBeanToCsvBuilder<Person>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .withOrderedResults(false)
                .build();

        //write all users to csv file
        writer.write(personRepository.findAll());


    }
}
