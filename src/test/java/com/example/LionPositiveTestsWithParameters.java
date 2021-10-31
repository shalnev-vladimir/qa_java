package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionPositiveTestsWithParameters {

    String sex;
    boolean expected;
    Feline feline;

    public LionPositiveTestsWithParameters(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void shouldBeLionMale() throws Exception {

        Lion lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }
}
