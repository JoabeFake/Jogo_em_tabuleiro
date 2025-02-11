package jogo.model.checkboard.houses;

import jogo.model.checkboard.houses.abstrato.CasaEspecial;
import jogo.model.player.types.Jogador;

public class CasaMudarTipo implements CasaEspecial{
    // public CasaMudarTipo(int numero){
    //     super(numero);
    //     this.nome = "Surpresa";
    // }
    
    @Override
    public void executar(Jogador jogador) {
        jogador.mudarTipo();
        System.out.println("Jogador " + jogador.getCor() + " mudou seu tipo para: " + jogador.getTipo());
    }
}