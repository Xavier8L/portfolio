import java.util.ArrayList;

 class Outfit {

    ArrayList<Kleding> kleren;


    double totalPrijs;


    public Outfit(ArrayList<Kleding> kleren){
        this.kleren = kleren;
    }



    public void BestOutfit(){
        System.out.println("Het best draagt van vandaag is: ");
        for(Kleding kleding:kleren){
            kleding.Print();
            totalPrijs +=kleding.prijs;
        }
        System.out.println("Totaal prijs:"+totalPrijs);

    }
}
