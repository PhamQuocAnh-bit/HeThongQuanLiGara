/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.employer;

import com.mysql.cj.x.protobuf.MysqlxResultset;
import javax.swing.table.DefaultTableModel;
import dao.EmployerDAO;
import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Employer;

import org.apache.poi.ss.usermodel.* ;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import view.client.ClientFrm;
import view.client.PaymentFrm;
import view.service.ServiceFRM;
import view.user.LoginFrm;
import view.user.ManagerHomeFrm;
import view.user.StatisicalFrm;


/**
 *
 * @author ADMIN
 */
public class EmployerFrm extends javax.swing.JFrame {

    /**
     * Creates new form EmployerFrm
     */
    public EmployerFrm() {
        super("Employer") ;
        initComponents();
        this.setLocationRelativeTo(null);
        showEmployer(); 
        
    }
    // test chuyen dong cua thanh menu --> Khong dùng nữa 
    /* int width = 200 ;
    int heigt = 214 ;
    
    public void openMenu(){
        new  Thread (new Runnable() {
            @Override
            public void run() {
                for (int i=0 ; i<width ; i++){
                    JPMenu.setSize(width, heigt);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EmployerFrm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    public void closeMenu(){
        new  Thread (new Runnable() {
            @Override
            public void run() {
                for (int i=width ; i>0 ; i--){
                    JPMenu.setSize(i, heigt);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EmployerFrm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    } */
    
    //public EmployerDAO dao = new EmployerDAO() ;
    
    //ArrayList<Employer> listEmp = dao.searchEmployerByName("") ;
    
    public void showEmployer(){
        EmployerDAO dao = new EmployerDAO();
    
        ArrayList<Employer> listEmp = dao.searchEmployerByName("") ;
        DefaultTableModel tblModel = (DefaultTableModel) tblEmployer.getModel();
        tblModel.setRowCount(0);
        
        for (Employer emp : listEmp){
            Object dataRow[] = new Object[8] ;
            
            dataRow[0] = emp.getID() ;
            dataRow[1] = emp.getFullname() ;
            dataRow[2] = emp.getEmail() ;
            dataRow[3] = emp.getTel() ;
            dataRow[4] = emp.getGender() ;
            dataRow[5] = emp.getAddress() ;
            dataRow[6] = emp.getRole() ;
            dataRow[7] = emp.getNote() ;
            
            tblModel.addRow(dataRow);
            
            
        }
    }
    private void clearForm() {
        
    txtName.setText("");
    txtAddress.setText("");
    txtTel.setText("");
    txtRole.setSelectedItem("");
    txtEmail.setText("");
    txtNote.setText("");
    btnID.setText("");
      }
    
    
    private void print(JTable table){
        Workbook workbook = new XSSFWorkbook() ;
        Sheet sheet = workbook.createSheet("Employees") ;
        TableModel model = table.getModel() ;
        
        Row header = sheet.createRow(0) ;
        for(int i=0 ; i<model.getColumnCount();i++) {
            header.createCell(i).setCellValue(model.getColumnName(i));
           
        }
        
        for(int row = 0 ; row<model.getRowCount();row++) {
            Row dataRow = sheet.createRow(row+1) ;
            for(int col = 0 ; col<model.getColumnCount();col++) {
                Object value = model.getValueAt(row, col) ;
                dataRow.createCell(col).setCellValue(value != null ? value.toString(): "");
                
            }
        }
        String filePath =  "D:/employer.xlsx";
        
        try (FileOutputStream out = new FileOutputStream(filePath)){
            
            workbook.write(out) ;
            workbook.close() ;
            JOptionPane.showMessageDialog(null, "In Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"In thất bại");
        }
        
    }
    
    
   


    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnEmployer = new javax.swing.JButton();
        btnReceived = new javax.swing.JButton();
        btnPayment = new javax.swing.JButton();
        btnSta = new javax.swing.JButton();
        btnSer = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtFullnam = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnTel = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        btnEmail = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        txtNote = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        txtGender = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAddNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        txtRole = new javax.swing.JComboBox<>();
        btnReset = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnID = new javax.swing.JTextField();
        btnPrintf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblEmployer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fullname", "Email", "Tel", "Gender", "Address", "Role", "Note"
            }
        ));
        tblEmployer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployer);
        if (tblEmployer.getColumnModel().getColumnCount() > 0) {
            tblEmployer.getColumnModel().getColumn(0).setMinWidth(50);
            tblEmployer.getColumnModel().getColumn(0).setMaxWidth(100);
            tblEmployer.getColumnModel().getColumn(3).setMinWidth(50);
            tblEmployer.getColumnModel().getColumn(3).setMaxWidth(150);
            tblEmployer.getColumnModel().getColumn(4).setMinWidth(50);
            tblEmployer.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        jPanel2.setBackground(new java.awt.Color(5, 135, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(5, 135, 243));

        jPanel4.setBackground(new java.awt.Color(5, 135, 253));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnHome.setBackground(new java.awt.Color(5, 135, 253));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnHome.setForeground(new java.awt.Color(242, 242, 242));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-48.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.setBorder(null);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnHome)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnEmployer.setBackground(new java.awt.Color(5, 135, 253));
        btnEmployer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEmployer.setForeground(new java.awt.Color(242, 242, 242));
        btnEmployer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-employer-40.png"))); // NOI18N
        btnEmployer.setText("Employer");
        btnEmployer.setBorder(null);
        btnEmployer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployerActionPerformed(evt);
            }
        });

        btnReceived.setBackground(new java.awt.Color(5, 135, 253));
        btnReceived.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnReceived.setForeground(new java.awt.Color(242, 242, 242));
        btnReceived.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-car-40.png"))); // NOI18N
        btnReceived.setText("Received Car");
        btnReceived.setToolTipText("");
        btnReceived.setBorder(null);
        btnReceived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceivedActionPerformed(evt);
            }
        });

        btnPayment.setBackground(new java.awt.Color(5, 135, 253));
        btnPayment.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnPayment.setForeground(new java.awt.Color(242, 242, 242));
        btnPayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-payment-40.png"))); // NOI18N
        btnPayment.setText("Payment");
        btnPayment.setBorder(null);
        btnPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentActionPerformed(evt);
            }
        });

        btnSta.setBackground(new java.awt.Color(5, 135, 253));
        btnSta.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSta.setForeground(new java.awt.Color(242, 242, 242));
        btnSta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-analytics-40 (1).png"))); // NOI18N
        btnSta.setText("Statistical");
        btnSta.setBorder(null);
        btnSta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaActionPerformed(evt);
            }
        });

        btnSer.setBackground(new java.awt.Color(5, 135, 253));
        btnSer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSer.setForeground(new java.awt.Color(242, 242, 242));
        btnSer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-service-40.png"))); // NOI18N
        btnSer.setText("Services");
        btnSer.setBorder(null);
        btnSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(5, 135, 253));
        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(242, 242, 242));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-log-out-40.png"))); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.setBorder(null);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEmployer)
                    .addComponent(btnReceived, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPayment)
                    .addComponent(btnSta)
                    .addComponent(btnSer)
                    .addComponent(btnLogOut)
                    .addComponent(jSeparator2))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEmployer)
                .addGap(29, 29, 29)
                .addComponent(btnReceived)
                .addGap(28, 28, 28)
                .addComponent(btnPayment)
                .addGap(31, 31, 31)
                .addComponent(btnSta)
                .addGap(29, 29, 29)
                .addComponent(btnSer)
                .addGap(33, 33, 33)
                .addComponent(btnLogOut)
                .addGap(48, 48, 48)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton11.setBackground(new java.awt.Color(242, 242, 242));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/userhome48.png"))); // NOI18N
        jButton11.setText("Quản Lí ");
        jButton11.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton11)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton11)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-letter-30_1.png"))); // NOI18N

        jButton13.setBackground(new java.awt.Color(242, 242, 242));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-bell-30 (1).png"))); // NOI18N

        jButton3.setBackground(new java.awt.Color(242, 242, 242));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton3.setText("Employer");
        jButton3.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(323, 323, 323)
                .addComponent(jButton14)
                .addGap(28, 28, 28)
                .addComponent(jButton13)
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        txtFullnam.setBackground(new java.awt.Color(242, 242, 242));
        txtFullnam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFullnam.setText(" FullName :");
        txtFullnam.setBorder(null);

        txtName.setBackground(new java.awt.Color(242, 242, 242));
        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnTel.setBackground(new java.awt.Color(242, 242, 242));
        btnTel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTel.setText("Tel :");
        btnTel.setBorder(null);

        txtTel.setBackground(new java.awt.Color(242, 242, 242));
        txtTel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnEmail.setBackground(new java.awt.Color(242, 242, 242));
        btnEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmail.setText("Email :");
        btnEmail.setBorder(null);

        txtEmail.setBackground(new java.awt.Color(242, 242, 242));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextField8.setBackground(new java.awt.Color(242, 242, 242));
        jTextField8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField8.setText("Role : ");
        jTextField8.setBorder(null);

        jTextField10.setBackground(new java.awt.Color(242, 242, 242));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField10.setText("Address : ");
        jTextField10.setBorder(null);

        txtAddress.setBackground(new java.awt.Color(242, 242, 242));
        txtAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextField12.setBackground(new java.awt.Color(242, 242, 242));
        jTextField12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField12.setText("Note : ");
        jTextField12.setBorder(null);

        txtNote.setBackground(new java.awt.Color(242, 242, 242));
        txtNote.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextField14.setBackground(new java.awt.Color(242, 242, 242));
        jTextField14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField14.setText("Gender :");
        jTextField14.setBorder(null);

        txtGender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Giới Tính Thứ 3", " " }));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-search-20.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-update-20.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAddNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-add-new-20.png"))); // NOI18N
        btnAddNew.setText("AddNew");
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-20.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        txtRole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lí", "Nhân Viên Thu Ngân ", "Nhân Viên Kĩ Thuật ", "Nhân Viên Bán Hàng " }));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-reset-20.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(242, 242, 242));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setText("ID : ");
        jTextField1.setBorder(null);

        btnID.setEditable(false);
        btnID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIDMouseClicked(evt);
            }
        });

        btnPrintf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-print-20.png"))); // NOI18N
        btnPrintf.setText("Printf");
        btnPrintf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txtFullnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtName)
                                            .addComponent(txtTel)
                                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                                        .addGap(85, 85, 85)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                            .addComponent(txtRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnID, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnReset)
                                    .addComponent(btnPrintf))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFullnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(49, 49, 49))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdate)
                                    .addComponent(btnReset))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddNew)
                                    .addComponent(btnPrintf))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDelete))
                                .addGap(19, 19, 19)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(txtName.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui Lòng Chọn Tên Nhân Viên Muốn Thay Đổi");
        }
        else {   
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn Chắc Chắn Muốn Thay Đổi ?" , "Xác Nhận Update" , JOptionPane.YES_NO_OPTION) ;
        if(confirm == JOptionPane.YES_OPTION) {
            EmployerDAO dao = new EmployerDAO() ;
            Employer emp = new Employer() ;
            
            emp.setFullname(txtName.getText());
            emp.setEmail(txtEmail.getText()); 
            emp.setAddress(txtAddress.getText());
            emp.setTel(txtTel.getText());
            emp.setGender(txtGender.getSelectedItem().toString());
            emp.setRole(txtRole.getSelectedItem().toString());
            emp.setNote(txtNote.getText());
            emp.setID(Integer.parseInt(btnID.getText()));
            
            dao.updateEmployer(emp);
            JOptionPane.showMessageDialog(this,"Update Thành Công");
            showEmployer();
            clearForm();
        }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed
    // Tìm Nhân Viên 
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        EmployerDAO dao = new EmployerDAO();
        String  name = txtName.getText() ;
        if (name.isEmpty()){
            JOptionPane.showMessageDialog(this,"Vui Lòng Nhập Tên Để Tìm ");
            
        }
        else {
            
        
        ArrayList<Employer> Emp = dao.searchEmployerByName(name) ;
        DefaultTableModel tblModel = (DefaultTableModel) tblEmployer.getModel();
        tblModel.setRowCount(0);
        for (Employer emp : Emp) {
            Object dataRow[] = new Object[8] ;
            
            dataRow[0] = emp.getID() ;
            dataRow[1] = emp.getFullname() ;
            dataRow[2] = emp.getEmail() ;
            dataRow[3] = emp.getTel() ;
            dataRow[4] = emp.getGender() ;
            dataRow[5] = emp.getAddress() ;
            dataRow[6] = emp.getRole() ;
            dataRow[7] = emp.getNote() ;
            
            tblModel.addRow(dataRow);
        }}
    }//GEN-LAST:event_btnSearchActionPerformed
     // Thêm nhân Viên 
    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        if (txtName.getText().isEmpty() || txtEmail.getText().isEmpty() || txtAddress.getText().isEmpty() || txtTel.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this , "Bạn Cần Nhập Đầy Đủ Thông Tin");
        }
        else {
        Employer emp = new Employer() ;
        emp.setFullname(txtName.getText());
        emp.setEmail(txtEmail.getText());
        emp.setTel(txtTel.getText());
        emp.setGender(txtGender.getSelectedItem().toString());
        emp.setRole(txtRole.getSelectedItem().toString());
        emp.setAddress(txtAddress.getText());
        emp.setNote(txtNote.getText());
       
        
        
        EmployerDAO dao = new EmployerDAO();
        dao.addNewEmployer(emp);
        JOptionPane.showMessageDialog(this,"Them Thanh Cong");
        clearForm();
        showEmployer();
        
        
        }
        
    }//GEN-LAST:event_btnAddNewActionPerformed
    // Xóa Nhân Viên 
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblEmployer.getSelectedRow(); // Lấy dòng được chọn trong bảng tblEmployer ;
        if (selectedRow == -1 ) {
            JOptionPane.showMessageDialog(this,"Vui Long Chọn Nhân Viên Để Xóa!!");
        }
        else {
            int id = (int) tblEmployer.getValueAt(selectedRow, 0) ;
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa "+ id + "?" , "Xác Nhận Xóa",JOptionPane.YES_NO_CANCEL_OPTION) ;
            if(confirm ==JOptionPane.YES_OPTION) {
                EmployerDAO dao = new EmployerDAO();
                dao.deleteEmployer(id); // gọi dao để xóa 
                JOptionPane.showMessageDialog(this,"Đã Xóa Thành Công");
                showEmployer(); // show lại table employer
                
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn Chắc Chắn Muốn Đăng Xuất", "Xác Nhận Đăng Xuất" ,JOptionPane.YES_NO_OPTION) ;
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            new LoginFrm().setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnReceivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceivedActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn Chắc Chắn Muốn Rời Trang Này ?" , "Xác Nhận Chuyển Trang ", JOptionPane.YES_NO_OPTION) ;
        if(confirm == JOptionPane.YES_OPTION) {
            this.dispose(); 
            new ClientFrm().setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnReceivedActionPerformed

    private void btnPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn Chắc Chắn Muốn Rời Trang Này ?" , "Xác Nhận Chuyển Trang", JOptionPane.YES_NO_OPTION) ;
        if(confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            new PaymentFrm().setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnPaymentActionPerformed

    private void btnEmployerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployerActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Đang Ở Trang Này" );
    }//GEN-LAST:event_btnEmployerActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this,"Bạn Chắc Chắn Muốn Quay Lại Trang Chủ" , "Xác Nhận Chuyển Trang" , JOptionPane.YES_NO_OPTION) ;
        if(confirm == JOptionPane.YES_OPTION){
            this.dispose();
            new ManagerHomeFrm().setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
       int confirm =  JOptionPane.showConfirmDialog(this , "Bạn Chắc Chắn Muốn Thoát Khỏi Mọi Chế Độ Đang Làm Việc ?", "Xác Nhận Reset" , JOptionPane.YES_NO_OPTION) ;
        if(confirm == JOptionPane.YES_OPTION){
        showEmployer();
        clearForm();}
    }//GEN-LAST:event_btnResetActionPerformed
    // Gan Click Chuot vao ten nhan vien --> Thong tin hien Len O Trong
    private void tblEmployerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployerMouseClicked
        // TODO add your handling code here:
        int selectedRow = tblEmployer.getSelectedRow() ;
        if(selectedRow != -1){
             txtName.setText(tblEmployer.getValueAt(selectedRow, 1).toString());
             txtEmail.setText(tblEmployer.getValueAt(selectedRow, 2).toString());
             txtTel.setText(tblEmployer.getValueAt(selectedRow, 3).toString());
             txtGender.setSelectedItem(tblEmployer.getValueAt(selectedRow, 4).toString());
             txtRole.setSelectedItem(tblEmployer.getValueAt(selectedRow,6));
             txtAddress.setText(tblEmployer.getValueAt(selectedRow, 5).toString());
             txtNote.setText(tblEmployer.getValueAt(selectedRow, 7).toString());
             btnID.setText(tblEmployer.getValueAt(selectedRow, 0).toString());
             
        }
    }//GEN-LAST:event_tblEmployerMouseClicked

    private void btnIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIDMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Không Thể Thêm/Thay Đổi ID Nhân Viên");
    }//GEN-LAST:event_btnIDMouseClicked

    private void btnPrintfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintfActionPerformed
        // TODO add your handling code here:
        print(tblEmployer);
       
    }//GEN-LAST:event_btnPrintfActionPerformed

    private void btnStaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaActionPerformed
        // TODO add your handling code here:
        new StatisicalFrm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnStaActionPerformed

    private void btnSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerActionPerformed
        // TODO add your handling code here:
        new ServiceFRM().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSerActionPerformed

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
            java.util.logging.Logger.getLogger(EmployerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployerFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployerFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField btnEmail;
    private javax.swing.JButton btnEmployer;
    private javax.swing.JButton btnHome;
    private javax.swing.JTextField btnID;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPayment;
    private javax.swing.JButton btnPrintf;
    private javax.swing.JButton btnReceived;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSer;
    private javax.swing.JButton btnSta;
    private javax.swing.JTextField btnTel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tblEmployer;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullnam;
    private javax.swing.JComboBox<String> txtGender;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNote;
    private javax.swing.JComboBox<String> txtRole;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
