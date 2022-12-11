package vehicleModel;

import java.awt.Color;

/**
 * Truck
 */
public class Truck extends Vehicle {

    private boolean rampInStandardPosition;

    Truck(int nrDoors, Color color, double enginePower, String modelName, double x, double y) {
        super(nrDoors, color, enginePower, modelName, x, y);
        this.rampInStandardPosition = true;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
    
    @Override
    public void gas(double amount) {
        if (this.rampInStandardPosition) {
            super.gas(amount);
        } else {
            throw new Error("Ramp is not in standard position, can't increase speed");
        }
    }

    public void setRampForUse() {
        rampInStandardPosition = false;
    }

    public void setRampStandardPosition() {
        rampInStandardPosition = true;
    }

    public boolean getRampStandardPositionStatus() {
        return rampInStandardPosition;
    }
}