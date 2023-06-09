/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.controladorDao.entidades.Autorizaciones;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sum27
 */
public interface AutorizacionesDao {
    int add(int idalumno, int idautorizacion) throws SQLException;
    
    Autorizaciones getById(int id) throws SQLException;
        
    List<Autorizaciones> getAll()  throws SQLException;
    
    void deleteAutorizado(int idautorizacion)  throws SQLException;
    void deleteAlumno(int idalumno)  throws SQLException;
}
