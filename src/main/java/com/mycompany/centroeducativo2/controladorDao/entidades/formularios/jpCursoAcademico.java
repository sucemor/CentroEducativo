/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao.entidades.formularios;

import com.mycompany.centroeducativo2.controladorDao.CursoAcademicoDaoImp;
import com.mycompany.centroeducativo2.controladorDao.entidades.CursoAcademico;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sum27
 */
public class jpCursoAcademico extends javax.swing.JPanel {

    public int idCurso[];

    /**
     * Creates new form curso
     */
    public jpCursoAcademico() {
        initComponents();
        configTabla();
        
        // Si la tabla esta vacia que pueda cargar
        boolean check = cargaTabla();
        if (check == true) {
            setCampos();
        }

        Ocultar();
        CargarCursor();
    }

    private void CargarCursor() {
        CursoAcademicoDaoImp CA = CursoAcademicoDaoImp.getInstance();
        try {
            List<CursoAcademico> ListaCA = CA.getAll();
            for (int i = 0; i < ListaCA.size(); i++) {
            }
        } catch (Exception e) {
            System.out.println("Error..." + e.getMessage());
        }
    }

    private void Ocultar() {
        txtLabelCodigo.setVisible(true);
        txtNombre.setVisible(true);
        txtObservaciones.setVisible(true);
        btnEditar.setVisible(true);

        txtFCodigo.setVisible(false);
        txtFNombre.setVisible(false);
        txtFDescripcion.setVisible(false);
        btnAnadir.setVisible(false);
        btnActualizar.setVisible(false);
        btnCancelar.setVisible(false);
        btnBorrar.setVisible(false);
        CBOpciones.setVisible(false);
    }

    public void Mostrar() {
        btnEditar.setVisible(false);
        txtLabelCodigo.setVisible(false);
        txtNombre.setVisible(false);
        txtObservaciones.setVisible(false);

        txtFCodigo.setVisible(true);
        txtFNombre.setVisible(true);
        txtFDescripcion.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTabla2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtCursoss = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        pnlDetalle = new javax.swing.JPanel();
        jlInicio = new javax.swing.JLabel();
        jlFIn = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JLabel();
        txtLabelCodigo = new javax.swing.JLabel();
        txtFDescripcion = new javax.swing.JTextField();
        txtFNombre = new javax.swing.JTextField();
        txtFCodigo = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLDescripcion = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        CBOpciones = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTabla2.setBackground(new java.awt.Color(255, 255, 255));
        pnlTabla2.setForeground(new java.awt.Color(255, 255, 255));

        jtCursoss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCursoss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCursosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtCursoss);

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLabel4.setText("Buscar");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlTabla2Layout = new javax.swing.GroupLayout(pnlTabla2);
        pnlTabla2.setLayout(pnlTabla2Layout);
        pnlTabla2Layout.setHorizontalGroup(
            pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabla2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTabla2Layout.createSequentialGroup()
                        .addGroup(pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTabla2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))))
        );
        pnlTabla2Layout.setVerticalGroup(
            pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabla2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(pnlTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));

        jlInicio.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jlInicio.setText("Fecha de inicio");

        jlFIn.setBackground(new java.awt.Color(153, 255, 153));
        jlFIn.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jlFIn.setText("Fecha de fin");

        txtNombre.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Fecha de fin");

        txtObservaciones.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtObservaciones.setForeground(new java.awt.Color(153, 153, 153));
        txtObservaciones.setText("Descripcion");

        txtLabelCodigo.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtLabelCodigo.setForeground(new java.awt.Color(153, 153, 153));
        txtLabelCodigo.setText("Fecha de inicio");

        txtFDescripcion.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtFDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFDescripcionActionPerformed(evt);
            }
        });

        txtFNombre.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNombreActionPerformed(evt);
            }
        });

        txtFCodigo.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        txtFCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFCodigoActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(51, 255, 51));
        btnActualizar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLDescripcion.setBackground(new java.awt.Color(153, 255, 153));
        jLDescripcion.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLDescripcion.setText("Descripcion");

        btnBorrar.setBackground(new java.awt.Color(51, 255, 51));
        btnBorrar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnAnadir.setBackground(new java.awt.Color(51, 255, 51));
        btnAnadir.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        CBOpciones.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        CBOpciones.setForeground(new java.awt.Color(255, 0, 0));
        CBOpciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Añadir", "Actualizar", "Borrar" }));
        CBOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBOpcionesActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnEditar.setText("Realizar modificaciones");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLabelCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createSequentialGroup()
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetalleLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                                .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnEditar))
                                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                                .addComponent(btnAnadir)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnActualizar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnBorrar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addComponent(jlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addComponent(jlFIn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(83, 83, 83)))
                        .addGap(229, 229, 229))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(txtLabelCodigo)
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFIn)
                    .addComponent(txtFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDescripcion)
                    .addComponent(txtFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnBorrar)
                    .addComponent(btnCancelar)
                    .addComponent(btnAnadir))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        add(pnlDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 550, 480));
    }// </editor-fold>//GEN-END:initComponents
public boolean cargaTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jtCursoss.getModel();

        CursoAcademicoDaoImp cursoAcaControler = CursoAcademicoDaoImp.getInstance();
        String[] fila = new String[3];

        modelo.setNumRows(0);
        try {
            List<CursoAcademico> lst = cursoAcaControler.getAll();
            
            if (lst.size() > 0) {
            // Para borrar necesito el id
            idCurso = new int[lst.size()];

            for (int i = 0; i < lst.size(); i++) {
                fila[0] = "" + lst.get(i).getYearinicio();
                fila[1] = "" + lst.get(i).getYearfin();
                fila[2] = "" + lst.get(i).getDescripcion();

                modelo.addRow(fila);

                // Le metemos el id
                idCurso[i] = lst.get(i).getId();
            }
            //selecciono la primera fila
            jtCursoss.setRowSelectionInterval(0, 0);
            return true;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return false;
    }

    private CursoAcademico getCampos() {
        CursoAcademico c = new CursoAcademico();
        c.setYearinicio(Integer.parseInt(txtFCodigo.getText()));
        c.setYearfin(Integer.parseInt(txtFNombre.getText()));
        c.setDescripcion(txtFDescripcion.getText());
        return c;
    }

    private CursoAcademico AyudaActualizar() {
        CursoAcademico cr = getCampos();
        cr.setId(idCurso[Integer.parseInt(jtCursoss.getSelectedRow() + "")]);

        return cr;
    }

    public void setCampos() {
        txtLabelCodigo.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 0).toString());
        txtNombre.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 1).toString());
        txtObservaciones.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 2).toString());
    }

    public void configTabla() {
        String col[] = {"INICIO", "FIN", "DESCRIPCION"};

        DefaultTableModel modelo = new DefaultTableModel(col, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        jtCursoss.setModel(modelo);
        jtCursoss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //configuro evento valor cambiado...
/*        jtCursoss.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {
            System.out.println(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 0).toString());
            setCampos();
        }
    });
         */
    }
    private void jtCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCursosMouseClicked
        setCampos();
    }//GEN-LAST:event_jtCursosMouseClicked

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        /**
         * Un buscador
         */
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) jtCursoss.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            jtCursoss.setRowSorter(trSorter);

            if (txtBuscar.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {

                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
            }

        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        CBOpciones.setVisible(true);
        btnEditar.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // Boton de añadir
        CursoAcademicoDaoImp c = CursoAcademicoDaoImp.getInstance();

        try {
            c.add(getCampos());
            JOptionPane.showMessageDialog(this, "Curso academico agregado correctamente");
            cargaTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CursoAcademicoDaoImp c = CursoAcademicoDaoImp.getInstance();
        try {
            c.update(AyudaActualizar());
            JOptionPane.showMessageDialog(this, "Curso academico actualizado");
            cargaTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        CursoAcademicoDaoImp c = CursoAcademicoDaoImp.getInstance();
        try {
            c.delete(idCurso[Integer.parseInt((jtCursoss.getSelectedRow() + ""))]);
            JOptionPane.showMessageDialog(this, "Curso academico borrado...");
            cargaTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Ocultar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void CBOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOpcionesActionPerformed
        Ocultar();
        Mostrar();
        switch (CBOpciones.getSelectedIndex()) {
            case 0 -> {
                btnAnadir.setVisible(true);
                btnCancelar.setVisible(true);
            }
            case 1 -> {
                btnActualizar.setVisible(true);
                btnCancelar.setVisible(true);

                txtFCodigo.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 0).toString());
                txtFNombre.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 1).toString());
                txtFDescripcion.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 2).toString());
            }
            case 2 -> {
                Ocultar();
                btnEditar.setVisible(false);
                btnBorrar.setVisible(true);
                btnCancelar.setVisible(true);
            }
        }
    }//GEN-LAST:event_CBOpcionesActionPerformed

    private void txtFDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFDescripcionActionPerformed

    private void txtFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNombreActionPerformed

    private void txtFCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBOpciones;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLDescripcion;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlFIn;
    private javax.swing.JLabel jlInicio;
    private javax.swing.JTable jtCursoss;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlTabla2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtFCodigo;
    private javax.swing.JTextField txtFDescripcion;
    private javax.swing.JTextField txtFNombre;
    private javax.swing.JLabel txtLabelCodigo;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
