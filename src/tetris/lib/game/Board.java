package tetris.lib.game;

import java.awt.Graphics;
import tetris.lib.blocks.Block;
import tetris.lib.blocks.Empty;
import tetris.lib.blocks.BlockMatrix;
import tetris.lib.pieces.Piece;
import tetris.lib.utils.TetrisPiece;

public class Board extends BlockMatrix {
    
    // Método responsável por desenhar os componentes gráficos no painel
    @Override
    public void paintComponent(Graphics g) {
        // Chamada ao método draw para desenhar os blocos na tela
        draw(g, 0, 0, getWidth(), getHeight());
    }

    // Método responsável por desenhar os blocos na tela
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        // Chamada ao método draw da superclasse para desenhar os blocos do tabuleiro
        super.draw(gr, px, py, width, height);
        
        // Calcula o tamanho de cada bloco com base nas dimensões do painel
        int sizeX = width / getColmuns();
        int sizeY = height / getLines(); 
        
        // Desenha o bloco flutuante (peça atual) na posição correta no painel
        current.draw(gr, px + current.getPositionX() * sizeX,
        py + current.getPositionY() * sizeY,
        sizeX * current.getColmuns(),
        sizeY * current.getLines());
    }

    // Atributo protegido que representa a peça flutuante (peça atual) no tabuleiro
    protected Piece current;

    // Construtor que cria um tabuleiro com as dimensões padrão (neste caso 20 linhas por 10 colunas)
    public Board() {
        this(20, 10);
    }

    // Construtor que recebe uma matriz de blocos e uma peça atual
    public Board(Block[][] mat, Piece current) {
        super(mat); // chamada ao construtor da superclasse (BlockMatrix) para inicializar a matriz do tabuleiro
        this.current = current.getClone(); // clona a peça atual passada como argumento
    }

    // Construtor que recebe um objeto Board como argumento para criar uma cópia
    public Board(Board b) {
        this(b.matrix, b.current);
    }
    
    // Construtor que recebe o número de linhas e colunas para criar um novo tabuleiro
    public Board(int lines, int columns) {
        resize(lines, columns);
    }

    // Redimensiona o tabuleiro para o número de linhas e colunas especificados
    @Override
    public void resize(int lines, int columns) {
        this.matrix = new Block[lines][columns]; // Cria uma nova matriz com as dimensões especificadas

        // Preenche a matriz com blocos vazios (Empty)
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = new Empty();
            }
        }
        generateRandomPiece(); // Gera uma nova peça aleatória
    }

    // Gera uma peça aleatória e a posiciona no tabuleiro
    public void generateRandomPiece() {
        this.current = TetrisPiece.generateRandom(); // Gera uma nova peça aleatória
        
        // Atualiza a posição x da peça para o centro do tabuleiro
        this.current.setPositionX(getColmuns() / 2 - current.getColmuns() / 2);
        
        // Posiciona a peça no topo do tabuleiro (posição y igual a 0)
        this.current.setPositionY(0);
        
        repaint(); // Redesenha o tabuleiro para refletir a nova peça
    }

    // "Congela" a peça flutuante e a transfere para o tabuleiro
    public void freezePiece() {
        // Itera sobre os blocos da peça flutuante
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                 // Verifica se o bloco não está vazio
                if (!(current.getMatrix()[y][x] instanceof Empty)) {
                    // "Congela" o bloco, transferindo-o para a matriz do tabuleiro
                    this.matrix[current.getPositionY() + y][current.getPositionX() + x] = current.getMatrix()[y][x];
                }
            }
        }
        repaint(); // Redesenha o tabuleiro para refletir a nova configuração após congelar a peça
    }

    // Retorna uma representação em String do tabuleiro e da peça flutuante
    @Override
    public String toString() {
        StringBuilder txt = new StringBuilder();
        
        // Clona o tabuleiro atual em um tabuleiro temporário
        Board tmp = new Board(this);
        
        // "Congela" a peça flutuante no tabuleiro temporário
        tmp.freezePiece();
        
        // Obtém a representação do tabuleiro
        for (int y = 0; y < getLines(); y++) {
            for (int x = 0; x < getColmuns(); x++) {
                txt.append(tmp.matrix[y][x]); // Adiciona a representação do bloco à string
            }
            txt.append("\n"); // Adiciona uma quebra de linha após cada linha do tabuleiro
        }
        
        return txt.toString(); // Retorna a representação do tabuleiro como uma string
    }

    // Verifica se a peça flutuante pode ser movida para a nova posição especificada
    public boolean canMovePiece(int dy, int dx) {
        // Itera sobre a matriz de blocos da peça atual
        for (int y = 0; y < current.getLines(); y++) {
            for (int x = 0; x < current.getColmuns(); x++) {
                // Se o bloco estiver vazio, continua para o próximo bloco
                if (current.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                
                // Calcula a nova posição do bloco
                int px = current.getPositionX() + x + dx;
                int py = current.getPositionY() + y + dy;

                // Verifica se a nova posição está dentro dos limites do tabuleiro ou se a nova posição não está vazia (ou seja, colide com algum bloco existente)
                if (px >= getColmuns() || px < 0 || py >= getLines() || py < 0 || !(matrix[py][px] instanceof Empty)) {
                    return false; // Não é possível mover a peça
                }
            }
        }
        return true; // É possível mover a peça
    }

    // Verifica se a peça flutuante pode ser rotacionada
    public boolean canRotatePiece() {
        // Clona a peça atual
        Piece clone = current.getClone();
        
        // Rotaciona o clone
        clone.rotate();
        
        // Verifica se a peça está fora dos limites do tabuleiro após a rotação
        if (clone.getPositionX() + clone.getColmuns() > getColmuns()) {
            return false;
        }
        
        // Verifica todos os blocos do clone
        for (int y = 0; y < clone.getLines(); y++) {
            for (int x = 0; x < clone.getColmuns(); x++) {
                // Se o bloco estiver vazio, continua para o próximo bloco
                if (clone.getMatrix()[y][x] instanceof Empty) {
                    continue;
                }
                
                // Verifica se a posição do bloco está dentro dos limites do tabuleiro e se a posição não está vazia (ou seja, colide com algum bloco existente)
                if (x < getColmuns() && x >= 0 && y < getLines() && y >= 0 && !(matrix[y][x] instanceof Empty)) {
                    return false; // Rotação não está disponível
                }
            }
        }
        return true; // Pode rotacionar a peça
    }

    // Move a peça flutuante para a esquerda
    public void moveLeft() {
        // Verifica se a peça pode se mover para a esquerda
        if (canMovePiece(0, -1)) {
            current.moveLeft(); // Move a peça para a esquerda
            repaint(); // Atualiza a exibição do tabuleiro
        }
    }

    // Move a peça flutuante para a direita
    public void moveRight() {
        // Verifica se a peça pode se mover para a direita
        if (canMovePiece(0, 1)) {
            current.moveRight(); // Move a peça para a direita
            repaint(); // Atualiza a exibição do tabuleiro
        }
    }

    // Move a peça flutuante para baixo
    public void moveDown() {
        // Verifica se a peça pode se mover para baixo
        if (canMovePiece(1, 0)) {
            current.moveDown(); // Move a peça para baixo
            repaint(); // Atualiza a exibição do tabuleiro
        }
    }

    // Faz a peça flutuante cair
    public void fallDown() {
        // Enquanto a peça puder se mover para baixo    
        while (canMovePiece(1, 0)) {
            current.moveDown(); // Move a peça para baixo
        }
    }

    // Sobrescreve o método rotate() para realizar a rotação da peça
    @Override
    public void rotate() {
        // Verifica se a peça pode ser rotacionada
        if (canRotatePiece()) {
            current.rotate(); // Realiza a rotação da peça atual
            repaint(); // Atualiza a exibição do tabuleiro após a rotação
        }
    }

    // Este método retorna a peça atual do tabuleiro.
    public Piece getCurrent() {
        return current; // Retorna a peça atual
    }

    // Este método define a peça atual do tabuleiro com base na peça fornecida como 
    public void setCurrent(Piece current) {
        this.current = current; // Define a peça atual como a peça fornecida
    }
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    private static final long serialVersionUID = 202305010848L;
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
}
