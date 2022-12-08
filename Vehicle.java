import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Supercar

    Skapa subklass till vehicle som heter typ smallcar, transporter och scania är subclasser till bigcar eller dyl. Sedan laddar vi 
    transporter med array av smallcars för att undvika att man kan ladda transporters på transporters på transporters.
 */
public abstract class Vehicle implements Movable {

    private final int nrDoors;
    private Color color;                    //can be hypothetically changed in car repair shop
    private double enginePower;             //can be hypothetically changed in car repair shop
    private final String modelName;
    private double currentSpeed;
    private double x;
    private double y;
    private List<Integer> directionWheel;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, double x, double y) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = x;
        this.y = y;
        this.directionWheel = new ArrayList<Integer>(4);
        directionWheel.add(0);
        directionWheel.add(1);
        directionWheel.add(0);
        directionWheel.add(-1);
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    private void setCurrentSpeed(double setSpeed) {
        currentSpeed = setSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    private void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    private void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1) {
            incrementSpeed(amount);
        } else {
            throw new Error("Gas amount out of range [0,1]");
        }
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1){
            decrementSpeed(amount);
        } else {
            throw new Error("Break amount out of range [0,1]");
        }
    }

    public int[] getDirections() {
        return new int[]{directionWheel.get(1),directionWheel.get(0)};
    }

    @Override
    public void move() {
        x += getDirections()[0] * getCurrentSpeed();
        y += getDirections()[1] * getCurrentSpeed();
    }

    public double[] getPosition() {
        double[] pos = new double[] {x,y};
        return pos;
    }

    protected void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void turnLeft() {
        Collections.rotate(directionWheel, -1);
    }

    @Override
    public void turnRight() {
        Collections.rotate(directionWheel, 1);
    }
}