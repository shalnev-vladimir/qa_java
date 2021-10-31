package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;
    List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба"); // ожидаемый список
    String expectedFamilyName = "Кошачьи";
    int numberOfKittens = 1;

    @Test
    public void eatMeatReturnsFoodListTest() throws Exception {

        Feline feline = spy(new Feline());
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFoodList);
        List<String> actualFoodList = feline.eatMeat();
        Assert.assertEquals("Ожидается список 'Животные, Птицы, Рыба', но возвращается" + feline.eatMeat(),
                expectedFoodList, actualFoodList);
    }

    @Test
    public void getFamilyReturnsFamilyNameTest() {

        Feline feline = new Feline();
        Assert.assertEquals("Название должно быть 'Кошачьи', но фактически" + feline.getFamily(),
                expectedFamilyName, feline.getFamily());
    }

    @Test
    public void getKittensReturnsKittensCountTest() {

        Feline feline = new Feline();
        Assert.assertEquals("Количество котят должно равняться 1, но равняется" + feline.getKittens(),
                numberOfKittens, feline.getKittens());
    }

    @Test
    public void getKittensMethodWithParametersTest() {

        Feline feline = new Feline();
        Assert.assertEquals("Количество котят должно равняться единице",
                numberOfKittens, feline.getKittens(1));
    }
}
