import java.util.ArrayList;

class Outfit {

    ArrayList<Kleding> kleren;

    String categorie;

    int nummer;
    double totalPrijs;


    public Outfit(ArrayList<Kleding> kleren){
        this.kleren = kleren;
    }

    public void setNummer(int nummer){
        this.nummer = nummer;
    }

    public int getNummer(){
        return nummer;
    }

    public String getCategorie(){return categorie;}

    public ArrayList<Kleding> getKleren() {
        return kleren;
    }

    public void BestOutfit(){
        System.out.println("Het best draagt van vandaag is: ");
        for(Kleding kleding:kleren){
            kleding.Print();
            totalPrijs +=kleding.prijs;
        }
        System.out.println("Totaal prijs:"+totalPrijs);

    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}

class LenteOutfit extends Outfit{


    public LenteOutfit(ArrayList<Kleding> kleren) {
        super(kleren);
    }

    @Override
    public String getCategorie(){
        return "lente";
    }

}

class ZomerOutfit extends Outfit{
    public ZomerOutfit(ArrayList<Kleding> kleren) {
        super(kleren);
    }

    @Override
    public String getCategorie(){
        return "zomer";
    }


}

class WinterOutfit extends Outfit{
    public WinterOutfit(ArrayList<Kleding> kleren) {
        super(kleren);
    }

    @Override
    public String getCategorie(){
        return "winter";
    }


}
