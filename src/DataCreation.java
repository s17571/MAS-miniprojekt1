import java.time.LocalDate;
import java.util.ArrayList;

public class DataCreation {

    public static void utworzDane() {
        try {
            // 1. Asocjacja zwykla
            // Audiobook i AutorTekstu (wiele do wielu), implementacja przy uzyciu ObjectPlusPlus
            // ObjectPlusPlus: Map<String, Map<Object, ObjectPlusPlus>> links - kluczem to nazwa roli asocjacji, a
            // wartosc to mapa, gdzie: klucz to obiekt docelowy (lub kwalifikator), a wartosc to referencja do powiazania
            // Alternatywa: dwie Listy
            AutorTekstu autorTekstu1 = new AutorTekstu("Jan", "Brzechwa");
            Wydawnictwo wydawnictwo1 = new Wydawnictwo("Wyd Proszynski", 112112112, "email@email.com");
            Wydawnictwo wydawnictwo2 = new Wydawnictwo("Wyd Znak", 332332332, "email2@email.com");
            ArrayList<String> gatunki1 = new ArrayList<String>();
            gatunki1.add("Science fiction");
            gatunki1.add("Przygodowe");
            ArrayList<String> gatunki2 = new ArrayList<String>();
            gatunki1.add("Romans");
            Audiobook audiobook1 = new Audiobook("Calineczka", 1876, wydawnictwo1, 19.00, 4, gatunki1, 19);
            Audiobook audiobook2 = new Audiobook("Muminki", 1922, wydawnictwo2, 28.00, 100, gatunki2, 19);
            autorTekstu1.addLink("audiobook", "autor tekstu", audiobook1);
            autorTekstu1.addLink("audiobook", "autor tekstu", audiobook2);
            System.out.println();
            System.out.println("1. Asocjacja zwykla");
            autorTekstu1.showLinks("audiobook", System.out);
            System.out.println();
            audiobook1.showLinks("autor tekstu", System.out);
            ObjectPlus.removeExtent(AutorTekstu.class, autorTekstu1, "autor tekstu");

            // 2. Asocjacja z atrybutem
            // Sprzedawca i Region - wiele do wielu - jeden sprzedawca moze byc przypisany do wielu regionow, a jeden
            // region do wielu sprzedawcow, chcemy sledzic od kiedy sprzedawca odpowiada za dany region (pole DataPrzypisania),
            // zobaczyc wskazowki w polu tekstowym i zobaczyc czy aktualnie jest przypisany (boolean czyPrzypisany).
            // Klasa asocjacyjna RegionSprzedawca
            Region region = new Region("mazowieckie");
            Sprzedawca sprzedawca = new Sprzedawca("Adam", "Kowalski", "90090912223", 123456789, 2000);
            RegionSprzedawca regionSprzedawca = new RegionSprzedawca(region, sprzedawca, "Wskazowki");
            System.out.println();
            System.out.println("2. Asocjacja z atrybutem");
            System.out.println(regionSprzedawca);

            // 3. Asocjacja kwalifikowana
            // Wyszukiwanie audiobooka po tytule przy pomocy asocjacji kwalifikowanej - metoda szukajPoNazwieAudiobooka
            // w klasie Wydawnictwo. Kwalifikatorem ostatni argument metody addLink.
            // Alternatywa: mapa, gdzie kluczem kwalifikator (tytul aubiobooka), a wartoscia referencja do obiektu docelowego
            wydawnictwo1.addLink("audiobook", "wydawnictwo", audiobook1, audiobook1.tytul);
            wydawnictwo2.addLink("audiobook", "wydawnictwo", audiobook2, audiobook2.tytul);
            System.out.println();
            System.out.println("3. Asocjacja kwalifikowana");
            System.out.println(wydawnictwo1.szukajPoNazwieAudiobooka("Calineczka"));
            System.out.println(wydawnictwo2.szukajPoNazwieAudiobooka("Muminki"));
            //System.out.println(wydawnictwo1.getLinkedObject("audiobook", audiobook1.tytul));

            // 4. Kompozycja - PrzedstawicielKlienta a Klient (firma)
            // - Czesc nie moze byc wspóldzielona - przedstawiciel przypisany tylko do jednej firmy
            // - Czesc nie moze istniec bez calosci - przedstawiciel klienta nie moze istniec bez klienta (firmy)
            // - Usuniecie czesci nie oznacza usuniecia calosci.
            // Moze byc kilku przedstawicieli klienta przypisanych do tego samego klienta.
            // Klasa wewnętrzna PrzedstawicielKlienta w klasie Klient:
            // Obiekt klasy wewnętrznej nie może istnieć bez obiektu klasy zewnętrznej.
            // I obiekt klasy wewnętrznej ma bezpośredni dostęp do inwariantów obiektu klasy zewnętrznej.
            // Ponadto dodalem:
            // Kontener przechowujący referencje do obiektów-części w klasie zewnetrznej, zeyb zapewnic polaczenie w te strone.
            // W klasie zewnetrznej metode tworzącą część i zwracająca referencję do niej.
            Adres adresFirmy1 = new Adres("Siedziba", "Polska", "Warszawa", "Jagiellonska", 2);
            Adres adresFirmy2 = new Adres("Siedziba", "USA", "NY", "10th Avenue", 200);
            Klient klient = new Klient("Audiobooki.pl", "1234567891", adresFirmy1, null);
            Klient klient2 = new Klient("Audio.com", "2222222222", adresFirmy2, null);
            Klient.PrzedstawicielKlienta przedstawicielKlienta = klient.new PrzedstawicielKlienta("Mark", "Swanson", 123456789, "test@test.pl");
            klient.addPart("part", "whole", przedstawicielKlienta);
            // Ponizsze wyrzuci blad: The part is already connected to a whole
            // klient2.addPart("part", "whole", przedstawicielKlienta);
            System.out.println();
            System.out.println("4. Kompozycja");
            System.out.println();
            System.out.println("Czesc:");
            klient.showLinks("part", System.out);
            System.out.println();
            System.out.println("Calosc:");
            przedstawicielKlienta.showLinks("whole", System.out);

            // Zaimplementowalem metode do usuwania ekstensji wraz z czesciami, jesli istnieja
            ObjectPlus.removeExtentWithParts(Klient.class, Klient.PrzedstawicielKlienta.class, klient);
            ObjectPlus.showExtent(Klient.PrzedstawicielKlienta.class);

            // Uzycie zwyklej metody removeExtent zamiast removeExtentWithParts wyrzuciloby blad:
            // Calosc ma powiazane czesci, uzyj metody removeExtentWithParts
            // ObjectPlus.removeExtent(Klient.class, klient, "whole");

            // W ObjectPlusPlus zaimplementowalem tez metode removePart, w ktorej najpierw usuwam asocjacje, a potem obiekt czesci
            // klient.removePart(przedstawicielKlienta);
            // Ponizsze wyrzuci blad
            // klient.removeLink("part");
            // Ponizsze wyrzuci blad: No links for the role: part
            // klient.showLinks("part", System.out);


            // 5. Agregacja - implementacja agregacji, ktora nie jest kompozycja jest dokładnie taka sama jak asocjacji
            // Część może należeć do kilku całości.
            // Usunięcie klasy całość nie wpływa na istnienie klasy część.
            // Silniejsza forma asocjacji - równowaga między powiązanymi klasami jest zaburzona: istnieje właściciel i obiekt podrzędny
            // U mnie to TimeSheet i Sprzedawca - z TimeSheetem powiazany jeden Sprzedawca, a Sprzedawca moze miec wiele TimeSheetow przypisanych
            // Poza tym TimeSheety moga istniec w bez przedstawicieli (np. jako szablony)
            // Implementacja za pomoca ObjectPlusPlus
            // Alternatywnie mozna bylo tez uzyc List<TimeSheet> w klasie Sprzedawca i referencji do Sprzedawcy w klasie TimeSheet
            TimeSheet timeSheet1 = new TimeSheet(LocalDate.now(), 8, "Projekt X");
            TimeSheet timeSheet2 = new TimeSheet(LocalDate.now(), 8, "Projekt Z");
            sprzedawca.addLink("timeSheet", "sprzedawca", timeSheet1);
            sprzedawca.addLink("timeSheet", "sprzedawca", timeSheet2);
            System.out.println();
            System.out.println("5. Agregacja");
            sprzedawca.showLinks("timeSheet", System.out);
            System.out.println();
            timeSheet1.showLinks("sprzedawca", System.out);
            System.out.println();
            timeSheet1.removeLink("sprzedawca");
            //Ponizsze wyrzuci blad: No links for the role: sprzedawca
            //timeSheet1.showLinks("sprzedawca", System.out);





























            /*
            miniprojekt1


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

            //Osoba przedstawiciel1 = new PrzedstawicielKlienta("Jan", "Nowak", 600400122, "hi@prod.com");
            //Osoba przedstawiciel2 = new PrzedstawicielKlienta("Marcin", "Koala", 123123123, "test@test.com");

            Osoba sprzedawca1 = new Sprzedawca("Jolanta", "Kowalska", "99313312312", 111111111, 2500);
            Osoba sprzedawca2 = new Sprzedawca("Jan", "Nowak", "94341234123", 222222333, 500);

            Adres adresFirmy1 = new Adres("Siedziba", "USA", "NY", "10th Avenue", 200);
            RabatKliencki rabat1 = new RabatIlosciowy(0.05, 1999.99);
            Klient klient1 = new Klient("Audiobook Enterprise", "12312312334", adresFirmy1, rabat1);
            klient1.wypiszAdresKlienta();

            //Zamowienie zamowienie1 = new Zamowienie(1, przedstawiciel1, sprzedawca1, 0.2);
            //Zamowienie zamowienie2 = new Zamowienie(2, przedstawiciel2, sprzedawca1, 0.1);
            //Zamowienie zamowienie3 = new Zamowienie(3, przedstawiciel1, sprzedawca2, 0.05);

            //przedstawiciel1.addZamowienieKlient(zamowienie1);
            //przedstawiciel2.addZamowienieKlient(zamowienie2);
            //przedstawiciel1.addZamowienieKlient(zamowienie3);

            //sprzedawca1.addZamowienieSprzedawca(zamowienie1);
            //sprzedawca1.addZamowienieSprzedawca(zamowienie2);
            //sprzedawca2.addZamowienieSprzedawca(zamowienie3);

            //zamowienie1.addAudiobook(audiobook1);
            //zamowienie1.addAudiobook(audiobook2);
            //zamowienie2.addAudiobook(audiobook2);
            //zamowienie3.addAudiobook(audiobook1);
            //zamowienie3.addAudiobook(audiobook2);

            //System.out.println("WARTOSC NETTO ZAMOWIENIA NR " + zamowienie1.getNrZamowienia() + ": " + zamowienie1.obliczWartoscZamowienia() + " PLN");
            //System.out.println("WARTOSC ZNIZKI PROMOCYJNEJ " + zamowienie1.getNrZamowienia() + ": " + zamowienie1.getWartoscZnizkiPromocyjnejNetto() + " PLN");
            System.out.println();

            autorTekstu2.przypiszAudiobook(audiobook1);
            autorTekstu1.przypiszAudiobook(audiobook2);
            */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
