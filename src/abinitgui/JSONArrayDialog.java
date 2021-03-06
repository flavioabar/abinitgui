/*
 Copyright (c) 2009-2013 Flavio Miguel ABREU ARAUJO (flavio.abreuaraujo@uclouvain.be)
                         Yannick GILLET (yannick.gillet@uclouvain.be)

Université catholique de Louvain, Louvain-la-Neuve, Belgium
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
notice, this list of conditions, and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright
notice, this list of conditions, and the disclaimer that follows
these conditions in the documentation and/or other materials
provided with the distribution.

3. The names of the author may not be used to endorse or promote
products derived from this software without specific prior written
permission.

In addition, we request (but do not require) that you include in the
end-user documentation provided with the redistribution and/or in the
software itself an acknowledgement equivalent to the following:
"This product includes software developed by the
Abinit Project (http://www.abinit.org/)."

THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED.  IN NO EVENT SHALL THE JDOM AUTHORS OR THE PROJECT
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
SUCH DAMAGE.

For more information on the Abinit Project, please see
<http://www.abinit.org/>.
 */

package abinitgui;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import json.JSONArray;

public class JSONArrayDialog extends javax.swing.JDialog
{

    private JSONArray data;
    private JSONArray curData;
    private JSONArrayTableModel model;
    private JSONArrayEditor editor;
    private MainFrame mf;
    private int columnWidth = 100;
    
    /**
     * Creates new form MyJSONArrayEditor
     */
    public JSONArrayDialog(MainFrame mf, JSONArrayEditor editor) {
        initComponents();
        this.editor = editor;
        this.mf = mf;
        model = new JSONArrayTableModel();
        jTable1.setModel(model);
        jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
    }
    
    public void setArray(JSONArray array)
    {
        this.data = array;
        model.changeStructure();
        
        setColumnWidths(this.columnWidth);
        this.repaint();
    }
    
    public void setColumnWidths(int width)
    {
        int nrCols=jTable1.getModel().getColumnCount();
        if(nrCols==0){
            return;
        }

        //current width of the table:
        int totalWidth=jTable1.getWidth();

        int totalWidthRequested=0;
        int defaultWidth=(int)Math.floor((double)totalWidth/(double)nrCols);

        for(int col=0;col<nrCols;col++){
            totalWidthRequested+=width;
        }
        //calculate the scale for the column width
        double factor=(double)totalWidth/(double)totalWidthRequested;

        for(int col=0;col<nrCols;col++){
            jTable1.getColumnModel().getColumn(col).setPreferredWidth(width);
            jTable1.getColumnModel().getColumn(col).setWidth(width);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jButton1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        editor.setData(data);
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        editor.setData(data);
        setVisible(false);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        editor.setData(data);
        setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private class JSONArrayTableModel extends DefaultTableModel {
        
        private int nbRows = 0;
        private int nbCols = 0;
        
        public void changeStructure()
        {
            curData = data;
        
            if(curData == null)
            {
                nbRows = 0;
                nbCols = 0;
            }
            else
            {
                while(curData.length() == 1 && curData.get(0) instanceof JSONArray)
                {
                    curData = curData.getJSONArray(0);
                }
                nbRows = curData.length();
                
                if(nbRows == 0)
                {
                    nbCols = 0;
                }
                else
                {
                    Object obj = curData.get(0);
                    if(obj instanceof JSONArray)
                    {
                        nbCols = ((JSONArray)(obj)).length();
                        if(((JSONArray)(obj)).get(0) instanceof JSONArray)
                        {
                            mf.printERR("Not able to handle 3D tables, will not edit !");
                            editor.setData(data);
                            setVisible(false);
                        }
                    }
                    else
                    {
                        nbCols = 1;
                    }
                    System.out.println("nbRows = "+nbRows);
                    System.out.println("nbCols = "+nbCols);
                }
            }

            fireTableStructureChanged();

            jTable1.invalidate();
            JSONArrayDialog.this.repaint();
        }
        
        @Override
        public int getColumnCount()
        {
            return nbCols;
        }
        
        @Override
        public String getColumnName(int col)
        {
            return ""+col;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {
            if(nbCols == 1)
            {
                return curData.get(row);
            }
            else
            {
                return ((JSONArray)(curData.get(row))).get(column);
            }
        }
        
        public Class<?> getColumnClass(int c) 
        {
            return getValueAt(0,c).getClass();
        }
        
        @Override
        public int getRowCount()
        {
            return nbRows;
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
            return true;
        }
        
        @Override
        public void setValueAt(Object o, int row, int column)
        {
            if(nbCols == 1)
            {
                curData.put(row, o);
            }
            else
            {
                ((JSONArray)curData.get(row)).put(column, o);
            }
        }
    }
}
