package com.example.AddressBook;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressBookGui")
    public String addressBookGui(@RequestParam(name="x", required=false, defaultValue="") String id, Model model) throws JsonProcessingException {
        String result;
        if (id.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            addressBookRepository.findAll().forEach(builder::append);
            result = builder.toString();
        } else {
            result = addressBookRepository.findById(Long.parseLong(id)).toString();
        }
        model.addAttribute("addressBook", result);
        return "addressBookGui";
    }
}
