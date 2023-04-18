import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    public void starts(){

        ArrayList<Outfit> outfits = ScannerFile();
        outfits =SetOutfitNummer(outfits);
        ArrayList<Outfit> lentes = new ArrayList<>();
        ArrayList<Outfit> zomers= new ArrayList<>();
        ArrayList<Outfit> winters = new ArrayList<>();
        boolean isOpnieuw = true;
        Scanner scanner = new Scanner(System.in);

        boolean res =false;
        User user = new User();
        while(!res){
            System.out.println("Hallo gebruiker, bent u Beheerder? Als ja type het wachtwoord in, als niet type nee.(wachtwoord/nee)");
            String wachtwoord = scanner.nextLine();
            res = user.ControlerWachtwoord(wachtwoord);
            if(wachtwoord.equals("nee")){
                break;
            }else if(!res){
                System.out.println("Verkeert wachtwoord, proberen opnieuw");
            }

        }

        if(res)
            while (isOpnieuw){
                outfits = UpdateOutfit(outfits);
                System.out.println();
                System.out.println("Wilt u uit loggen? y/n");
                if(scanner.nextLine().equals("y")){
                    isOpnieuw = false;
                }else {
                    isOpnieuw = true;
                }
                outfits =SetOutfitNummer(outfits);
            }
        System.out.println("U heeft uitgeloogd");

        for(Outfit outfit:outfits){
            switch (outfit.categorie){
                case "lente":
                    lentes.add(outfit);
                    break;
                case "zomer":
                    zomers.add(outfit);
                    break;
                case "winter":
                    winters.add(outfit);
                    break;
                default:
                    System.out.println("gevonden niet categorie");
                    break;
            }
        }

       System.out.println("Welkom gebruiker, invullen de weer naam");
        String weerNaam = scanner.nextLine();
        System.out.println("invullen gemiddelde temperatuur");
        double temp = scanner.nextDouble();
        Random random = new Random();

        if(weerNaam.equals("regen")){
            System.out.println("Vandaag is regen, dus beter neem een paraplu");
        }else{
            System.out.println("Vandaag is "+weerNaam +", is een mooie weer");
        }

        if(10 <=temp && temp <= 22){
            int index = random.nextInt(lentes.size()-1) ;
            lentes.get(index).BestOutfit();
        }else if(temp < 10){
            int index = random.nextInt(winters.size()-1) ;
            winters.get(index).BestOutfit();
        }else if(temp > 22){
            int index = random.nextInt(zomers.size()-1) ;
                zomers.get(index).BestOutfit();
        }else{
            System.out.println("temp kapot");
        }



    }


    public ArrayList<Outfit> ScannerFile(){
        ArrayList<Kleding> kleren  = new ArrayList<Kleding>();
        ArrayList<Outfit> outfits = new ArrayList<Outfit>();
        ArrayList categorie = new ArrayList();
        categorie.add("lente");
        categorie.add("winter");
        categorie.add("zomer");
        Outfit outfit ;

        for(Object ca:categorie) {
            File SeizoenFile = new File("src/Kleren/"+ca.toString()+".txt");
            try {
                Scanner filescanner = new Scanner(SeizoenFile);

                for (int i = 0; i < 3; i++) {
                    for (int x = 0; x < 4; x++) {
                        String naam = filescanner.nextLine();
//                        System.out.println(naam);
                        String kleur = filescanner.nextLine();
//                        System.out.println(kleur);
                        double prijs = filescanner.nextDouble();
//                        System.out.println(prijs);
                        if (x == 0) {
                            Jas jas = new Jas(naam, kleur, prijs);
                            kleren.add(jas);
                        } else if (x == 1) {
                            Topje topje = new Topje(naam, kleur, prijs);
                            kleren.add(topje);
                        } else if (x == 2) {
                            Broek broek = new Broek(naam, kleur, prijs);
                            kleren.add(broek);
                        } else if (x == 3) {
                            Schoen schoen = new Schoen(naam, kleur, prijs);

                            kleren.add(schoen);
                        }
                            if(filescanner.hasNext()){
                                filescanner.nextLine();
                            }

                    }
                    outfit = new Outfit(kleren);
                    outfit.setCategorie((String) ca);
                    outfits.add(outfit);
                    kleren = new ArrayList<Kleding>();
                    if(filescanner.hasNext()) {
                        filescanner.nextLine();
                    }

                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return outfits;
    }



    public ArrayList<Outfit> UpdateOutfit(ArrayList<Outfit> outfits){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kleding> kleren  = new ArrayList<Kleding>();
        LenteOutfit lenteOutfit ;
        ZomerOutfit zomerOutfit;
        WinterOutfit winterOutfit;
        ArrayList kledingCategorie = new ArrayList();
        kledingCategorie.add("jas");
        kledingCategorie.add("topje");
        kledingCategorie.add("broek");
        kledingCategorie.add("schoen");
        System.out.println("Wat wilt u doe beheerder? type nummer in '1:Toevoegen, 2:Verwijzen, 3:Verwijderen, 4:uitloggen'");
        int nummer = scanner.nextInt();
        if(nummer == 4){return outfits;}
        String naam ="";
        String kleur ="";
        double prijs =0;
        int outfitNummer = 0;
        String testNaam ="";
        Outfit gekozenOutfit;
        switch(nummer){
            case 1:
                System.out.println("Welke seizoen is voor deze kleding? type nummer in. 1:lente/herfst, 2:zomer, 3:winter");
                int seizoen = scanner.nextInt();
                System.out.println("OK, daarna moet 4 soort kleding stuk type 'jas', 'topje','broek', 'schoen'");
                for(int i=0; i<4;i++){
                    scanner.nextLine();
                    System.out.println("Eerst invullen "+ kledingCategorie.get(i)+" naam:");
                    naam = scanner.nextLine();
                    System.out.println("goed, en wat is kleur voor de "+ kledingCategorie.get(i) +"?");
                    kleur = scanner.nextLine();
                    System.out.println("invullen het prijs van "+kledingCategorie.get(i));
                    prijs = scanner.nextDouble();

                    switch(i){
                        case 0:
                            Jas jas = new Jas(naam,kleur,prijs);
                            kleren.add(jas);
                            break;
                        case 1:
                            Topje topje = new Topje(naam,kleur,prijs);
                            kleren.add(topje);
                            break;
                        case 2:
                            Broek broek = new Broek(naam,kleur,prijs);
                            kleren.add(broek);
                            break;
                        case 3:
                            Schoen schoen = new Schoen(naam,kleur,prijs);
                            kleren.add(schoen);
                            break;
                        default:
                            System.out.println("error");
                            break;
                    }

                }
                switch (seizoen){
                    case 1:
                        lenteOutfit = new LenteOutfit(kleren);
                        outfits.add(lenteOutfit);
                        testNaam = lenteOutfit.getCategorie();
                        break;
                    case 2:
                        zomerOutfit = new ZomerOutfit(kleren);
                        outfits.add(zomerOutfit);
                        testNaam = zomerOutfit.getCategorie();
                        break;
                    case 3:
                        winterOutfit = new WinterOutfit(kleren);
                        outfits.add(winterOutfit);
                        testNaam = winterOutfit.getCategorie();
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
//                File f = new File("src/Kleren/"+testNaam+".txt");
//                try (PrintWriter writer = new PrintWriter(new FileWriter(f, true))) {
//                    for(Kleding kleding:kleren){
//                        writer.println(kleding.naam);
//                        writer.println(kleding.kleur);
//                        writer.println(Double.toString(kleding.prijs).split("[.]")[0]);
//                    }
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
                System.out.println("Toevoegen is success!!");
                break;
            case 2:
                System.out.println("Welke outfit wilt u verwijzen: kies de outfit nummer.");
                for (Outfit outfit:outfits){
                    System.out.println("Outfit nummer: "+outfit.getNummer());
                    System.out.println("het outfit zijn: "+outfit.getKleren().get(0).naam+" + "+outfit.getKleren().get(1).naam +" + "+ outfit.getKleren().get(2).naam+" + "+outfit.getKleren().get(3).naam);
                }
                outfitNummer = scanner.nextInt();
                gekozenOutfit = outfits.get(outfitNummer);
                for(int i=0; i<4;i++) {
                    scanner.nextLine();
                    System.out.println("Invullen nieuw " + kledingCategorie.get(i) + " naam:");
                    gekozenOutfit.getKleren().get(i).setNaam(scanner.nextLine());
                    System.out.println("goed, en wat is kleur voor de " + kledingCategorie.get(i) + "?");
                    gekozenOutfit.getKleren().get(i).setKleur(scanner.nextLine());
                    System.out.println("invullen het prijs van " + kledingCategorie.get(i));
                    gekozenOutfit.getKleren().get(i).setPrijs(scanner.nextDouble());
                }
                break;
            case 3:
                System.out.println("Welke outfit wilt u verderen: kies de outfit nummer.");
                for (Outfit outfit:outfits){
                    System.out.println("Outfit nummer: "+outfit.getNummer());
                    System.out.println("het outfit zijn: "+outfit.getKleren().get(0).naam+" + "+outfit.getKleren().get(1).naam +" + "+ outfit.getKleren().get(2).naam+" + "+outfit.getKleren().get(3).naam);
                }
                outfitNummer = scanner.nextInt();
                outfits.remove(outfitNummer-1);
//                for (Outfit outfit:outfits){
//                    outfit.BestOutfit();
//                    System.out.println("Outfit nummer: "+outfit.getNummer());
//                    System.out.println("het outfit zijn: "+outfit.getKleren().get(0).naam+" + "+outfit.getKleren().get(1).naam +" + "+ outfit.getKleren().get(2).naam+" + "+outfit.getKleren().get(3).naam);
//
//                }
                break;
            default:
                System.out.println("error");


        }
        return outfits;
    }



    public ArrayList<Outfit> SetOutfitNummer(ArrayList<Outfit> outfits){
        int teller =1;
        for(Outfit outfit:outfits){
            outfit.setNummer(teller);
            teller ++;
        }
        return outfits;
    }

}
