import java.awt.Color;

/**
 * TurboCar
 */
public abstract class TurboCar extends Car {

    private boolean turboOn;

    TurboCar(int nrDoors, Color color, int enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
        turboOn = false;
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3; // TODO kanske borde ändra så att turbo inte är en konstant och kan variera mellan bilar.
        return getEnginePower() * 0.01 * turbo;
    }

}