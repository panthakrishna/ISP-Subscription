/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myApplication;

import businessLayer.BLUser;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objectFactory.User;
import objectFactory.OfficeStaff;

/**
 *
 * @author Kriss
 */
public class ViewOfficeStaffProfile extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewOfficeStaffProfile1
     */
    public ViewOfficeStaffProfile() {
        super("Office Staff Profile");
        initComponents();
        bluser = new BLUser();
        user = new User();
        officeStaff = new OfficeStaff();
        
    }

    public void setUser(User usr){
        this.user = usr;
    }
    
    public void viewOfficeStaffProfile() {
        DefaultTableModel dtm = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        
        try{
            dtm.addColumn("User ID");
            dtm.addColumn("Username");
            dtm.addColumn("User Type");
            dtm.addColumn("First Name");
            dtm.addColumn("Middle Name");
            dtm.addColumn("Last Name");
            dtm.addColumn("Block Code");
            dtm.addColumn("Street Name");
            dtm.addColumn("City Code");
            dtm.addColumn("City Name");
            dtm.addColumn("Telephone");
            dtm.addColumn("Email");
            dtm.addColumn("Status");
            dtm.addColumn("Designation");
            
            bluser.setUser(this.user);
            bluser.setOfficeStaff(officeStaff);
            ResultSet rs = bluser.selectOfficeStaffProfile();
            
            while(rs.next()) {
                Object objData[] = new Object[14];
                objData[0] = rs.getInt("userId");
                objData[1] = rs.getString("username");
                objData[2] = rs.getString("userType");
                objData[3] = rs.getString("firstName");
                objData[4] = rs.getString("middleName");
                objData[5] = rs.getString("lastName");
                objData[6] = rs.getString("blockCode");
                objData[7] = rs.getString("streetName");
                objData[8] = rs.getString("cityCode");
                objData[9] = rs.getString("cityName");
                objData[10] = rs.getString("telephone");
                objData[11] = rs.getString("email");
                objData[12] = rs.getString("status");
                objData[13] = rs.getString("designation");

                dtm.addRow(objData);
            }
            this.jTable1.setModel(dtm);
        

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.INFORMATION_MESSAGE);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 204, 255));
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(1265, 643));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    
    private businessLayer.BLUser bluser;
    private objectFactory.User user;
    private objectFactory.OfficeStaff officeStaff;
}
