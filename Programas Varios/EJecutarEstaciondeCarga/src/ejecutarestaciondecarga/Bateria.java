package ejecutarestaciondecarga;

public class Bateria {

    private final double capacidadMaxima;
    private double capacidadActual;
    private int estadoSalud;

    public Bateria(double capacidadMaxima, int estadoSalud) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad maxima de la bateria debe ser positiva.");
        }
        if (estadoSalud < 0 || estadoSalud > 100) {
            throw new IllegalArgumentException("El estado de salud debe estar entre 0 y 100.");
        }
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadMaxima;
        this.estadoSalud = estadoSalud;
    }

    public void usar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de la bateria a usar no puede ser negativa.");
        }
        capacidadActual = Math.max(0, capacidadActual - cantidad);
    }

    public void recargar(double kwh) {
        if (kwh < 0) {
            throw new IllegalArgumentException("La cantidad a recargar no puede ser negativa.");
        }
        capacidadActual = Math.min(capacidadMaxima, capacidadActual + kwh);
    }

    public double espacioDisponible() {
        return capacidadMaxima - capacidadActual;
    }

    public double porcentajeCarga() {
        return (capacidadActual / capacidadMaxima) * 100.0;
    }

    public double getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }

    public int getEstadoSalud() {
        return estadoSalud;
    }
    
    public String toString() {
        return String.format(
            "Bateria [%.1f / %.1f kWh | %.1f%% cargada | Salud: %d%%]",
            capacidadActual, capacidadMaxima, porcentajeCarga(), estadoSalud
        );
    }
}
