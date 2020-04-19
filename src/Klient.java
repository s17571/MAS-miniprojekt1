import java.io.Serializable;

public class Klient extends ObjectPlus implements Serializable{

    private String nazwaFirmy;
    private int NIP; // atrybut wymagany (nie moze byc null)
    private Adres adres; // miniprojekt - Atrybut zlozony i opcjonalny (metoda wypiszAdresKlienta())
    private RabatKliencki rabat; // miniprojekt - Atrybut zlozony i opcjonalny

    // Konstruktor
    Klient(String nazwaFirmy, int NIP, Adres adres, RabatKliencki rabat) {
        super();
        this.nazwaFirmy = nazwaFirmy;
        this.NIP = NIP;
        this.adres = adres;
        this.rabat = rabat;
    }

    // Wypisywanie adresu
    public void wypiszAdresKlienta() {
        if (this.adres != null) {
            System.out.println("Adres klienta to: " + this.adres);
        } else System.out.println("Brak adresu");
    }

    // Gettery
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public int getNIP() {
        return NIP;
    }

    public Adres getAdres() {
        return adres;
    }

    public RabatKliencki getRabat() {
        return rabat;
    }

}

