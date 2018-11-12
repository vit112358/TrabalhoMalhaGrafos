package Model.GraphRota;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Graph {
    private int id;
    private Map<String, Vertex> vertices;
    private List<Edges> arestas;
    /*
    * dirigido = true o grafo é dirigido
    * caso o dirigido = false o grafo é não dirigido
    * */
    private boolean dirigido;

    public Graph(int id, Map<String, Vertex> vertices, List<Edges> arestas, boolean dirigido) {
        this.id = id;
        this.vertices = vertices;
        this.arestas = arestas;
        this.dirigido = dirigido;
    }

    public Graph() {
    }

    public Graph(boolean dirigido) {
        this.dirigido = dirigido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Map<String, Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(Map<String, Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edges> getArestas() {
        return arestas;
    }

    public void setArestas(List<Edges> arestas) {
        this.arestas = arestas;
    }

    public boolean isDirigido() {
        return dirigido;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return id == graph.id &&
                dirigido == graph.dirigido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GraphRota{" +
                "id=" + id +
                ", dirigido=" + dirigido +
                '}';
    }
}
