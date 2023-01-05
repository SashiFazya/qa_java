import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LionTest {
    @Test
    public void constructorThrowsExceptionOnUnsupportedSex() {
        Feline feline = new Feline();

        Exception exception = Assert.assertThrows(Exception.class, () -> {
            Lion lion = new Lion(feline, "оно");
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
