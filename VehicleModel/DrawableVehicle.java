package VehicleModel;

import java.awt.image.BufferedImage;

public class DrawableVehicle {
    
    private final Vehicle vehicle;
    private final BufferedImage image;

    public DrawableVehicle(Vehicle vehicle, BufferedImage image) {
        this.vehicle = vehicle;
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

}
