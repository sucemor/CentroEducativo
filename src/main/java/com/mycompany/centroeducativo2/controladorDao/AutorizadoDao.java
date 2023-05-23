/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.controladorDao.entidades.Autorizado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sum27
 */
public interface AutorizadoDao {

    int add(Autorizado a) throws SQLException;

    Autorizado getById(int id) throws SQLException;

    List<Autorizado> getAll() throws SQLException;

    int update(Autorizado a) throws SQLException;

    void delete(int id) throws SQLException;
}
