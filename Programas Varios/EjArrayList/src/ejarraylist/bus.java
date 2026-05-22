
package ejarraylist;

public class bus {
    private String id;
    private String placa;
    private String color;
    private int capacidad;

    public bus(String id, String palca, String color, int capacidad) {
        this.id = id;
        this.placa = palca;
        this.color = color;
        this.capacidad = capacidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPalca() {
        return placa;
    }

    public void setPalca(String palca) {
        this.placa = palca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
    
}
