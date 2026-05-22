package ejecutaronu;

import java.time.LocalDate;

public class Evento {
    private String nombreEvento;
    private LocalDate fecha;
    private String ubicacion;
    private String descripcion;
    private String tipoEvento;
    private boolean usaArmasNucleares;
    private boolean enPaisPrimerMundo;
    private double porcentajeBajasMaximo;

    public Evento(String nombreEvento, LocalDate fecha, String ubicacion, String descripcion, String tipoEvento, boolean usaArmasNucleares, boolean enPaisPrimerMundo, double porcentajeBajasMaximo) {
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tipoEvento = tipoEvento;
        this.usaArmasNucleares = usaArmasNucleares;
        this.enPaisPrimerMundo = enPaisPrimerMundo;
        this.porcentajeBajasMaximo = porcentajeBajasMaximo;
    }

    public String getNombreEvento() { return nombreEvento; }
    public void setNombreEvento(String nombreEvento) { this.nombreEvento = nombreEvento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public boolean isUsaArmasNucleares() { return usaArmasNucleares; }
    public void setUsaArmasNucleares(boolean usaArmasNucleares) { this.usaArmasNucleares = usaArmasNucleares; }

    public boolean isEnPaisPrimerMundo() { return enPaisPrimerMundo; }
    public void setEnPaisPrimerMundo(boolean enPaisPrimerMundo) { this.enPaisPrimerMundo = enPaisPrimerMundo; }

    public double getPorcentajeBajasMaximo() { return porcentajeBajasMaximo; }
    public void setPorcentajeBajasMaximo(double porcentajeBajasMaximo) { this.porcentajeBajasMaximo = porcentajeBajasMaximo; }

    public String toString() {
        return "  Evento: " + nombreEvento + " | Tipo: " + tipoEvento + " | Ubicacion: " + ubicacion + " | Bajas: " + porcentajeBajasMaximo + "%";
    }
}