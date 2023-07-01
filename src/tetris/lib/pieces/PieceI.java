package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;

public class PieceI extends Piece {

    // Define a matriz de blocos para a peça I
    public static Block[][] I = {
        {new Block(Color.CYAN), new Block(Color.CYAN),new Block(Color.CYAN),new Block(Color.CYAN)},        
    };

    /**
    * Construtor da classe PieceI.
    * Chama o construtor da superclasse Piece e passa a matriz I como parâmetro,
    * além das posições iniciais (0, 0).
    */
    public PieceI() {
        super(I, 0, 0);
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
