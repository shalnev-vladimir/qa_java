package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test(expected = Exception.class)
    public void animalTestShouldReturnException() throws Exception {
        Animal animal = new Animal();
        animal.getFood("");
    }

    @Test
    public void getFamilyAnimalTest() {
        Animal animal = new Animal();
        String actualString = animal.getFamily();
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Ожидается, что вернется строка " + expectedString + " . Но возвращается " +
                actualString, expectedString, actualString);
    }
}
