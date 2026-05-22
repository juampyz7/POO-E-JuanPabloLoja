package ejecutarpadel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPadelTexto {

    private static final String DELIMITADOR = " | ";
    private static final String DELIMITADOR_REGEX = "\\s\\|\\s";
    private final String rutaArchivo;

    public GestorPadelTexto(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardarPartidos(List<PartidoPadel> partidos) throws IOException {

        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo, true))) {
            for (PartidoPadel partido : partidos) {
                String linea = partido.getParejaLocal()
                        + DELIMITADOR + partido.getParejaVisitante()
                        + DELIMITADOR + partido.getSetsParejaLocal()
                        + DELIMITADOR + partido.getSetsParejaVisitante();
                writer.println(linea);
            }

            System.out.println("[Texto] Datos agregados correctamente.");
        }
    }

    public List<PartidoPadel> cargarPartidos() throws IOException {
        List<PartidoPadel> partidos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = reader.readLine()) != null) {
                numeroLinea++;
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] partes = linea.split(DELIMITADOR_REGEX);
                if (partes.length != 4) {
                    System.err.println("[Texto] Advertencia: linea " + numeroLinea
                            + " con formato incorrecto, se omite: " + linea);
                    continue;
                }

                try {
                    String parejaLocal = partes[0].trim();
                    String parejaVisitante = partes[1].trim();
                    int setsLocal = Integer.parseInt(partes[2].trim());
                    int setsVisitante = Integer.parseInt(partes[3].trim());
                    partidos.add(new PartidoPadel(parejaLocal, parejaVisitante,
                            setsLocal, setsVisitante));
                } catch (NumberFormatException e) {
                    System.err.println("[Texto] Error al parsear sets en linea "
                            + numeroLinea + ": " + e.getMessage());
                }
            }
        }

        System.out.println("[Texto] " + partidos.size()
                + " partido(s) cargado(s) desde: " + rutaArchivo);
        return partidos;
    }
}
