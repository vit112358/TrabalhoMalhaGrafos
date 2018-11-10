package Model;

import Model.GraphRota.Graph;

public class Estrutura {

    private Graph rotas;
    private Graph voos;

    public Estrutura(Graph rotas, Graph voos) {
        this.rotas = rotas;
        this.voos = voos;
    }

    public Estrutura() {
        this.rotas = new Graph(false);
        this.voos = new Graph(true);
    }

    public Graph getRotas() {
        return rotas;
    }

    public void setRotas(Graph rotas) {
        this.rotas = rotas;
    }

    public Graph getVoos() {
        return voos;
    }

    public void setVoos(Graph voos) {
        this.voos = voos;
    }

    @Override
    public String toString() {
        return "Estrutura{" +
                "rotas=" + rotas.getNome() +
                ", voos=" + voos.getNome() +
                '}';
    }
}
