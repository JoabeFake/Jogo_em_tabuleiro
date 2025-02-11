package jogo.model.checkboard.houses.abstrato;

import jogo.model.player.types.Jogador;

public abstract class Casa {
    protected int numero;
    protected String nome;

    public Casa(int numero){
        this.numero = numero;
    }

    public abstract void aplicarRegra(Jogador jogador);
}
