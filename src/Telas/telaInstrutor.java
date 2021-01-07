/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package Telas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import DAOS.Instrutor;
import DAOS.InstrutorDAO;
import java.awt.Color;
import java.awt.Font;
import java.util.InputMismatchException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.JTableHeader;


/**
 *
 * @author Mario Souto
 */
public class telaInstrutor extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public telaInstrutor() {
        initComponents();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable.getModel();
        jTable.setRowSorter(new TableRowSorter(modeloTabela));

        readJTable();

        Font font = new Font("Tahoma", 2, 16);
        JTableHeader header = jTable.getTableHeader();
        header.setFont(font);
        header.setBackground(Color.black);
        header.setForeground(Color.white);

    }

    public void readJTable() {

        DefaultTableModel modeloTabela = (DefaultTableModel) jTable.getModel();
        modeloTabela.setNumRows(0);

        InstrutorDAO dao = new InstrutorDAO();

        for (Instrutor i : dao.lista()) {

            modeloTabela.addRow(new Object[]{
                i.getIdInstrutor(),
                i.getNome(),
                i.getCpf(),
                i.getRua(),
                i.getNumero(),
                i.getBairro(),
                i.getSexo(),});
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NOME = new javax.swing.JTextField();
        SEXO = new javax.swing.JComboBox<>();
        CPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        BAIRRO = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        RUA = new javax.swing.JTextField();
        NUMERO = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        excluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        limpar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        VOLTAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserir"));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("NOME");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CPF");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("RUA/");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 255));
        jLabel8.setText("SEXO");

        NOME.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        NOME.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        SEXO.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        SEXO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMININO" }));
        SEXO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));
        SEXO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEXOActionPerformed(evt);
            }
        });

        CPF.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));
        CPF.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        CPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("NUMERO");

        BAIRRO.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BAIRRO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("BAIRRO");

        RUA.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        RUA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));
        RUA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RUAActionPerformed(evt);
            }
        });

        NUMERO.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));
        NUMERO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        NUMERO.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        NUMERO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUMEROActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("AVENIDA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NOME)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(RUA)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(65, 65, 65))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SEXO, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(393, 393, 393)
                        .addComponent(NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RUA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SEXO, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        excluir.setBackground(new java.awt.Color(0, 0, 0));
        excluir.setForeground(new java.awt.Color(255, 255, 0));
        excluir.setText("EXCLUIR");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        jLabel1.setText("(Para remover selecione o aluno na tabela acima e clique no botao excluir)");

        limpar.setBackground(new java.awt.Color(0, 0, 0));
        limpar.setForeground(new java.awt.Color(255, 255, 0));
        limpar.setText("LIMPAR");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("INSERIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        VOLTAR.setBackground(new java.awt.Color(0, 0, 0));
        VOLTAR.setForeground(new java.awt.Color(255, 255, 0));
        VOLTAR.setText("VOLTAR");
        VOLTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VOLTARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(limpar)
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(excluir)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(VOLTAR)
                        .addGap(22, 22, 22))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(VOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CPF", "Rua", "Numero", "Bairro", "Sexo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jTable.setSelectionBackground(new java.awt.Color(255, 255, 51));
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Editar");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyReleased
        // TODO add your handling code here:

        if (jTable.getSelectedRow() != -1) {
            NOME.setText(jTable.getValueAt(jTable.getSelectedRow(), 2).toString());
            CPF.setText(jTable.getValueAt(jTable.getSelectedRow(), 3).toString());
            RUA.setText(jTable.getValueAt(jTable.getSelectedRow(), 4).toString());
            BAIRRO.setText(jTable.getValueAt(jTable.getSelectedRow(), 5).toString());
            NUMERO.setText(jTable.getValueAt(jTable.getSelectedRow(), 6).toString());
            SEXO.setSelectedItem(jTable.getValueAt(jTable.getSelectedRow(), 7).toString());

        }


    }//GEN-LAST:event_jTableKeyReleased


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Instrutor i = new Instrutor();
        InstrutorDAO instrutorDAO = new InstrutorDAO();

        boolean cpf = ValidaCPF(CPF.getText());
        if (cpf == true) {

            i.setNome(NOME.getText());
            i.setCpf(CPF.getText());
            i.setRua(RUA.getText());
            i.setBairro(BAIRRO.getText());
            i.setNumero(NUMERO.getText());
            i.setSexo((String) SEXO.getSelectedItem());
            instrutorDAO.adiciona(i);

            readJTable();

            NOME.setText("");
            CPF.setText("");
            RUA.setText("");
            BAIRRO.setText("");
            NUMERO.setText("");
            SEXO.setSelectedIndex(0);

        } else {

            JOptionPane.showMessageDialog(null, "ERRO! CPF INVÁLIDO", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (jTable.getSelectedRow() != -1) {
            Instrutor i = new Instrutor();
            InstrutorDAO dao = new InstrutorDAO();

            boolean cpf = ValidaCPF(CPF.getText());
            if (cpf == true) {

                i.setNome(NOME.getText());
                i.setCpf(CPF.getText());
                i.setRua(RUA.getText());
                i.setBairro(BAIRRO.getText());
                i.setNumero(NUMERO.getText());
                i.setSexo((String) SEXO.getSelectedItem());
                i.setIdInstrutor((int) jTable.getValueAt(jTable.getSelectedRow(), 0));
                dao.altera(i);
                readJTable();

                NOME.setText("");
                CPF.setText("");
                RUA.setText("");
                BAIRRO.setText("");
                NUMERO.setText("");
                SEXO.setSelectedIndex(0);

            } else {

                JOptionPane.showMessageDialog(null, "ERRO! CPF INVÁLIDO", "ERRO", JOptionPane.ERROR_MESSAGE);

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed

        NOME.setText("");
        CPF.setText("");
        RUA.setText("");
        BAIRRO.setText("");
        NUMERO.setText("");
        SEXO.setSelectedIndex(0);
    }//GEN-LAST:event_limparActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        Instrutor i = new Instrutor();
        InstrutorDAO instrutorDAO = new InstrutorDAO();

        if (jTable.getSelectedRow() != -1) {

            i.setIdInstrutor((int) jTable.getValueAt(jTable.getSelectedRow(), 0));
            instrutorDAO.exclui(i);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "Excluido", JOptionPane.INFORMATION_MESSAGE);

            readJTable();

        }

    }//GEN-LAST:event_excluirActionPerformed

    private void NUMEROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUMEROActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NUMEROActionPerformed

    private void RUAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RUAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RUAActionPerformed

    private void CPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPFActionPerformed

    private void SEXOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEXOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SEXOActionPerformed

    private void VOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VOLTARActionPerformed
        telaPrincipal tela = new telaPrincipal();
        tela.setExtendedState(tela.MAXIMIZED_BOTH);
        tela.setVisible(true);
        setVisible(false);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_VOLTARActionPerformed

    private static boolean ValidaCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000")
                || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        //"try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaInstrutor ta = new telaInstrutor();
                ta.setVisible(true);
                ta.dispose();
                ta.setUndecorated(true);
                ta.setVisible(true);
                ta.setResizable(false);
                ta.setDefaultCloseOperation(EXIT_ON_CLOSE);
                ta.setLocationRelativeTo(null);
                //ta.setAlwaysOnTop(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BAIRRO;
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JTextField NOME;
    private javax.swing.JFormattedTextField NUMERO;
    private javax.swing.JTextField RUA;
    private javax.swing.JComboBox<String> SEXO;
    private javax.swing.JButton VOLTAR;
    private javax.swing.JButton excluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton limpar;
    // End of variables declaration//GEN-END:variables
}
