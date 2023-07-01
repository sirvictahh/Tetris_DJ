package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

public class PieceS extends Piece {

    // Define a matriz de blocos para a peça S
    public static Block[][] S = {
        { new Empty(),new Block(Color.ORANGE), new Block(Color.ORANGE)},
        {new Block(Color.ORANGE), new Block(Color.ORANGE),new Empty() }
    };

    /**
     * Construtor da classe PieceS.
     * Chama o construtor da superclasse Piece e passa a matriz S como parâmetro,
     * além das posições iniciais (0, 0).
     */
    public PieceS() {
        super(S, 0, 0);
    }

  
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
