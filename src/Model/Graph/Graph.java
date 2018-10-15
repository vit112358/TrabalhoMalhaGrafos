package Model.Graph;

import java.util.List;
import java.util.Objects;

public class Graph {
    private int id;
    private String nome;
    private List<Vertex> vertices;
    private List<Edges> arestas;
    private boolean tipoGrafo;

    public Graph(int id, String nome, List<Vertex> vertices, List<Edges> arestas, boolean tipoGrafo) {
        this.id = id;
        this.nome = nome;
        this.vertices = vertices;
        this.arestas = arestas;
        this.tipoGrafo = tipoGrafo;
    }

    public Graph() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edges> getArestas() {
        return arestas;
    }

    public void setArestas(List<Edges> arestas) {
        this.arestas = arestas;
    }

    public boolean isTipoGrafo() {
        return tipoGrafo;
    }

    public void setTipoGrafo(boolean tipoGrafo) {
        this.tipoGrafo = tipoGrafo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return id == graph.id &&
                tipoGrafo == graph.tipoGrafo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoGrafo=" + tipoGrafo +
                '}';
    }
}
