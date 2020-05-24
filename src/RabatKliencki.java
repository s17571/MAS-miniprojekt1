import java.io.Serializable;

public abstract class RabatKliencki extends ObjectPlusPlus {

    private double znizkaProcentowa;

    // Konstruktor
    RabatKliencki(double znizkaProcentowa) {
        super();
        this.znizkaProcentowa = znizkaProcentowa;
    }

    // Gettery
    public double getZnizkaProcentowa() {
        return znizkaProcentowa;
    }
}
