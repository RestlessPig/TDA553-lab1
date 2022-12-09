import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    //BufferedImage volvoImage;
    //BufferedImage saabImage;
    //BufferedImage scaniaImage;
    // To keep track of a singel cars position

    private Dictionary<Object,BufferedImage> imageDictionary = new Hashtable<>();

    private ArrayList<Vehicle> vehicles;

    public void updateVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            BufferedImage volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            BufferedImage saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            BufferedImage scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));


            
            imageDictionary.put(Volvo240.class, volvoImage);
            imageDictionary.put(Saab95.class, saabImage);
            imageDictionary.put(Scania.class, scaniaImage);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle vehicle : vehicles) {
            g.drawImage(imageDictionary.get(vehicle.getClass()), (int)vehicle.getPosition()[0], (int)vehicle.getPosition()[1], null); // see javadoc for more info on the parameters   
        }
    }
}
