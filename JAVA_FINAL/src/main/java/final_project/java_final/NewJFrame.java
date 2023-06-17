/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_project.java_final;
import static com.google.common.io.Files.getFileExtension;
import final_project.java_final.DB_providers.CreatorSQL;
import final_project.java_final.DB_providers.DisplayerDB;
import final_project.java_final.DB_providers.FileWriter;
import final_project.java_final.DB_providers.GetIdSQL;
import final_project.java_final.DB_providers.InserterSQL;
import final_project.java_final.DB_providers.RefractorSQL;
import java.awt.event.WindowEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.value;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 79509
 */
public class NewJFrame extends javax.swing.JFrame {

    
    
    CreatorSQL creatorDB = new CreatorSQL();
    
    RefractorSQL refractorSQL = new RefractorSQL();
    
    
    String displayAllRecordsString = "select * from java.all_records";
    String StrindRecord2Edit = "SELECT \n" +
"ar.client_id,record_id , client_name, client_phone, description,\n" +
"status, accepter_id, maker_id, work_result, bill\n" +
"FROM \n" +
"java.all_records ar LEFT JOIN\n" +
"java.clients c ON c.client_id = ar.client_id\n" +
"WHERE record_id = ";
    InserterSQL inserter = new InserterSQL();
    GetIdSQL getterID = new GetIdSQL();
    DisplayerDB displayer;
    FileWriter writer = new FileWriter();
    
    
    public NewJFrame() {
        try {
            initComponents();
            this.displayer = new DisplayerDB();
            this.allRecordsTable.setSize(700, 400);
            this.showSelectedRecordTable.setSize(650, 300);
            this.showSelectedRecordTable.setVisible(false);
            this.AllRecordsDialog.setSize(800, 500);
            this.EditRecordDoneDialog.setSize(1000, 800);
            this.BillDialog.setSize(900, 800);
            TableColumn newRecord_model = this.newRecordTable.getColumnModel().getColumn(3);
            
            JComboBox comboBox = new JComboBox();
            comboBox.addItem("Сервисное обслуживание");
            comboBox.addItem("Поломки");

            newRecord_model.setCellEditor(new DefaultCellEditor(comboBox));
            
            this.setAccepterBottom.setVisible(false);
            this.workAccepterBottom.setVisible(false);
            
            this.setMakerBottom.setVisible(false);
            this.workMakerBottom.setVisible(false);
            
            
            this.RefreshButtom.setVisible(true);
            this.CloseRecordButtom.setVisible(false);
   
            
        } catch (SQLException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newRecordDialog = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        newRecordTable = new javax.swing.JTable();
        AddRecord = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AllRecordsDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        allRecordsTable = new javax.swing.JTable();
        EditRecordButton = new javax.swing.JButton();
        EditRecordDoneDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        setAccepterBottom = new javax.swing.JButton();
        setMakerBottom = new javax.swing.JButton();
        workAccepterBottom = new javax.swing.JButton();
        workMakerBottom = new javax.swing.JButton();
        RefreshButtom = new javax.swing.JButton();
        CloseRecordButtom = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        showSelectedRecordTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        ShowDiagnosisResultTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        SeeBillButton = new javax.swing.JButton();
        BillDialog = new javax.swing.JDialog();
        ExportBillButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        ExportTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CreateDBBottom = new javax.swing.JButton();
        AddRecordButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        newRecordDialog.setBackground(new java.awt.Color(51, 51, 51));
        newRecordDialog.setForeground(java.awt.Color.black);

        newRecordTable.setBackground(new java.awt.Color(0, 0, 0));
        newRecordTable.setForeground(new java.awt.Color(0, 102, 204));
        newRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ClientName", "Client Phone", "Client's car number", "Record Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(newRecordTable);

        AddRecord.setBackground(new java.awt.Color(0, 0, 0));
        AddRecord.setForeground(new java.awt.Color(204, 204, 255));
        AddRecord.setText("Add Record");
        AddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordActionPerformed(evt);
            }
        });

        jLabel3.setText("damage Description : \"damage\" or \"service\"");

        javax.swing.GroupLayout newRecordDialogLayout = new javax.swing.GroupLayout(newRecordDialog.getContentPane());
        newRecordDialog.getContentPane().setLayout(newRecordDialogLayout);
        newRecordDialogLayout.setHorizontalGroup(
            newRecordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newRecordDialogLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(newRecordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newRecordDialogLayout.createSequentialGroup()
                        .addComponent(AddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        newRecordDialogLayout.setVerticalGroup(
            newRecordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newRecordDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(newRecordDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newRecordDialogLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(AddRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newRecordDialogLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(223, Short.MAX_VALUE))
        );

        allRecordsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(allRecordsTable);

        EditRecordButton.setText("edit record");
        EditRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditRecordButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllRecordsDialogLayout = new javax.swing.GroupLayout(AllRecordsDialog.getContentPane());
        AllRecordsDialog.getContentPane().setLayout(AllRecordsDialogLayout);
        AllRecordsDialogLayout.setHorizontalGroup(
            AllRecordsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllRecordsDialogLayout.createSequentialGroup()
                .addGroup(AllRecordsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllRecordsDialogLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(EditRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AllRecordsDialogLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        AllRecordsDialogLayout.setVerticalGroup(
            AllRecordsDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllRecordsDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(EditRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jLabel1.setText("You choose record: ");

        setAccepterBottom.setText("set accepter");
        setAccepterBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setAccepterBottomActionPerformed(evt);
            }
        });

        setMakerBottom.setText("set maker");
        setMakerBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setMakerBottomActionPerformed(evt);
            }
        });

        workAccepterBottom.setText("work");
        workAccepterBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workAccepterBottomActionPerformed(evt);
            }
        });

        workMakerBottom.setText("work");
        workMakerBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workMakerBottomActionPerformed(evt);
            }
        });

        RefreshButtom.setText("refresh");
        RefreshButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtomActionPerformed(evt);
            }
        });

        CloseRecordButtom.setText("Close Record");
        CloseRecordButtom.setToolTipText("");
        CloseRecordButtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseRecordButtomActionPerformed(evt);
            }
        });

        showSelectedRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(showSelectedRecordTable);

        ShowDiagnosisResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(ShowDiagnosisResultTable);

        jLabel2.setText("Found  Damages :");

        SeeBillButton.setText("BILL");
        SeeBillButton.setToolTipText("");
        SeeBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeeBillButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditRecordDoneDialogLayout = new javax.swing.GroupLayout(EditRecordDoneDialog.getContentPane());
        EditRecordDoneDialog.getContentPane().setLayout(EditRecordDoneDialogLayout);
        EditRecordDoneDialogLayout.setHorizontalGroup(
            EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                                .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(RefreshButtom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setMakerBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workMakerBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                                        .addComponent(CloseRecordButtom)
                                        .addGap(117, 117, 117)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                                .addComponent(setAccepterBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(workAccepterBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SeeBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        EditRecordDoneDialogLayout.setVerticalGroup(
            EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(setAccepterBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workAccepterBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditRecordDoneDialogLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(SeeBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                                .addComponent(setMakerBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(EditRecordDoneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RefreshButtom)
                                    .addComponent(CloseRecordButtom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(workMakerBottom)))
                    .addGroup(EditRecordDoneDialogLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        ExportBillButton.setText("export Bill");
        ExportBillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBillButtonActionPerformed(evt);
            }
        });

        ExportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(ExportTable);

        javax.swing.GroupLayout BillDialogLayout = new javax.swing.GroupLayout(BillDialog.getContentPane());
        BillDialog.getContentPane().setLayout(BillDialogLayout);
        BillDialogLayout.setHorizontalGroup(
            BillDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillDialogLayout.createSequentialGroup()
                .addGroup(BillDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BillDialogLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(ExportBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BillDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        BillDialogLayout.setVerticalGroup(
            BillDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillDialogLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(ExportBillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CreateDBBottom.setText("create_DB");
        CreateDBBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDBBottomActionPerformed(evt);
            }
        });

        AddRecordButton.setText("new_record");
        AddRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordButtonActionPerformed(evt);
            }
        });

        jButton3.setText("view_records");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CreateDBBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(791, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(CreateDBBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(AddRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateDBBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDBBottomActionPerformed
        creatorDB.run();
    }//GEN-LAST:event_CreateDBBottomActionPerformed

    private void AddRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordButtonActionPerformed
        // TODO add your handling code here:
        newRecordDialog.setSize(800, 500);
        newRecordDialog.setVisible(true);
        
    }//GEN-LAST:event_AddRecordButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
            
            DefaultTableModel dt = new DefaultTableModel(displayer.getData(this.displayAllRecordsString), displayer.getColNames());
            
            this.allRecordsTable.setModel(dt );
            

            this.AllRecordsDialog.setVisible(true);
            this.allRecordsTable.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void AddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRecordActionPerformed
        // TODO add your handling code here:
        inserter.run("clients", newRecordTable);
        inserter.run("records", newRecordTable);
        

        
    }//GEN-LAST:event_AddRecordActionPerformed

    
    private void RefreshBottomActions(JButton setAccepterBottom ,JButton workAccepterBottom ,
                JButton setMakerBottom, JButton workMakerBottom, JButton CloseRecordButtom , String status){
        
          // в зависимости от статуса и причины обращения выводим определённые кнопки
        switch (status) {
            case "new":
                setAccepterBottom.setVisible(true);
                workAccepterBottom.setVisible(true);
                break;
                
            case "diagnosis":
                setMakerBottom.setVisible(true);
                workMakerBottom.setVisible(true);
                
                break;
            case "done_damages":
                
                CloseRecordButtom.setVisible(true);
            case "done_service":
                
                CloseRecordButtom.setVisible(true);
                
                break;
            default:
                throw new AssertionError();
        }
    
    
    }
    
    
    private void EditRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditRecordButtonActionPerformed
        // TODO add your handling code here:
        
   
        int row_number_selected = this.allRecordsTable.getSelectedRow();
        String reasonOfRecord = this.allRecordsTable.getValueAt(this.allRecordsTable.getSelectedRow(), 3).toString();
        
        
        int selected_record_id = (int) this.allRecordsTable.getValueAt(this.allRecordsTable.getSelectedRow(), 0);
        
     
        DefaultTableModel dt2 = new DefaultTableModel(displayer.getData(this.StrindRecord2Edit + 
                                  Integer.toString(selected_record_id)), displayer.getColNames());
        /// выводим всю инфу по заявке
        this.showSelectedRecordTable.setModel(dt2 );
            
        // получаем статус этой заявки
        String status = this.showSelectedRecordTable.getValueAt(0, 5).toString();
        System.out.println("status = " + status);
        
       this.RefreshBottomActions(this.setAccepterBottom ,this.workAccepterBottom ,
                this.setMakerBottom, this.workMakerBottom, this.CloseRecordButtom ,  status);
       
        
  
        this.EditRecordDoneDialog.setVisible(true);
        this.showSelectedRecordTable.setVisible(true);
            
            
        
   
        
        
    }//GEN-LAST:event_EditRecordButtonActionPerformed

    private void setAccepterBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setAccepterBottomActionPerformed
        // TODO add your handling code here:
        
        
        int record_id  = (int) this.showSelectedRecordTable.getValueAt(0, 1);
        this.refractorSQL.SetAccepter(record_id);
        
       
        
    }//GEN-LAST:event_setAccepterBottomActionPerformed

    private void workMakerBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workMakerBottomActionPerformed
        // TODO add your handling code here:
           int record_id  = (int) this.showSelectedRecordTable.getValueAt(0, 1);
         
       try{
              
          
            if(this.showSelectedRecordTable.getValueAt(0, 7) == null ){
              throw new Exception("") ;
            }

            this.refractorSQL.SetStatusAfterMaker(record_id);
         
        
          }
        catch(Exception e)
        { JOptionPane.showMessageDialog (null, "Вы не выбрали Maker", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
       
       
       this.refractorSQL.setBillAfterWork(record_id);
       
       
       
    }//GEN-LAST:event_workMakerBottomActionPerformed

    private void setMakerBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setMakerBottomActionPerformed
        // TODO add your handling code here:
        int record_id  = (int) this.showSelectedRecordTable.getValueAt(0, 1);
        
        int nDamages = this.ShowDiagnosisResultTable.getRowCount();
        System.out.println("nDamages = " + nDamages);
        for(int i = 0; i < nDamages; i++){
                  String damage = (String) this.ShowDiagnosisResultTable.getValueAt(i, 2);
                   this.refractorSQL.SetMaker(record_id, damage);
        }
        
  
        
        
    }//GEN-LAST:event_setMakerBottomActionPerformed

    private void workAccepterBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_workAccepterBottomActionPerformed
        // TODO add your handling code here:
        int record_id  = (int) this.showSelectedRecordTable.getValueAt(0, 1);
    
    
        /// ОБЯЗАТЕЛЬНО ПРОВЕРИТЬ ЧТО НАЗНАЧЕН ACCEPTER
        try{
        if(this.showSelectedRecordTable.getValueAt(0, 6) == null ){
          throw new Exception("") ;
        }
        
        /// в зависимости от типа обслуживания - сервис или поломки делаем что то одно
        String typeRecord =  this.showSelectedRecordTable.getValueAt(0,4).toString();
            switch (typeRecord) {
                case "Поломки":
                    refractorSQL.addDamage2Record(record_id);
                    this.refractorSQL.SetStatusAfterAccepter(record_id, "diagnosis");
                    break;
                case "Сервисное обслуживание":
                    refractorSQL.addDamageService2Record(record_id);
                    this.refractorSQL.SetStatusAfterAccepter(record_id, "done_service");
                    break;
                default:
                    throw new AssertionError();
            }
        
        
        System.out.println("Integer.toString(record_id) = " + Integer.toString(record_id));
        DefaultTableModel dt = new DefaultTableModel(displayer.getData("select * from java.damages2records where record_id = " + Integer.toString(record_id)), displayer.getColNames());
        /// выводим всю инфу по заявке
        this.ShowDiagnosisResultTable.setModel(dt );
        
        this.ShowDiagnosisResultTable.setVisible(true);
        
        
        
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog (null, "Вы не выбрали ACCEPTER", "Oшибка", JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_workAccepterBottomActionPerformed

    private void CloseRecordButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseRecordButtomActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel dt = new DefaultTableModel(displayer.getData(this.displayAllRecordsString), displayer.getColNames());
            
        this.allRecordsTable.setModel(dt );
        this.EditRecordDoneDialog.dispose();
        
        
        
        
        
    }//GEN-LAST:event_CloseRecordButtomActionPerformed

    private void RefreshButtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtomActionPerformed
        int record_id  =  (int) this.allRecordsTable.getValueAt(this.allRecordsTable.getSelectedRow(), 0);
    
           System.out.println("record_id = "  + record_id);

         DefaultTableModel dt2 = new DefaultTableModel(displayer.getData(this.StrindRecord2Edit + 
                                  Integer.toString(record_id)), displayer.getColNames());
        
        this.showSelectedRecordTable.setModel(dt2 );
                  System.out.println("record_id = " + record_id);
        DefaultTableModel dt = new DefaultTableModel(displayer.getData("select * from java.damages2records"
                    + " where record_id = " + Integer.toString(record_id)   ), displayer.getColNames());
        this.ShowDiagnosisResultTable.setModel(dt );
         this.ShowDiagnosisResultTable.setVisible(true);
         
        String status = this.showSelectedRecordTable.getValueAt(0, 5).toString();

        this.RefreshBottomActions(this.setAccepterBottom ,this.workAccepterBottom ,
                this.setMakerBottom, this.workMakerBottom, this.CloseRecordButtom ,  status);
        
    }//GEN-LAST:event_RefreshButtomActionPerformed

    String exportSQL = "";
    
    
    private void SeeBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeeBillButtonActionPerformed
        // TODO add your handling code here:
        
        String record_id = this.showSelectedRecordTable.getValueAt(0, 1).toString();
        String query = "SELECT \n" +
                "\n" +
                "client_name, status,  accepters.accepter_name, \n" +
                "makers.maker_name,\n" +
                "dr.category, dr.sub_category, detail_name, detail_price\n" +
                "\n" +
                "FROM \n" +
                "java.all_records ar \n" +
                "LEFT JOIN java.clients c ON c.client_id  = ar.client_id \n" +
                "LEFT JOIN java.damages2records dr ON dr.record_id = ar.record_id \n" +
                "LEFT JOIN \n" +
                "(SELECT worker_id AS accepter_id, worker_name AS accepter_name FROM java.workers ) accepters \n" +
                "ON accepters.accepter_id  = ar.accepter_id \n" +
                "\n" +
                "LEFT JOIN \n" +
                "(SELECT worker_id AS maker_id, worker_name AS maker_name FROM java.workers ) makers \n" +
                "ON makers.maker_id  = ar.maker_id \n" +
                "\n" +
                "WHERE ar.record_id = ";
        DefaultTableModel dt = new DefaultTableModel(displayer.getData(query + record_id), displayer.getColNames());
        this.exportSQL = query;
        this.ExportTable.setModel(dt );
       
        
       
        
        
        
        
        
        this.BillDialog.setVisible(true);
        
        
    }//GEN-LAST:event_SeeBillButtonActionPerformed

    private void ExportBillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBillButtonActionPerformed
        // TODO add your handling code here:
            String record_id = this.showSelectedRecordTable.getValueAt(0, 1).toString();
            JFileChooser filechooser = new JFileChooser();
            filechooser.showOpenDialog(this);
            File selectedFile = filechooser.getSelectedFile();
            
           
            System.out.println(selectedFile);
            writer.write2File(selectedFile, record_id, this.exportSQL);
            
            ///reader.writeToFile(selectedFile.toString(), results, cov_results);
         
     
    }//GEN-LAST:event_ExportBillButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
       
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddRecord;
    private javax.swing.JButton AddRecordButton;
    private javax.swing.JDialog AllRecordsDialog;
    private javax.swing.JDialog BillDialog;
    private javax.swing.JButton CloseRecordButtom;
    private javax.swing.JButton CreateDBBottom;
    private javax.swing.JButton EditRecordButton;
    private javax.swing.JDialog EditRecordDoneDialog;
    private javax.swing.JButton ExportBillButton;
    private javax.swing.JTable ExportTable;
    private javax.swing.JButton RefreshButtom;
    private javax.swing.JButton SeeBillButton;
    private javax.swing.JTable ShowDiagnosisResultTable;
    private javax.swing.JTable allRecordsTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JDialog newRecordDialog;
    private javax.swing.JTable newRecordTable;
    private javax.swing.JButton setAccepterBottom;
    private javax.swing.JButton setMakerBottom;
    private javax.swing.JTable showSelectedRecordTable;
    private javax.swing.JButton workAccepterBottom;
    private javax.swing.JButton workMakerBottom;
    // End of variables declaration//GEN-END:variables
}
