package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;

public class PieceO extends Piece {

    // Define a matriz de blocos para a peça O
    public static Block[][] O = {
        {new Block(Color.MAGENTA), new Block(Color.MAGENTA)},
        {new Block(Color.MAGENTA), new Block(Color.MAGENTA)}
    };

    /**
     * Construtor da classe PieceO.
     * Chama o construtor da superclasse Piece e passa a matriz O como parâmetro,
     * além das posições iniciais (0, 0).
     */
    public PieceO() {
        super(O, 0, 0);
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
