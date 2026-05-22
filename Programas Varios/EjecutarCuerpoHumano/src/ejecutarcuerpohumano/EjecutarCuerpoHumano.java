package ejecutarcuerpohumano;

public class EjecutarCuerpoHumano {

    public static void main(String[] args) {

        //1. Crear objeto soporte
        Soporte s1 = new Soporte();

        //2. Crear objeto cerebro
        Cerebro c1 = new Cerebro();

        //3. Crear objeto pulmon
        Pulmones pl1 = new Pulmones();
        Pulmones pl2 = new Pulmones();

        //4. Crear objeto cuerpo humano
        CuerpoHumano cpUno = new CuerpoHumano();

        System.out.println("Armado del cuerpo humano");

        //5. Asignar valores
        s1.setNumSerie("Sop001");
        s1.setMaterial("Plastico");
        s1.setTamanio(150);

        c1.setIdCerebro("Cer010");
        c1.setColor("Gris");
        c1.setForma("Ovalada");
        c1.setCantNeuronas(40);
        c1.setEstado("Activo");

        pl1.setIdPulmon("Pul015");
        pl1.setColor("Blanco");
        pl1.setPeso("40 kg");
        pl1.setAlveolos(578);

        cpUno.setSerieCH("CH07");
        cpUno.setColor("cafe");
        cpUno.setMaterial("Plastico");
        cpUno.setTamanio(156);
        cpUno.setPeso("80 kg");
        cpUno.setC(c1);
        cpUno.setP(pl1);
        cpUno.setS(s1);

        System.out.println("Objeto cuerpo humano armado completamente...");

        //6. Mostrar datos en pantalla
        System.out.println("El cuerpo humano con serie = " + cpUno.getSerieCH() + " tiene las siguiente caracteristicas: ");
        System.out.println("- cantidad de alveolos " + cpUno.getP().getAlveolos() + " millones");
        System.out.println("- cantidad de neuronas " + cpUno.getC().getCantNeuronas() + " millones, con esta cantidad es un: ");
        cpUno.getC().pensar();
        
        cpUno.calcularPrecio(); 
        System.out.println("- precio es igual a: " + cpUno.getPrecio());
    }

}
