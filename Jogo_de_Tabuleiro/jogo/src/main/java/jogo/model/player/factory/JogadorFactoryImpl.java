package jogo.model.player.factory;

import jogo.model.player.types.Jogador;
import jogo.model.player.types.JogadorAzarado;
import jogo.model.player.types.JogadorNormal;
import jogo.model.player.types.JogadorSortudo;

public class JogadorFactoryImpl implements JogadorFactory {
    @Override
    public Jogador criarJogador(String cor, Jogador.TipoJogador tipo) {
        switch (tipo) {
            case NORMAL -> {
                return new JogadorNormal(cor);
            }
            case SORTUDO -> {
                return new JogadorSortudo(cor);
            }
            case AZARADO -> {
                return new JogadorAzarado(cor);
            }
            default -> throw new IllegalArgumentException("Tipo de Jogador inválido");
        }
    }
}