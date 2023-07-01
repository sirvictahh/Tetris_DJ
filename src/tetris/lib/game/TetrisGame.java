package tetris.lib.game;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import tetris.lib.blocks.Empty;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

public class TetrisGame extends Board {

    Timer timer;
    JLabel pontos;
    JLabel nivel;
    int score;
    int previousLevelUpScore;
    private Clip currentSoundClip; // Variável que armazena o clipe de som atualmente em reprodução
    private boolean isFirstLevel; // Flag para controlar se estamos no primeiro nível
    private Clip soundClip;
    private boolean isMuted; // Flag para controlar se o som está silenciado
    int level; // Nível atual
    int delay; // Atraso entre cada movimento do jogo
    boolean isPaused;

    // Atraso entre cada movimento do jogo
    public TetrisGame() {
        super();
        timer = new Timer();
        score = 0; // Inicializa a pontuação
        level = 1; // Inicializa o nível
        delay = calculateDelay(level); // Inicializa o atraso com base no nível
        System.out.println("Level 1! Atraso: " + delay + "ms");
        previousLevelUpScore = 0;
        startGame(300);
        isPaused = false; // Reinicia a flag de pausa do jogo
        isMuted = false; // Inicializa a flag de som silenciado
        isFirstLevel = true; // Define a flag como true inicialmente
        
        // Toca a música do primeiro nível
        playSound("/tetris/resources/sounds/level_1.wav");
        
        // Adiciona um listener de janela após a janela do jogo Tetris ser exibida
        SwingUtilities.invokeLater(() -> {
            Window tetrisWindow = SwingUtilities.getWindowAncestor(this);
            tetrisWindow.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    togglePause();
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?", "Leave?",
                    JOptionPane.YES_NO_OPTION);

                    if (choice == JOptionPane.YES_OPTION) {
                        stopGame();
                        stopSound();
                        tetrisWindow.dispose();
                    } else if (choice == JOptionPane.NO_OPTION) {
                        togglePause();
                    } else if (choice == JOptionPane.CLOSED_OPTION) {
                        togglePause();
                    }
                }
            });
            if (tetrisWindow instanceof JDialog) {
                JDialog tetrisFrame = (JDialog) tetrisWindow;
                tetrisFrame.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            }
        });
    }

    
    // Inicia o jogo com um determinado atraso.
    //@param delay O atraso em milissegundos entre cada movimento do jogo.
    public void startGame(int delay) {
        timer.purge();
        timer = new Timer();
        timer.schedule(new MoveGame(), delay, delay);
    }
    
    
    //Reinicia o jogo com um novo atraso.
    //@param delay O novo atraso em milissegundos entre cada movimento do jogo.
    public void restartGame(int delay) {
        // Cria uma nova instância da tarefa MoveGame
        MoveGame moveGame = new MoveGame();

        // Cancela a tarefa agendada anteriormente
        timer.cancel();

        // Reinicia o tabuleiro e outras variáveis do jogo
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = new Empty();
            }
        }
        generateRandomPiece();
        previousLevelUpScore = 0;
        score = 0; // Reinicia a pontuação
        level = 1; // Reinicia o nível 
        this.delay = delay; // Atualiza a variável de membro da classe com o novo atraso

        // Agenda a nova tarefa MoveGame no temporizador existente
        timer = new Timer();
        timer.schedule(moveGame, 0, delay);

        playSound("/tetris/resources/sounds/level_1.wav");
        System.out.println("Level 1! Delay: " + delay + "ms");
        nivel.setText("Level: 1");
    }

    //Interrompe o jogo atual, cancelando o temporizador.
    public void stopGame() {
        timer.cancel();
    }
    
    // Verifica se o jogo terminou.
    //@return true se o jogo terminou, false caso contrário.
    public boolean isGameOver() {
        // Verifica se a peça atual está no topo e não pode mais mover para baixo
        if (current.getPositionY() == 0 && !canMovePiece(1, 0)) {
            playSound("/tetris/resources/sounds/over.wav");
            
            // Exibe uma caixa de diálogo perguntando ao jogador se ele deseja jogar novamente
            int choice = JOptionPane.showConfirmDialog(null, "Your score was: " + score + "! Want to try again? ", "Game Over",
                    JOptionPane.YES_NO_OPTION);
            
            if (choice == JOptionPane.YES_OPTION) {
                // Reinicia o jogo com um novo atraso de tempo
                restartGame(300);
                pontos.setText("Pontos: ");
            }else if (choice == JOptionPane.NO_OPTION || choice == JOptionPane.CLOSED_OPTION) {
                // Fecha a janela do jogo
                Window window = SwingUtilities.getWindowAncestor(this);
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    stopGame(); // Interrompe o jogo
                    stopSound(); // Para o som
                    dialog.dispose(); // Fecha a janela
                }
            }
            return true; // Retorna true indicando que o jogo terminou
        } 
       return false; // Retorna false indicando que o jogo ainda não terminou
    }

    //Classe interna que representa a tarefa de movimento do jogo.
    private class MoveGame extends TimerTask {
        @Override
        public void run() {
            // Verifica se o jogo está pausado; se estiver, não realiza nenhum movimento
            if (isPaused) { 
                return; // If the game is paused, do not perform any game moves
            }
            
            // Verifica se o jogo terminou
            if (isGameOver()) {
                return;
            }
            
            if (canMovePiece(1, 0)) {
                // Se a peça atual ainda pode ser movida para baixo, move-a para baixo
                moveDown();
            } else {
                // Caso contrário, a peça atual é congelada no lugar e uma nova peça é gerada
                freezePiece();
                score += 100; // Aumenta a pontuação quando uma linha é completada
                pontos.setText("Pontos: " + score);
                generateRandomPiece();
            }
            
            // Solicita o foco para o componente atual
            requestFocus();
            
            // Verifica se houve aumento de nível a cada 1000 pontos
            if (score >= previousLevelUpScore + 1000 && delay > 50) {
                level++;
                delay -= 50; // Diminui o atraso em 50 milissegundos

                // Garante que o atraso seja positivo
                if (delay <= 0) {
                    delay = 1; // Define um atraso mínimo de 1 milissegundo
                }
                
                
                if (level <=5) {
                    // Atualiza o nível exibido e reproduz o som correspondente ao nível
                    nivel.setText("Level: " + level);
                    System.out.println("Level " + level + "! New Delay: " + delay + "ms");
                    // Play the level up sound based on the level
                    String soundFilePath = "/tetris/resources/sounds/level_" + level + ".wav";
                    currentSoundClip = playSound(soundFilePath);
                } else if (level == 6) {
                    // Último nível: exibe mensagem e reproduz o som correspondente
                    nivel.setText("Level: " + level);
                    System.out.println("Last level! New Delay: " + delay + "ms");
                    playSound("/tetris/resources/sounds/level_6.wav");
                }

                timer.cancel();
                timer = new Timer();
                timer.schedule(new MoveGame(), 0, delay);
                previousLevelUpScore = score;
                
                // Para o som atualmente em reprodução
                if (currentSoundClip != null && currentSoundClip.isRunning()) {
                    currentSoundClip.stop();
                    currentSoundClip.close();
                }
                
                // Para a reprodução da música do primeiro nível quando o segundo nível é alcançado
                if (level == 2 && isFirstLevel) {
                    isFirstLevel = false;
                    stopSound();
                }
            }
        }
    }

    // Verifica se uma linha está completamente preenchida.
    //@param line O índice da linha a ser verificada.
    //@return true se a linha estiver completa, false caso contrário.
    public boolean isLineFull(int line) {
        for (int x = 0; x < matrix[line].length; x++) {
            // Verifica se alguma célula da linha é vazia
            if (matrix[line][x] instanceof Empty) {
                return false;
            }
        }
        return true;
    }
    
    
    
    //Alterna o estado de mudo do som.
    //Se estiver mudo, retoma a reprodução do som atualmente associado ao nível.
    //Se não estiver mudo, interrompe a reprodução do som.
    public void mute() {
        isMuted = !isMuted; // Alterna o estado de mudo

        // Interrompe ou retoma a reprodução do som com base no estado de mudo
        if (isMuted) {
            stopSound();
        } else {
            playSound("/tetris/resources/sounds/level_" + level + ".wav");
        }
    }
    
    //Reproduz um arquivo de som.
    //@param soundFilePath O caminho do arquivo de som a ser reproduzido.
    //@return O Clip que está reproduzindo o som.
    private Clip playSound(String soundFilePath) {
        if (isMuted) {
            return null; // Se o som estiver mudo, não reproduz o som
        }
        
        try {
            // Interrompe o som atualmente em reprodução
            if (soundClip != null && soundClip.isRunning()) {
                soundClip.stop();
                soundClip.close();
            }

            // Obtém o fluxo de entrada de áudio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFilePath));

            // Obtém o formato de áudio
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Cria uma instância de DataLine.Info com o formato de áudio
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);

            // Abre a linha de áudio
            soundClip = (Clip) AudioSystem.getLine(info);
            soundClip.open(audioInputStream);

            // Inicia a reprodução do som
            soundClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Reproduz um arquivo de som para uma linha específica.
    //@param soundFilePath O caminho do arquivo de som a ser reproduzido.
    private void lineSound(String soundFilePath) {
        try {
            // Obtém o fluxo de entrada de áudio
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundFilePath));

            // Obtém o formato de áudio
            AudioFormat audioFormat = audioInputStream.getFormat();

            // Cria uma instância de DataLine.Info com o tipo Clip e o formato de áudio
            DataLine.Info info = new DataLine.Info(Clip.class, audioFormat);

            // Abre a linha de áudio
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);

            // Inicia a reprodução do som
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Para a reprodução do som atual.
    private void stopSound() {
         if (soundClip != null && soundClip.isRunning()) {
            soundClip.stop();
            soundClip.close();
        }
    }

    // Remove uma linha completa do tabuleiro.
    // @param line O número da linha a ser removida.
    public void deleteLine(int line) {
         // Desce todas as colunas acima da linha
        for (int y = line; y > 0; y--) {
             // Copia a linha y
            for (int x = 0; x < matrix[y].length; x++) {
                matrix[y][x] = matrix[y - 1][x];
            }
        }
        
        // Coloca uma linha vazia na primeira linha
        for (int x = 0; x < matrix[0].length; x++) {
            matrix[0][x] = new Empty();
        }
        
        score += 150; // Aumenta a pontuação quando uma linha é removida
        pontos.setText("Pontos: " + score);
        
        // Verifica se quatro linhas foram removidas simultaneamente
        int clearedLines = 0;
        for (int y = line; y > line - 4; y--) {
            if (isLineFull(y)) {
                clearedLines++;
            }
        }

        if (clearedLines >= 3) {
            lineSound("/tetris/resources/sounds/four_clear.wav");
        } else {
            lineSound("/tetris/resources/sounds/line_clear.wav");
        }
    }

    //Deleta todas as linhas completas presentes no tabuleiro.
    public void deleteFullLines() {
        // Itera pelas linhas de baixo para cima
        for (int y = matrix.length - 1; y > 0; y--) {
            // Verifica se a linha está completa
            while (isLineFull(y)) {
                // Deleta a linha
                deleteLine(y);
            }
        }
    }
    
    
    //Congela a peça atual e deleta as linhas completas.
    //Sobrescreve o método freezePiece() da classe pai (Board).
    @Override
    public void freezePiece() {
        // Chama o método freezePiece() da classe pai (Board)
        super.freezePiece();
        // Deleta as linhas completas
        deleteFullLines();
    }

    //Obtém a pontuação atual do jogo.
    //@return A pontuação atual do jogo.
    public int getScore() {
        return score;
    }
    
    //Define o JLabel utilizado para exibir a pontuação.
    //@param pontos O JLabel utilizado para exibir a pontuação.
    public void setPontos(JLabel pontos) {
        this.pontos = pontos;
    }
    
    //Define o JLabel utilizado para exibir o nível.
    //  @param nivel O JLabel utilizado para exibir o nível.
    public void setNivel(JLabel nivel) {
        this.nivel = nivel;
    }
    
    //Calcula o atraso (delay) com base no nível atual.
    //@param level O nível atual.
    //@return O atraso calculado.
    private int calculateDelay(int level) {
        // Ajusta o atraso com base no nível atual
        // Usa um atraso base de 300 milissegundos e diminui 25 milissegundos para cada nível
        return 300 - (50 * (level - 1));
    }
    
    //Alterna a pausa do jogo.
    // Se o jogo estiver pausado, retoma o jogo; caso contrário, pausa o jogo.
    public void togglePause() {
    isPaused = !isPaused; // Alterna a flag de pausa
        if (isPaused) {
            stopGame(); // Se o jogo estiver pausado, para o timer
        } else {
            startGame(delay); // Se o jogo estiver sendo retomado, inicia o timer com o atraso atual
        }
    }
}