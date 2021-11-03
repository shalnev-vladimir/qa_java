package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline; // создали мок

    // Проверяет метод doesHaveMane. У "самки" не должно быть гривы.
    @Test
    public void doesHaveManeFemaleLionShouldNotHaveManeTest() throws Exception {

        Lion lion = new Lion("Самка", feline);
        lion.doesHaveMane();
        Assert.assertFalse("Должно вернуться false, по факту возвращается true", lion.doesHaveMane());
    }

    // Проверяет метод doesHaveMane. У "самца" должна быть гривы.
    @Test
    public void doesHaveManeMaleLionShouldHaveManeTest() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Должно вернуться true, по факту возвращается false", lion.doesHaveMane());
    }

    // Проверяет кол-во котят
    @Test
    public void getKittensReturnsCountTest() throws Exception {

        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline); // после ревью добавил пол "Самец" при создании экземпляра

        int expectedCountOfKittens = 1;
        int actualCountOfKittens = lion.getKittens();

        Assert.assertEquals("Ожидаемое количество котят 1, по факту возвращается " + actualCountOfKittens,
                expectedCountOfKittens, actualCountOfKittens);
    }

    // проверка метода getFood в классе Lion
    @Test
    public void getFoodReturnsFoodListTest() throws Exception {

        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = lion.getFood("Хищник");
        // Чтобы не копипастить 'Животные, Птицы, Рыба'
        // можно написать expectedFoodList.toString() и добавить это в текст ошибки
        Assert.assertEquals("Должен вернуться список" + expectedFoodList.toString() +
                        ", фактически возвращается " + actualFoodList, expectedFoodList, actualFoodList);
    }

    @Test
    public void lionInvalidValueOfSexExceptionTest() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Exception exception = Assert.assertThrows(Exception.class, () -> lion.getFood("12"));
        Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }


    // Проверяет, что списое еды льва "Животные", "Птицы", "Рыба"
    @Test
    public void getFoodReturnsPredatorFoodListTest() throws Exception {

        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);

        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = lion.getFood("Хищник");

        lion.getFood();

        Assert.assertEquals(expectedFoodList, actualFoodList);
    }
}
