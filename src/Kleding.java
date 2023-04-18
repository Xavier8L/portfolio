 abstract class Kleding {
        String naam;
        String kleur;

        double prijs;

        String categorie;



        public Kleding(String naam, String kleur,double prijs) {
                this.naam = naam;
                this.kleur = kleur;
                this.prijs = prijs;
        }

         public void setNaam(String naam) {
                 this.naam = naam;
         }

         public void setKleur(String kleur) {
                 this.kleur = kleur;
         }

         public void setPrijs(double prijs) {
                 this.prijs = prijs;
         }

         public void Print(){
                 System.out.println("Het best kleding is "+ naam);
         }



 }

class Jas extends Kleding {

        public Jas(String naam, String kleur,double prijs) {
                super(naam, kleur,prijs);
                this.categorie = "jas";
        }

        @Override
        public void Print(){
                System.out.println("Jas："+ kleur+" " +naam +";  prijs:"+ prijs);

        }

}

class Topje extends Kleding{
        public Topje(String naam, String kleur,double prijs) {
                super(naam, kleur,prijs);
                this.categorie = "topje";
        }

        @Override
        public void Print(){
                System.out.println("Topje:"+kleur+" " +naam+ ";  prijs:"+ prijs);
        }
}

class Broek extends Kleding{

        public Broek(String naam, String kleur,double prijs) {
                super(naam, kleur,prijs);
                this.categorie = "broek";
        }

        @Override
        public void Print(){
                System.out.println("Broek:"+kleur+" " + naam+ ";  prijs:"+ prijs);
        }
}

class Schoen extends Kleding{

        public Schoen(String naam, String kleur,double prijs) {
                super(naam, kleur,prijs);
                this.categorie = "schoen";
        }

        @Override
        public void Print(){
                System.out.println("Schoen: "+kleur+" " + naam+ ";  prijs:"+ prijs);
        }
}
