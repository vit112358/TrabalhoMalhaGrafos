package Model.Graph;

import java.util.Objects;

public class Edges {
    private int id;
    private Vertex origem;
    private Vertex destino;

    public Edges(int id, Vertex origem, Vertex destino) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
    }

    public Edges() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertex getOrigem() {
        return origem;
    }

    public void setOrigem(Vertex origem) {
        this.origem = origem;
    }

    public Vertex getDestino() {
        return destino;
    }

    public void setDestino(Vertex destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Edges{" +
                "id=" + id +
                ", origem=" + origem +
                ", destino=" + destino +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edges edges = (Edges) o;
        return id == edges.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
