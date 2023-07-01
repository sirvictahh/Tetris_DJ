package tetris.gui;

import java.awt.Graphics;

// Interface Drawable
// Define um contrato para objetos que podem ser desenhados na tela
public interface Drawable {
    // Método draw
    // Desenha o objeto na tela usando o contexto gráfico (Graphics)
    // px e py são as coordenadas de posicionamento do objeto
    // widtg e heigy são a largura e altura do objeto, respectivamente
    public void draw(Graphics gr, int px, int py, int widtg, int heigy);
}
