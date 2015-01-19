package com.robert.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by work on 1/18/15.
 */
@RestController
public class CoreRestController {


    @RequestMapping(value = "/reflect/{value}", method = RequestMethod.GET)
    public ResponseEntity<?> getOffers(@PathVariable String value) {

        return new ResponseEntity<>(new Object() {
            public String message = value;
        }, HttpStatus.OK);
    }

}
