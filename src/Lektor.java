import java.time.LocalDate;

public class Lektor extends Osoba {

    private LocalDate dataDodania;

    // Konstruktor
    public Lektor(String imie, String nazwisko) {
        super(imie, nazwisko);
        this.dataDodania = LocalDate.now();
    }

    // Gettery
    @Override
    public LocalDate getDataDodania() {
        return dataDodania;
    }

}