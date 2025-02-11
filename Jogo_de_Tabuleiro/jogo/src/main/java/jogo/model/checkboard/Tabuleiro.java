package jogo.model.checkboard;

import java.util.List;

import jogo.model.checkboard.houses.abstrato.CasaEspecial;
import jogo.model.checkboard.houses.factory.CasaEspecialFactory;
import jogo.model.player.types.Jogador;

public class Tabuleiro{
    private static Tabuleiro instance;
    private CasaEspecialFactory casaEspecialFactory;
    private static final int NUM_CASAS = 40;
    private static List<Jogador> jogadores;
    
    //Construtor
    public Tabuleiro(List<Jogador> jogadores){
        this.jogadores = jogadores;
        this.casaEspecialFactory = new CasaEspecialFactory(this);
    }
    
    //Verificar Fim de Jogo
    public boolean verificarFimJogo(Jogador player){
        return player.getPosition() >= NUM_CASAS;
    }

    //verifica posicao do jogador e executa efeito da casa especial
    public boolean executarCasaEspecial(Jogador jogador){
        CasaEspecial casaEspecial = casaEspecialFactory.getCasaEspecial(jogador.getPosition());

        if(casaEspecial != null){
            casaEspecial.executar(jogador);
            return true;
        }
        return false;
    }

    public List<Jogador> getJogadores(){
        return jogadores;
    }

    public static Tabuleiro getInstance(List<Jogador> jogadores){
        if(instance == null){
            instance = new Tabuleiro(jogadores);
        }
        return instance;
    }
}