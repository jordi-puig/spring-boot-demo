package com.example.demo.services.converters;

import java.util.TreeMap;

public class RomanConverter implements NumberConverter {

    private static final TreeMap<Integer, String> map = new TreeMap<>();
    private static RomanConverter instance;

    static {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
    }

    public static RomanConverter getInstance() {
        if (instance == null) {
            instance = new RomanConverter();
        }
        return instance;
    }

    private RomanConverter() {
    }

    public String convert(int number) {
        int l = map.floorKey(number);
        if (number == l) {
            return map.get(number);
        }
        return map.get(l) + convert(number - l);
    }

}
