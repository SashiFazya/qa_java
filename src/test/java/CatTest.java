import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    @Test
    public void getSoundReturnsMeow(){
        Cat cat = new Cat(feline);
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnsMeatMeal() throws Exception{
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = cat.getFood();
        List <String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }
}
