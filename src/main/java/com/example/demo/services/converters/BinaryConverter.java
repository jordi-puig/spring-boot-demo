package com.example.demo.services.converters;

public class BinaryConverter implements Converter {

    private static BinaryConverter instance;

    public static BinaryConverter getInstance() {
        if (instance == null) {
            instance = new BinaryConverter();
        }
        return instance;
    }

    private BinaryConverter() {
    }

    public String convert(int number) {
        return Integer.toString(number, 2);
    }

}
