public class RabatIlosciowy extends RabatKliencki {

    private double minimalnaWartoscZamowienia;

    // Konstruktor
    RabatIlosciowy(double minimalnaWartoscZamowienia, double znizkaProcentowa) {
        super(znizkaProcentowa);
        this.minimalnaWartoscZamowienia = minimalnaWartoscZamowienia;
    }

    // Gettery
    public double getMinimalnaWartoscZamowienia() {
        return minimalnaWartoscZamowienia;
    }

}
