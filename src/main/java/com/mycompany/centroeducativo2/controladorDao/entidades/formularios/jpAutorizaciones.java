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
public class jpAutorizaciones extends javax.swing.JPanel {

    public int idMatricula[];
    public int idAlumnoGlobal[];
    public int idUnidadGlobal[];

    /**
     * Creates new form jpAutorizaciones
     */
    public jpAutorizaciones() {
        initComponents();
        configTabla();
        cargaTablaUnidad();
        cargaTablaAlumno();
        // Si la tabla esta vacia que pueda cargar
        cargaTabla();
    }

    public boolean cargaTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TablaMatricula.getModel();

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
                        fila[0] = "" + alum.getById(lst.get(i).getIdalumno()).getDni()
                                + " - " + alum.getById(lst.get(i).getIdalumno()).getNombre()
                                + " " + alum.getById(lst.get(i).getIdalumno()).getApellido1();
                    } else {
                        fila[0] = "" + null;
                    }

                    if (uni.getById(lst.get(i).getIdunidad()) != null) {
                        fila[1] = "" + uni.getById(lst.get(i).getIdunidad()).getCodigo();
                    } else {
                        fila[1] = "" + null;
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
                TablaMatricula.setRowSelectionInterval(0, 0);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        return false;
    }

    private void cargaTablaUnidad() {
        DefaultTableModel modelo1 = (DefaultTableModel) TablaUnidad.getModel();

        UnidadDaoImp UnidadControler = UnidadDaoImp.getInstance();
        String[] fila1 = new String[3];

        modelo1.setNumRows(0);
        try {
            List<Unidad> lst1 = UnidadControler.getAll();
            if (lst1.size() > 0) {

                for (int i = 0; i < lst1.size(); i++) {
                    fila1[0] = "" + lst1.get(i).getCodigo();
                    fila1[1] = "" + lst1.get(i).getNombre();
                    fila1[2] = "" + lst1.get(i).getObservaciones();
                    //fila1[3] = "" + cur.getById(lst1.get(i).getIdcurso()).getNombre();
                    //fila[4] = "" + per.getById(lst.get(i).getIdtutor()).getNombre();
                    //fila[5] = "" + aul.getById(lst.get(i).getIdaula()).getCodigo();

                    modelo1.addRow(fila1);
                }
                //selecciono la primera fila
                TablaUnidad.setRowSelectionInterval(0, 0);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

    }

    private void cargaTablaAlumno() {
        DefaultTableModel modelo = (DefaultTableModel) TableAlumnos.getModel();

        AlumnoDaoImp cursoAcaControler = AlumnoDaoImp.getInstance();
        String[] fila = new String[11];

        modelo.setNumRows(0);
        try {
            List<Alumno> lst = cursoAcaControler.getAll();

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
                }
                //selecciono la primera fila
                TableAlumnos.setRowSelectionInterval(0, 0);
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    public void configTabla() {
        //MATRICULA
        String col[] = {"ALUMNO", "UNIDAD", "DESCRIPCION", "Fecha Matricula"};

        DefaultTableModel modelo1 = new DefaultTableModel(col, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        TablaMatricula.setModel(modelo1);
        TablaMatricula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //AUTORIZADOS
        String col2[] = {"CODIGO", "NOMBRE", "OBSERVACIONES"};

        DefaultTableModel modelo2 = new DefaultTableModel(col2, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        TablaUnidad.setModel(modelo2);
        TablaUnidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //ALUMNOS
        String col3[] = {"DNI", "NOMBRE", "APELLIDO1", "APELLIDO2", "FECHA NACIMIENTO",
            "TELEFONO", "EMAIL", "DIRECCION", "CP", "POBLACION", "PROVINCIA"};

        DefaultTableModel modelo3 = new DefaultTableModel(col3, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        TableAlumnos.setModel(modelo3);
        TableAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    private Matricula getCampos() {
        Matricula c = new Matricula();
        c.setDescripcion(txtObservaciones.getText());
        c.setfMatricula(txtfMatricula.getText());
        //c.setIdalumno(idAlumnoGlobal[CBAlumno.getSelectedIndex()]);
        //c.setIdunidad(idUnidadGlobal[CBUnidad.getSelectedIndex()]);
        return c;
    }
    private Matricula AyudaActualizar() {
        Matricula cr = getCampos();
        cr.setIdmatricula(idMatricula[Integer.parseInt(TablaMatricula.getSelectedRow() + "")]);
        return cr;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaMatricula = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaUnidad = new javax.swing.JTable();
        txtBuscarUnidad = new javax.swing.JTextField();
        txtBuscarAlumnos = new javax.swing.JTextField();
        txtBuscarMatricula = new javax.swing.JTextField();
        jLParentesco = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        jLMatricula = new javax.swing.JLabel();
        txtfMatricula = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        CBOpciones = new javax.swing.JComboBox<>();
        jLUnidad = new javax.swing.JLabel();
        jLAlumno = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JLabel();
        txtUnidad = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        TableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableAlumnos);

        TablaMatricula.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TablaMatricula);

        TablaUnidad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TablaUnidad);

        txtBuscarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarUnidadActionPerformed(evt);
            }
        });
        txtBuscarUnidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarUnidadKeyPressed(evt);
            }
        });

        txtBuscarAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarAlumnosActionPerformed(evt);
            }
        });
        txtBuscarAlumnos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarAlumnosKeyPressed(evt);
            }
        });

        txtBuscarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarMatriculaActionPerformed(evt);
            }
        });
        txtBuscarMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarMatriculaKeyPressed(evt);
            }
        });

        jLParentesco.setBackground(new java.awt.Color(153, 255, 153));
        jLParentesco.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLParentesco.setText("Descripcion");

        txtObservaciones.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtObservaciones.setForeground(new java.awt.Color(153, 153, 153));

        jLMatricula.setBackground(new java.awt.Color(153, 255, 153));
        jLMatricula.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLMatricula.setText("Fecha de matriculación");

        txtfMatricula.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtfMatricula.setForeground(new java.awt.Color(153, 153, 153));
        txtfMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfMatriculaActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnEditar.setText("Realizar modificaciones");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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

        btnAnadir.setBackground(new java.awt.Color(51, 255, 51));
        btnAnadir.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
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

        btnBorrar.setBackground(new java.awt.Color(51, 255, 51));
        btnBorrar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
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

        jLUnidad.setBackground(new java.awt.Color(153, 255, 153));
        jLUnidad.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLUnidad.setText("Unidad");

        jLAlumno.setBackground(new java.awt.Color(153, 255, 153));
        jLAlumno.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLAlumno.setText("Alumno");

        txtAlumno.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtAlumno.setForeground(new java.awt.Color(153, 153, 153));
        txtAlumno.setText("Alumno");

        txtUnidad.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtUnidad.setForeground(new java.awt.Color(153, 153, 153));
        txtUnidad.setText("Unidad");

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLabel4.setText("Buscar");

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLabel5.setText("Buscar");

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 15)); // NOI18N
        jLabel6.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(148, 148, 148)
                            .addComponent(txtBuscarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtBuscarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAnadir)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(397, 397, 397)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar))
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(txtAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBorrar))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBuscarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(txtBuscarMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscarAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLParentesco)
                            .addComponent(jLMatricula))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnBorrar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLUnidad)
                                .addGap(18, 18, 18)
                                .addComponent(txtUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLAlumno)
                                .addGap(18, 18, 18)
                                .addComponent(txtAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btnAnadir)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CBOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditar))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarUnidadActionPerformed

    private void txtBuscarUnidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarUnidadKeyPressed
        /**
         * Un buscador
         */
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) TablaUnidad.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            TablaUnidad.setRowSorter(trSorter);

            if (txtBuscarUnidad.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {

                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscarUnidad.getText().trim()));
            }

        }
    }//GEN-LAST:event_txtBuscarUnidadKeyPressed

    private void txtBuscarAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarAlumnosActionPerformed

    private void txtBuscarAlumnosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAlumnosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) TableAlumnos.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            TableAlumnos.setRowSorter(trSorter);

            if (txtBuscarAlumnos.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {

                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscarAlumnos.getText().trim()));
            }

        }
    }//GEN-LAST:event_txtBuscarAlumnosKeyPressed

    private void txtBuscarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarMatriculaActionPerformed

    private void txtBuscarMatriculaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMatriculaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            DefaultTableModel modelo = (DefaultTableModel) TablaMatricula.getModel();
            TableRowSorter<TableModel> trSorter = new TableRowSorter<TableModel>(modelo);

            TablaMatricula.setRowSorter(trSorter);

            if (txtBuscarMatricula.getText().length() == 0) {
                trSorter.setRowFilter(null);
            } else {

                trSorter.setRowFilter(RowFilter.regexFilter(txtBuscarMatricula.getText().trim()));
            }

        }
    }//GEN-LAST:event_txtBuscarMatriculaKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        CBOpciones.setVisible(true);
        btnEditar.setVisible(false);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Ocultar();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            c.delete(idMatricula[Integer.parseInt((TablaMatricula.getSelectedRow() + ""))]);
            JOptionPane.showMessageDialog(this, "Matricula borrado...");
            cargaTabla();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error");
            System.out.println("Error:" + e.getMessage());
        }
        Ocultar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void CBOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOpcionesActionPerformed
        txtUnidad.setVisible(false);
        txtAlumno.setVisible(false);
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

    private void txtfMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfMatriculaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBOpciones;
    private javax.swing.JTable TablaMatricula;
    private javax.swing.JTable TablaUnidad;
    private javax.swing.JTable TableAlumnos;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel txtAlumno;
    private javax.swing.JTextField txtBuscarAlumnos;
    private javax.swing.JTextField txtBuscarMatricula;
    private javax.swing.JTextField txtBuscarUnidad;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JLabel txtUnidad;
    private javax.swing.JTextField txtfMatricula;
    // End of variables declaration//GEN-END:variables
}
