import java.awt.Color;
/**
 * Truck
 */
public class Truck extends Vehicle {

    private boolean rampInStandardPosition;

    Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        this.rampInStandardPosition = true;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }
    
    @Override
    public void incrementSpeed(double amount) {
        incrementSpeedIfSafe(amount);
    }

    private void incrementSpeedIfSafe(double amount) {
        if (this.rampInStandardPosition) {
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        } else {
            throw new Error("Ramp is up, can't increase speed");
        }
    }

    protected void setRampForUse() {
        rampInStandardPosition = false;
    }

    protected void setRampStandardPosition() {
        rampInStandardPosition = true;
    }

    public boolean getRampStandardPositionStatus() {
        return rampInStandardPosition;
    }
}