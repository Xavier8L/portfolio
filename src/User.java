import java.util.ArrayList;

public class User {

    String wachtwoord ="qwe123";


    public boolean ControlerWachtwoord(String wachtwoord){
        if(this.wachtwoord.equals(wachtwoord)){
            return true;
        }else{
            return false;
        }

    }



}
