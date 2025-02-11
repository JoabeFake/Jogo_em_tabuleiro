package jogo.model.checkboard.houses;

import jogo.model.checkboard.houses.abstrato.CasaEspecial;
import jogo.model.player.types.Jogador;

public class CasaPularRodada implements CasaEspecial {
    @Override
    public void executar(Jogador jogador) {
        jogador.setPularRodada(true);
        System.out.println("Pule a próxima rodada");
    }
}
