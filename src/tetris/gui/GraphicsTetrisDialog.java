package tetris.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class GraphicsTetrisDialog extends javax.swing.JDialog {
    // Variável para controlar se o jogo está pausado ou não
    private boolean gamePaused = false;
    // Variável para controlar se o som está mutado ou não
    private boolean muted = false;
    
    
    public GraphicsTetrisDialog(java.awt.Frame parent, boolean modal) {
        // Chama o construtor da superclasse JDialog
        super(parent, modal);
        // Inicializa os componentes da interface gráfica
        initComponents();      
        // Centraliza a janela na tela         
        setLocationRelativeTo(null);
        // Configura os pontos e o nível do jogo
        tetris.setPontos(pontos);
        tetris.setNivel(nivel);
        // Foca o jogo para que possa receber entrada do teclado
        tetris.requestFocus();
        // Torna os botões transparentes, exceto por alguns botões específicos
        makeButtonsTransparent(this);
    }
    
    
    private void makeButtonsTransparent(Container container) {
        // Obtém todos os componentes contidos no container fornecido
        Component[] components = container.getComponents();
        // Percorre todos os componentes
        for (Component component : components) {
            // Verifica se o componente é um JButton
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                // Obtém o texto do botão
                String buttonText = button.getText();
                // Verifica se o texto do botão não é "NOVO JOGO", "PAUSAR" ou "JOGAR"
                if (!buttonText.equals("    NEW GAME") && !buttonText.equals("    PAUSE") && !buttonText.equals("    JOGAR")) {
                    // Configura o botão para ser transparente
                    button.setOpaque(false);
                    button.setContentAreaFilled(false);
                    button.setBorderPainted(false);
                }
            }
            // Se o componente for um container, chama recursivamente o método para tornar os botões transparentes dentro dele
            else if (component instanceof Container) {
                makeButtonsTransparent((Container) component);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board1 = new tetris.lib.game.Board();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        spLines = new javax.swing.JSpinner();
        spColumns = new javax.swing.JSpinner();
        btCreate = new javax.swing.JButton();
        pause = new javax.swing.JButton();
        pontos = new javax.swing.JLabel();
        tetris = new tetris.lib.game.TetrisGame();
        mute = new javax.swing.JButton();
        nivel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        right = new javax.swing.JButton();
        up = new javax.swing.JButton();
        left = new javax.swing.JButton();
        down = new javax.swing.JButton();
        help = new javax.swing.JButton();
        fall = new javax.swing.JButton();

        javax.swing.GroupLayout board1Layout = new javax.swing.GroupLayout(board1);
        board1.setLayout(board1Layout);
        board1Layout.setHorizontalGroup(
            board1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        board1Layout.setVerticalGroup(
            board1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setTitle("GAME");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 43, 91));

        jPanel2.setBackground(new java.awt.Color(0, 43, 91));
        jPanel2.setLayout(new java.awt.GridLayout(3, 4, 5, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(228, 220, 207));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("          Tetris");
        jPanel2.add(jLabel3);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(228, 220, 207));
        jLabel1.setText("D&J");
        jPanel2.add(jLabel1);

        spLines.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        spLines.setModel(new javax.swing.SpinnerNumberModel(20, 8, null, 1));
        spLines.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Linhas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(228, 220, 207))); // NOI18N
        jPanel2.add(spLines);

        spColumns.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        spColumns.setModel(new javax.swing.SpinnerNumberModel(10, 5, null, 1));
        spColumns.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colunas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(228, 220, 207))); // NOI18N
        jPanel2.add(spColumns);

        btCreate.setBackground(new java.awt.Color(249, 245, 235));
        btCreate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCreate.setForeground(new java.awt.Color(234, 84, 85));
        btCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/new_game.png"))); // NOI18N
        btCreate.setText("    NEW GAME");
        btCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateActionPerformed(evt);
            }
        });
        jPanel2.add(btCreate);

        pause.setBackground(new java.awt.Color(249, 245, 235));
        pause.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pause.setForeground(new java.awt.Color(234, 84, 85));
        pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/pause.png"))); // NOI18N
        pause.setText("    PAUSE");
        pause.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });
        jPanel2.add(pause);

        pontos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        pontos.setForeground(new java.awt.Color(228, 220, 207));
        pontos.setText("Points: ");

        tetris.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(0, 0, 0)));
        tetris.setPontos(null);
        tetris.setPreferredSize(new java.awt.Dimension(350, 520));
        tetris.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tetrisKeyPressed(evt);
            }
        });

        mute.setForeground(new java.awt.Color(0, 43, 91));
        mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/volume.png"))); // NOI18N
        mute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tetrisLayout = new javax.swing.GroupLayout(tetris);
        tetris.setLayout(tetrisLayout);
        tetrisLayout.setHorizontalGroup(
            tetrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tetrisLayout.createSequentialGroup()
                .addGap(0, 325, Short.MAX_VALUE)
                .addComponent(mute, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tetrisLayout.setVerticalGroup(
            tetrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tetrisLayout.createSequentialGroup()
                .addComponent(mute)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        nivel.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        nivel.setForeground(new java.awt.Color(228, 220, 207));
        nivel.setText("Level: 1");

        jPanel5.setBackground(new java.awt.Color(0, 43, 91));

        right.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/right_arrow.png"))); // NOI18N
        right.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        right.setMaximumSize(new java.awt.Dimension(64, 64));
        right.setMinimumSize(new java.awt.Dimension(64, 64));
        right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightActionPerformed(evt);
            }
        });

        up.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/up_arrow.png"))); // NOI18N
        up.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        up.setMaximumSize(new java.awt.Dimension(64, 64));
        up.setMinimumSize(new java.awt.Dimension(64, 64));
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/left_arrow.png"))); // NOI18N
        left.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        left.setMaximumSize(new java.awt.Dimension(64, 64));
        left.setMinimumSize(new java.awt.Dimension(64, 64));
        left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftActionPerformed(evt);
            }
        });

        down.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/down_arrow.png"))); // NOI18N
        down.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        down.setMaximumSize(new java.awt.Dimension(64, 64));
        down.setMinimumSize(new java.awt.Dimension(64, 64));
        down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/help.png"))); // NOI18N
        help.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        fall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/fall.png"))); // NOI18N
        fall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(help)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(fall)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fall)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(up, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(down, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(pontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(tetris, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(pontos, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(tetris, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void fallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fallActionPerformed
        // Chamada do método fallDown() da instância do objeto tetris
        tetris.fallDown();
    }//GEN-LAST:event_fallActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        // Chamada do método moveDown() da instância do objeto tetris
        tetris.moveDown();
    }//GEN-LAST:event_downActionPerformed

    private void rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightActionPerformed
        // Chamada do método moveRight() da instância do objeto tetris
        tetris.moveRight();
    }//GEN-LAST:event_rightActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // Chama o método togglePause() para pausar o jogo
        togglePause();
        
        // Cria uma mensagem de ajuda para exibir ao utilizador
        String message = "<html><body width='%1s'><h1>HELP</h1>"
        + "<p>The user can play using the graphic interface. "
        + "<p>"
        + "It's easier if you use the keyboard: "
        + "<p>"
        + "<p>UP - rotate;"
        + "<p>LEFT - left;"
        + "<p>RIGHT - right;"
        + "<p>DOWN - down;"
        + "<p>X - fall;"
        + "<p>M - toggle music;"
        + "<p>SPACE - pause;";
        int w = 175;

        // Exibe uma caixa de diálogo com a mensagem de ajuda
        JOptionPane.showMessageDialog(null, String.format(message, w, w));
        
        // Chama o método togglePause() novamente para retornar ao estado anterior de pausa
        togglePause();
    }//GEN-LAST:event_helpActionPerformed

    private void muteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muteActionPerformed
        // Chama o método mute() do objeto tetris para ativar ou desativar o som
        tetris.mute();
        
        // Altera o estado de 'muted' para o oposto do estado atual
        muted = !muted; // Toggle the muted state
        
        // Verifica o estado de 'muted' e define o ícone do botão 'mute' de acordo
        if (muted) {
            // Define o ícone do botão como um ícone de som mutado
            mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/mute.png")));
        } else {
            // Define o ícone do botão como um ícone de som ativado
            mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/volume.png")));
        }
    }//GEN-LAST:event_muteActionPerformed

    private void tetrisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tetrisKeyPressed
        // Verifica se a tecla pressionada é a barra de espaço
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            // Chama o método togglePause() para alternar entre pausar e continuar o jogo
            togglePause();
            
            gamePaused = !gamePaused;

                if (gamePaused) {
                    // Se o jogo estiver pausado, retoma o jogo
                    pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/pause.png")));
                    pause.setText("    PAUSAR");
                    gamePaused = false;
                } else {
                    // Se o jogo não estiver pausado, pausa o jogo
                    pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/play.png")));
                    pause.setText("    JOGAR");
                    gamePaused = true;
                }
            return; // Retorna imediatamente após alternar a pausa
        }

        // Verifica se o jogo não está pausado
        if (!gamePaused) {
            // Verifica qual tecla foi pressionada e executa a ação correspondente
            if (evt.getKeyCode() == KeyEvent.VK_UP) {
                // Pressionar a tecla "UP" rotaciona a peça
                tetris.rotate();
            } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
                // Pressionar a tecla "RIGHT" move a peça para a direita
                tetris.moveRight();
            } else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
                // Pressionar a tecla "LEFT" move a peça para a esquerda
                tetris.moveLeft();
            } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
                // Pressionar a tecla "DOWN" move a peça para baixo
                tetris.moveDown();
            } else if (evt.getKeyCode() == KeyEvent.VK_X) {
                // Pressionar a tecla "X" faz a peça cair instantaneamente
                tetris.fallDown();
            } else if (evt.getKeyCode() == KeyEvent.VK_M) {
                // Pressionar a tecla "M" ativa ou desativa o som do jogo
                tetris.mute();

                // Altera o estado de 'muted' para o oposto do estado atual
                muted = !muted;

                // Verifica o estado de 'muted' e define o ícone do botão 'mute' de acordo
                if (muted) {
                    // Define o ícone do botão como um ícone de som mutado
                    mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/mute.png")));
                } else {
                    // Define o ícone do botão como um ícone de som ativado
                    mute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/volume.png")));
                }
            }
        }
    }//GEN-LAST:event_tetrisKeyPressed

   
    //Método chamado quando o botão "PAUSAR" é clicado.
    //Controla o estado de pausa do jogo.
    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
        // Chama o método togglePause() para alternar entre pausar e continuar o jogo
        togglePause();
        
        gamePaused = !gamePaused;
        
        
        if (gamePaused) {
            // Se o jogo estiver pausado, retoma o jogo
            pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/pause.png")));
            pause.setText("    PAUSAR");
            gamePaused = false;
        } else {
            // Se o jogo não estiver pausado, pausa o jogo
            pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/game/play.png")));
            pause.setText("    JOGAR");
            gamePaused = true;
        }
    }//GEN-LAST:event_pauseActionPerformed

    //Método chamado quando o botão "NOVO JOGO" é clicado.
    //Realiza a criação de um novo tabuleiro de jogo com base nas linhas e colunas selecionadas.
    private void btCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateActionPerformed
        int lines = (Integer) spLines.getValue();
        int cols = (Integer) spColumns.getValue();
        tetris.resize(lines, cols);
        tetris.requestFocus();
        tetris.stopGame();
        tetris.restartGame(300);
        pontos.setText("Pontos: ");
    }//GEN-LAST:event_btCreateActionPerformed

    //Método chamado quando o botão "Cima" é clicado.
    // Realiza a rotação da peça atual no sentido horário.
    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        tetris.rotate();
    }//GEN-LAST:event_upActionPerformed

    // Método chamado quando o botão "Esquerda" é clicado.
    // Move a peça atual para a esquerda.
    private void leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftActionPerformed
       tetris.moveLeft();
    }//GEN-LAST:event_leftActionPerformed

    // Alterna o estado de pausa do jogo.
    private void togglePause() {
        gamePaused = !gamePaused;
        if (gamePaused) {
            tetris.stopGame(); // Para o jogo ao pausar
        } else {
            tetris.startGame(300); // Continua o jogo ao despausar, com um atraso de 300ms entre movimentos
        }
    }
        
    
    public static void main(String args[]) {
        // Criação e exibição do diálogo principal
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GraphicsTetrisDialog dialog = new GraphicsTetrisDialog(new javax.swing.JFrame(), true);
                
                // Adiciona um listener para o evento de fechar a janela
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0); // Encerra a aplicação ao fechar a janela
                    }
                });
                dialog.setVisible(true); // Torna o diálogo visível
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tetris.lib.game.Board board1;
    private javax.swing.JButton btCreate;
    private javax.swing.JButton down;
    private javax.swing.JButton fall;
    private javax.swing.JButton help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton left;
    private javax.swing.JButton mute;
    private javax.swing.JLabel nivel;
    private javax.swing.JButton pause;
    private javax.swing.JLabel pontos;
    private javax.swing.JButton right;
    private javax.swing.JSpinner spColumns;
    private javax.swing.JSpinner spLines;
    private tetris.lib.game.TetrisGame tetris;
    private javax.swing.JButton up;
    // End of variables declaration//GEN-END:variables
}
