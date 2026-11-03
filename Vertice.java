import java.util.ArrayList;

/**
 * Representa un vértice (nodo) de un grafo.
 * Cada vértice guarda su lista de adyacencia (las aristas que salen de él).
 */
public class Vertice {

    private String nombre;
    private ArrayList<Arista> aristas;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    /** Busca la arista que va hacia el vértice indicado. Devuelve null si no existe. */
    public Arista buscarArista(String nombreDestino) {
        for (Arista a : aristas) {
            if (a.getDestino().getNombre().equals(nombreDestino)) {
                return a;
            }
        }
        return null;
    }

    /** Agrega una arista hacia otro vértice. Si ya existe, solo actualiza el peso. */
    public void agregarArista(Vertice destino, int peso) {
        Arista existente = buscarArista(destino.getNombre());
        if (existente != null) {
            existente.setPeso(peso);
        } else {
            aristas.add(new Arista(destino, peso));
        }
    }

    /** Elimina la arista hacia el vértice indicado. Devuelve true si la eliminó. */
    public boolean eliminarArista(String nombreDestino) {
        Arista a = buscarArista(nombreDestino);
        if (a == null) {
            return false;
        }
        aristas.remove(a);
        return true;
    }
}
