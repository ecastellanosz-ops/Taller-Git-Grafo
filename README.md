# Taller-Git-Grafo

Implementación de un **grafo** en Java con sus operaciones básicas, desarrollada como práctica de uso de Git y GitHub
(Programación y Lenguaje Computacional II).

**Autor:** Erick Santiago Castellanos Zabala

## Descripción

El grafo se representa con **listas de adyacencia** usando `ArrayList`. Puede ser dirigido o no dirigido y sus aristas tienen peso.

## Estructura del proyecto

| Archivo | Descripción |
|---|---|
| `Arista.java` | Conexión entre dos vértices (destino y peso). |
| `Vertice.java` | Nodo del grafo con su lista de aristas. |
| `Grafo.java` | Operaciones básicas del grafo. |
| `Main.java` | Programa de prueba. |

## Operaciones básicas

- Insertar, buscar y eliminar vértices.
- Insertar, eliminar y verificar aristas.
- Consultar el grado de un vértice y las cantidades de vértices y aristas.
- Recorrido en anchura (BFS) y en profundidad (DFS).
- Imprimir la lista de adyacencia.

## Cómo compilar y ejecutar

```bash
javac *.java
java Main
```

También se puede abrir en NetBeans copiando los cuatro archivos `.java` a un proyecto nuevo de Java.
