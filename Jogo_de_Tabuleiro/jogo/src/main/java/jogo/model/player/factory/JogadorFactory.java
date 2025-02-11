package jogo.model.player.factory;

import jogo.model.player.types.Jogador;

public interface JogadorFactory {
    Jogador criarJogador(String cor, Jogador.TipoJogador tipo);
}
