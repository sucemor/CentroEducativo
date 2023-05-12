package com.mycompany.centroeducativo2.controladorDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sum27
 */
public interface MatriculaDao {
    int add(MatriculaDao m) throws SQLException;
    
    MatriculaDao getById(int id) throws SQLException;
        
    List<MatriculaDao> getAll()  throws SQLException;
    
    int update(MatriculaDao m)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
