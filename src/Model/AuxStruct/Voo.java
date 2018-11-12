package Model.AuxStruct;

import java.time.LocalTime;
import java.util.Objects;

public class Voo {
    private String linha;
    private String voo;/**Id do Voo**/
    private Aeroporto origem;
    private LocalTime partida;
    private Aeroporto destino;
    private LocalTime chegada;
    private int numeroParadas;

    public Voo() {
    }

    public Voo(String linha, String voo, Aeroporto origem, LocalTime partida, Aeroporto destino,
            LocalTime chegada, int numeroParadas) {
        this.linha = linha;
        this.voo = voo;
        this.origem = origem;
        this.partida = partida;
        this.destino = destino;
        this.chegada = chegada;
        this.numeroParadas = numeroParadas;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    public String getVoo() {
        return voo;
    }

    public void setVoo(String voo) {
        this.voo = voo;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public LocalTime getPartida() {
        return partida;
    }

    public void setPartida(LocalTime partida) {
        this.partida = partida;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public LocalTime getChegada() {
        return chegada;
    }

    public void setChegada(LocalTime chegada) {
        this.chegada = chegada;
    }

    public int getNumeroParadas() {
        return numeroParadas;
    }

    public void setNumeroParadas(int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "linha='" + linha + '\'' +
                ", voo='" + voo + '\'' +
                ", origem=" + origem.getAirportName() +
                ", partida=" + partida +
                ", destino=" + destino.getAirportName()+
                ", chegada=" + chegada +
                ", numeroParadas=" + numeroParadas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voo voo1 = (Voo) o;
        return Objects.equals(voo, voo1.voo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voo);
    }
}
