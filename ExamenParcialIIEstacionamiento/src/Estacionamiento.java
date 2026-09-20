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
    public void mostrarVehiculos() {

        if (vehiculos.isEmpty()) {

            System.out.println("No existen vehículos registrados.");
            return;
        }

        for (Vehiculo vehiculo : vehiculos) {

            System.out.println("-----------------------------");

            vehiculo.mostrarInformacion();

            System.out.println(
                    "Tipo: " + vehiculo.getClass().getSimpleName()
            );

            System.out.printf(
                    "Costo: Q%.2f%n",
                    vehiculo.calcularCosto()
            );
        }

    }
    public void buscarPorPlaca(String placa) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {

                vehiculo.mostrarInformacion();

                System.out.println(
                        "Tipo: " + vehiculo.getClass().getSimpleName()
                );

                System.out.printf(
                        "Costo: Q%.2f%n",
                        vehiculo.calcularCosto()
                );

                return;
            }
        }

        System.out.println("Vehículo no encontrado.");
    }
    public void mostrarMayorCosto() {

        if (vehiculos.isEmpty()) {

            System.out.println("No existen vehículos registrados.");
            return;
        }

        Vehiculo mayor = vehiculos.get(0);

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.calcularCosto() > mayor.calcularCosto()) {
                mayor = vehiculo;
            }
        }

        System.out.println("Vehículo con mayor costo:");

        mayor.mostrarInformacion();

        System.out.printf(
                "Costo: Q%.2f%n",
                mayor.calcularCosto()
        );
    }

    public void mostrarTotalGeneral() {

        double total = 0;

        for (Vehiculo vehiculo : vehiculos) {

            total += vehiculo.calcularCosto();
        }

        System.out.printf(
                "Total general recaudado: Q%.2f%n",
                total
        );
    }
    public void mostrarTotalPorTipo() {

        HashMap<String, Double> totales = new HashMap<>();

        for (Vehiculo vehiculo : vehiculos) {

            String tipo =
                    vehiculo.getClass().getSimpleName();

            double costo =
                    vehiculo.calcularCosto();

            totales.put(
                    tipo,
                    totales.getOrDefault(tipo, 0.0) + costo
            );
        }

        System.out.println("TOTAL RECAUDADO POR TIPO");

        for (String tipo : totales.keySet()) {

            System.out.printf(
                    "%s: Q%.2f%n",
                    tipo,
                    totales.get(tipo)
            );
        }
    }

}
