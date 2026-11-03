/**
 * Programa de prueba del grafo y sus operaciones básicas.
 */
public class Main {

    public static void main(String[] args) {

        Grafo g = new Grafo(false); // grafo NO dirigido

        System.out.println("=== 1. Insertar vértices ===");
        String[] ciudades = {"Bogotá", "Medellín", "Cali", "Cartagena", "Bucaramanga"};
        for (String c : ciudades) {
            System.out.println("Insertar " + c + ": " + g.insertarVertice(c));
        }
        System.out.println("Insertar Cali otra vez: " + g.insertarVertice("Cali"));

        System.out.println("\n=== 2. Insertar aristas (peso = distancia en km aprox.) ===");
        g.insertarArista("Bogotá", "Medellín", 415);
        g.insertarArista("Bogotá", "Cali", 460);
        g.insertarArista("Bogotá", "Bucaramanga", 390);
        g.insertarArista("Medellín", "Cartagena", 640);
        g.insertarArista("Bucaramanga", "Cartagena", 600);
        g.imprimir();
        System.out.println("Vértices: " + g.cantidadVertices()
                + " | Aristas: " + g.cantidadAristas());

        System.out.println("\n=== 3. Buscar y consultar ===");
        System.out.println("¿Existe Cali? " + (g.buscarVertice("Cali") != null));
        System.out.println("¿Existe Pasto? " + (g.buscarVertice("Pasto") != null));
        System.out.println("¿Hay arista Bogotá-Medellín? " + g.existeArista("Bogotá", "Medellín"));
        System.out.println("¿Hay arista Cali-Cartagena? " + g.existeArista("Cali", "Cartagena"));
        System.out.println("Grado de Bogotá: " + g.grado("Bogotá"));

        System.out.println("\n=== 4. Recorridos desde Bogotá ===");
        System.out.println("Anchura (BFS):     " + g.recorridoAnchura("Bogotá"));
        System.out.println("Profundidad (DFS): " + g.recorridoProfundidad("Bogotá"));

        System.out.println("\n=== 5. Eliminar una arista (Bogotá-Cali) ===");
        System.out.println("Eliminada: " + g.eliminarArista("Bogotá", "Cali"));
        g.imprimir();

        System.out.println("\n=== 6. Eliminar un vértice (Medellín) ===");
        System.out.println("Eliminado: " + g.eliminarVertice("Medellín"));
        g.imprimir();
        System.out.println("Vértices: " + g.cantidadVertices()
                + " | Aristas: " + g.cantidadAristas());
    }
}
