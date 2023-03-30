public class Weer {
    String weerNaam;
    double gemiddleTemperatuur;

    public Weer(String weerNaam, double gemiddleTemperatuur) {
        this.weerNaam = weerNaam;
        this.gemiddleTemperatuur = gemiddleTemperatuur;
    }

    public String getWeerNaam() {
        return weerNaam;
    }

    public void setWeerNaam(String weerNaam) {
        this.weerNaam = weerNaam;
    }




    public double getGemiddleTemperatuur() {
        return gemiddleTemperatuur;
    }

    public void setGemiddleTemperatuur(double gemiddleTemperatuur) {
        this.gemiddleTemperatuur = gemiddleTemperatuur;
    }


}
