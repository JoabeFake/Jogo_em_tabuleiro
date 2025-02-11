package jogo.model.checkboard.houses;

import jogo.model.checkboard.houses.abstrato.Casa;
import jogo.model.player.types.Jogador;

public class CasaMoedas extends Casa {
    public CasaMoedas(int numero){
        super(numero);
        this.nome = "Simples";
    }

    @Override
    public void aplicarRegra(Jogador jogador){
        jogador.addMoedas(1);
    }
}
