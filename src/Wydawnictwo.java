import java.io.Serializable;
import java.util.ArrayList;

public class Wydawnictwo extends ObjectPlus implements Serializable {

    private String nazwaWydawnictwa;
    private long telefon; // atrybut wymagany, nie moze byc null
    private String email;
    private ArrayList<Adres> adresy = new ArrayList<Adres>();

    // Konstruktor
    public Wydawnictwo(String nazwaWydawnictwa, long telefon, String email) {
        super();
        this.nazwaWydawnictwa = nazwaWydawnictwa;
        this.telefon = telefon;
        this.email = email;
    }

    // Gettery
    public String getNazwaWydawnictwa() {
        return nazwaWydawnictwa;
    }

    public long getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public Audiobook szukajPoNazwieWydawnictwa(String nazwa) throws Exception {
        //TODO implement
        return null;
    }

    public void addAdresWytworni(Adres adres) throws Exception {
        if (!adresy.contains(adres) && adres != null) {
            adresy.add(adres);
        } else {
            throw new Exception("Wydawnictwo już jest dodana do tego adresu");
        }
    }

    public String toString() {
        String result = "Wydawnictwo: " + getNazwaWydawnictwa() + "\n";
        for (Adres a : adresy) {
            result += " Lokalizacja budynku: " + a.getKraj() + " " + a.getMiejscowosc() + " " + a.getUlica() + " " + a.getNrBudynku();
        }
        return result;
    }
}
