import java.time.LocalDate;
import java.util.ArrayList;

public class AutorTekstu extends Osoba {

    private LocalDate dataDodania;
    public ArrayList<Audiobook> audiobooki = new ArrayList<Audiobook>(); // MP2 - asocjacja zwykla, licznosc wiele, ale ostatecznie ObjectPlusPlus

    // Konstruktor
    public AutorTekstu(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.dataDodania = LocalDate.now();
    }

    @Override
    public LocalDate getDataDodania() {
        return dataDodania;
    }

    public String toString() {
        String result = "Autor: " + getImie() + " " + getNazwisko();
//        for (Audiobook a : audiobooki) {
//            result += " Audiobooki autora: " + a.getTytul() + " liczba lat od wydania: " + a.getLiczbaLatOdWydania() + " lat" + "\n";
//        }
        return result;
    }


}	





