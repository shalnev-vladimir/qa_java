package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

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
    public void catGetFoodReturnsPredatorFoodListTest() throws Exception {

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(feline);
        List<String> expectedCatFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualCatFoodList = cat.getFood();
        cat.getFood();
        Assert.assertEquals("Ожидаемый список еды Кота " + expectedCatFoodList + ". Фактически возвращается",
                expectedCatFoodList, actualCatFoodList);
    }
}
