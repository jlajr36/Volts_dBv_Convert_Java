package pkg;

import java.text.DecimalFormat;

public class dBV_Volts_Main extends javax.swing.JFrame {

    DecimalFormat df;
    
    public dBV_Volts_Main() {
        initComponents();
        df = new DecimalFormat("####.####");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtVolts = new javax.swing.JTextField();
        lblVolts = new javax.swing.JLabel();
        lbldBv = new javax.swing.JLabel();
        txtdBV = new javax.swing.JTextField();
        txtdBVOut = new javax.swing.JTextField();
        txtVoltsOut = new javax.swing.JTextField();
        lbldBVOut = new javax.swing.JLabel();
        lblVoltsOut = new javax.swing.JLabel();
        btnConvert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtVolts.setText("1");

        lblVolts.setText("Volts");

        lbldBv.setText("dBV");

        txtdBV.setText("1");

        txtdBVOut.setEditable(false);

        txtVoltsOut.setEditable(false);

        lbldBVOut.setText("dBV");

        lblVoltsOut.setText("Volts");

        btnConvert.setText("Convert");
        btnConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldBv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdBV))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVolts)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVolts, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbldBVOut)
                    .addComponent(lblVoltsOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdBVOut, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(txtVoltsOut))
                .addGap(18, 18, 18)
                .addComponent(btnConvert)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVolts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVolts)
                            .addComponent(txtdBVOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbldBVOut))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldBv)
                            .addComponent(txtdBV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVoltsOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVoltsOut)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnConvert, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertActionPerformed
        Thread convertThread = new Thread() {
            public void run() {
                convert();
            }
        };
        convertThread.start();
    }//GEN-LAST:event_btnConvertActionPerformed

    public void convert() {
        double VoltsIn = Double.parseDouble(txtVolts.getText());
        double dBVOut = 20 * Math.log10(VoltsIn);
        String strdBVOut = df.format(dBVOut);
        txtdBVOut.setText(strdBVOut);
        //-----------------------------------------------
        double dBVIn = Double.parseDouble(txtdBV.getText());
        double VoltsOut = Math.pow(10, (dBVIn/20));
        String strVoltsOut = df.format(VoltsOut);
        txtVoltsOut.setText(strVoltsOut);
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dBV_Volts_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvert;
    private javax.swing.JLabel lblVolts;
    private javax.swing.JLabel lblVoltsOut;
    private javax.swing.JLabel lbldBVOut;
    private javax.swing.JLabel lbldBv;
    private javax.swing.JTextField txtVolts;
    private javax.swing.JTextField txtVoltsOut;
    private javax.swing.JTextField txtdBV;
    private javax.swing.JTextField txtdBVOut;
    // End of variables declaration//GEN-END:variables
}
