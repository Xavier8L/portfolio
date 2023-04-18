import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ControllerTest {
    Controller controller = new Controller();

    @Test
    public void testScanOnderdelenFile() throws FileNotFoundException {

        //test scan goed gewerk en een Outfit staat vier soort kleding. Het zijn "jas" , "topje","broek" en "Schoen"
        ArrayList<Outfit> outfits= controller.ScannerFile();
        for(Outfit outfit:outfits){
            Assertions.assertTrue(outfit.getKleren().size() == 4);
            Assertions.assertEquals("jas",outfit.getKleren().get(0).categorie);
            Assertions.assertEquals("topje",outfit.getKleren().get(1).categorie);
            Assertions.assertEquals("broek",outfit.getKleren().get(2).categorie);
            Assertions.assertEquals("schoen",outfit.getKleren().get(3).categorie);

        }


    }
}
