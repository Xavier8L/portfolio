
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User user = new User();
       boolean res = user.ControlerWachtwoord("qwe123");
        ArrayList<Kleding> kleren  = new ArrayList<Kleding>();
//        ArrayList<LenteEnHerfstOutfit> lentes = new ArrayList<LenteEnHerfstOutfit>();
//        ArrayList<ZomerOutfit> zomers = new ArrayList<ZomerOutfit>();
//        ArrayList<WinterOutfit> winters = new ArrayList<WinterOutfit>();
        ArrayList<Outfit> lentes = new ArrayList<Outfit>();
        ArrayList<Outfit> winters = new ArrayList<Outfit>();
        ArrayList<Outfit> zomers = new ArrayList<Outfit>();
        String seizon = "";

       if(res){
           File file = new File("src/Kleren/lente.txt");
           try {
               Scanner scanner = new Scanner(file);

               seizon = scanner.nextLine();
               for(int i = 0; i<3; i++){
               for(int x =0; x<4; x++){

                   scanner.nextLine();
                   String naam = scanner.nextLine();
                   String kleur = scanner.nextLine();
                   double prijs = scanner.nextDouble();
                   if(x == 0){
                       Jas jas = new Jas(naam,kleur,prijs);
                       kleren.add(jas);
                   }else if(x == 1 ){
                       Topje topje = new Topje(naam,kleur,prijs);
                       kleren.add(topje);
                   }else if( x == 2){
                       Broek broek = new Broek(naam,kleur,prijs);
                       kleren.add(broek);
                   }else if(x == 3){
                       Schoen schoen = new Schoen(naam,kleur,prijs);

                       kleren.add(schoen);
                   }

                }

               Outfit lente = new Outfit(kleren);


                   lentes.add(lente);
                   kleren  = new ArrayList<Kleding>();
                   scanner.nextLine();

               }

           } catch (FileNotFoundException e) {
               throw new RuntimeException(e);
           }

       }



        Weer weer =new Weer("zon",17);

        Random random = new Random();
        int index = random.nextInt(3) ;
        if(10<=weer.gemiddleTemperatuur&& weer.gemiddleTemperatuur<=22){
            lentes.get(index).BestOutfit();
        }else if(10>=weer.gemiddleTemperatuur){
            winters.get(0).BestOutfit();
        }else if(weer.gemiddleTemperatuur>=22){
             zomers.get(0).BestOutfit();
        }else{
            System.out.println("Niet goevond weer gemiddleTemperatuur");
        }







    }
}