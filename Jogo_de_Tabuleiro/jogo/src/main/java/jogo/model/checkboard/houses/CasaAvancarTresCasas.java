package jogo.model.checkboard.houses;

import jogo.model.checkboard.houses.abstrato.CasaEspecial;
import jogo.model.player.types.Jogador;
import jogo.model.player.types.Jogador.TipoJogador;

public class CasaAvancarTresCasas implements CasaEspecial{
    @Override
    public void executar(Jogador jogador){
        if(jogador.getTipo() != TipoJogador.AZARADO){
            jogador.setPosition(jogador.getPosition() + 3);
        }
        System.out.println("Casa da Sorte! Jogador " + jogador.getCor() + " Avançou 3 casas");
    }
}
