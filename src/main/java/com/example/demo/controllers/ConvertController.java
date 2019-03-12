package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ConverterService;
import com.example.demo.services.converters.NotDefinedConverterException;

@RestController
public class ConvertController {

    @RequestMapping("/convert/")
    public String convert(@RequestParam(name = "type") String type, @RequestParam(name = "number") Integer number) throws NotDefinedConverterException {
        return new ConverterService().convert(type, number);
    }

}
