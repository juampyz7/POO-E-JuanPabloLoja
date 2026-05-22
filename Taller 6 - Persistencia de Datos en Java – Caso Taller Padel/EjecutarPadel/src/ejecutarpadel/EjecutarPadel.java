package ejecutarpadel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjecutarPadel {

    private static final String ARCHIVO_BINARIO = "partidos_padel.dat";
    private static final String ARCHIVO_TEXTO = "partidos_padel.txt";

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        List<PartidoPadel> partidos = new ArrayList<>();
        GestorPadelBinario gestorBinario
                = new GestorPadelBinario(ARCHIVO_BINARIO);
        GestorPadelTexto gestorTexto
                = new GestorPadelTexto(ARCHIVO_TEXTO);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("             MENU PRINCIPAL             ");
            System.out.println("========================================");
            System.out.println("1. Registrar partido");
            System.out.println("2. Mostrar partidos");
            System.out.println("3. Guardar en archivos");
            System.out.println("4. Cargar desde archivo binario");
            System.out.println("5. Cargar desde archivo texto");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--------- REGISTRO DE PARTIDO ---------");
                    System.out.print("Ingrese nombre de la pareja local: ");
                    String local = entrada.nextLine();
                    System.out.print("Ingrese nombre de la pareja visitante: ");
                    String visitante = entrada.nextLine();
                    System.out.print("Ingrese sets ganados por pareja local: ");
                    int setsLocal = entrada.nextInt();
                    System.out.print("Ingrese sets ganados por pareja visitante: ");
                    int setsVisitante = entrada.nextInt();
                    entrada.nextLine();

                    PartidoPadel partido = new PartidoPadel(
                            local,
                            visitante,
                            setsLocal,
                            setsVisitante
                    );

                    partidos.add(partido);

                    System.out.println("Partido registrado correctamente.");
                    break;

                case 2:
                    System.out.println("\n--------- LISTA DE PARTIDOS ---------");
                    try {
                        List<PartidoPadel> partidosGuardados
                                = gestorTexto.cargarPartidos();
                        if (partidosGuardados.isEmpty()) {
                            System.out.println("No existen partidos.");
                        } else {
                            for (PartidoPadel p : partidosGuardados) {
                                System.out.println(p);
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error al leer archivo.");
                    }
                    break;

                case 3:
                    try {
                        gestorBinario.guardarPartidos(partidos);
                        gestorTexto.guardarPartidos(partidos);
                        partidos.clear();
                        System.out.println("Archivos generados correctamente.");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        List<PartidoPadel> cargadosBinario
                                = gestorBinario.cargarPartidos();
                        System.out.println("\nPARTIDOS DESDE .DAT");
                        for (PartidoPadel p : cargadosBinario) {
                            System.out.println(p);
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        List<PartidoPadel> cargadosTexto
                                = gestorTexto.cargarPartidos();
                        System.out.println("\nPARTIDOS DESDE .TXT");
                        for (PartidoPadel p : cargadosTexto) {
                            System.out.println(p);
                        }
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente de nuevo.");
            }

        } while (opcion != 6);
    }
}
