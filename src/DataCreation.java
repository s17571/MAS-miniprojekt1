import java.time.LocalDate;
import java.util.ArrayList;

public class DataCreation {

    public static void utworzDane() {
        try {
            AutorTekstu autorTekstu1 = new AutorTekstu("Jan", "Brzechwa");
            AutorTekstu autorTekstu2 = new AutorTekstu("Adam", "Mickiewicz");

            Wydawnictwo wydawnictwo1 = new Wydawnictwo("Wyd Proszynski", 112112112, "email@email.com");
            Wydawnictwo wydawnictwo2 = new Wydawnictwo("Wyd Znak", 332332332, "email2@email.com");

            ArrayList<String> gatunki1 = new ArrayList<String>();
            gatunki1.add("Science fiction");
            gatunki1.add("Przygodowe");
            ArrayList<String> gatunki2 = new ArrayList<String>();
            gatunki1.add("Romans");

            Audiobook audiobook1 = new Audiobook("Tytul 1", 1876, wydawnictwo1, 19.00, 4, gatunki1, 19);
            Audiobook audiobook2 = new Audiobook("Tytul 2", 1922, wydawnictwo2, 28.00, 100, gatunki2, 19);

            Adres.przypiszAdres("Siedziba", wydawnictwo1, "Polska", "Warszawa", "Koszykowa", 86);
            Adres.przypiszAdres("Magazyn", wydawnictwo2, "Polska", "Los Angeles", "Simple Street", 12);
            Adres.przypiszAdres("Magazyn", wydawnictwo1, "USA", "Londyn", "King Street", 18);

            LocalDate a1 = LocalDate.of(2020, 1, 22);
            LocalDate a2 = LocalDate.of(2020, 2, 13);
            LocalDate a3 = LocalDate.of(2019, 3, 22);
            LocalDate a4 = LocalDate.of(2020, 4, 1);

            Osoba klient1 = new PrzedstawicielKlienta("Jan", "Nowak", 123123123, "hi@prod.com", a1);
            Osoba klient2 = new PrzedstawicielKlienta("Marcin", "Koala", 123123123, "test@test.com", a2);

            Osoba sprzedawca1 = new Sprzedawca("Jolanta", "Kowalska", "99313312312", 111111111, a3, 2500);
            Osoba sprzedawca2 = new Sprzedawca("Jan", "Nowak", "94341234123", 222222333, a4, 500);

            Zamowienie zamowienie1 = new Zamowienie(1, klient1, sprzedawca1);
            Zamowienie zamowienie2 = new Zamowienie(2, klient2, sprzedawca1);
            Zamowienie zamowienie3 = new Zamowienie(3, klient1, sprzedawca2);

            klient1.addZamowienieKlient(zamowienie1);
            klient2.addZamowienieKlient(zamowienie2);
            klient1.addZamowienieKlient(zamowienie3);

            sprzedawca1.addZamowienieSprzedawca(zamowienie1);
            sprzedawca1.addZamowienieSprzedawca(zamowienie2);
            sprzedawca2.addZamowienieSprzedawca(zamowienie3);

            zamowienie1.addAudiobook(audiobook1);
            zamowienie1.addAudiobook(audiobook2);
            zamowienie2.addAudiobook(audiobook2);
            zamowienie3.addAudiobook(audiobook1);
            zamowienie3.addAudiobook(audiobook2);

            autorTekstu2.przypiszAudiobook(audiobook1);
            autorTekstu1.przypiszAudiobook(audiobook2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
