package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private String lionSex;
    private Feline feline;
    private boolean hasManeExpected;

    public LionParameterizedTest(String lionSex, boolean hasManeExpected) {
        this.lionSex = lionSex;
        this.hasManeExpected = hasManeExpected;
    }

    @Parameterized.Parameters(name = "Пол животного: {0}, значение: {1}")
    public static Object[][] getDataForm() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeReturnsExpectedValue() throws Exception {
        Lion lion = new Lion(feline, lionSex);
        boolean hasManeActual = lion.doesHaveMane();

        assertEquals(hasManeExpected, hasManeActual);
    }
}
