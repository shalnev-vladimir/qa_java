package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    // сравниваем ожидаемое место жизни с реальным
    @Test
    public void placeOfLivingShouldBeNYZooTest() throws Exception {


        Alex alex = new Alex("Самец", feline);
        String expectedPlaceOfLiving = "Нью-Йоркский Зоопарк";
        String actualPlaceOfLiving = alex.getPlaceOfLiving();
        assertEquals("Ожидается, что место, где живет Алекс - Нью-Йоркский Зоопарк. Но фактически возвращается "
                + actualPlaceOfLiving, expectedPlaceOfLiving, actualPlaceOfLiving);
    }

    // сравнивает ожидаемый и фактический список друзей Алекса
    @Test
    public void getAlexFriedListTest() throws Exception {

        Alex alex = new Alex("Самец", feline);
        List<String> expectedAlexFriendsList = List.of("Марти", "Глория", "Мелман");
        List<String> actualAlexFriendsList = alex.getFriends();
        assertEquals("Ожидаемый список друзей Алекса 'Марти, Глория, Мелман', но фактический " + actualAlexFriendsList,
                expectedAlexFriendsList, actualAlexFriendsList);
    }

    // кол-во котят у Алекса должно быть 0
    @Test
    public void getKittensShouldReturnZero() throws Exception {

        Alex alex = spy(new Alex("Самец", feline));
        // Mockito.when(alex.getKittens()).thenReturn(0);
        int expectedCountOfAlexKittens = 0;
        int actualCountOfAlexKittens = alex.getKittens();
        assertEquals("Количество котят должно быть 0, но возвращается " + actualCountOfAlexKittens,
                expectedCountOfAlexKittens, actualCountOfAlexKittens);
    }
}
