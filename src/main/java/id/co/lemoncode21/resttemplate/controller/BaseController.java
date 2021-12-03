package id.co.lemoncode21.resttemplate.controller;

import id.co.lemoncode21.resttemplate.services.GovernmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    private GovernmentService governmentService;

    @GetMapping("/")
    public String Home() {
        return "Helo Home";
    }

    @GetMapping("/getAll")
    public Object getAll() {
        try {
            return this.governmentService.getAllData();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
