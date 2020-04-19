import java.time.LocalDate;

public class Lektor extends Osoba {

    private LocalDate data;

    // Konstruktor
    public Lektor(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    // Gettery
    @Override
    public LocalDate getData() {
        return data;
    }

}