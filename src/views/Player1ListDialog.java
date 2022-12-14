/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import main.Menu;
import model.Player;

/**
 *
 * @author kalva
 */
public class Player1ListDialog extends javax.swing.JDialog {
    
    public static Player player1;
    private DefaultListModel model;

    /**
     * Creates new form PlayerListDialog
     */
    public Player1ListDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        model = new DefaultListModel();
        fillList();
    }

    private void fillList() {
        for (int i = 0; i < Menu.playerList.getSize(); i++) {
            model.addElement(Menu.playerList.getPlayer(i));
        }
        ltPlayers.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSubHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ltPlayers = new javax.swing.JList<>();
        lbExistingUsersHeader = new javax.swing.JLabel();
        lbPlayer1ListLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de usuarios disponibles 1");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbSubHeader.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbSubHeader.setForeground(new java.awt.Color(255, 255, 255));
        lbSubHeader.setText("Usuarios disponibles");

        ltPlayers.setBackground(new java.awt.Color(102, 102, 102));
        ltPlayers.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        ltPlayers.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        ltPlayers.setForeground(new java.awt.Color(255, 255, 255));
        ltPlayers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ltPlayersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ltPlayers);

        lbExistingUsersHeader.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbExistingUsersHeader.setForeground(new java.awt.Color(255, 255, 255));
        lbExistingUsersHeader.setText("Seleccione un usuario para el jugador 1");

        lbPlayer1ListLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Player1ListLogo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbPlayer1ListLogo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbExistingUsersHeader))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(lbSubHeader)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lbExistingUsersHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSubHeader)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(lbPlayer1ListLogo)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ltPlayersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ltPlayersValueChanged
        // TODO add your handling code here:
        player1 = ((Player) model.getElementAt(ltPlayers.getSelectedIndex()));
        player1.setPlayerSymbol("J1");
        //Enviar el jugador al modo de juego.
        dispose();
        BoardSizeFormDialog boardDialog = new BoardSizeFormDialog((JFrame) this.getParent(), true);
        boardDialog.setVisible(true);
    }//GEN-LAST:event_ltPlayersValueChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        PlayersMenuDialog playersMenu = new PlayersMenuDialog((JFrame) this.getParent(), true);
        dispose();
        playersMenu.setVisible(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbExistingUsersHeader;
    private javax.swing.JLabel lbPlayer1ListLogo;
    private javax.swing.JLabel lbSubHeader;
    private javax.swing.JList<String> ltPlayers;
    // End of variables declaration//GEN-END:variables
}
