package jogo.model.checkboard.houses.factory;

import java.util.HashMap;
import java.util.Map;

import jogo.model.checkboard.Tabuleiro;
import jogo.model.checkboard.houses.CasaAvancarTresCasas;
import jogo.model.checkboard.houses.CasaMudarTipo;
import jogo.model.checkboard.houses.CasaPularRodada;
import jogo.model.checkboard.houses.CasaTrocarComMaisAtras;
import jogo.model.checkboard.houses.CasaVoltarInicio;
import jogo.model.checkboard.houses.abstrato.CasaEspecial;

public class CasaEspecialFactory {
    private final Map<Integer, CasaEspecial> casasEspeciais = new HashMap<>();
    private final Tabuleiro tabuleiro;

    public CasaEspecialFactory(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        iniciarCasasEspeciais();
    }

    private void iniciarCasasEspeciais(){
        casasEspeciais.put(10, new CasaPularRodada());
        casasEspeciais.put(25, new CasaPularRodada());
        casasEspeciais.put(38, new CasaPularRodada());
        casasEspeciais.put(13, new CasaMudarTipo());
        casasEspeciais.put(5, new CasaAvancarTresCasas());
        casasEspeciais.put(15, new CasaAvancarTresCasas());
        casasEspeciais.put(30, new CasaAvancarTresCasas());
        casasEspeciais.put(17, new CasaVoltarInicio(tabuleiro));
        casasEspeciais.put(27, new CasaVoltarInicio(tabuleiro));
        casasEspeciais.put(20, new CasaTrocarComMaisAtras(tabuleiro));
        casasEspeciais.put(35, new CasaTrocarComMaisAtras(tabuleiro));
    }

    public CasaEspecial getCasaEspecial(int posicao) {
        return casasEspeciais.getOrDefault(posicao, null);
    }
}
