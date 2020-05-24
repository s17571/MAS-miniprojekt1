import java.time.LocalDate;

public class Sprzedawca extends Osoba {

    private String PESEL;
    private long telefon;
    private LocalDate dataDodania;
    private int wynagrodzenie;

    // Konstruktor
    public Sprzedawca(String imie, String nazwisko, String PESEL, long telefon, int wynagrodzenie) {
        super(imie, nazwisko);
        this.PESEL = PESEL;
        this.telefon = telefon;
        this.dataDodania = LocalDate.now();
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
    public LocalDate getDataDodania() {
        return dataDodania;
    }


    public static void szukajPoImieniu(String imie) throws ClassNotFoundException {
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
        String result = "Sprzedawca: " + getImie() + " " + getNazwisko() + " PESEL: " + getPESEL() + " Telefon: " + getTelefon() + " Data zatrudnienia: " + getDataDodania() + " Pensja: " + getWynagrodzenie() + " zl";
                //+ "\n" + " Obslugiwane zakupy:" + "\n";
        //for (Zamowienie a : zamowienia2) {
        //    result += " ID zakupu: " + a.getNrZamowienia() + " laczny koszt tego zakupu: " + a.obliczWartoscZamowienia() + " zl " + "\n";
        //}
        return result;
    }


}
