package tetris.lib.pieces;

import java.awt.Color;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;

/**
 * Created on 01/05/2023, 08:20:18
 *
 * @author IPT - computer
 * @version 1.0
 */
public class PieceZ extends Piece {

    // Define a matriz de blocos para a peça Z
    public static Block[][] Z = {
        {new Block(Color.RED), new Block(Color.RED), new Empty()},
        {new Empty(), new Block(Color.RED), new Block(Color.RED)}

    };
    
    /**
     * Construtor da classe PieceZ.
     * Chama o construtor da superclasse Piece e passa a matriz Z como parâmetro,
     * além das posições iniciais (0, 0).
     */
    public PieceZ() {
        super(Z, 0, 0);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
