import java.awt.*;

public class Saab95 extends Supercar {

    private boolean turboOn;

    // public Saab95(){
    // nrDoors = 2;
    // color = Color.red;
    // enginePower = 125;
    // turboOn = false;
    // modelName = "Saab95";
    // stopEngine();
    // }

    public Saab95() {
        super(2, Color.red, 125, "Saab95", 0);
        this.turboOn = false;
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
            turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}