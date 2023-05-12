package com.mycompany.centroeducativo2.controladorDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

import com.mycompany.centroeducativo2.controladorDao.entidades.Alumno;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sergio
 */
public interface AlumnoDao {
    int add(Alumno a) throws SQLException;
    
    Alumno getById(int id) throws SQLException;
        
    List<Alumno> getAll()  throws SQLException;
    
    int update(Alumno a)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
