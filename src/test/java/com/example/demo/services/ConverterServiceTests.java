package com.example.demo.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.services.converters.ConverterFactory.NUMBER_TYPE;
import com.example.demo.services.converters.NotDefinedConverterException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterServiceTests {

    @Test
    public void testBinaryConvertion() throws NotDefinedConverterException {
        String binaryResult = new ConverterService().convert(NUMBER_TYPE.BINARY.name(), 1223);
        assertEquals("10011000111", binaryResult);
    }

    @Test
    public void testHexaConvertion() throws NotDefinedConverterException {
        String hexaResult = new ConverterService().convert(NUMBER_TYPE.HEXA.name(), 1223);
        assertEquals("4C7", hexaResult);
    }

    @Test
    public void testRomanConvertion() throws NotDefinedConverterException {
        String hexaResult = new ConverterService().convert(NUMBER_TYPE.ROMAN.name(), 1223);
        assertEquals("MCCXXIII", hexaResult);
    }

    @Test
    public void testNotDefinedConvertion() throws NotDefinedConverterException {
        assertThatThrownBy(() -> {
            new ConverterService().convert("not defined", 1223);
        }).isInstanceOf(NotDefinedConverterException.class);
    }

}
