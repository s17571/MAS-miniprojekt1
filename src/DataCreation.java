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

            Audiobook audiobook1 = new Audiobook("Calineczka", 1876, wydawnictwo1, 19.00, 4, gatunki1, 19);
            Audiobook audiobook2 = new Audiobook("Muminki", 1922, wydawnictwo2, 28.00, 100, gatunki2, 19);

            Adres.przypiszAdres("Siedziba", wydawnictwo1, "Polska", "Warszawa", "Koszykowa", 86);
            Adres.przypiszAdres("Magazyn", wydawnictwo2, "Polska", "Los Angeles", "Simple Street", 12);
            Adres.przypiszAdres("Magazyn", wydawnictwo1, "USA", "Londyn", "King Street", 18);

            Osoba przedstawiciel1 = new PrzedstawicielKlienta("Jan", "Nowak", 600400122, "hi@prod.com");
            Osoba przedstawiciel2 = new PrzedstawicielKlienta("Marcin", "Koala", 123123123, "test@test.com");

            Osoba sprzedawca1 = new Sprzedawca("Jolanta", "Kowalska", "99313312312", 111111111, 2500);
            Osoba sprzedawca2 = new Sprzedawca("Jan", "Nowak", "94341234123", 222222333, 500);

            Adres adresFirmy1 = new Adres("Siedziba", "USA", "NY", "10th Avenue", 200);
            RabatKliencki rabat1 = new RabatIlosciowy(0.05, 1999.99);
            Klient klient1 = new Klient("Audiobook Enterprise", "12312312334", adresFirmy1, rabat1);
            klient1.wypiszAdresKlienta();

            Zamowienie zamowienie1 = new Zamowienie(1, przedstawiciel1, sprzedawca1, 0.2);
            Zamowienie zamowienie2 = new Zamowienie(2, przedstawiciel2, sprzedawca1, 0.1);
            Zamowienie zamowienie3 = new Zamowienie(3, przedstawiciel1, sprzedawca2, 0.05);

            przedstawiciel1.addZamowienieKlient(zamowienie1);
            przedstawiciel2.addZamowienieKlient(zamowienie2);
            przedstawiciel1.addZamowienieKlient(zamowienie3);

            sprzedawca1.addZamowienieSprzedawca(zamowienie1);
            sprzedawca1.addZamowienieSprzedawca(zamowienie2);
            sprzedawca2.addZamowienieSprzedawca(zamowienie3);

            zamowienie1.addAudiobook(audiobook1);
            zamowienie1.addAudiobook(audiobook2);
            zamowienie2.addAudiobook(audiobook2);
            zamowienie3.addAudiobook(audiobook1);
            zamowienie3.addAudiobook(audiobook2);

            System.out.println("WARTOSC NETTO ZAMOWIENIA NR " + zamowienie1.getNrZamowienia() + ": " + zamowienie1.obliczWartoscZamowienia() + " PLN");
            System.out.println("WARTOSC ZNIZKI PROMOCYJNEJ " + zamowienie1.getNrZamowienia() + ": " + zamowienie1.getWartoscZnizkiPromocyjnejNetto() + " PLN");
            System.out.println();

            autorTekstu2.przypiszAudiobook(audiobook1);
            autorTekstu1.przypiszAudiobook(audiobook2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
