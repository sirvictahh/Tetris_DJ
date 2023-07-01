package tetris.lib.blocks;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import tetris.gui.Drawable;

public class Block extends JComponent implements Drawable{

    
    @Override
    public void paintComponent(Graphics gr){
        super.paintComponent(gr); // Constrói o componente
        draw(gr, 0, 0, getWidth()-1, getHeight()-1);
    }
    
    
    @Override
    public void draw(Graphics gr, int px, int py, int width, int height) {
        // Calcula o tamanho de cada célula
        int cellSize = Math.min(width, height) / 16;

        // Desenha o bloco usando uma representação simplificada
        gr.setColor(myColor);

        // Desenha o retângulo principal
        gr.fillRect(px + cellSize, py + cellSize, width - 1 * cellSize, height - 2 * cellSize);

        // Desenha as bordas superior e esquerda
        gr.setColor(Color.BLACK);
        gr.drawRect(px + cellSize, py + cellSize, width - 2 * cellSize, height - 2 * cellSize);

        // Desenha o sombreamento
        gr.setColor(Color.BLACK);
        for (int i = 0; i < cellSize; i++) {
            gr.drawLine(px + i, py + i, px + width - i - 1, py + i);
            gr.drawLine(px + i, py + i, px + i, py + height - i - 1);
        }
    }
    
    protected char txt; // Variável para armazenar um caractere associado ao bloco
    protected Color myColor; // Variável para armazenar a cor do bloco

    // Retorna a cor do bloco.
    public Color getMyColor() {
        return myColor;
    }

    // Define a cor do bloco.
    public void setMyColor(Color myColor) {
        this.myColor = myColor;
    }
    
    // Construtor que define a cor do bloco.
    public Block(Color color) {
        this.myColor = color;
    }
    
    // Construtor padrão que cria um bloco com cor padrão azul.
    public Block(){
        this(Color.BLUE);
    }
    
    // Construtor que cria um bloco com cor verde e define um caractere associado a ele.
    public Block(char ch) {
        this(Color.GREEN);
    }

    // Construtor que cria um bloco com base em outro bloco, copiando sua cor.
    public Block(Block b) {
        this(b.myColor);
    }

    //// Método que retorna o caractere associado ao bloco.
    public char getTxt() {
        return txt;
    }

    // Método que define o caractere associado ao bloco.
    public void setTxt(char txt) {
        this.txt = txt;
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return txt + "";
    }

    // Método para clonar o bloco
    public Block getClone() {
        return new Block(this);
    }
}
