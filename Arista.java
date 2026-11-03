/**
 * Representa una arista (conexión) de un grafo.
 * Guarda el vértice de destino y el peso de la conexión.
 */
public class Arista {

    private Vertice destino;
    private int peso;

    public Arista(Vertice destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
