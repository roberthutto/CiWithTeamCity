package com.robert.rest.controllers;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Class initializes SystemProperties with values from the application properties.
 */
public class SystemPropertiesInitializer {

    //Needed for property replacement in the ehcache.xml
    @Value("${ehcache.multicastGroupAddress}")
    private String ehcacheMulticastGroupAddress;

    @PostConstruct
    private void init() {
        System.setProperty("ehcache.multicastGroupAddress", ehcacheMulticastGroupAddress);
    }
}
