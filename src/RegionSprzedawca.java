import java.time.LocalDate;

// MP2 - asocjacja z atrybutem
public class RegionSprzedawca extends ObjectPlusPlus {

    private LocalDate dataPrzypisania;
    private String wskazowki;
    private Boolean czyPrzypisany;
    private Region region;
    private Sprzedawca sprzedawca;

    // Konstruktor
    public RegionSprzedawca(Region region, Sprzedawca sprzedawca, String wskazowki) {
        this.dataPrzypisania = LocalDate.now();
        this.wskazowki = wskazowki;
        this.czyPrzypisany = true;
        this.region = region;
        this.sprzedawca = sprzedawca;
    }

    public String toString() {
        String result = "Sprzedawca: " + sprzedawca.getImie() + " " + sprzedawca.getNazwisko() + "\n" + "Region: " + region.nazwaWojewodztwa + " od " + dataPrzypisania;
        if (czyPrzypisany) {
            result += " Przypisanie Aktywne";
        } else {
            result += " Przypisanie Nieaktywne";
        }
        return result;
    }
}
