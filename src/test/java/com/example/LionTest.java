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
public class LionTest {

    @Mock
    Feline feline; // создали мок

    // Проверяет метод doesHaveMane. У "самки" не должно быть гривы.
    @Test
    public void doesHaveManeFemaleLionShouldNotHaveManeTest() throws Exception {

        Lion lion = new Lion("Самка", this.feline);
        Assert.assertFalse("Должно вернуться false, по факту возвращается true", lion.doesHaveMane());
    }

    // Проверяет метод doesHaveMane. У "самца" должна быть гривы.
    @Test
    public void doesHaveManeMaleLionShouldHaveManeTest() throws Exception {

        Lion lion = new Lion("Самец", feline);
        Assert.assertTrue("Должно вернуться true, по факту возвращается false", lion.doesHaveMane());
    }

    // Проверяет, что метод getKittens класса Lion работает
    @Test
    public void getKittenShouldReturnCountsOfKittensTest() throws Exception {

        Feline feline = spy(new Feline());
        Mockito.when(feline.getKittens()).thenReturn(1);
        feline.getKittens();
        int expectedKittensCount = 1;
        Assert.assertEquals("Ожидаемое количество котят 1, по факту возвращается " + feline.getKittens(),
                expectedKittensCount, feline.getKittens());
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

        Feline feline = spy(new Feline());
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = feline.getFood("Хищник");
        // Чтобы не копипастить 'Животные, Птицы, Рыба'
        // можно написать expectedFoodList.toString() и добавить это в текст ошибки
        Assert.assertEquals("Должен вернуться список" + expectedFoodList.toString() +
                        ", фактически возвращается " + actualFoodList, expectedFoodList, actualFoodList);
    }

    // Тест проверяет исключение при создании объекта класса Lion, если не указать "Самец" это или "Самка"
    @Test(expected = Exception.class)
    public void lionInvalidValueOfSexExceptionTest() throws Exception {

        Lion lion = new Lion("Еще не определился", this.feline);
        lion.doesHaveMane();
    }

    // Проверяет, что списое еды льва "Животные", "Птицы", "Рыба"
    @Test
    public void getFoodReturnsPredatorFoodListTest() throws Exception {

        Feline feline = spy(new Feline());
        Lion lion = new Lion("Самец", feline);

        List<String> expectedFoodList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFoodList = lion.getFood("Хищник");

        lion.getFood();

        Assert.assertEquals(expectedFoodList, actualFoodList);
    }
}
