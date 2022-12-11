package vehicleModel;

import java.awt.Color;

/**
 * TrimCar
 */
public class TrimCar extends Car {

    private final double trimFactor;

    public TrimCar(int nrDoors, Color color, int enginePower, String modelName, double trimFactor, double x, double y) {
        super(nrDoors, color, enginePower, modelName, x, y);
        this.trimFactor = trimFactor;
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}