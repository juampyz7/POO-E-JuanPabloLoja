public class main {
    public static void main(String[] args) {
        // Crear un objeto de la clase triangulo
        triangulo miTriangulo = new triangulo();

        // Asignar valores a los atributos del triángulo
        miTriangulo.base = 5.0;
        miTriangulo.altura = 3.0;
        miTriangulo.lado1 = 5.0;
        miTriangulo.lado2 = 4.0;
        miTriangulo.lado3 = 3.0;

        // Calcular el área y el perímetro del triángulo
        miTriangulo.calcularArea();
        miTriangulo.calcularPerimetro();
        double angulos = miTriangulo.calcularAngulos();

        // Imprimir los resultados
        System.out.println("Área del triángulo: " + miTriangulo.area);
        System.out.println("Perímetro del triángulo: " + miTriangulo.perimetro);
        System.out.println("Suma de ángulos del triángulo: " + angulos);
    }
    
}
