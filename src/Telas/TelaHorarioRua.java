/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Beans.Aluno;
import DAOS.AlunoDAO;
import Beans.HoraAula;
import DAOS.HoraAulaDAO;
import Beans.HorarioRua;
import DAOS.HorarioRuaDAO;
import Beans.Instrutor;
import DAOS.InstrutorDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import DAOS.HorarioRuaDAO;
import Beans.HorarioRua;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateStringConverter;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.JTableHeader;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Mario Souto
 */
public class TelaHorarioRua extends javax.swing.JFrame {

    /**
     *
     * Creates new form NewJFrame
     */
    HoraAulaDAO horaDAO = new HoraAulaDAO();
    InstrutorDAO insDAO = new InstrutorDAO();
    AlunoDAO alunoDAO = new AlunoDAO();

    public TelaHorarioRua() {
        initComponents();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable.getModel();
        jTable.setRowSorter(new TableRowSorter(modeloTabela));

        DefaultTableModel modeloTabela2 = (DefaultTableModel) jTable2.getModel();
        jTable2.setRowSorter(new TableRowSorter(modeloTabela2));

        carregandoComboBox();
        readJTable();
        readTable2();
        setLayout();

        try {
            MaskFormatter msk = new MaskFormatter("##/##/####");
            msk.install(data);
        } catch (ParseException ex) {
            Logger.getLogger(TelaHorarioRua.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void readTable2() {

        DefaultTableModel modeloTabela2 = (DefaultTableModel) jTable2.getModel();
        modeloTabela2.setNumRows(0);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.now();

        HorarioRuaDAO dao = new HorarioRuaDAO();
        Instrutor instrutorSelecionado = (Instrutor) instrutorcombo1.getSelectedItem();
        for (HorarioRua u : dao.listaInstrutor(instrutorSelecionado.getIdInstrutor())) {

            if (u.getData().equals(dtf.format(date).toString())) {
                modeloTabela2.addRow(new Object[]{
                    u.getHorario(),
                    u.getNome(),});

            }
        }

    }

    public void readJTable() {

        DefaultTableModel modeloTabela = (DefaultTableModel) jTable.getModel();
        modeloTabela.setNumRows(0);

        HorarioRuaDAO dao = new HorarioRuaDAO();
        for (HorarioRua u : dao.lista()) {

            modeloTabela.addRow(new Object[]{
                u.getId(),
                u.getNome(),
                u.getHorario(),
                u.getData(),
                u.getInstrutor(),});

        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        data = new javax.swing.JFormattedTextField();
        nomeinstrutorcombo = new javax.swing.JComboBox();
        nomeAluno = new javax.swing.JComboBox();
        limpar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        horacombo = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        instrutorcombo1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        excluir = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserir e Editar"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ALUNO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("HORARIO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("INSTRUTOR");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("DATA");

        data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataActionPerformed(evt);
            }
        });

        nomeinstrutorcombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        horacombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        horacombo.setFont(new java.awt.Font("Tahoma", 1, 16));

        nomeAluno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        limpar.setText("LIMPAR");
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        jButton2.setText("EDITAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("INSERIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        horacombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        horacombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        horacombo.setFont(new java.awt.Font("Tahoma", 1, 16));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(data)
                            .addComponent(nomeAluno, 0, 136, Short.MAX_VALUE)
                            .addComponent(nomeinstrutorcombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(horacombo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(limpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(horacombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeinstrutorcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        instrutorcombo1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        horacombo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true));

        horacombo.setFont(new java.awt.Font("Tahoma", 1, 16));
        instrutorcombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrutorcombo1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("INSTRUTOR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(instrutorcombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(instrutorcombo1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horário", "Aluno"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(555, 555, 555)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Horario", "Data", "Instrutor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setGridColor(new java.awt.Color(0, 0, 0));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("(Para remover selecione o usuario na tabela acima e clique no botao excluir)");

        excluir.setText("EXCLUIR");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        jButton4.setText("VOLTAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(excluir)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed

        HorarioRua u = new HorarioRua();
        HorarioRuaDAO uDAO = new HorarioRuaDAO();

        if (jTable.getSelectedRow() != -1) {

            u.setId((int) jTable.getValueAt(jTable.getSelectedRow(), 0));
            uDAO.exclui(u);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "Excluido", JOptionPane.INFORMATION_MESSAGE);

            readTable2();
            readJTable();

        }


    }//GEN-LAST:event_excluirActionPerformed

    private void jTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyReleased
        // TODO add your handling code here:

        if (jTable.getSelectedRow() != -1) {
            nomeAluno.setSelectedItem(jTable.getValueAt(jTable.getSelectedRow(), 1).toString());
            horacombo.setSelectedItem(jTable.getValueAt(jTable.getSelectedRow(), 2).toString());
            data.setText(jTable.getValueAt(jTable.getSelectedRow(), 3).toString());
            nomeinstrutorcombo.setSelectedItem(jTable.getValueAt(jTable.getSelectedRow(), 4).toString());

        }


    }//GEN-LAST:event_jTableKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HorarioRua u = new HorarioRua();
        HorarioRuaDAO uDAO = new HorarioRuaDAO();
        int i;

        u.setNome(nomeAluno.getSelectedItem().toString());
        u.setData(data.getText());

        i = 0;
        while (!(horaDAO.lista().isEmpty())) {

            if (horaDAO.lista().get(i).getHoraAula().equals(horacombo.getSelectedItem().toString())) {
                u.setHorario(horaDAO.lista().get(i));
                break;
            }
            i++;
        }
        i = 0;
        while (!(insDAO.lista().isEmpty())) {

            if (insDAO.lista().get(i).getNome().equals(nomeinstrutorcombo.getSelectedItem().toString())) {
                u.setInstrutor(insDAO.lista().get(i));
                break;
            }
            i++;
        }
        
        uDAO.adiciona(u);
        readJTable();
        readTable2();
        data.setText("");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed

        data.setText("");


    }//GEN-LAST:event_limparActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int i;
        if (jTable.getSelectedRow() != -1) {
            HorarioRua u = new HorarioRua();
            HorarioRuaDAO dao = new HorarioRuaDAO();

            u.setNome(nomeAluno.getSelectedItem().toString());
            u.setData(data.getText());

            i = 0;
            while (!(horaDAO.lista().isEmpty())) {
                System.out.println("Não entrou" + String.valueOf(horaDAO.lista().isEmpty()));
                System.out.println("Não entrou" + horaDAO.lista().size());
                System.out.println("Não entrou" + i);

                if (horaDAO.lista().get(i).getHoraAula().equals(horacombo.getSelectedItem().toString())) {
                    u.setHorario(horaDAO.lista().get(i));
                    break;
                }
                i++;
            }
            i = 0;
            while (!(insDAO.lista().isEmpty())) {
                if (insDAO.lista().get(i).getNome().equals(nomeinstrutorcombo.getSelectedItem().toString())) {
                    u.setInstrutor(insDAO.lista().get(i));
                    break;
                }
                i++;
            }

            u.setId((int) jTable.getValueAt(jTable.getSelectedRow(), 0));
            dao.altera(u);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Alterado", JOptionPane.INFORMATION_MESSAGE);
            readJTable();
            readTable2();

            data.setText("");

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked

        int selecionado = jTable.getSelectedRow();
        String nome = (String) jTable.getValueAt(selecionado, 1);
        HoraAula hora = (HoraAula) jTable.getValueAt(selecionado, 2);
        String dat = (String) jTable.getValueAt(selecionado, 3);
        Instrutor inst = (Instrutor) jTable.getValueAt(selecionado, 4);

        nomeAluno.getModel().setSelectedItem(nome);
        data.setText(dat);
        horacombo.getModel().setSelectedItem(hora);
        nomeinstrutorcombo.getModel().setSelectedItem(inst);


    }//GEN-LAST:event_jTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        telaPrincipal tela = new telaPrincipal();
        tela.setExtendedState(tela.MAXIMIZED_BOTH);
        tela.setVisible(true);
        setVisible(false);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataActionPerformed

    private void instrutorcombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrutorcombo1ActionPerformed
        readTable2();
    }//GEN-LAST:event_instrutorcombo1ActionPerformed

    public void setLayout() {

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);


    }

    public void carregandoComboBox() {
        for (int i = 0; i < insDAO.lista().size(); i++) {
            Instrutor inst = insDAO.lista().get(i);
            System.out.println(insDAO.lista().size());
            nomeinstrutorcombo.addItem(inst);
            instrutorcombo1.addItem(inst);
        }

        for (int i = 0; i < horaDAO.lista().size(); i++) {
            HoraAula hora = horaDAO.lista().get(i);

            horacombo.addItem(hora);
        }

        for (int i = 0; i < alunoDAO.lista().size(); i++) {
            Aluno aluno = alunoDAO.lista().get(i);

            nomeAluno.addItem(aluno);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaHorarioRua tu = new TelaHorarioRua();

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data;
    private javax.swing.JButton excluir;
    private javax.swing.JComboBox horacombo;
    private javax.swing.JComboBox<Instrutor> instrutorcombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton limpar;
    private javax.swing.JComboBox nomeAluno;
    private javax.swing.JComboBox nomeinstrutorcombo;
    // End of variables declaration//GEN-END:variables
}
