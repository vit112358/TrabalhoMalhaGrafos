package Control.GraphOP;

import Model.AuxStruct.Aeroporto;
import Model.AuxStruct.Voo;
import Model.Estrutura;
import Model.GraphRota.Edges;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
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
    public long distanciaPontos(Ponto a, Ponto b) {
        double aux = Math.sqrt(Math.pow((b.x - a.x), 2) + Math.pow((b.y - a.y), 2));
        return (long) aux;
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

    /**
     * Esta função Calcula a diferenca entre 2 horas
     * @param a: Hora A
     * @param b: Hora B
     * @return A diferença entre 2 horas em minutos
     */
    public long calculaDiferencaTempo(LocalTime a, LocalTime b){
        long result=(long)0;
        if(a.toNanoOfDay()>b.toNanoOfDay()){
            result = Duration.between(b,a).toMinutes();
        }else{
            result = Duration.between(a,b).toMinutes();
        }
        return result;
    }

    public Voo buscaVoo(List<Voo> voos, String origem, String destino){
        Voo result = new Voo();
        for (Voo v: voos
             ) {
            if(v.getOrigem().getAbreviation().equals(origem) && v.getDestino().getAbreviation().equals(destino)){
                result = v;
            }
        }

        return result;
    }
}
