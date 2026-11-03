import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Grafo implementado con listas de adyacencia (ArrayList).
 * Puede ser dirigido o no dirigido, y las aristas tienen peso.
 *
 * Operaciones básicas:
 *  - insertarVertice / buscarVertice / eliminarVertice
 *  - insertarArista / eliminarArista / existeArista
 *  - grado
 *  - recorridoAnchura (BFS) y recorridoProfundidad (DFS)
 *  - imprimir
 */
public class Grafo {

    private ArrayList<Vertice> vertices;
    private boolean dirigido;

    public Grafo(boolean dirigido) {
        this.vertices = new ArrayList<>();
        this.dirigido = dirigido;
    }

    // ---------------------------------------------------------------
    // VÉRTICES
    // ---------------------------------------------------------------

    /** Busca un vértice por su nombre. Devuelve null si no existe. */
    public Vertice buscarVertice(String nombre) {
        for (Vertice v : vertices) {
            if (v.getNombre().equals(nombre)) {
                return v;
            }
        }
        return null;
    }

    /** Inserta un vértice nuevo. Devuelve false si ya existía uno con ese nombre. */
    public boolean insertarVertice(String nombre) {
        if (buscarVertice(nombre) != null) {
            return false;
        }
        vertices.add(new Vertice(nombre));
        return true;
    }

    /** Elimina un vértice y todas las aristas que llegan a él o salen de él. */
    public boolean eliminarVertice(String nombre) {
        Vertice v = buscarVertice(nombre);
        if (v == null) {
            return false;
        }
        // Primero se borran las aristas de los demás vértices que apuntan a v
        for (Vertice otro : vertices) {
            otro.eliminarArista(nombre);
        }
        vertices.remove(v);
        return true;
    }

    // ---------------------------------------------------------------
    // ARISTAS
    // ---------------------------------------------------------------

    /** Inserta una arista entre dos vértices existentes. */
    public boolean insertarArista(String origen, String destino, int peso) {
        Vertice o = buscarVertice(origen);
        Vertice d = buscarVertice(destino);
        if (o == null || d == null) {
            return false;
        }
        o.agregarArista(d, peso);
        if (!dirigido) {
            d.agregarArista(o, peso);
        }
        return true;
    }

    /** Elimina la arista entre dos vértices. */
    public boolean eliminarArista(String origen, String destino) {
        Vertice o = buscarVertice(origen);
        Vertice d = buscarVertice(destino);
        if (o == null || d == null) {
            return false;
        }
        boolean eliminada = o.eliminarArista(destino);
        if (!dirigido) {
            d.eliminarArista(origen);
        }
        return eliminada;
    }

    /** Indica si existe una arista de origen a destino. */
    public boolean existeArista(String origen, String destino) {
        Vertice o = buscarVertice(origen);
        return o != null && o.buscarArista(destino) != null;
    }

    // ---------------------------------------------------------------
    // CONSULTAS
    // ---------------------------------------------------------------

    /** Grado de un vértice (cantidad de aristas que salen de él). -1 si no existe. */
    public int grado(String nombre) {
        Vertice v = buscarVertice(nombre);
        if (v == null) {
            return -1;
        }
        return v.getAristas().size();
    }

    public int cantidadVertices() {
        return vertices.size();
    }

    public int cantidadAristas() {
        int total = 0;
        for (Vertice v : vertices) {
            total += v.getAristas().size();
        }
        return dirigido ? total : total / 2;
    }

    // ---------------------------------------------------------------
    // RECORRIDOS
    // ---------------------------------------------------------------

    /** Recorrido en anchura (BFS) desde un vértice inicial. */
    public ArrayList<String> recorridoAnchura(String inicio) {
        ArrayList<String> resultado = new ArrayList<>();
        Vertice v = buscarVertice(inicio);
        if (v == null) {
            return resultado;
        }
        ArrayList<Vertice> visitados = new ArrayList<>();
        LinkedList<Vertice> cola = new LinkedList<>();
        visitados.add(v);
        cola.add(v);
        while (!cola.isEmpty()) {
            Vertice actual = cola.removeFirst();
            resultado.add(actual.getNombre());
            for (Arista a : actual.getAristas()) {
                Vertice vecino = a.getDestino();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return resultado;
    }

    /** Recorrido en profundidad (DFS) desde un vértice inicial. */
    public ArrayList<String> recorridoProfundidad(String inicio) {
        ArrayList<String> resultado = new ArrayList<>();
        Vertice v = buscarVertice(inicio);
        if (v != null) {
            dfs(v, new ArrayList<Vertice>(), resultado);
        }
        return resultado;
    }

    private void dfs(Vertice actual, ArrayList<Vertice> visitados, ArrayList<String> resultado) {
        visitados.add(actual);
        resultado.add(actual.getNombre());
        for (Arista a : actual.getAristas()) {
            if (!visitados.contains(a.getDestino())) {
                dfs(a.getDestino(), visitados, resultado);
            }
        }
    }

    // ---------------------------------------------------------------
    // IMPRESIÓN
    // ---------------------------------------------------------------

    /** Imprime la lista de adyacencia del grafo. */
    public void imprimir() {
        if (vertices.isEmpty()) {
            System.out.println("(grafo vacío)");
            return;
        }
        for (Vertice v : vertices) {
            StringBuilder linea = new StringBuilder(v.getNombre() + " -> ");
            if (v.getAristas().isEmpty()) {
                linea.append("(sin conexiones)");
            }
            for (Arista a : v.getAristas()) {
                linea.append("[").append(a.getDestino().getNombre())
                     .append(", peso ").append(a.getPeso()).append("] ");
            }
            System.out.println(linea.toString().trim());
        }
    }
}
