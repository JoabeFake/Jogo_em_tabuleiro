package jogo.model.checkboard.houses;

import jogo.model.checkboard.Tabuleiro;
import jogo.model.checkboard.houses.abstrato.CasaEspecial;
import jogo.model.player.types.Jogador;

public class CasaTrocarComMaisAtras implements CasaEspecial {
    private final Tabuleiro tabuleiro;

    public CasaTrocarComMaisAtras(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void executar(Jogador jogadorAtual) {
        Jogador maisAtras = tabuleiro.getJogadores().stream()
            .filter(jogador -> !jogador.equals(jogadorAtual) && jogador.getPosition() < jogadorAtual.getPosition())
            .min((j1, j2) -> Integer.compare(j1.getPosition(), j2.getPosition()))
            .orElse(null);

        if(maisAtras != null){
            int posAtual = jogadorAtual.getPosition();
            jogadorAtual.setPosition(maisAtras.getPosition());
            maisAtras.setPosition(posAtual);

            System.out.println("Jogador " + jogadorAtual.getCor() + " Trocou de lugar com o Jogador " + maisAtras.getCor());
        }else{
            System.out.println("Jogador " + jogadorAtual.getCor() + " está mais atrás no tabuleiro");
        }
    }
}
