package ejecutarcuerpohumano;

public class Pulmones {
    
    private String idPulmon;
    private int Alveolos;
    private String color;
    private String peso;

    public String getIdPulmon() {
        return idPulmon;
    }

    public void setIdPulmon(String idPulmon) {
        this.idPulmon = idPulmon;
    }

    public int getAlveolos() {
        return Alveolos;
    }

    public void setAlveolos(int Alveolos) {
        this.Alveolos = Alveolos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
    
    public String respirar(){
        String msn = "Los pulmones " + Alveolos + " alveolos para respirar";
        return msn;
    }
    
}
