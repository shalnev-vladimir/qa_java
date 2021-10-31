package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void shouldBeMeowTest() {

        Cat cat = new Cat(this.feline);
        String actualSound = cat.getSound();
        String expectedSound = "Мяу";
        Assert.assertEquals("Кот должен говорить 'Мяу', но говорит " + actualSound, expectedSound, actualSound);
    }

    @Test
    public void catShouldEatMeatTest() throws Exception {

        Cat cat = new Cat(this.feline);
        cat.getFood();
        Mockito.verify(this.feline).eatMeat();
    }
}
