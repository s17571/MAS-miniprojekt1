import java.util.ArrayList;

public class Kraj {

    private String nazwa;
    private String waluta;
    private Integer stawkaVat;
    ArrayList<Adres> adresy = new ArrayList<>();

    public Kraj (String nazwa, String waluta, Integer stawkaVat) {
        this.nazwa = nazwa;
        this.waluta = waluta;
        this.stawkaVat = stawkaVat;
    }
}
