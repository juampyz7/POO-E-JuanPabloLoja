package ejecutarcuerpohumano;

public class Cerebro {
    
    private String idCerebro;
    private int cantNeuronas;
    private String color;
    private String forma;
    private String estado;

    public String getIdCerebro() {
        return idCerebro;
    }

    public void setIdCerebro(String idCerebro) {
        this.idCerebro = idCerebro;
    }

    public int getCantNeuronas() {
        return cantNeuronas;
    }

    public void setCantNeuronas(int cantNeuronas) {
        this.cantNeuronas = cantNeuronas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void pensar(){
        if (cantNeuronas <= 100) {
            System.out.println("Coeficiente intelectual Bueno");
        } else if (cantNeuronas <= 150) {
            System.out.println("Coeficiente intelectual Muy Bueno");
        } else {
            System.out.println("Coeficiente intelectual Excelente");
        }
    }
    
}
