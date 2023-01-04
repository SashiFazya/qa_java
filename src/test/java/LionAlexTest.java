import com.example.Feline;
import com.example.LionAlex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTest {
    @Mock
    Feline feline;
    @Test
    public void getFriendsReturnsAlexFriends() throws Exception {
        LionAlex alex = new LionAlex(feline);
        List<String> expectedResult = List.of("Марти", "Глория", "Мелман");
        List<String> actualResult = alex.getFriends();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPlaceOfLivingReturnsZooName() throws Exception {
        LionAlex alex = new LionAlex(feline);
        String expectedResult = "Нью-Йоркский зоопарк";
        String actualResult = alex.getPlaceOfLiving();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensReturnsNoKittens() throws Exception {
        LionAlex alex = new LionAlex(feline);
        int actualResult = alex.getKittens();
        assertEquals(0, actualResult);
    }
}
