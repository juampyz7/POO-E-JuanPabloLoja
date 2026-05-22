package ejecutarfiscalia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class CasoCorrupcion {

    private static final int DIAS_ALERTA  = 7;
    private static final int DIAS_URGENTE = 14;

    private String nombreCaso;
    private LocalDate fechaInicio;
    private String estado;
    private String detallesAdicionales;
    private ArrayList<PersonaImplicada> personasImplicadas;

    public CasoCorrupcion(String nombreCaso, LocalDate fechaInicio, String detallesAdicionales) {
        this.nombreCaso = nombreCaso;
        this.fechaInicio = fechaInicio;
        this.estado = "Iniciado";
        this.detallesAdicionales = detallesAdicionales;
        this.personasImplicadas = new ArrayList<>();
    }

    public void actualizarEstado() {
        if (estado.equalsIgnoreCase("Cerrado")) {
            System.out.println("El caso " + nombreCaso + " ya esta cerrado.");
            return;
        }

        long diasTranscurridos = ChronoUnit.DAYS.between(fechaInicio, LocalDate.now());

        if (diasTranscurridos > DIAS_URGENTE) {
            estado = "Urgente";
        } else if (diasTranscurridos > DIAS_ALERTA) {
            estado = "Alerta";
        } else {
            estado = "Iniciado";
        }

        System.out.println("Caso " + nombreCaso + ": " + diasTranscurridos + " dias transcurridos. Estado: " + estado);
    }

    public void agregarPersona(PersonaImplicada persona) {
        personasImplicadas.add(persona);
        System.out.println("Persona " + persona.getNombre() + " agregada al caso " + nombreCaso + " como " + persona.getNivelImplicacion() + ".");
    }

    public void consultarInformacion() {
        System.out.println("---------------------------------------------------");
        System.out.println("Caso: " + nombreCaso);
        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Estado: " + estado);
        System.out.println("Detalles: " + detallesAdicionales);
        System.out.println("Personas implicadas (" + personasImplicadas.size() + "):");
        if (personasImplicadas.isEmpty()) {
            System.out.println("  Ninguna registrada.");
        } else {
            for (PersonaImplicada p : personasImplicadas) {
                System.out.println(p);
            }
        }
        System.out.println("---------------------------------------------------");
    }

    public PersonaImplicada buscarPersona(String nombre) {
        for (PersonaImplicada p : personasImplicadas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        System.out.println("No se encontro a " + nombre + " en el caso " + nombreCaso + ".");
        return null;
    }

    public void cerrarCaso() {
        this.estado = "Cerrado";
        System.out.println("El caso " + nombreCaso + " ha sido cerrado.");
    }

    public String getNombreCaso() { return nombreCaso; }
    public void setNombreCaso(String nombreCaso) { this.nombreCaso = nombreCaso; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getDetallesAdicionales() { return detallesAdicionales; }
    public void setDetallesAdicionales(String detallesAdicionales) { this.detallesAdicionales = detallesAdicionales; }

    public ArrayList<PersonaImplicada> getPersonasImplicadas() { return personasImplicadas; }
}
