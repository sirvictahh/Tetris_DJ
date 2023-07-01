package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

public class PieceT extends Piece {

    // Define a matriz de blocos para a peça T
    public static Block[][] T = {
        {new Block(Color.PINK), new Block(Color.PINK), new Block(Color.PINK)},
        {new Empty(), new Block(Color.PINK), new Empty()}

    };

    /**
     * Construtor da classe PieceT.
     * Chama o construtor da superclasse Piece e passa a matriz T como parâmetro,
     * além das posições iniciais (0, 0).
     */
    public PieceT() {
        super(T, 0, 0);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
