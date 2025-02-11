package jogo.model.checkboard.houses;

import jogo.model.checkboard.Tabuleiro;
import jogo.model.checkboard.houses.abstrato.CasaEspecial;
import jogo.model.player.types.Jogador;

public class CasaVoltarInicio implements CasaEspecial {
    private Tabuleiro tabuleiro;

    public CasaVoltarInicio(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void executar(Jogador jogador) {
    Jogador jogadorVoltar = jogador.escolherJogador(tabuleiro.getJogadores());
    if (jogadorVoltar != null) {
        jogadorVoltar.setPosition(1);
        System.out.println(jogadorVoltar.getCor() + " Voltou ao início");
    }
    }
}