import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsetTest {
    User user = new User();

    //controller wachtwoord zelfde is;
    @Test
    public void userTest(){
        user.wachtwoord = "abc123";
        String wachtwoord = "abc123";
        Assertions.assertTrue(user.ControlerWachtwoord(wachtwoord));
    }
}
