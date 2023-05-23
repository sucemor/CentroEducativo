/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.entidades.Autorizaciones;
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
public class AutorizacionesDaoImp implements AutorizacionesDao {

    private static AutorizacionesDaoImp instance;

    static {
        instance = new AutorizacionesDaoImp();
    }

    private AutorizacionesDaoImp() {
    }

    public static AutorizacionesDaoImp getInstance() {
        return instance;
    }


    @Override
    public int add(Autorizaciones c) throws SQLException {
    String sql = """
                  insert into autorizaciones(idalumno,idautorizado)
                  values (?,?,?)
                  """;
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, c.getIdalumno());
            pstm.setInt(2, c.getIdautorizado());

            result = pstm.executeUpdate();

        }

        return result;    
    }

    @Override
    public Autorizaciones getById(int id) throws SQLException {
    Autorizaciones au = null;
        String sql = "select * from autorizaciones where id=?";

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                au = new Autorizaciones();

                au.setIdalumno(rs.getInt("idalumno"));
                au.setIdautorizado(rs.getInt("idautorizado"));

            }
        }
        return au;
    }

    @Override
    public List<Autorizaciones> getAll() throws SQLException {
        Autorizaciones au = null;
        String sql = "select * from autorizaciones";

        List<Autorizaciones> result = new ArrayList();

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                au = new Autorizaciones();

                au.setIdalumno(rs.getInt("idalumno"));
                au.setIdautorizado(rs.getInt("idautorizado"));
                result.add(au);
            }

        } catch (Exception e) {
            System.out.println("Error..." + e.getMessage());
        }

        return result;
    }

    @Override
    public void delete(int idalumno, int idautorizado) throws SQLException {
     String sql = """
                   delete from centroeducativo.autorizaciones where idalumno=? and
                     idautorizado=?;
                   """;
        try (Connection cn = MyDataSource.getConnection();) {

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, idalumno);
            pstm.setInt(2, idautorizado);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }    
    }

    

}
