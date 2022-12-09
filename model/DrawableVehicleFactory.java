package model;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DrawableVehicleFactory {
    
    public static DrawableVehicle createDrawableVolvo(double x, double y) throws IOException {
        BufferedImage image = ImageIO.read(JPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        Vehicle vehicle = new Volvo240(x, y);
        return new DrawableVehicle(vehicle, image);
    }

    public static DrawableVehicle createDrawableSaab(double x, double y) throws IOException {
        BufferedImage image = ImageIO.read(JPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        Vehicle vehicle = new Saab95(x, y);
        return new DrawableVehicle(vehicle, image);
    }

    public static DrawableVehicle createDrawableScania(double x, double y) throws IOException {
        BufferedImage image = ImageIO.read(JPanel.class.getResourceAsStream("pics/Scania.jpg"));
        Vehicle vehicle = new Scania(x, y);
        return new DrawableVehicle(vehicle, image);
    }

    // Not needed
    //public static DrawableVehicle createDrawableTransporter(double x, double y, int slots) throws IOException {
    //    BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
    //    Vehicle vehicle = new Transporter(x, y, slots);
    //    return new DrawableVehicle(vehicle, image);
    //}

}
