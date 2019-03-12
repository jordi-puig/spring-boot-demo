package com.example.demo.services;

import com.example.demo.services.converters.ConverterFactory;
import com.example.demo.services.converters.NotDefinedConverterException;

public class ConverterService {

    public String convert(String converterType, int number) throws NotDefinedConverterException {
        return ConverterFactory.getInstance().getNumberService(converterType).convert(number);
    }
}
