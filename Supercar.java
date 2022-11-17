import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Supercar
 */
public abstract class Supercar implements Movable {

    private int nrDoors;
    private Color color;
    private double enginePower;
    private String modelName;
    private double currentSpeed;
    private double x;
    private double y;
    List<Integer> directionWheel;

    public Supercar(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.x = 0;
        this.y = 0;
        this.directionWheel = new ArrayList<Integer>(4);
        directionWheel.add(1);
        directionWheel.add(0);
        directionWheel.add(-1);
        directionWheel.add(0);
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

    protected void setCurrentSpeed(double setSpeed) {
        if (0 <= setSpeed) {
            if (setSpeed <= enginePower) {
                currentSpeed = setSpeed;
            } else {
                currentSpeed = enginePower;
            }
        } else {
            currentSpeed = 0.0;
        }
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

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

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

    @Override
    public void move() {
        x += directionWheel.get(1) * getCurrentSpeed();
        y += directionWheel.get(0) * getCurrentSpeed();
    }

    public double[] getCarPosition() {
        double[] pos = new double[] {x,y};
        return pos;
    }

    @Override
    public void turnLeft(){
        Collections.rotate(directionWheel, -1);
    }
    @Override
    public void turnRight(){
        Collections.rotate(directionWheel, 1);
    }
}