package ejecutarestaciondecarga;

public class VehiculoElectrico implements Carga {

    private final String marca;
    private final String modelo;
    private final String matricula;
    private final Bateria bateria;

    public VehiculoElectrico(String marca, String modelo, String matricula,
                             double capacidadBateria, int saludBateria) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacia.");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no puede estar vacio.");
        }
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("La matricula no puede estar vacia.");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.bateria = new Bateria(capacidadBateria, saludBateria);
    }

    public void cargar(double kwh) {
        if (kwh <= 0) {
            System.out.println("Cantidad de carga invalida: " + kwh + " kWh. Se omite.");
            return;
        }

        double espacioLibre = bateria.espacioDisponible();

        if (espacioLibre == 0) {
            System.out.printf("%s %s [%s] Bateria ya esta al 100%%. No se carga.%n",
                              marca, modelo, matricula);
            return;
        }

        double kwhEfectivos = Math.min(kwh, espacioLibre);
        bateria.recargar(kwhEfectivos);

        System.out.printf("%s %s [%s] +%.1f kWh cargados (solicitados: %.1f kWh)%n",
                          marca, modelo, matricula, kwhEfectivos, kwh);
    }

    public void mostrarEstado() {
        System.out.println("------------------------------------------------------");
        System.out.printf("Vehiculo  : %s %s%n", marca, modelo);
        System.out.printf("Matricula : %s%n", matricula);
        System.out.printf("%s%n", bateria.toString());
        System.out.printf("Espacio libre: %.1f kWh%n", bateria.espacioDisponible());
        System.out.println("------------------------------------------------------");
    }

    public void realizarViaje(double kwh) {
        bateria.usar(kwh);
        System.out.printf("%s %s viaje realizado: -%.1f kWh consumidos.%n",
                          marca, modelo, kwh);
    }

    public String getMarca()     { return marca;     }
    public String getModelo()    { return modelo;    }
    public String getMatricula() { return matricula; }
    public Bateria getBateria()  { return bateria;   }
}
