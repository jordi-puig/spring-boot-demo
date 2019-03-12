package com.example.demo.services.converters;

public class HexaConverter implements NumberConverter {

    private static HexaConverter instance;

    public static HexaConverter getInstance() {
        if (instance == null) {
            instance = new HexaConverter();
        }
        return instance;
    }

    private HexaConverter() {
    }

    public String convert(int number) {
        return String.format("%X", number);
    }

}
