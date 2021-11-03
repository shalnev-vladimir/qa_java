package com.example;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void animalTestShouldReturnExceptionTest(){
        Animal animal = new Animal();
        Exception exception = Assert.assertThrows(Exception.class, () -> animal.getFood("12"));
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
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
