import java.time.LocalDate;

public class TimeSheet extends ObjectPlusPlus {

    private LocalDate data;
    private int liczbaGodzin;
    private String opis;
    private Sprzedawca sprzedawca;

    public TimeSheet(LocalDate data, int liczbaGodzin, String opis) {
        this.data = data;
        this.liczbaGodzin = liczbaGodzin;
        this.opis = opis;
    }

    @Override
    public String toString() {
        String result = "Time Sheet: " + "\n" + data + " " + opis;
        return result;
    }
}
