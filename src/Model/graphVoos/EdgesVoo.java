package Model.graphVoos;

import java.util.Objects;

public class EdgesVoo {

    private int id;
    private VertexVoo origem;
    private VertexVoo destino;
    private Long peso;

    public EdgesVoo() {
    }

    public EdgesVoo(int id, VertexVoo origem, VertexVoo destino, Long peso) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VertexVoo getOrigem() {
        return origem;
    }

    public void setOrigem(VertexVoo origem) {
        this.origem = origem;
    }

    public VertexVoo getDestino() {
        return destino;
    }

    public void setDestino(VertexVoo destino) {
        this.destino = destino;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdgesVoo edgesVoo = (EdgesVoo) o;
        return id == edgesVoo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "EdgesVoo{" +
                "id=" + id +
                ", origem=" + origem.getVoo().toString() +
                ", destino=" + destino.getVoo().toString() +
                ", peso=" + peso +
                '}';
    }
}
