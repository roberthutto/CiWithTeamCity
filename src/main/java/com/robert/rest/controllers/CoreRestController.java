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
    public ResponseEntity<Message> getOffers(@PathVariable String value) {
        Message message = new Message();
        message.setValue(value);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
