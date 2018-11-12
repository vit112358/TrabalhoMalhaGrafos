package Control.GraphOP;

import Model.AuxStruct.Voo;
import Model.Estrutura;
import Model.GraphRota.Edges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Controls {

    public Controls() {
    }

    /**
     * Esta função calcula a distância entre 2 pontos
     *
     * @param a: Primeiro ponto a ser calculado a distância;
     * @param b: Segundo ponto ser calculado a distância;
     * @return o valor da distância entre dois Pontos retornado pela fórmula
     * ((x_final-x_inicial)^2+(y_final-y_inicial)^2)^(1/2)
     *
     * Custo: O(1)
     */
    public double distanciaPontos(Ponto a, Ponto b) {
        return Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
    }

    /**
     * Esta função busca todos os voos diretos, ou seja que não tem escalas
     * @param voosRotas: Estrutura que simula os voos e as Rotas
     * @return lista dos Voos diretos
     */
    public List<Voo> buscaVoosDiretos(Estrutura voosRotas){
        List<Voo> voosDiretos = new ArrayList<>();
        for(Edges edges: voosRotas.getRotas().getArestas()){
            for(Voo v : voosRotas.getVoos().getArestas()){
                if ((edges.getOrigem().getAeroporto().equals(v.getOrigem())) && (edges.getDestino().getAeroporto().equals(v.getDestino()))){
                    voosDiretos.add(v);
                }
            }
        }
        return voosDiretos;
    }
}
