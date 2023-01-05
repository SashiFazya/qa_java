import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    private Feline feline; //Spy-копия класса будет использоваться в тестах, где необходимо мокировать.
    // Где мок не нужен, объект класса будет создан локально

    @Test
    public void eatMeatReturnsPredatorMeal() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = feline.eatMeat();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFamilyReturnsValidFamily() {
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getCertainNumberKittens() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(5);
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getJustKittens() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int actualResult = feline.getKittens();
        int expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }
}
