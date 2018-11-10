package Model.graphVoos;

import Model.AuxStruct.Voo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GraphVoo {

    private int id;
    private String nome;
    private List<Voo> arestas;

    public GraphVoo(int id, String nome, List<Voo> arestas) {
        this.id = id;
        this.nome = nome;
        this.arestas = arestas;
    }

    public GraphVoo() {
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

    public List<Voo> getArestas() {
        return arestas;
    }

    public void setArestas(List<Voo> arestas) {
        this.arestas = arestas;
    }

    @Override
    public String toString() {
        return "GraphVoo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", arestas=" + arestas +
                '}';
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
}
