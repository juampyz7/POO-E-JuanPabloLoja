package ejecutarcuerpohumano;

public class Soporte {
    
    private String numSerie;
    private String material;
    private double tamanio;

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }
    
    public boolean parar(){
        if (tamanio <= 170) {
            return true;
        } else  {
            return false;
        }
    }
    
}
