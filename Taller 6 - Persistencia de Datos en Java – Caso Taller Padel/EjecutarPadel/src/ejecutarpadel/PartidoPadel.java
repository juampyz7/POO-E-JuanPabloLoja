package ejecutarpadel;

import java.io.Serializable;

public class PartidoPadel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String parejaLocal;
    private String parejaVisitante;
    private int setsParejaLocal;
    private int setsParejaVisitante;

    public PartidoPadel(String parejaLocal, String parejaVisitante,
            int setsParejaLocal, int setsParejaVisitante) {
        this.parejaLocal = parejaLocal;
        this.parejaVisitante = parejaVisitante;
        this.setsParejaLocal = setsParejaLocal;
        this.setsParejaVisitante = setsParejaVisitante;
    }

    public String getParejaLocal() {
        return parejaLocal;
    }

    public String getParejaVisitante() {
        return parejaVisitante;
    }

    public int getSetsParejaLocal() {
        return setsParejaLocal;
    }

    public int getSetsParejaVisitante() {
        return setsParejaVisitante;
    }

    public void setParejaLocal(String parejaLocal) {
        this.parejaLocal = parejaLocal;
    }

    public void setParejaVisitante(String parejaVisitante) {
        this.parejaVisitante = parejaVisitante;
    }

    public void setSetsParejaLocal(int setsParejaLocal) {
        this.setsParejaLocal = setsParejaLocal;
    }

    public void setSetsParejaVisitante(int setsParejaVisitante) {
        this.setsParejaVisitante = setsParejaVisitante;
    }

    public String obtenerGanador() {
        if (setsParejaLocal > setsParejaVisitante) {
            return parejaLocal;
        } else if (setsParejaVisitante > setsParejaLocal) {
            return parejaVisitante;
        } else {
            return "Empate";
        }
    }

    @Override
    public String toString() {
        return "Partido: " + parejaLocal + " vs " + parejaVisitante
                + " | Marcador: " + setsParejaLocal + " - " + setsParejaVisitante
                + " | Ganador: " + obtenerGanador();
    }
}
