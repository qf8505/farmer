package com.qf.farmer.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qf.farmer.es.service.EslService;

@RestController
@RequestMapping(value = "/esl/")
public class EslController
{
    @Autowired
    private EslService esl;

    private static final Logger LOG = LoggerFactory.getLogger(EslController.class);

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object test(String id)
    {
        return esl.findCliente(id);
    }
}
