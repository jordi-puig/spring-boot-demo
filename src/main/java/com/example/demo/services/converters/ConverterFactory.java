package com.example.demo.services.converters;

public class ConverterFactory {

    private static ConverterFactory instance;

    public static ConverterFactory getInstance() {
        if (instance == null) {
            instance = new ConverterFactory();
        }
        return instance;
    }

    private ConverterFactory() {
    }

    public enum NUMBER_TYPE {
        BINARY, HEXA, ROMAN;
    }

    public NumberConverter getNumberService(String type) throws NotDefinedConverterException {
        if (type.equals(NUMBER_TYPE.BINARY.name())) return BinaryConverter.getInstance();
        if (type.equals(NUMBER_TYPE.HEXA.name())) return HexaConverter.getInstance();
        if (type.equals(NUMBER_TYPE.ROMAN.name())) return RomanConverter.getInstance();
        throw new NotDefinedConverterException();
    }
}
