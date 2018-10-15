package Model.Graph;

import java.util.Objects;

public class Vertex {
    private int id;
    private String nomeAeroporto;

    public Vertex(int id, String nomeAeroporto) {
        this.id = id;
        this.nomeAeroporto = nomeAeroporto;
    }

    public Vertex() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public void setNomeAeroporto(String nomeAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", nomeAeroporto='" + nomeAeroporto + '\'' +
                '}';
    }
}
