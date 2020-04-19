import java.io.Serializable;

public class Adres extends ObjectPlus implements Serializable {

    private String kraj;
    private String miejscowosc;
    private String ulica;
    private int nrBudynku;
    private String funkcjaBudynku;


    // Konstruktor
    public Adres(String funkcjaBudynku, Wydawnictwo wydawnictwo, String kraj, String miejscowosc, String ulica, int nrBudynku) throws Exception {
        super();
        if (wydawnictwo == null) {
            throw new Exception("Brak wytworni");
        }
        this.funkcjaBudynku = funkcjaBudynku;
        this.kraj = kraj;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrBudynku = nrBudynku;
    }

    // Gettery
    public String getKraj() {
        return kraj;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public int getNrBudynku() {
        return nrBudynku;
    }


    public static Adres przypiszAdres(String funkcjaBudynku, Wydawnictwo wydawnictwo, String kraj, String miasto, String ulica, int numerulicy) throws Exception {
        if (wydawnictwo == null) {
            throw new Exception("Brak wydawnictwa");
        }
        Adres adres = new Adres(funkcjaBudynku, wydawnictwo, kraj, miasto, ulica, numerulicy);
        wydawnictwo.addAdresWytworni(adres);
        return adres;
    }

    public String toString() {
        String result = "" + getKraj() + " " + getMiejscowosc() + " " + getMiejscowosc() + " " + getUlica() + " " + getNrBudynku();
        return result;
    }
}
