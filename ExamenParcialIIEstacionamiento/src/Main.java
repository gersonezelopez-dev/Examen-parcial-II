import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Estacionamiento estacionamiento =
                new Estacionamiento();

        int opcion = 0;

        do {

            System.out.println();
            System.out.println("===== ESTACIONAMIENTO =====");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Mostrar vehículos");
            System.out.println("3. Buscar por placa");
            System.out.println("4. Vehículo con mayor costo");
            System.out.println("5. Total general");
            System.out.println("6. Total por tipo");
            System.out.println("7. Salir");

            try {

                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(
                        scanner.nextLine()
                );

                switch (opcion) {

                    case 1:
                        registrar(scanner, estacionamiento);
                        break;

                    case 2:
                        estacionamiento.mostrarVehiculos();
                        break;

                    case 3:

                        System.out.print("Ingrese la placa: ");

                        String placa =
                                scanner.nextLine();

                        estacionamiento.buscarPorPlaca(placa);

                        break;

                    case 4:
                        estacionamiento.mostrarMayorCosto();
                        break;

                    case 5:
                        estacionamiento.mostrarTotalGeneral();
                        break;

                    case 6:
                        estacionamiento.mostrarTotalPorTipo();
                        break;

                    case 7:
                        System.out.println(
                                "Programa finalizado."
                        );
                        break;

                    default:
                        System.out.println(
                                "Opción no válida."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Error: debe ingresar un número."
                );

            } finally {

                System.out.println(
                        "Operación del menú finalizada."
                );
            }

        } while (opcion != 7);

        scanner.close();
    }

    private static void registrar(
            Scanner scanner,
            Estacionamiento estacionamiento) {

        try {

            System.out.println();
            System.out.println("TIPO DE VEHÍCULO");

            System.out.println("1. Automóvil");
            System.out.println("2. Motocicleta");

            System.out.print("Seleccione tipo: ");

            int tipo =
                    Integer.parseInt(scanner.nextLine());

            if (tipo != 1 && tipo != 2) {

                System.out.println(
                        "Tipo de vehículo no válido."
                );

                return;
            }

            System.out.print("Placa: ");

            String placa =
                    scanner.nextLine().trim();

            if (placa.isEmpty()) {

                System.out.println(
                        "La placa no puede estar vacía."
                );

                return;
            }

            System.out.print("Propietario: ");

            String propietario =
                    scanner.nextLine().trim();

            if (propietario.isEmpty()) {

                System.out.println(
                        "El propietario no puede estar vacío."
                );

                return;
            }

            System.out.print("Hora de ingreso: ");

            String horaIngreso =
                    scanner.nextLine();

            System.out.print("Horas utilizadas: ");

            double horas =
                    Double.parseDouble(scanner.nextLine());

            if (horas <= 0) {

                System.out.println(
                        "Las horas deben ser mayores que cero."
                );

                return;
            }

            Vehiculo vehiculo;

            if (tipo == 1) {

                vehiculo = new Automovil(
                        placa,
                        propietario,
                        horaIngreso,
                        horas
                );

            } else {

                vehiculo = new Motocicleta(
                        placa,
                        propietario,
                        horaIngreso,
                        horas
                );
            }

            estacionamiento.registrarVehiculo(vehiculo);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Error: ingresó un valor incompatible."
            );

        } finally {

            System.out.println(
                    "Proceso de registro finalizado."
            );
        }
    }

}