package ejecutarestaciondecarga;

public class EstacionDeCarga {

    private final String nombre;
    private final String ubicacion;
    private final java.util.List<VehiculoElectrico> vehiculos;
    private static final double ENERGIA_POR_CICLO = 15.0;

    public EstacionDeCarga(String nombre, String ubicacion) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la estacion no puede estar vacio.");
        }
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.vehiculos = new java.util.ArrayList<>();
    }

    public void registrarVehiculo(VehiculoElectrico v) {
        if (v == null) {
            throw new IllegalArgumentException("No se puede registrar un vehiculo nulo.");
        }
        vehiculos.add(v);
        System.out.printf("Vehiculo registrado: %s %s [%s]%n",
                          v.getMarca(), v.getModelo(), v.getMatricula());
    }

    public boolean retirarVehiculo(String matricula) {
        boolean removido = vehiculos.removeIf(
            v -> v.getMatricula().equalsIgnoreCase(matricula)
        );
        if (removido) {
            System.out.printf("Vehiculo con matricula [%s] retirado de la estacion.%n", matricula);
        } else {
            System.out.printf("Matricula [%s] no encontrada en esta estacion.%n", matricula);
        }
        return removido;
    }

    public void suministrarEnergia() {
        System.out.println();
        System.out.printf("[%s] Iniciando suministro de energia (%.1f kWh por vehiculo)...%n",
                          nombre, ENERGIA_POR_CICLO);
        System.out.println("-------------------------------------------------------");

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados en esta estacion.");
            return;
        }

        for (VehiculoElectrico v : vehiculos) {
            v.cargar(ENERGIA_POR_CICLO);
        }

        System.out.println("------------------------------------------------------");
        System.out.println("Suministro completado.");
    }

    public void mostrarEstadoVehiculos() {
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.printf("Estacion   : %s%n", nombre);
        System.out.printf("Ubicacion  : %s%n", ubicacion);
        System.out.printf("Vehiculos  : %d%n", vehiculos.size());
        System.out.println("------------------------------------------------------");

        if (vehiculos.isEmpty()) {
            System.out.println("Sin vehiculos registrados.");
        } else {
            for (VehiculoElectrico v : vehiculos) {
                v.mostrarEstado();
            }
        }
    }

    public String getNombre()    { return nombre;    }
    public String getUbicacion() { return ubicacion; }
    public int cantidadVehiculos() { return vehiculos.size(); }
}
