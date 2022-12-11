import vehiclemodel.*;
import java.io.IOException;

public class VehicleApp {

    public static void main(String[] args) {
        
        VehicleModel vm = new VehicleModel();

        try {
            vm.addDrawableVehicle(DrawableVehicleFactory.createDrawableVolvo(0, 0));
            vm.addDrawableVehicle(DrawableVehicleFactory.createDrawableSaab(0, 100));
            vm.addDrawableVehicle(DrawableVehicleFactory.createDrawableScania(0, 200));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        VehicleView vv = new VehicleView("CarSim 1.0", vm);

        VehicleController vc = new VehicleController(vm,vv);

        vv.addObserver(vc);
        vm.addObserver(vv);

    }
}
