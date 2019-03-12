package com.example.SpringBootSoapWebService;

import https.ro_wikipedia_org.wiki.world_wide_web.StudentDetailsRequest;
import https.ro_wikipedia_org.wiki.world_wide_web.StudentDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndPoint {
    private static final String NAMESPACE_URI = "https://ro.wikipedia.org/wiki/World_Wide_Web";

    private StudentRepository StudentRepository;

    @Autowired
    public StudentEndPoint(StudentRepository studentRepository) {
        this.StudentRepository = studentRepository;
    }

    /*
    You annotate the method with another annotation, typically @PayloadRoot , to indicate what sort of messages it can handle
    Annotation Type ResponsePayload ... Annotation which indicates that a method return value should be bound to the response payload
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request){
        StudentDetailsResponse response = new StudentDetailsResponse();
        response.setStudent(StudentRepository.findStudent(request.getName()));
        return response;
    }
}

