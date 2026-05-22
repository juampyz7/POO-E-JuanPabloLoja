package ejecutarfiscalia;

public class PersonaImplicada {

    private String nombre;
    private int edad;
    private String ocupacion;
    private String nivelImplicacion;
    private boolean colabora;
    private double sentenciaAnios;
    private double danoEconomicoTotal;

    public PersonaImplicada(String nombre, int edad, String ocupacion, String nivelImplicacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.ocupacion = ocupacion;
        this.nivelImplicacion = nivelImplicacion;
        this.colabora = false;
        this.sentenciaAnios = 0;
        this.danoEconomicoTotal = 0;
    }

    public void colaborarConFiscalia() {
        if (nivelImplicacion.equalsIgnoreCase("acusado")) {
            this.colabora = true;
            System.out.println(nombre + " ha decidido colaborar con la Fiscalia.");
            System.out.println("Se acoge a reduccion de pena por confesion voluntaria.");
        } else {
            System.out.println(nombre + " no es acusado. Esta opcion no aplica.");
        }
    }

    public double calcularFianza() {
        if (!nivelImplicacion.equalsIgnoreCase("acusado")) {
            System.out.println(nombre + " no es acusado. La fianza no aplica.");
            return -1;
        }
        if (!colabora) {
            System.out.println(nombre + " no ha decidido colaborar. No puede acogerse a fianza.");
            return -1;
        }
        if (sentenciaAnios >= 1) {
            System.out.println("La sentencia de " + nombre + " (" + sentenciaAnios + " anos) es mayor o igual a 1 ano. No aplica fianza.");
            return -1;
        }

        double fianza = danoEconomicoTotal * 0.50;
        System.out.println(nombre + " puede acogerse a fianza.");
        System.out.printf("Fianza maxima: $%.2f (50%% de $%.2f de dano economico)%n", fianza, danoEconomicoTotal);
        return fianza;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getOcupacion() { return ocupacion; }
    public void setOcupacion(String ocupacion) { this.ocupacion = ocupacion; }

    public String getNivelImplicacion() { return nivelImplicacion; }
    public void setNivelImplicacion(String nivelImplicacion) { this.nivelImplicacion = nivelImplicacion; }

    public boolean isColabora() { return colabora; }
    public void setColabora(boolean colabora) { this.colabora = colabora; }

    public double getSentenciaAnios() { return sentenciaAnios; }
    public void setSentenciaAnios(double sentenciaAnios) { this.sentenciaAnios = sentenciaAnios; }

    public double getDanoEconomicoTotal() { return danoEconomicoTotal; }
    public void setDanoEconomicoTotal(double danoEconomicoTotal) { this.danoEconomicoTotal = danoEconomicoTotal; }

    public String toString() {
        return String.format(
            "  Persona: %s | Edad: %d | Ocupacion: %s | Rol: %s | Colabora: %s",
            nombre, edad, ocupacion, nivelImplicacion, (colabora ? "Si" : "No")
        );
    }
}

