package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalGetFoodListPositiveWithParametersTest {

    String animalKind;
    List<String> expectedFoodList;

    public AnimalGetFoodListPositiveWithParametersTest(String animalKind, List<String> expectedFoodList) {
        this.animalKind = animalKind;
        this.expectedFoodList = expectedFoodList;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodListData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void plantEatingShouldEatPlantPredatorsShouldEatMeatTest() throws Exception {

        Animal animal = new Animal();
        List<String> actualFoodList= animal.getFood(animalKind);
        assertEquals(expectedFoodList, actualFoodList);
    }
}

