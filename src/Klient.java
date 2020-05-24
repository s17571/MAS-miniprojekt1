import java.time.LocalDate;
import java.util.ArrayList;

public class Klient extends ObjectPlusPlus {

    private String nazwaFirmy;
    private String NIP; // atrybut wymagany (nie moze byc null)
    private Adres adres; // miniprojekt - Atrybut zlozony i opcjonalny (metoda wypiszAdresKlienta())
    private RabatKliencki rabat; // miniprojekt - Atrybut zlozony i opcjonalny
    private ArrayList<PrzedstawicielKlienta> przedstawicieleKlienta = new ArrayList<>();

    // Konstruktor
    Klient(String nazwaFirmy, String NIP, Adres adres, RabatKliencki rabat) {
        super();
        this.nazwaFirmy = nazwaFirmy;
        this.NIP = NIP;
        this.adres = adres;
        this.rabat = rabat;
    }

    // Wypisywanie adresu
    public void wypiszAdresKlienta() {
        if (this.adres != null) {
            System.out.println("Adres klienta " + nazwaFirmy + ": " + this.adres + "\n");
        } else System.out.println("Brak adresu dla klienta " + nazwaFirmy + "\n");
    }

    public PrzedstawicielKlienta createPart(String imie, String nazwisko, int telefon, String email) {
        PrzedstawicielKlienta part = new PrzedstawicielKlienta(imie, nazwisko, telefon, email);
        przedstawicieleKlienta.add(part);
        return part;
    }

    // Gettery
    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public String getNIP() {
        return NIP;
    }

    public Adres getAdres() {
        return adres;
    }

    public RabatKliencki getRabat() {
        return rabat;
    }

    @Override
    public String toString() {
        String result = "Klient: " + nazwaFirmy;
        return result;
    }

    // Klasa wewnetrzna
    public class PrzedstawicielKlienta extends Osoba {

        private LocalDate dataDodania;
        private int telefon;
        private String email;
        private ArrayList<TimeSheet> timesheets = new ArrayList<TimeSheet>();

        // Konstruktor
        public PrzedstawicielKlienta(String imie, String nazwisko, int telefon, String email) {
            super(imie, nazwisko);
            this.telefon = telefon;
            this.email = email;
            this.dataDodania = LocalDate.now();
        }

        // Gettery
        @Override
        public LocalDate getDataDodania() {
            return dataDodania;
        }

        public int getTelefon() {
            return telefon;
        }

        public String getEmail() {
            return email;
        }


        public double getWartoscZamowien() {
            double wartoscZamowien = 0;
            for (Zamowienie a : zamowienia) {
                wartoscZamowien += a.obliczWartoscZamowienia();
            }
            return wartoscZamowien;
        }

        // miniprojekt - przesloniecie toString()
        @Override
        public String toString() {
            String result = "Przedstawiciel Klienta: " + getImie() + " " + getNazwisko() + " " + "\n" +
                    "Telefon: " + getTelefon() + "\n" + "Email: " + getEmail();
            //+ "\n" + "Wartosc zrealizowanych zamowien: " + getWartoscZamowien() + " PLN";
            return result;
        }
    }


}

