package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.ConverterService;
import com.example.demo.services.converters.ConverterFactory.NUMBER_TYPE;
import com.example.demo.services.converters.NotDefinedConverterException;

@RestController
public class ConvertController {

    @RequestMapping("/restricted/")
    public String convertToBinaryRestricted(@RequestParam(name = "number") Integer number) throws NotDefinedConverterException {
        return new ConverterService().convert(NUMBER_TYPE.BINARY.name(), number);
    }

    @RequestMapping("/convert/binary")
    public String convertToBinary(@RequestParam(name = "number") Integer number) throws NotDefinedConverterException {
        return new ConverterService().convert(NUMBER_TYPE.BINARY.name(), number);
    }

    @RequestMapping("/convert/hexa")
    public String convertToHexa(@RequestParam(name = "number") Integer number) throws NotDefinedConverterException {
        return new ConverterService().convert(NUMBER_TYPE.HEXA.name(), number);
    }

    @RequestMapping("/convert/roman")
    public String convertToRoman(@RequestParam(name = "number") Integer number) throws NotDefinedConverterException {
        return new ConverterService().convert(NUMBER_TYPE.ROMAN.name(), number);
    }

    @RequestMapping("/adminPage")
    public String adminPage(@RequestParam(name = "number") Integer number) throws NotDefinedConverterException {
        return new ConverterService().convert(NUMBER_TYPE.HEXA.name(), number);
    }

}
