import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class VehicleView extends JFrame implements Observer{
    private static final int X = 1000;
    private static final int Y = 800;

    // The controller member
    private VehicleModel vehicleM;

    private ArrayList<Observer> observers;

    DrawPanel drawPanel;

    // Constructor
    public VehicleView(String framename, VehicleModel vm, VehicleController vc) {
        this.vehicleM = vm;
        this.drawPanel = new DrawPanel(X, Y-340);
        observers = new ArrayList<>();
        initComponents(framename);
        this.add(vc, BorderLayout.SOUTH);
    }

    public void updateVehicles() {
        drawPanel.updateVehicles(vehicleM.getVehicles());
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void updateObserver() {
        updateVehicles();
        drawPanel.repaint();
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);          
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}