import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> animalKindMeal;

    public AnimalParameterizedTest(String animalKind, List<String> animalKindMeal) {
        this.animalKind = animalKind;
        this.animalKindMeal = animalKindMeal;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getAnimalMealByKind() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getValidFoodByKind() throws Exception {
        Animal animal = new Animal();
        List<String> actualResult = animal.getFood(animalKind);
        List<String> expectedResult = animalKindMeal;
        assertEquals(expectedResult, actualResult);
    }
}
