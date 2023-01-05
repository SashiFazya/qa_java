import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String lionMane;
    private final boolean checkResult;

    @Mock
    private Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public LionParameterizedTest(String lionMane, boolean checkResult) {
        this.lionMane = lionMane;
        this.checkResult = checkResult;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} - {1}")
    public static Object[][] setLionSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeCheck() throws Exception {
        Lion lion = new Lion(feline, lionMane);
        assertEquals(checkResult, lion.doesHaveMane());
    }

    @Test
    public void getLionKittensReturnsValidNumber() throws Exception {
        Lion lion = new Lion(feline, lionMane);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedResult = 1;
        int actualResult = lion.getKittens();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getLionFoodReturnsPredatorMeal() throws Exception {
        Lion lion = new Lion(feline, lionMane);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.getFood("Травоядное")).thenReturn(List.of("Трава", "Различные растения"));
        List<String> actualResult = lion.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }
}