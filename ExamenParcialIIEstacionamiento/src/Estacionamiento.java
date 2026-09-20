import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Estacionamiento {

    private ArrayList<Vehiculo> vehiculos;
    private HashSet<String> placas;

    public Estacionamiento() {

        vehiculos = new ArrayList<>();
        placas = new HashSet<>();
    }
    public boolean registrarVehiculo(Vehiculo vehiculo) {

        String placa = vehiculo.getPlaca().toUpperCase();

        if (placas.contains(placa)) {

            System.out.println("La placa ya se encuentra registrada.");
            return false;
        }

        vehiculos.add(vehiculo);
        placas.add(placa);

        System.out.println("Vehículo registrado correctamente.");

        return true;
    }
}
