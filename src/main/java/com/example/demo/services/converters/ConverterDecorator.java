package com.example.demo.services.converters;

public class ConverterDecorator {

    private Converter converter;

    public ConverterDecorator(Converter converter) {
        this.converter = converter;
    }

    public String convert(int number) {
        return converter.convert(number);
    }

}
