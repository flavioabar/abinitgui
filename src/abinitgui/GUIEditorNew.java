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

import java.awt.Color;
import java.awt.Component;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
import json.*;
import parser.AbinitInput;

public class GUIEditorNew extends javax.swing.JFrame {
    
    private String fileName;
    private MainFrame mf;
    private JSONArray jsonArray;
    private DatasetModel model;
    private ArrayList<HashMap<String,Object>> dataTable;
    
    private AbinitInput input = null;
    
    private String[] toHide = new String[]{"ndtset","spgroup","bravais","kptns","nelect",
                 "ntyppure","prtpmp","rprimd_orig", "rprimd","xclevel","ziontypat"};
    private HashMap<String,String> mapVar = new HashMap<String, String>();
    
    /**
     * Creates new form GUIEditor
     */
    public GUIEditorNew(MainFrame mf) {
        this.mf = mf;
        initComponents();
        
        dataTable = new ArrayList<HashMap<String,Object>>();
        
        model = new DatasetModel();
        jTable1.setModel(model);
        
        jTable1.setDefaultRenderer(Object.class, new DatasetRenderer());
        jTable1.setDefaultEditor(JSONArray.class,new JSONArrayEditor(mf));
        
        mapVar.put("acell_orig", "acell");
        mapVar.put("rprimd_orig", "rprimd");
        mapVar.put("rprim_orig","rprim");
        mapVar.put("amu_orig", "amu");
        mapVar.put("xred_orig", "xred");
        mapVar.put("occ_orig","occ");
    }
    
    public void loadFile(String fileName)
    {
        dataTable.clear();
        this.fileName = fileName;
        System.out.println("Parsing file : "+fileName);
        input = new AbinitInput();

        try{
            input.readFromFile(fileName);
        } catch(IOException e)
        {
            mf.printERR("Unable to parse fileName = "+fileName);
            mf.printERR("Error = "+e.getMessage());
        }
        System.out.println(input);
        
//        mf.printOUT("Loading JSON File "+fileName);
//        
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(fileName));
//            String s = br.readLine();
//            jsonArray = new JSONArray(s);
//            int length = jsonArray.length();
//            mf.printOUT("length = "+length);
            String[] data = null;
//            if(length == 2)
//            {
//                mf.printOUT("Only 1 dataset detected !");
//                data[0] = "1 Dataset";
//            }
//            else
//            {
//                mf.printOUT((length-1)+" datasets detected !");
//                for(int idtset = 1; idtset < length; idtset++)
//                {
//
//                    JSONObject json = new JSONArray(s).getJSONObject(idtset);
//                    data[idtset-1] = "jdtset "+json.get("jdtset");
//                }
//            }
//            
        if(input.getNdtset() == 1 || input.getNdtset() == 0)
        {
            data = new String[1];
            data[0] = "1";
        }
        else
        {
            data = input.getJdtsets().toArray(new String[0]);
        }
        
        dtsetList.setListData(data);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(TestJSon.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                br.close();
//            } catch (IOException ex) {
//                Logger.getLogger(TestJSon.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
        setVisible(true);
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
        dtsetList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = jTable1 = new DatasetTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nbReplicaY = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1,1,99,1));
        jLabel8 = new javax.swing.JLabel();
        nbReplicaZ = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1,1,99,1));
        nbReplicaX = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1,1,99,1));
        jLabel2 = new javax.swing.JLabel();
        viewGeomButton = new javax.swing.JButton();

        setTitle("GUI Editor");
        setResizable(false);

        dtsetList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        dtsetList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dtsetListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(dtsetList);

        jLabel1.setText("All datasets :");

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

        jLabel7.setText("Nb. Y");

        jLabel8.setText("Nb. Z");

        nbReplicaX.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Nb. X");

        viewGeomButton.setText("View Geometry inside JMOL");
        viewGeomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGeomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbReplicaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbReplicaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nbReplicaZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(viewGeomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbReplicaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbReplicaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbReplicaZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewGeomButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewGeomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGeomButtonActionPerformed

        String jdtset = (String)dtsetList.getSelectedValue();
        
        if(jdtset == null)
        {
            mf.printERR("First select a dataset !");
            return;
        }
        
        
        String simName = fileName+jdtset;
        
        final String XYZFile = simName + ".aims";

        try {
            AbinitGeometry geom = new AbinitGeometry();
            
            if(jdtset == null)
            {
                return;
            }
            HashMap<String,Object> values = null;
            if(input.isUsejdtset())
            {
                values = input.getAllDatasets().get(jdtset);
            }
            else
            {
                values = input.getAllDatasets().get("0");
            }
            
            geom.loadData(values);

            if (geom == null) {
                mf.printERR("Geometry analyzer does not support multi-dataset files !");
            } else {
                geom.fillData();

                geom.computeReplicas((Integer) nbReplicaX.getValue(), (Integer) nbReplicaY.getValue(), (Integer) nbReplicaZ.getValue());

                geom.writeIntoAIMS(XYZFile);

                new Thread(new Runnable() {
                    public void run() {

                        mf.localCommand("java -jar Jmol.jar " + XYZFile);
                    }
                }).start();
            }

        } catch (IOException e) {
            mf.printERR(e.getMessage());
        }
    }//GEN-LAST:event_viewGeomButtonActionPerformed

    private void loadDatabase()
    {
        String jdtset = (String)dtsetList.getSelectedValue();
        if(jdtset == null)
        {
            return;
        }
        HashMap<String,Object> values = null;
        if(input.isUsejdtset())
        {
            values = input.getAllDatasets().get(jdtset);
        }
        else
        {
            values = input.getAllDatasets().get("0");
        }
        
        dataTable.clear();
        
        Iterator<String> iter = values.keySet().iterator();
        
        while(iter.hasNext())
        {
            String o = iter.next();
            
            Object value = values.get(o);
            
            HashMap<String,Object> map = new HashMap<String,Object>();
            
            map.put("name", o);
            map.put("value", value);
            
            dataTable.add(map);
        }
    }
    
    public void dumpDatabase()
    {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("test-json-output.txt")));
            jsonArray.write(pw);
        } catch (IOException ex) {
            Logger.getLogger(GUIEditorNew.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }
    
    private void dtsetListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dtsetListValueChanged
        
        loadDatabase();
        
        model.fireTableDataChanged();
    }//GEN-LAST:event_dtsetListValueChanged

    public class DatasetTable extends JTable
    {
        @Override
        public TableCellEditor getCellEditor(int row, int column)
        {
            return getDefaultEditor(getModel().getValueAt(row, column).getClass());
        }
        
    }
    public class DatasetModel extends DefaultTableModel
    {
        @Override
        public int getColumnCount()
        {
            return 2;
        }
        
        @Override
        public String getColumnName(int col)
        {
            if(col == 0)
            {
                return "name";
            }
            else if(col == 1)
            {
                return "value";
            }
            return null;
        }
        
        @Override
        public Object getValueAt(int row, int column)
        {
            if(column == 0)
            {
                return dataTable.get(row).get("name");
            }
            else if(column == 1)
            {
                Object o = dataTable.get(row).get("value");
                StringBuilder sb = new StringBuilder();
                if(o instanceof Number[])
                {
                    for(Number nb : (Number[])o)
                    {
                        sb.append(nb+" ");
                    }
                }
                else if(o instanceof Number[][])
                {
                    for(Number[] nbs : (Number[][])o)
                    {
                        for(Number nb : nbs)
                        {
                            sb.append(nb).append(" ");
                        }
                        sb.append(";");
                    }
                }
                else
                {
                    sb.append(o.toString());
                }
                
                return sb.toString();
            }
            return null;
        }
        
        @Override
        public int getRowCount()
        {
            if(dataTable != null)
            {
                return dataTable.size();
            }
            else
            {
                return 0;
            }
        }
        
        @Override
        public boolean isCellEditable(int row, int column)
        {
//            return (column == 1); // Value of the variable
            return false;
        }
        
        @Override
        public void setValueAt(Object o, int row, int column)
        {
            if(column == 1)
            {
                String name = (String)getValueAt(row,0);
                
                JSONObject object = jsonArray.getJSONObject(dtsetList.getSelectedIndex()+1);
                JSONObject objectdefault = jsonArray.getJSONObject(0);
                
                object.put(name, o);
                
                loadDatabase();
                model.fireTableDataChanged();
            }
        }
    }
    
    public class DatasetRenderer extends DefaultTableCellRenderer
    {
        @Override
        public Component getTableCellRendererComponent(
              JTable table,
              Object value,
              boolean selected,
              boolean hasFocus,
              int row,
              int column) 
        {
            // Allow the original renderer to set up the label
            Component c = super.getTableCellRendererComponent(
                           table, value, selected, hasFocus,
                           row, column); 

            if(column == 0 || column == 2)
            {
                // if name, no special renderer
                c.setForeground(Color.BLACK);
                return c;
            }
            else
            {
                Object val = dataTable.get(row).get("value");
                Object valDefault = dataTable.get(row).get("default");
                
                if(val.equals(valDefault))
                {
                    c.setForeground(Color.BLACK);
                }
                else
                {
                    c.setForeground(Color.RED);
                }
                return c;
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList dtsetList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner nbReplicaX;
    private javax.swing.JSpinner nbReplicaY;
    private javax.swing.JSpinner nbReplicaZ;
    private javax.swing.JButton viewGeomButton;
    // End of variables declaration//GEN-END:variables
}
