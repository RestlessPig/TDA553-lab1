import java.awt.Color;
/**
 * SmallCar
 */
// Kolla med TA om detta är en bra ide eller om man ska få skapa transporterstacks
public abstract class Car extends Vehicle {

    private boolean isLoaded;

    Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.isLoaded = false;
    }

    protected void toggleIsLoaded() {
        this.isLoaded = !this.isLoaded;
    }
   
   @Override
    public void move() {
        if (!isLoaded) {
        super.move();
        }
    }
}