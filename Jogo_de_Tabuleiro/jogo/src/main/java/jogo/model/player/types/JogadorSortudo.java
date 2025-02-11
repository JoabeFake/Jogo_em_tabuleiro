package jogo.model.player.types;

import jogo.model.diceroll.LuckyRoll;

public class JogadorSortudo extends Jogador{
    
    public JogadorSortudo(String cor){
        super(cor, new LuckyRoll());
        this.tipo = TipoJogador.SORTUDO;
    }
}