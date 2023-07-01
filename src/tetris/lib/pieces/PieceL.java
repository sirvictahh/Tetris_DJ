package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

public class PieceL extends Piece {

    // Define a matriz de blocos para a peça L
    public static Block[][] L = {
        {new Block(Color.GREEN), new Empty()},
        {new Block(Color.GREEN), new Empty()},
        {new Block(Color.GREEN), new Block(Color.GREEN)}
    };

    /**
     * Construtor da classe PieceL.
     * Chama o construtor da superclasse Piece e passa a matriz L como parâmetro,
     * além das posições iniciais (0, 0).
     */
    public PieceL() {
        super(L, 0, 0);
    }
  
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
