package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

public class PieceJ extends Piece {

    // Define a matriz de blocos para a peça J
    public static Block[][] J = {
        {new Empty(), new Block(Color.BLUE)},
        {new Empty(), new Block(Color.BLUE)},
        {new Block(Color.BLUE), new Block(Color.BLUE)}
    };

    /**
     * Construtor da classe PieceJ.
     * Chama o construtor da superclasse Piece e passa a matriz J como parâmetro,
     * além das posições iniciais (0, 0).
     */
    public PieceJ() {
        super(J, 0, 0);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}