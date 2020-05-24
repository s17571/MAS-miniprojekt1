import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Audiobook extends ObjectPlusPlus {

    public static final int ALARMUJACY_STAN_MAGAZYNOWY = 5; //liczba sztuk uznawanych za alarmujacy stan
    private int stanMagazynowy;
    private ArrayList<String> gatunki = new ArrayList<>(); //MP1 - atrybut powtarzajacy - moze byc kilka gatunkow audiobooka
    private double stawkaVAT;
    private double cenaNetto;
    public String tytul;
    private int rokWydania;
    private Wydawnictwo wydawnictwo;
    private  ArrayList<Wydawnictwo> wydawnictwa = new ArrayList<Wydawnictwo>();
    public  ArrayList<AutorTekstu> autorzy = new ArrayList<AutorTekstu>(); // MP2 - asocjacja zwykla, licznosc wiele, ale ostatecznie ObjectPlusPlus
    public ArrayList<Zamowienie> zamowienie = new ArrayList<Zamowienie>();

    // Konstruktor
    public Audiobook(String tytul, int rokWydania, Wydawnictwo wydawnictwo, double cenaNetto,
                     int stanMagazynowy, ArrayList<String> gatunki, double stawkaVAT
    ) {
        super();
        this.tytul = tytul;
        this.rokWydania = rokWydania;
        this.wydawnictwo = wydawnictwo;
        this.cenaNetto = cenaNetto;
        this.stanMagazynowy = stanMagazynowy;
        this.gatunki = gatunki;
        this.stawkaVAT = stawkaVAT;
        this.wydawnictwo = wydawnictwo;
    }

    // Gettery
    public String getTytul() {
        return tytul;
    }

    public Wydawnictwo getWydawnictwo() {
        return wydawnictwo;
    }

    public double getCenaNetto() {
        return cenaNetto;
    }

    public double getStanMagazynowy() {
        return stanMagazynowy;
    }

    // miniprojekt - trwalosc ekstensji - klasa ObjectPlus, przyklad uzycia:
    public static void showExtent() throws Exception {
        ObjectPlus.showExtent(Audiobook.class);
    }

    // miniprojekt - trwalosc ekstensji - metoda klasowa
    public static ArrayList<Audiobook> znajdzBraki() throws ClassNotFoundException {
        ArrayList<Audiobook> audiobookiZBrakami = new ArrayList<Audiobook>();
        Iterable<Audiobook> audiobookExtent = ObjectPlus.getExtent(Audiobook.class);
        for (Audiobook a : audiobookExtent) {
            if (a.getStanMagazynowy() <= ALARMUJACY_STAN_MAGAZYNOWY) {
                audiobookiZBrakami.add(a);
            }
        }
        return audiobookiZBrakami;
    }


    public int getLiczbaLatOdWydania() {
        int data = Calendar.getInstance().get(Calendar.YEAR);
        int czas_od_wydania = data - rokWydania;
        return czas_od_wydania;
    }

    public void addZamowienie(Zamowienie noweZakupy) {
        if (!zamowienie.contains(noweZakupy)) {
            zamowienie.add(noweZakupy);
            noweZakupy.addAudiobook(this);
        }
    }

//    public void addWydawnictwo(Wydawnictwo wydawnictwo) throws Exception{
//        if (!wydawnictwa.contains(wydawnictwo)){
//            wydawnictwa.add(wydawnictwo);
//            wydawnictwo.addAudiobookQualif(this);
//        }
//    }

    @Override
    public String toString() {
        String result = "Tytul: " + getTytul();
                //+ "\n" + " Wydawnictwo: " + getWydawnictwo() + "\n";
                //+ " W magazynie: " + getStanMagazynowy();
        return result;
    }
}
