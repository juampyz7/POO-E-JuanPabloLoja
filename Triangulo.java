// Clase triangulo
public class triangulo {

    // atributos
    public int id;
    public int numLados;
    public int numVertices;
    public String color;
    public double area;
    public double perimetro;
    public String tipo;
    public double base;
    public double altura;  
    public double lado1;
    public double lado2;
    public double lado3;

    // métodos
    public void calcularArea() {
        // código para calcular el área del triángulo
        area = 0.5 * base * altura;
    
    }
    public void calcularPerimetro() {
        // código para calcular el perímetro del triángulo
        perimetro = lado1 + lado2 + lado3;
    }

    public double calcularAngulos(){
        // código para calcular los ángulos del triángulo
        double angulo1 = Math.acos((Math.pow(lado2, 2) + Math.pow(lado3, 2) - Math.pow(lado1, 2)) / (2 * lado2 * lado3));
        double angulo2 = Math.acos((Math.pow(lado1, 2) + Math.pow(lado3, 2) - Math.pow(lado2, 2)) / (2 * lado1 * lado3));
        double angulo3 = Math.acos((Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(lado3, 2)) / (2 * lado1 * lado2));
        return angulo1 + angulo2 + angulo3;
    }




}
