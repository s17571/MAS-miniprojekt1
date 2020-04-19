import java.io.Serializable;

public abstract class RabatKliencki extends ObjectPlus implements Serializable {

    private double znizkaProcentowa;

    // Konstruktor
    RabatKliencki(double znizkaProcentowa) {
        super();
        this.znizkaProcentowa = znizkaProcentowa;
    }

    // Gettery
    public double getZnizkaProcentowa(){
        return znizkaProcentowa;
    }
}
