package com.mycompany.centroeducativo2.controladorDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import com.mycompany.centroeducativo2.controladorDao.entidades.Matricula;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sum27
 */
public interface MatriculaDao {
    int add(Matricula m) throws SQLException;
    
    Matricula getById(int id) throws SQLException;
        
    List<Matricula> getAll()  throws SQLException;
    
    int update(Matricula m)  throws SQLException;
    
    void delete(int id)  throws SQLException;
}
