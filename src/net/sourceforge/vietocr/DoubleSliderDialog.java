/**
 * Copyright @ 2016 Quan Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.sourceforge.vietocr;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.KeyStroke;

/**
 *
 * @author John Helour
 */
public class DoubleSliderDialog extends javax.swing.JDialog {

    private int actionSelected = 2;
    public static final String VALUE_CHANGED = "Value Changed";
    private static final int smallChange = 2;
    private int value1 = 0;
    private int value2 = 0;
    private int prevValue;

    /**
     * Creates new form SliderDialog.
     *
     * @param parent
     * @param modal
     */
    public DoubleSliderDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jSlider2 = new javax.swing.JSlider();
        jPanelButton = new javax.swing.JPanel();
        jButtonAccept = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("net/sourceforge/vietocr/SliderDialog"); // NOI18N
        setTitle(bundle.getString("this.Title")); // NOI18N
        setPreferredSize(new java.awt.Dimension(324, 320));
        setResizable(false);

        jPanelMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 30, 5, 30));
        jPanelMain.setMinimumSize(new java.awt.Dimension(124, 250));
        jPanelMain.setPreferredSize(new java.awt.Dimension(324, 258));
        jPanelMain.setRequestFocusEnabled(false);
        jPanelMain.setLayout(new java.awt.GridLayout(5, 2));

        jLabel.setLabelFor(jSlider1);
        jLabel.setText("Label");
        jPanelMain.add(jLabel);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Black Level");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelMain.add(jLabel1);

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setPaintTicks(true);
        jSlider1.setValue(0);
        jSlider1.setRequestFocusEnabled(false);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanelMain.add(jSlider1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("White Level");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanelMain.add(jLabel2);

        jSlider2.setMajorTickSpacing(10);
        jSlider2.setPaintTicks(true);
        jSlider2.setValue(0);
        jSlider2.setRequestFocusEnabled(false);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanelMain.add(jSlider2);

        getContentPane().add(jPanelMain, java.awt.BorderLayout.CENTER);

        jPanelButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 15, 1));
        jPanelButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jButtonAccept.setText(bundle.getString("jButtonAccept.Text")); // NOI18N
        jButtonAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceptActionPerformed(evt);
            }
        });
        jPanelButton.add(jButtonAccept);

        jButtonCancel.setText(bundle.getString("jButtonCancel.Text")); // NOI18N
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanelButton.add(jButtonCancel);

        getContentPane().add(jPanelButton, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceptActionPerformed
        actionSelected = JOptionPane.OK_OPTION;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonAcceptActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        actionSelected = JOptionPane.CANCEL_OPTION;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        JSlider slider = (JSlider) evt.getSource();

        //reduce # of unnecessary update events
        value1 = slider.getValue();
        if (Math.abs(value1 - prevValue) >= smallChange) {
            prevValue = value1;
            firePropertyChange(VALUE_CHANGED, value1, value2);
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        JSlider slider = (JSlider) evt.getSource();

        //reduce # of unnecessary update events
        value2 = slider.getValue();
        if (Math.abs(value2 - prevValue) >= smallChange) {
            prevValue = value2;
            firePropertyChange(VALUE_CHANGED, value1, value2);
        }
    }//GEN-LAST:event_jSlider2StateChanged

    public void setLabelText(String text) {
        jLabel.setText(text);
    }

    /**
     * Displays dialog.
     *
     * @return
     */
    public int showDialog() {
        setLocationRelativeTo(getOwner());

        //  Handle escape key to hide the dialog
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        };

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);

        prevValue = jSlider1.getValue();
        setVisible(true);

        return actionSelected;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DoubleSliderDialog dialog = new DoubleSliderDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAccept;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    // End of variables declaration//GEN-END:variables
}
