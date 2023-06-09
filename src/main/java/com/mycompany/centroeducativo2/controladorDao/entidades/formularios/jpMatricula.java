/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao.entidades.formularios;

import com.mycompany.centroeducativo2.controladorDao.AlumnoDaoImp;
import com.mycompany.centroeducativo2.controladorDao.MatriculaDaoImp;
import com.mycompany.centroeducativo2.controladorDao.UnidadDaoImp;
import com.mycompany.centroeducativo2.controladorDao.entidades.Alumno;
import com.mycompany.centroeducativo2.controladorDao.entidades.Matricula;
import com.mycompany.centroeducativo2.controladorDao.entidades.Unidad;
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
public class jpMatricula extends javax.swing.JPanel {

    public int idMatricula[];
    public int idAlumnoGlobal[];
    public int idUnidadGlobal[];

    /**
     * Creates new form curso
     */
    public jpMatricula() {
        initComponents();
        configTabla();

        // Si la tabla esta vacia que pueda cargar
        if (cargaTabla() == true) {
            setCampos();
        }

        Ocultar();
    }

    private void Ocultar() {
        txtAlumno.setVisible(true);
        txtUnidad.setVisible(true);
        txtObservaciones.setVisible(true);
        btnEditar.setVisible(true);

        btnAnadir.setVisible(false);
        btnActualizar.setVisible(false);
        btnCancelar.setVisible(false);
        btnBorrar.setVisible(false);
        CBOpciones.setVisible(false);
        CBAlumno.setVisible(false);
        CBUnidad.setVisible(false);
    }

    public void Mostrar() {
        txtAlumno.setVisible(false);
        txtUnidad.setVisible(false);
        txtObservaciones.setVisible(false);
        btnEditar.setVisible(false);
        btnEditar.setVisible(false);

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
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        CBOpciones = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        jLParentesco = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jLUnidad = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JTextField();
        jLAlumno = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        CBAlumno = new javax.swing.JComboBox<>();
        CBUnidad = new javax.swing.JComboBox<>();
        jLMatricula = new javax.swing.JLabel();
        txtfMatricula = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
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
                .addGap(33, 33, 33)
                .addGroup(pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        pnlTabla2Layout.setVerticalGroup(
            pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabla2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, -1));

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));

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
        CBOpciones.setForeground(new java.awt.Color(255, 51, 51));
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

        jLParentesco.setBackground(new java.awt.Color(153, 255, 153));
        jLParentesco.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLParentesco.setText("Descripcion");

        txtObservaciones.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtObservaciones.setForeground(new java.awt.Color(153, 153, 153));

        jLUnidad.setBackground(new java.awt.Color(153, 255, 153));
        jLUnidad.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLUnidad.setText("Unidad");

        txtUnidad.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtUnidad.setForeground(new java.awt.Color(153, 153, 153));

        jLAlumno.setBackground(new java.awt.Color(153, 255, 153));
        jLAlumno.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLAlumno.setText("Alumno");

        txtAlumno.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtAlumno.setForeground(new java.awt.Color(153, 153, 153));

        CBAlumno.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        CBAlumno.setForeground(new java.awt.Color(153, 153, 153));
        CBAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBAlumnoActionPerformed(evt);
            }
        });

        CBUnidad.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        CBUnidad.setForeground(new java.awt.Color(153, 153, 153));

        jLMatricula.setBackground(new java.awt.Color(153, 255, 153));
        jLMatricula.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLMatricula.setText("Fecha de matriculación");

        txtfMatricula.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtfMatricula.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnEditar))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLParentesco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addComponent(jLUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CBUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addComponent(jLAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CBAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                                        .addGap(145, 145, 145)
                                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAnadir)
                                            .addComponent(btnActualizar)
                                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBorrar))))))))
                .addGap(237, 237, 237))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLParentesco)
                    .addComponent(CBAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAlumno))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLUnidad)
                    .addComponent(CBUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMatricula))
                .addGap(18, 18, 18)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar)))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)))
                .addGap(18, 18, 18)
                .addComponent(btnAnadir)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        add(pnlDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 720, 610));
    }// </editor-fold>//GEN-END:initComponents
public boolean cargaTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jtCursoss.getModel();

        MatriculaDaoImp MatriculaControler = MatriculaDaoImp.getInstance();
        String[] fila = new String[4];

        modelo.setNumRows(0);
        try {
            List<Matricula> lst = MatriculaControler.getAll();
            // Necesito guardar las id
            int unidades[] = new int[lst.size()];
            int alumnos[] = new int[lst.size()];

            if (lst.size() > 0) {
                // Para borrar necesito el id
                idMatricula = new int[lst.size()];
                AlumnoDaoImp alum = AlumnoDaoImp.getInstance();
                UnidadDaoImp uni = UnidadDaoImp.getInstance();

                for (int i = 0; i < lst.size(); i++) {
                    if (alum.getById(lst.get(i).getIdalumno()) != null) {
                        fila[0] =  alum.getById(lst.get(i).getIdalumno()).getDni()
                                + " - " +alum.getById(lst.get(i).getIdalumno()).getNombre()
                                + " " + alum.getById(lst.get(i).getIdalumno()).getApellido1();
                    }else{
                        fila[0] = "No asignado";
                    }
                    
                    if (uni.getById(lst.get(i).getIdunidad()) != null) {
                        fila[1] = "" + uni.getById(lst.get(i).getIdunidad()).getCodigo();
                    }else{
                        fila[1] = "No asignado";
                    }
                    fila[2] = "" + lst.get(i).getDescripcion();
                    fila[3] = "" + lst.get(i).getfMatricula();

                    modelo.addRow(fila);

                    // Le metemos el id
                    idMatricula[i] = lst.get(i).getIdmatricula();
                    // Guardo la variable
                    unidades[i] = lst.get(i).getIdunidad();
                    alumnos[i] = lst.get(i).getIdalumno();
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

    private Matricula getCampos() {
        Matricula c = new Matricula();
        c.setDescripcion(txtObservaciones.getText());
        c.setfMatricula(txtfMatricula.getText());
        c.setIdalumno(idAlumnoGlobal[CBAlumno.getSelectedIndex()]);
        c.setIdunidad(idUnidadGlobal[CBUnidad.getSelectedIndex()]);
        return c;
    }

    private Matricula AyudaActualizar() {
        Matricula cr = getCampos();
        cr.setIdmatricula(idMatricula[Integer.parseInt(jtCursoss.getSelectedRow() + "")]);
        return cr;
    }

    public void setCampos() {
        txtAlumno.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 0).toString());
        txtUnidad.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 1).toString());
        txtObservaciones.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 2).toString());
        txtfMatricula.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 3).toString());

        btnEditar.setVisible(true);
    }

    public void configTabla() {
        String col[] = {"ALUMNO", "UNIDAD", "DESCRIPCION", "Fecha Matricula"};

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
        MatriculaDaoImp c = MatriculaDaoImp.getInstance();

        try {
            c.add(getCampos());
            JOptionPane.showMessageDialog(this, "Matricula agregado correctamente");
            cargaTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        MatriculaDaoImp c = MatriculaDaoImp.getInstance();

        try {
            c.update(AyudaActualizar());
            JOptionPane.showMessageDialog(this, "Matricula actualizado");
            cargaTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        MatriculaDaoImp c = MatriculaDaoImp.getInstance();
        try {
            c.delete(idMatricula[Integer.parseInt((jtCursoss.getSelectedRow() + ""))]);
            JOptionPane.showMessageDialog(this, "Matricula borrado...");
            cargaTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Ocultar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void cargarComboBox() {
        AlumnoDaoImp alum = AlumnoDaoImp.getInstance();
        UnidadDaoImp uni = UnidadDaoImp.getInstance();
        try {
            int cont = 0;
            List<Alumno> alumnoLista = alum.getAll();
            idAlumnoGlobal = new int[alumnoLista.size()];
            for (Alumno alu : alumnoLista) {
                CBAlumno.addItem(alu.getDni() +" "+  alu.getNombre() +" "+ alu.getApellido1());
                idAlumnoGlobal[cont] = alu.getId();
                cont++;
            }
            cont = 0;

            List<Unidad> unidadLista = uni.getAll();
            idUnidadGlobal = new int[unidadLista.size()];
            for (Unidad al : unidadLista) {
                CBUnidad.addItem(al.getCodigo());
                idUnidadGlobal[cont] = al.getId();
                cont++;
            }
            cont = 0;
        } catch (Exception e) {
            System.out.println("Error..." + e.getMessage());
        }
    }


    private void CBOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOpcionesActionPerformed
        cargarComboBox();

        txtUnidad.setVisible(false);
        txtAlumno.setVisible(false);
        CBAlumno.setVisible(true);
        CBUnidad.setVisible(true);
        switch (CBOpciones.getSelectedIndex()) {
            case 0 -> {
                btnAnadir.setVisible(true);
                btnCancelar.setVisible(true);
            }
            case 1 -> {
                btnActualizar.setVisible(true);
                btnCancelar.setVisible(true);
            }
            case 2 -> {
                btnEditar.setVisible(false);
                btnBorrar.setVisible(true);
                btnCancelar.setVisible(true);
            }
        }
        CBOpciones.setVisible(false);
    }//GEN-LAST:event_CBOpcionesActionPerformed

    private void CBAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBAlumnoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBAlumno;
    private javax.swing.JComboBox<String> CBOpciones;
    private javax.swing.JComboBox<String> CBUnidad;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLAlumno;
    private javax.swing.JLabel jLMatricula;
    private javax.swing.JLabel jLParentesco;
    private javax.swing.JLabel jLUnidad;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtCursoss;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlTabla2;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtUnidad;
    private javax.swing.JTextField txtfMatricula;
    // End of variables declaration//GEN-END:variables
}
