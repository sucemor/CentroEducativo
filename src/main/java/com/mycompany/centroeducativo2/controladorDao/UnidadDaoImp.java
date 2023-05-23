/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.entidades.Unidad;
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
public class UnidadDaoImp implements UnidadDao{
    private static UnidadDaoImp instance;

    static {
        instance = new UnidadDaoImp();
    }

    private UnidadDaoImp() {
    }

    public static UnidadDaoImp getInstance() {
        return instance;
    }
    @Override
    public int add(Unidad c) throws SQLException {

        String sql = """
                     insert into
                  unidad (codigo, nombre, Observaciones, idcurso, idtutor, idaula)
                  values (?,?,?,?,?,?)
                  """;
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcurso());
            pstm.setInt(5, c.getIdtutor());
            pstm.setInt(6, c.getIdaula());

            result = pstm.executeUpdate();

        }

        return result;

    }

    @Override
    public Unidad getById(int id) throws SQLException {
        Unidad uni = null;
        String sql = "select * from unidad where id=?";

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                uni = new Unidad();

                uni.setId(rs.getInt("id"));
                uni.setCodigo(rs.getString("codigo"));
                uni.setNombre(rs.getString("nombre"));
                uni.setObservaciones(rs.getString("observaciones"));
                uni.setIdcurso(rs.getInt("idcurso"));
                uni.setIdtutor(rs.getInt("idtutor"));
                uni.setIdaula(rs.getInt("idaula"));
            }

        }

        return uni;
    }

    @Override
    public List<Unidad> getAll() throws SQLException {
        Unidad uni = null;
        String sql = "select * from unidad";

        List<Unidad> result = new ArrayList();

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                uni = new Unidad();

                uni.setId(rs.getInt("id"));
                uni.setCodigo(rs.getString("codigo"));
                uni.setNombre(rs.getString("nombre"));
                uni.setObservaciones(rs.getString("observaciones"));
                uni.setIdcurso(rs.getInt("idcurso"));
                uni.setIdtutor(rs.getInt("idtutor"));
                uni.setIdaula(rs.getInt("idaula"));
                result.add(uni);
            }

        } catch (Exception e) {
            System.out.println("Error..." + e.getMessage());
        }

        return result;
    }

    @Override
    public int update(Unidad c) throws SQLException {

        String sql = """
                  update unidad
                  set codigo=?, nombre=?, Observaciones=?, idcurso=?, idtutor=?, idaula=?
                   where id=?
                   """;
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getIdcurso());
            pstm.setInt(5, c.getIdtutor());
            pstm.setInt(6, c.getIdaula());
            pstm.setInt(7, c.getId());

            result = pstm.executeUpdate();

        }

        return result;

    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                   delete from centroeducativo.unidad where id=?;
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
