import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Osoba extends ObjectPlus implements Serializable {

    private String imie;
    private String nazwisko;

    public ArrayList<Zamowienie> zamowienia = new ArrayList<Zamowienie>();
    private static HashSet<Zamowienie> zamowieniaPrzypisaneDoKlientow = new HashSet<Zamowienie>();
    public ArrayList<Zamowienie> zamowienia2 = new ArrayList<Zamowienie>();
    private static HashSet<Zamowienie> zamowieniaPrzypisaneDoSprzedawcow = new HashSet<Zamowienie>();

    // Konstruktor
    public Osoba(String imie, String nazwisko) {
        super();
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // Gettery
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public abstract LocalDate getDataDodania();

    public void addZamowienieKlient(Zamowienie noweZakupy) throws Exception {
        if (!zamowienia.contains(noweZakupy)) {
            if (zamowieniaPrzypisaneDoKlientow.contains(noweZakupy)) {
                throw new Exception("To zamowienia ma juz klienta");
            }
            zamowienia.add(noweZakupy);
            zamowieniaPrzypisaneDoKlientow.add(noweZakupy);
        }
    }

    public void addZamowienieSprzedawca(Zamowienie noweZakupy) throws Exception {
        if (!zamowienia2.contains(noweZakupy)) {
            if (zamowieniaPrzypisaneDoSprzedawcow.contains(noweZakupy)) {
                throw new Exception("To zamowienia ma juz przypisanego sprzedawce");
            }
            zamowienia2.add(noweZakupy);
            zamowieniaPrzypisaneDoSprzedawcow.add(noweZakupy);
        }
    }
}
