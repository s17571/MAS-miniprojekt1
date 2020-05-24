import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Wydawnictwo extends ObjectPlusPlus {

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

//    public void addAudiobookQualif(Audiobook audiobook) throws Exception {
//        if(!audiobookQualif.containsKey(audiobook.tytul)) {
//            audiobookQualif.put(audiobook.tytul, audiobook);
//            // polaczenie zwrotne
//            audiobook.addWydawnictwo(this);
//        }
//    }

    public ObjectPlusPlus szukajPoNazwieAudiobooka(String nazwa) throws Exception {
        if(getLinkedObject("audiobook", nazwa) == null) {
            throw new Exception("Nie znaleziono audiobooka " + nazwa + " przypisanego do tego wydawnictwa");
        } else return getLinkedObject("audiobook", nazwa);
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
