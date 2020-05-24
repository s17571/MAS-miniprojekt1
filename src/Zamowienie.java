import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Zamowienie extends ObjectPlusPlus {

    private int nrZamowienia;
    private LocalDate dataDodania;
    private String status;
    public ArrayList<Audiobook> audiobook = new ArrayList<Audiobook>();
    private Osoba klient;
    private Osoba sprzedawca;
    private double znizkaPromocyjna; // np. 0.2 znizki

    // Konstruktor
    public Zamowienie(int nrZamowienia, Osoba klient, Osoba sprzedawca, double znizkaPromocyjna) {
        super();
        this.nrZamowienia = nrZamowienia;
        this.klient = klient;
        this.sprzedawca = sprzedawca;
        this.znizkaPromocyjna = znizkaPromocyjna;
        this.status = "Nowe";
        this.dataDodania = LocalDate.now();
    }

    // Gettery
    public int getNrZamowienia() {
        return nrZamowienia;
    }

    public Osoba getKlient() {
        return klient;
    }

    public Osoba getSprzedawca() {
        return sprzedawca;
    }

    // miniprojekt - Atrybut pochodny zorganizowany jako metoda:
    public double getWartoscZnizkiPromocyjnejNetto() {
        return obliczWartoscZamowienia() * znizkaPromocyjna;
    }

    public double obliczWartoscZamowienia() {
        double suma = 0;
        for (Audiobook a : audiobook) {
            suma += a.getCenaNetto();
        }
        return suma;
    }

    public void addAudiobook(Audiobook nowaAudiobook) {
        if (!audiobook.contains(nowaAudiobook)) {
            audiobook.add(nowaAudiobook);
            nowaAudiobook.addZamowienie(this);
        }
    }

    public String toString() {
        String result = " Nr zamowienia: " + getNrZamowienia() + " Laczny koszt zamowienia: " + obliczWartoscZamowienia() + " zl " + "\n" + " Lista produktow: " + "\n";
        for (Audiobook a : audiobook) {
            result += " Audiobook: " + a.getTytul() + " Cena: " + a.getCenaNetto() + " zl" + "\n";
        }
        return result;
    }

}
