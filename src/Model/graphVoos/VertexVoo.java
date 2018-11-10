package Model.graphVoos;

import Model.AuxStruct.Voo;

import java.util.Objects;

public class VertexVoo {

    private String id;
    private Voo voo;

    public VertexVoo() {
    }

    public VertexVoo(String id, Voo voo) {
        this.id = id;
        this.voo = voo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    @Override
    public String toString() {
        return "VertexVoo{" +
                "id='" + id + '\'' +
                ", " + voo.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VertexVoo vertexVoo = (VertexVoo) o;
        return Objects.equals(id, vertexVoo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
