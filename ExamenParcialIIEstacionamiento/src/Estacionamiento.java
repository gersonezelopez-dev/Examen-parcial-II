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
}
