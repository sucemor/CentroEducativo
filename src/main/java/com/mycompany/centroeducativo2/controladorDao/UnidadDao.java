/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.controladorDao.entidades.Unidad;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sum27
 */
public interface UnidadDao {
    int add(Unidad c) throws SQLException;
    
    Unidad getById(int id) throws SQLException;
        
    List<Unidad> getAll()  throws SQLException;
    
    int update(Unidad c)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
