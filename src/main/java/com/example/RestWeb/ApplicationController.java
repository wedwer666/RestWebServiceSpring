package com.example.RestWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService service;

    @Autowired
    private ApplicationModelResourceAssembler assembler;

    @GetMapping(path = "/")
    public Resource<ApplicationModel> get(){
        ApplicationModel applicationModel = service.findById(1L).orElseThrow(() -> new RuntimeException("Not found"));
        return assembler.toResource(applicationModel);
    }
}
