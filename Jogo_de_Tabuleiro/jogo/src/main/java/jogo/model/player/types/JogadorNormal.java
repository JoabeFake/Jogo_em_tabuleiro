package jogo.model.player.types;

import jogo.model.diceroll.NormalRoll;

public class JogadorNormal extends Jogador {
    //Constructor
    public JogadorNormal(String cor){
        super(cor, new NormalRoll());
        this.tipo = TipoJogador.NORMAL;
    }
}