package ejecutarcuerpohumano;

public class CuerpoHumano {
    
    private String serieCH;
    private double tamanio;
    private String color;
    private String peso;
    private double precio;
    private String material;
    private Cerebro c;
    private Pulmones p;
    private Soporte s;

    public String getSerieCH() {
        return serieCH;
    }

    public void setSerieCH(String serieCH) {
        this.serieCH = serieCH;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Cerebro getC() {
        return c;
    }

    public void setC(Cerebro c) {
        this.c = c;
    }

    public Pulmones getP() {
        return p;
    }

    public void setP(Pulmones p) {
        this.p = p;
    }

    public Soporte getS() {
        return s;
    }

    public void setS(Soporte s) {
        this.s = s;
    }
    
    public void calcularPrecio(){
        if (material.equals("Plastico")){
            precio = 200;
        } else {
            precio = 450;
        }
    }
}
