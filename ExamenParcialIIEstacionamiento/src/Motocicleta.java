public class Motocicleta extends Vehiculo {

    private static final double TARIFA = 6.00;

    public Motocicleta(String placa, String propietario,
                       String horaIngreso, double horasUtilizadas) {

        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {

        double costo = getHorasUtilizadas() * TARIFA;

        if (getHorasUtilizadas() > 5) {
            costo = costo * 0.90;
        }

        return costo;
    }
}