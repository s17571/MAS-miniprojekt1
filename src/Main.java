public class Main {

    public static void main(String[] args) throws Exception {

        // Tworzenie danych
        DataCreation.utworzDane();

        System.out.println("AUDIOBOOKI:");
        Audiobook.showExtent();

        System.out.println();

        System.out.println("ALARMUJACE STANY MAGAZYNOWE:");
        System.out.println(Audiobook.znajdzBraki());

        System.out.println();
        // Wyszukaj przedstawiciela klienta po nazwisku
        PrzedstawicielKlienta.wyszukaj("Koala");
        // Wyszukaj przedstawiciela klienta po numerze telefonu
        PrzedstawicielKlienta.wyszukaj(600400122);
    }
}
