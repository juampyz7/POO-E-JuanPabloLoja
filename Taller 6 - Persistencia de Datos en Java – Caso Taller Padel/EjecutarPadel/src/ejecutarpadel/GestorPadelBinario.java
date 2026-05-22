package ejecutarpadel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPadelBinario {

    private final String rutaArchivo;

    public GestorPadelBinario(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void guardarPartidos(List<PartidoPadel> nuevosPartidos) throws IOException {

        List<PartidoPadel> todos = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {

            try (ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(rutaArchivo)))) {
                todos = (List<PartidoPadel>) ois.readObject();
            } catch (ClassNotFoundException e) {
                System.out.println("Error leyendo archivo.");
            }
        }

        todos.addAll(nuevosPartidos);

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(rutaArchivo)))) {
            oos.writeObject(todos);
            System.out.println("[Binario] "
                    + todos.size()
                    + " partido(s) guardado(s).");
        }
    }

    @SuppressWarnings("unchecked")
    public List<PartidoPadel> cargarPartidos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(rutaArchivo)))) {

            List<PartidoPadel> partidos = (List<PartidoPadel>) ois.readObject();
            System.out.println("[Binario] " + partidos.size()
                    + " partido(s) cargado(s) desde: " + rutaArchivo);
            return partidos;
        }
    }
}
