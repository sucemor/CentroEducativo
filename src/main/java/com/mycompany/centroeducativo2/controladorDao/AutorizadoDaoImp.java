/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.entidades.Autorizado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sum27
 */
public class AutorizadoDaoImp implements AutorizadoDao {

    private static AutorizadoDaoImp instance;

    static {
        instance = new AutorizadoDaoImp();
    }

    private AutorizadoDaoImp() {
    }

    public static AutorizadoDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Autorizado a) throws SQLException {
    String sql = """
                  insert into autorizado (dni, nombre, apellido1, apellido2, parentesto)
                  values (?,?,?,?,?)
                  """;
        int result = 0;
        
        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, a.getParen().toString());

            result = pstm.executeUpdate();

        }

        return result;    
    }

    @Override
    public Autorizado getById(int id) throws SQLException {
        Autorizado au = null;
        String sql = "select * from aula where id=?";

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                au = new Autorizado();

                au.setId(rs.getInt("id"));
                au.setDni(rs.getString("dni"));
                au.setNombre(rs.getString("nombre"));
                au.setApellido1(rs.getString("apellido1"));
                au.setApellido2(rs.getString("apellido2"));
                //Es un enumerado
                String respuesta = rs.getString("parentesto");
                au.setParen(au.getParen().valueOf(respuesta));

            }

        }

        return au;  
    }

    @Override
    public List<Autorizado> getAll() throws SQLException {
        Autorizado au = null;
        String sql = "select * from autorizado";

        List<Autorizado> result = new ArrayList();

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                au = new Autorizado();

                au.setId(rs.getInt("id"));
                au.setDni(rs.getString("dni"));
                au.setNombre(rs.getString("nombre"));
                au.setApellido1(rs.getString("apellido1"));
                au.setApellido2(rs.getString("apellido2"));
                //Es un enumerado
                String respuesta = rs.getString("parentesto");
                au.setParen(au.getParen().valueOf(respuesta));
                
                result.add(au);
            }

        } catch (Exception e) {
            System.out.println("Error..." + e.getMessage());
        }

        return result;
    }

    @Override
    public int update(Autorizado a) throws SQLException {
        String sql = """
                  update autorizado
                  set dni=?, nombre=?, apellido1=?, apellido2=?, parentesto=?
                   where id=?
                   """;
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, a.getDni());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido1());
            pstm.setString(4, a.getApellido2());
            pstm.setString(5, a.getParen()+"");
            pstm.setInt(6, a.getId());

            result = pstm.executeUpdate();

        }

        return result;   
    }

    @Override
    public void delete(int id) throws SQLException {
    String sql = """
                   delete from autorizado where id=?;
                   """;
        try (Connection cn = MyDataSource.getConnection();) {

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, id);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }        
    }

}
