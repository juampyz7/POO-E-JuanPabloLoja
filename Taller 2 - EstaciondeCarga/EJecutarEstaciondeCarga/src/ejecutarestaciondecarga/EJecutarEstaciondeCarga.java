package ejecutarestaciondecarga;

public class EJecutarEstaciondeCarga {

    public static void main(String[] args) {

        System.out.println("======================================================");
        System.out.println("         RED DE CARGA DE VEHICULOS ELECTRICOS         ");
        System.out.println("======================================================");

        System.out.println("\n[1] Creando vehiculos electricos...\n");

        VehiculoElectrico renault = new VehiculoElectrico("Renault", "Kwit", "OBJ-123", 75.0, 90);

        VehiculoElectrico chevrolet = new VehiculoElectrico("Chevrolet", "Equinox", "LOH-456", 40.0, 70);

        VehiculoElectrico byd = new VehiculoElectrico("BYD", "Yuan Plus", "UIO-789", 60.0, 100);

        System.out.println("[2] Simulando viajes previos...\n");
        renault.realizarViaje(50.0);
        chevrolet.realizarViaje(30.0);
        byd.realizarViaje(10.0);

        System.out.println("\n[3] Creando estacion de carga...\n");
        EstacionDeCarga estacion = new EstacionDeCarga("Estacion Norte", "Av. Occidental, Loja"
        );

        System.out.println("Registrando vehiculos en la estacion:");
        estacion.registrarVehiculo(renault);
        estacion.registrarVehiculo(chevrolet);
        estacion.registrarVehiculo(byd);

        System.out.println("\n[4] Estado de los vehiculos antes de la carga masiva:");
        estacion.mostrarEstadoVehiculos();

        System.out.println("\n[5] Ejecutando carga masiva...");
        estacion.suministrarEnergia();

        System.out.println("\n[6] Estado de los vehiculos despues de la carga masiva:");
        estacion.mostrarEstadoVehiculos();

        System.out.println("\n[7] Retirando el Renault de la estacion...");
        estacion.retirarVehiculo("OBJ-123");

        System.out.println("\nEl Renault sigue accesible fuera de la estacion:");
        renault.mostrarEstado();

        System.out.println("\n======================================================");
        System.out.println("                FIN DE LA DEMOSTRACION                ");
        System.out.println("======================================================");
    }
}
    