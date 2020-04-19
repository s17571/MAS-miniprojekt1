import java.time.LocalDate;

public class PrzedstawicielKlienta extends Osoba {

    private LocalDate data;
    private String imie;
    private String nazwisko;
    private int telefon;
    private String email;

    // Konstruktor
    public PrzedstawicielKlienta(String imie, String nazwisko, int telefon, String email, LocalDate data) {
        super(imie, nazwisko);
        this.telefon = telefon;
        this.email = email;
        this.data = data;
    }

    // Gettery
    @Override
    public LocalDate getData() {
        return data;
    }

    public int getTelefon() {
        return telefon;
    }


    public double getWartoscZamowien() {
        double wartoscZamowien = 0;
        for(Zamowienie a : zamowienia){
            wartoscZamowien += a.obliczWartoscZamowienia();
        }
        return wartoscZamowien;
    }

    public static void szukajPoImieniu(String imie) throws ClassNotFoundException {
        Iterable<PrzedstawicielKlienta> przedstawicielExtent = ObjectPlus.getExtent(PrzedstawicielKlienta.class);
        for(PrzedstawicielKlienta przedstawicielKlienta : przedstawicielExtent){
            if(imie.equals(przedstawicielKlienta.getImie())){
                System.out.println("Szukales: " + przedstawicielKlienta);
            }
        }
    }

    //miniprojekt - przeciazanie
    public static void wyszukaj(String nazwisko) throws ClassNotFoundException {
        Iterable<PrzedstawicielKlienta> przedstawicielExtent = ObjectPlus.getExtent(PrzedstawicielKlienta.class);
        for(PrzedstawicielKlienta przedstawicielKlienta : przedstawicielExtent){
            if(nazwisko.equals(przedstawicielKlienta.getNazwisko())){
                System.out.println("Szukales: " + przedstawicielKlienta);
            }
        }
    }
    //miniprojekt - przeciazanie metody wyszukaj
    public static void wyszukaj(int telefon) throws ClassNotFoundException {
        Iterable<PrzedstawicielKlienta> przedstawicielExtent = ObjectPlus.getExtent(PrzedstawicielKlienta.class);
        for(PrzedstawicielKlienta przedstawicielKlienta : przedstawicielExtent){
            if(telefon == (przedstawicielKlienta.getTelefon())){
                System.out.println("Szukales: " + przedstawicielKlienta);
            }
        }
    }

    // miniprojekt - przesloniecie toString()
    @Override
    public String toString(){
        String result = "Przedstawiciel Klienta: " + getImie() + " " + getNazwisko() + " " +
                " Wartosc zamowien: " + getWartoscZamowien() + " zl ";
        return result;
    }










}
