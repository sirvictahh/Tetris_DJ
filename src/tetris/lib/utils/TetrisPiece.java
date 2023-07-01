package tetris.lib.utils;

import java.util.Random;
import tetris.lib.pieces.Piece;
import tetris.lib.pieces.PieceI;
import tetris.lib.pieces.PieceJ;
import tetris.lib.pieces.PieceL;
import tetris.lib.pieces.PieceO;
import tetris.lib.pieces.PieceS;
import tetris.lib.pieces.PieceT;
import tetris.lib.pieces.PieceZ;

public enum TetrisPiece {
    L(new PieceL()),     // Enum constante para a peça L
    O(new PieceO()),     // Enum constante para a peça O
    S(new PieceS()),     // Enum constante para a peça S
    Z(new PieceZ()),     // Enum constante para a peça Z
    J(new PieceJ()),     // Enum constante para a peça J
    T(new PieceT()),     // Enum constante para a peça T
    I(new PieceI());     // Enum constante para a peça I

    Piece piece;          // Instância da peça correspondente

    // Construtor da enumeração TetrisPiece
    private TetrisPiece(Piece piece) {
        this.piece = piece;
    }
    
    private static Random rnd = new Random();   // Objeto Random para geração de valores aleatórios
    
    // Método estático para gerar uma peça aleatória
    public static Piece generateRandom() {
        TetrisPiece[] pieces = {TetrisPiece.L, TetrisPiece.I, TetrisPiece.S, TetrisPiece.Z, TetrisPiece.J, TetrisPiece.T, TetrisPiece.O};
        int index = rnd.nextInt(pieces.length);
        return pieces[index].piece.getClone();
    }
}