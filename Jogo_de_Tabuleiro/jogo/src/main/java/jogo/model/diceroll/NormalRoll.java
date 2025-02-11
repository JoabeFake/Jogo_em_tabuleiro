package jogo.model.diceroll;

import java.util.Random;

public class NormalRoll implements DiceStrategy{
    private Random random = new Random();

    @Override
    public int rolarDados(){
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        return dado1 + dado2;
    }
}
