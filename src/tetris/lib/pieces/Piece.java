package tetris.lib.pieces;

import tetris.lib.blocks.Block;
import tetris.lib.blocks.BlockMatrix;

public class Piece extends BlockMatrix {

    // Posição no tabuleiro do Tetris
    protected int positionX;
    protected int positionY;

    /**
     * Construtor da classe Piece.
     * @param mat Matriz de blocos
     * @param y   Posição Y
     * @param x   Posição X
     */
    public Piece(Block[][] mat, int y, int x) {
        super(mat); // Chama o construtor da superclasse BlockMatrix
        this.positionX = x;
        this.positionY = y;
    }
    
    /**
     * Construtor de cópia.
     * @param p Peça a ser clonada
     */
    public Piece(Piece p) {
        this(p.matrix, p.positionY, p.positionX);
    }

    /**
     * Move a peça para a esquerda.
     */
    public void moveLeft() {
        positionX--;
    }

    /**
     * Move a peça para a direita.
     */
    public void moveRight() {
        positionX++;
    }

    /**
     * Move a peça para baixo.
     */
    public void moveDown() {
        positionY++;
    }

    /**
     * Clona a peça.
     * @return Clonagem da peça
     */
    @Override
    public Piece getClone() {
        return new Piece(this);
    }
    
    // Encapsulamento dos atributos

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "(" + positionY + "," + positionX + ")\n" + super.toString();
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010820L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}