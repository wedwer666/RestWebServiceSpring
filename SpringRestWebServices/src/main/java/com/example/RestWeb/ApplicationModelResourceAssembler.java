package com.example.RestWeb;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;


// works with postman
@Component
public class ApplicationModelResourceAssembler implements ResourceAssembler<ApplicationModel, Resource<ApplicationModel>> {

    public Resource toResource(ApplicationModel entity) {
        Resource<ApplicationModel> resource = new Resource<>(entity);
        addLinks(resource);
        return resource;
    }

    private void addLinks(Resource<ApplicationModel> resource) {
        resource.add(linkTo(ApplicationController.class).slash(resource.getContent()).withSelfRel());
    }
}
