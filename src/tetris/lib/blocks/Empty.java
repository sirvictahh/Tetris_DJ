package tetris.lib.blocks;

import java.awt.Color;

public class Empty extends Block {
    
    // Construtor da classe
    public Empty() {
        super(Color.DARK_GRAY);
    }

    // Sobrescreve o método getClone() da classe pai para retornar uma nova instância de Empty
    @Override
    public Block getClone() {
        return new Empty();
    }
}