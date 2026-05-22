package ejecutaronu;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConflictoInternacional {
    private String nombre;
    private LocalDate fechaInicio;
    private String estadoActual;
    private String detallesAdicionales;
    private ArrayList<String> paisesInvolucrados;
    private ArrayList<Evento> eventos;
    
    private final int TOTAL_PAISES_MUNDO = 195;

    public ConflictoInternacional(String nombre, LocalDate fechaInicio, String detallesAdicionales) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.estadoActual = "Activo";
        this.detallesAdicionales = detallesAdicionales;
        this.paisesInvolucrados = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public void agregarPais(String pais) {
        if (!paisesInvolucrados.contains(pais)) {
            paisesInvolucrados.add(pais);
            evaluarEstado();
        }
    }

    public void agregarEvento(Evento evento) {
        eventos.add(evento);
        evaluarEstado();
    }

    private void evaluarEstado() {
        double porcentajePaisesAfectados = (double) paisesInvolucrados.size() / TOTAL_PAISES_MUNDO;
        boolean alertaReunionUrgente = false;
        boolean alertaGuerraMundial = false;

        for (Evento e : eventos) {
            if (e.getPorcentajeBajasMaximo() >= 50.0) {
                alertaReunionUrgente = true;
            }

            if (e.getTipoEvento().equalsIgnoreCase("batalla")) {
                if (e.isEnPaisPrimerMundo() && e.isUsaArmasNucleares()) {
                    alertaGuerraMundial = true;
                }
            }
        }

        if (porcentajePaisesAfectados > 0.50 || alertaGuerraMundial) {
            this.estadoActual = "Guerra Mundial";
        } else if (porcentajePaisesAfectados >= 0.30 || alertaReunionUrgente) {
            this.estadoActual = "Reunion Urgente ONU";
        } else {
            this.estadoActual = "Activo";
        }
    }

    public void consultarInformacion() {
        System.out.println("\n---------------------------------------------------");
        System.out.println("Conflicto: " + nombre);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Estado actual: " + estadoActual);
        System.out.println("Paises involucrados: " + paisesInvolucrados.size());
        for (String p : paisesInvolucrados) {
            System.out.println("  - " + p);
        }
        System.out.println("Eventos registrados (" + eventos.size() + "):");
        for (Evento e : eventos) {
            System.out.println(e.toString());
        }
        System.out.println("---------------------------------------------------");
    }

    public String getNombre() { return nombre; }
}