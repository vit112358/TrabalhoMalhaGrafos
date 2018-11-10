package Model.graphVoos;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GraphVoo {

    private int id;
    private String nome;
    private Map<String, VertexVoo> vertices;
    private List<EdgesVoo> arestas;

    public GraphVoo() {
    }

    public GraphVoo(int id, String nome, Map<String, VertexVoo> vertices, List<EdgesVoo> arestas) {
        this.id = id;
        this.nome = nome;
        this.vertices = vertices;
        this.arestas = arestas;
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

    public Map<String, VertexVoo> getVertices() {
        return vertices;
    }

    public void setVertices(Map<String, VertexVoo> vertices) {
        this.vertices = vertices;
    }

    public List<EdgesVoo> getArestas() {
        return arestas;
    }

    public void setArestas(List<EdgesVoo> arestas) {
        this.arestas = arestas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphVoo graphVoo = (GraphVoo) o;
        return id == graphVoo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GraphVoo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vertices=" + vertices +
                ", arestas=" + arestas +
                '}';
    }
}
