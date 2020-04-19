import java.time.LocalDate;
import java.util.ArrayList;

public class AutorTekstu extends Osoba {

    private String nazwisko;
    private String imie;
    private LocalDate dataDodania;

    // Konstruktor
    public AutorTekstu(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.dataDodania = LocalDate.now();
    }

    // Gettery
    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    @Override
    public LocalDate getDataDodania() {
        return dataDodania;
    }


    public ArrayList<Audiobook> audiobooki = new ArrayList<Audiobook>();

    public void przypiszAudiobook(Audiobook newAudiobook) throws Exception {
        if (!audiobooki.contains(newAudiobook)) {
            audiobooki.add(newAudiobook);
        }
    }

    public String toString() {
        String result = "Autor: " + "\n";
        for (Audiobook a : audiobooki) {
            result += " Audiobooki autora: " + a.getTytul() + " liczba lat od wydania: " + a.getLiczbaLatOdWydania() + " lat" + "\n";
        }
        return result;
    }


}	





