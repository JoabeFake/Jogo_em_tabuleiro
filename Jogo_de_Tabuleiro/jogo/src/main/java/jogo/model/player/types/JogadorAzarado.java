package jogo.model.player.types;

import jogo.model.diceroll.UnluckyRoll;

public class JogadorAzarado extends Jogador {
    public JogadorAzarado(String cor){
        super(cor, new UnluckyRoll());
        this.tipo = TipoJogador.AZARADO;
    }
}