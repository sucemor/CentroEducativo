/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao.entidades.formularios;

import com.mycompany.centroeducativo2.controladorDao.AlumnoDaoImp;
import com.mycompany.centroeducativo2.controladorDao.entidades.Alumno;
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
public class jpAlumnos extends javax.swing.JPanel {

    public int idAlumno[];

    /**
     * Creates new form curso
     */
    public jpAlumnos() {
        initComponents();
        configTabla();
        
        // Si la tabla esta vacia que pueda cargar
        boolean check = cargaTabla();
        if (check == true) {
            setCampos();
        }

        Ocultar();
    }

    private void Ocultar() {
        btnAnadir.setVisible(false);
        btnActualizar.setVisible(false);
        btnCancelar.setVisible(false);
        btnBorrar.setVisible(false);
        CBOpciones.setVisible(false);

        // TEXTO
    }

    public void Mostrar() {
        btnEditar.setVisible(false);
        // TEXTO
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
        jLApellido1 = new javax.swing.JLabel();
        jLDNI1 = new javax.swing.JLabel();
        jLNOMBRE1 = new javax.swing.JLabel();
        jLTelefono = new javax.swing.JLabel();
        jLCP = new javax.swing.JLabel();
        jLFNacimiento1 = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jLApellido2 = new javax.swing.JLabel();
        jLDireccion1 = new javax.swing.JLabel();
        jLPoblacion = new javax.swing.JLabel();
        jLProvinicia = new javax.swing.JLabel();
        btnAnadir = new javax.swing.JButton();
        CBOpciones = new javax.swing.JComboBox<>();
        btnEditar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtPoblacion = new javax.swing.JTextField();
        txtProvinicia = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtDNI = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCP = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

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
                .addGroup(pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTabla2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlTabla2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        pnlTabla2Layout.setVerticalGroup(
            pnlTabla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabla2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(pnlTabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, -1));

        pnlDetalle.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalle.setToolTipText("");

        btnActualizar.setBackground(new java.awt.Color(51, 255, 51));
        btnActualizar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setToolTipText("");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBorrar.setBackground(new java.awt.Color(51, 255, 51));
        btnBorrar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLApellido1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLApellido1.setText("Apellido1");

        jLDNI1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLDNI1.setText("DNI");

        jLNOMBRE1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLNOMBRE1.setText("Nombre");

        jLTelefono.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLTelefono.setText("Telefono");

        jLCP.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLCP.setText("CP");
        jLCP.setToolTipText("");

        jLFNacimiento1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLFNacimiento1.setText("Fecha de nacimiento");

        jLEmail.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLEmail.setText("Email");

        jLApellido2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLApellido2.setText("Apellido2");

        jLDireccion1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLDireccion1.setText("Direccion");

        jLPoblacion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLPoblacion.setText("Poblacion");
        jLPoblacion.setToolTipText("");

        jLProvinicia.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLProvinicia.setText("Provincia");
        jLProvinicia.setToolTipText("");

        btnAnadir.setBackground(new java.awt.Color(51, 255, 51));
        btnAnadir.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnAnadir.setText("Añadir");
        btnAnadir.setToolTipText("");
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
        btnEditar.setToolTipText("");
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
                .addGap(41, 41, 41)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLProvinicia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLPoblacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLNOMBRE1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLApellido1)
                                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(pnlDetalleLayout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtProvinicia, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLDireccion1)
                                    .addComponent(jLApellido2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLDNI1)
                                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLFNacimiento1)
                                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLTelefono)
                                        .addComponent(jLCP)
                                        .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLEmail)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnAnadir, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlDetalleLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(63, 63, 63)
                                .addComponent(btnBorrar)))
                        .addGap(63, 63, 63))))
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLApellido2)
                            .addComponent(jLTelefono))
                        .addGap(4, 4, 4)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLDireccion1)
                            .addComponent(jLCP))
                        .addGap(8, 8, 8)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLNOMBRE1)
                            .addComponent(jLDNI1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLApellido1)
                            .addComponent(jLFNacimiento1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPoblacion)
                    .addComponent(jLEmail))
                .addGap(8, 8, 8)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPoblacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProvinicia)
                    .addComponent(btnAnadir))
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(10, 10, 10))
                    .addGroup(pnlDetalleLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProvinicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar)
                    .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btnCancelar)
                .addGap(63, 63, 63))
        );

        add(pnlDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 580, 640));
    }// </editor-fold>//GEN-END:initComponents
public boolean cargaTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jtCursoss.getModel();

        AlumnoDaoImp cursoAcaControler = AlumnoDaoImp.getInstance();
        String[] fila = new String[11];

        modelo.setNumRows(0);
        try {
            List<Alumno> lst = cursoAcaControler.getAll();
            // Para borrar necesito el id
            idAlumno = new int[lst.size()];

            if (lst.size() > 0) {
                for (int i = 0; i < lst.size(); i++) {
                    fila[0] = "" + lst.get(i).getDni();
                    fila[1] = "" + lst.get(i).getNombre();
                    fila[2] = "" + lst.get(i).getApellido1();
                    fila[3] = "" + lst.get(i).getApellido2();
                    fila[4] = "" + lst.get(i).getFnacimiento();
                    fila[5] = "" + lst.get(i).getTelefono();
                    fila[6] = "" + lst.get(i).getEmail();
                    fila[7] = "" + lst.get(i).getDireccion();
                    fila[8] = "" + lst.get(i).getCp();
                    fila[9] = "" + lst.get(i).getPoblacion();
                    fila[10] = "" + lst.get(i).getProvincia();

                    modelo.addRow(fila);

                    // Le metemos el id
                    idAlumno[i] = lst.get(i).getId();
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

    private Alumno getCampos() {
        Alumno c = new Alumno();
        c.setDni(txtDNI.getText());
        c.setNombre(txtNombre.getText());
        c.setApellido1(txtApellido1.getText());
        c.setApellido2(txtApellido2.getText());
        c.setFnacimiento(txtFechaNacimiento.getText());
        c.setTelefono(txtTelefono.getText());
        c.setEmail(txtEmail.getText());
        c.setDireccion(txtDireccion.getText());
        c.setCp(txtCP.getText());
        c.setProvincia(txtProvinicia.getText());
        c.setPoblacion(txtPoblacion.getText());

        return c;
    }

    private Alumno AyudaActualizar() {
        Alumno cr = getCampos();
        cr.setId(idAlumno[Integer.parseInt(jtCursoss.getSelectedRow() + "")]);
        System.out.println(cr);
        return cr;
    }

    public void setCampos() {
        txtDNI.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 0).toString());
        txtNombre.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 1).toString());
        txtApellido1.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 2).toString());
        txtApellido2.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 3).toString());
        txtFechaNacimiento.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 4).toString());
        txtTelefono.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 5).toString());
        txtEmail.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 6).toString());
        txtDireccion.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 7).toString());
        txtCP.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 8).toString());
        txtPoblacion.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 9).toString());
        txtProvinicia.setText(jtCursoss.getValueAt(jtCursoss.getSelectedRow(), 10).toString());
    }

    public void configTabla() {
        String col[] = {"DNI", "NOMBRE", "APELLIDO1", "APELLIDO2", "FECHA NACIMIENTO",
            "TELEFONO", "EMAIL", "DIRECCION", "CP", "POBLACION", "PROVINCIA"};

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
        AlumnoDaoImp c = AlumnoDaoImp.getInstance();

        try {
            c.add(getCampos());
            JOptionPane.showMessageDialog(this, "Alumno agregado correctamente");
            cargaTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
        btnEditar.setVisible(true);
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        AlumnoDaoImp c = AlumnoDaoImp.getInstance();
        try {
            c.update(AyudaActualizar());
            JOptionPane.showMessageDialog(this, "Alumno actualizado");
            cargaTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
        btnEditar.setVisible(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        AlumnoDaoImp c = AlumnoDaoImp.getInstance();
        try {
            c.delete(idAlumno[Integer.parseInt((jtCursoss.getSelectedRow() + ""))]);
            JOptionPane.showMessageDialog(this, "Alumno borrado...");
            cargaTabla();

        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
        btnEditar.setVisible(true);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Ocultar();
        btnEditar.setVisible(true);
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
            }
            case 2 -> {
                Ocultar();
                btnEditar.setVisible(false);
                btnBorrar.setVisible(true);
                btnCancelar.setVisible(true);
            }
        }
    }//GEN-LAST:event_CBOpcionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBOpciones;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLApellido1;
    private javax.swing.JLabel jLApellido2;
    private javax.swing.JLabel jLCP;
    private javax.swing.JLabel jLDNI1;
    private javax.swing.JLabel jLDireccion1;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLFNacimiento1;
    private javax.swing.JLabel jLNOMBRE1;
    private javax.swing.JLabel jLPoblacion;
    private javax.swing.JLabel jLProvinicia;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtCursoss;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlTabla2;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPoblacion;
    private javax.swing.JTextField txtProvinicia;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
