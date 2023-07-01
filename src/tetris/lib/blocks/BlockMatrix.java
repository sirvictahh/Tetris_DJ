package tetris.lib.blocks;

import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.gui.Drawable;

public class BlockMatrix extends JPanel implements Drawable {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g, 0, 0, getWidth(), getHeight());
    }

    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        int sizeX = width / getColmuns();
        int sizeY = height / getLines();
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColmuns(); x++) {
                matrix[y][x].draw(gr, px + x * sizeX, py + y * sizeY, sizeX, sizeY);
            }
        }
    }

    //acessible by inheritance  
    protected Block[][] matrix;

    /**
     * clone the matrix in the parameter
     *
     * @param mat matrix
     */
    public BlockMatrix(Block[][] mat) {
        //new matrix
        this.matrix = new Block[mat.length][mat[0].length];
        //for each block in matrix
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[y].length; x++) {
                //clone block
                this.matrix[y][x] = mat[y][x].getClone();
            }
        }
    }

    /**
     * one empty block
     */
    public BlockMatrix() {
        this(new Block[][]{{new Empty()}});
    }

    /**
     * copy constructor
     *
     * @param blockMat mat
     */
    public BlockMatrix(BlockMatrix blockMat) {
        this(blockMat.matrix);
    }

    public Block[][] getMatrix() {
        return matrix;
    }

    public int getLines() {
        return matrix.length;
    }

    public int getColmuns() {
        return matrix[0].length;
    }

    /**
     * rotate matrix to right side
     */
    public void rotate() {
        int lines = matrix.length;
        int cols = matrix[0].length;
        //temporary matrix
        Block[][] tmp = new Block[cols][lines];
        for (int y = 0; y < lines; y++) {
            for (int x = 0; x < cols; x++) {
                // transpose matrix
                // miror in y axis
                tmp[x][lines - y - 1] = matrix[y][x];
            }
        }
        //update matrix with the temporary
        this.matrix = tmp;
    }

    /**
     * To String
     *
     * @return 2d matrix of chars
     */
    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        for (Block[] matrixLine : matrix) {
            for (Block block : matrixLine) {
                txt.append(block.toString()).append(" ");
            }
            txt.append("\n");
        }
        return txt.toString();
    }

    /**
     * Clone the matrix
     *
     * @return clone of the object
     */
    public BlockMatrix getClone() {
        return new BlockMatrix(this);
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010812L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
