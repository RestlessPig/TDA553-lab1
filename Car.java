import java.awt.Color;
/**
 * SmallCar
 */
// Kolla med TA om detta är en bra ide eller om man ska få skapa transporterstacks
public abstract class Car extends Vehicle {

    private boolean isBeingTransported;

    Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.isBeingTransported = false;
    }

    protected void toggleIsBeingTransported() {
        this.isBeingTransported = !this.isBeingTransported;
    }
   
}