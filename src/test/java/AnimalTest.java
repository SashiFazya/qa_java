import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void getFoodThrowsExceptionOnUnsupportedKind() {
        Exception exception;
        Animal animal = new Animal();
        exception = Assert.assertThrows(Exception.class, () -> {
            animal.getFood("Рыба");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyReturnsDescription() {
        Animal animal = new Animal();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedResult, animal.getFamily());
    }
}