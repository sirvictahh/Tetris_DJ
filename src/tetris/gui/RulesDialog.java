package tetris.gui;

public class RulesDialog extends javax.swing.JDialog {
    
    public RulesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // Chama o construtor da superclasse JDialog passando o JFrame pai e o valor booleano modal
        initComponents(); // Inicializa os componentes visuais do diálogo
        setLocationRelativeTo(null); // Centraliza o diálogo na tela
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btOk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TETRIS RULES");

        jPanel1.setBackground(new java.awt.Color(0, 43, 91));

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(228, 220, 207));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tetris Rules");

        btOk.setBackground(new java.awt.Color(249, 245, 235));
        btOk.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btOk.setForeground(new java.awt.Color(234, 84, 85));
        btOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/rules/back.png"))); // NOI18N
        btOk.setText("Back");
        btOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(187, 187, 187));
        jScrollPane1.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 43, 91));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("      RULES!\n\n      → The object of the game is to make lines of blocks;\n      → You can rotate the pieces so that they fit together;\n      → When a line is completed, it disappears;\n      → You lose the game when the pieces reach the top.\n");
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tetris/resources/rules/rules.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 205, Short.MAX_VALUE)
                        .addComponent(btOk)
                        .addGap(205, 205, 205))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btOk)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Método chamado quando o botão "Ok" é clicado
    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        dispose(); // Fecha o diálogo
    }//GEN-LAST:event_btOkActionPerformed

    public static void main(String args[]) {
        // Criação de um novo evento na fila de eventos da AWT
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Criação e exibição do diálogo de regras
                RulesDialog dialog = new RulesDialog(new javax.swing.JFrame(), true);
                
                // Adição de um WindowListener para lidar com o evento de fechar a janela
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0); // Encerra a aplicação quando o diálogo for fechado
                    }
                });
                dialog.setVisible(true); // Torna o diálogo visível na interface do usuário
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}