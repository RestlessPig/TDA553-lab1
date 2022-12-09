package model;
import java.awt.Color;
/**
 * SmallCar
 */
// Car is a class that enables the subclasses to be loaded to a CarLoader
// We made this desicion to prevent Trucks from being loaded onto other Trucks
// thereby 
public abstract class Car extends Vehicle {

    private boolean isLoaded;

    Car(int nrDoors, Color color, double enginePower, String modelName, double x, double y) {
        super(nrDoors, color, enginePower, modelName, x, y);
        this.isLoaded = false;
    }

    protected void toggleIsLoaded() {
        this.isLoaded = !this.isLoaded;
    }

    protected boolean isLoaded() {
        return this.isLoaded;
    }
   
    @Override
    public void move() {
        if (!isLoaded) {
            super.move();
        } else {
            throw new Error("Cannot move car on loader");
        }
    }
}