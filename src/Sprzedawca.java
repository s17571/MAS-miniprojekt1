import java.time.LocalDate;
import java.util.ArrayList;

public class Sprzedawca extends Osoba {

    private String PESEL;
    private long telefon;
    private LocalDate data;
    private int wynagrodzenie;

    // Konstruktor
    public Sprzedawca(String imie, String nazwisko, String PESEL, long telefon, LocalDate date, int wynagrodzenie) {
        super(imie, nazwisko);
        this.PESEL = PESEL;
        this.telefon = telefon;
        this.data = data;
        this.wynagrodzenie = wynagrodzenie;
    }

    // Gettery
    public String getPESEL() {
        return PESEL;
    }

    public long getTelefon() {
        return telefon;
    }

    public int getWynagrodzenie() {
        return wynagrodzenie;
    }

    @Override
    public LocalDate getData() {
        return data;
    }


    public static void szukajPoImieniu(String imie) throws ClassNotFoundException{
        Iterable<Sprzedawca> sprzedawcaExtent = ObjectPlus.getExtent(Sprzedawca.class);
        for (Sprzedawca sprzedawca : sprzedawcaExtent) {
            if (imie.equals(sprzedawca.getImie())) {
                System.out.println("Szukales: " + sprzedawca);
            }
        }
    }

    public static void szukajPoNazwisku(String nazwisko) throws ClassNotFoundException {
        Iterable<Sprzedawca> sprzedawcaExtent = ObjectPlus.getExtent(Sprzedawca.class);
        for (Sprzedawca sprzedawca : sprzedawcaExtent) {
            if (nazwisko.equals(sprzedawca.getNazwisko())) {
                System.out.println("Szukales: " + sprzedawca);
            }
        }


    }


    public String toString() {
        String result = "Sprzedawca: " + getImie() + " " + getNazwisko() + " PESEL: " + getPESEL() + " Telefon: " + getTelefon() + " Data zatrudnienia: " + getData() + " Pensja: " + getWynagrodzenie() + " zl" + "\n" + " Obslugiwane zakupy:" + "\n";
        for (Zamowienie a : zamowienia2) {
            result += " ID zakupu: " + a.getNrZamowienia() + " laczny koszt tego zakupu: " + a.obliczWartoscZamowienia() + " zl " + "\n";
        }
        return result;
    }


}
