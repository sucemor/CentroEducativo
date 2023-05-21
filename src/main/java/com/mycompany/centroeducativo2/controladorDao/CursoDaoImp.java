package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.entidades.Curso;
import com.mycompany.centroeducativo2.controladorDao.entidades.CursoAcademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sergio
 */
public class CursoDaoImp implements CursoDao {

    private static CursoDaoImp instance;

    static {
        instance = new CursoDaoImp();
    }

    private CursoDaoImp() {
    }

    public static CursoDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Curso cu) throws SQLException {
        String sql = "insert into curso(codigo,nombre,Observaciones,idcursoacademico)"
                + " values (?,?,?,?)";

        int devolver = 0;
        try (Connection cn = MyDataSource.getConnection();) {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, cu.getCodigo());
            pstm.setString(2, cu.getNombre());
            pstm.setString(3, cu.getObservaciones());
            pstm.setInt(4, cu.getIdcursoacademico());

            devolver = pstm.executeUpdate();
        }

        return devolver;
    }

    @Override
    public int update(Curso c) throws SQLException {
        String sql = """
                   update curso
                   set codigo=?, nombre=?, Observaciones=?
                   where id=?
                   """;
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, c.getCodigo());
            pstm.setString(2, c.getNombre());
            pstm.setString(3, c.getObservaciones());
            pstm.setInt(4, c.getId());

            result = pstm.executeUpdate();

        }

        return result;
    }

    @Override
    public CursoAcademico getCursoAcademico(Curso cu) throws SQLException {
        String sql = "select * from cursoacademico where id = ?";

        CursoAcademico cursoaca = null;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setInt(1, cu.getIdcursoacademico());

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                cursoaca = new CursoAcademico();

                cursoaca.setId(rs.getInt("id"));
                cursoaca.setYearinicio(rs.getInt("yearinicio"));
                cursoaca.setYearfin(rs.getInt("yearfin"));
                cursoaca.setDescripcion(rs.getString("descripcion"));
            }
        }

        return cursoaca;
    }

    @Override
    public Curso getById(int id) throws SQLException {
        Curso cur = null;
        String sql = "select * from curso where id=?";

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                cur = new Curso();

                cur.setId(rs.getInt("id"));
                cur.setCodigo(rs.getString("codigo"));
                cur.setNombre(rs.getString("nombre"));
                cur.setObservaciones(rs.getString("Observaciones"));
                cur.setIdcursoacademico(rs.getInt("idcursoacademico"));
            }

        }

        return cur;
    }

    @Override
    public List<Curso> getAll() throws SQLException {
        Curso cur = null;
        String sql = "select * from curso";

        List<Curso> result = new ArrayList();
        
        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cur = new Curso();

                cur.setId(rs.getInt("id"));
                cur.setCodigo(rs.getString("codigo"));
                cur.setNombre(rs.getString("nombre"));
                cur.setObservaciones(rs.getString("Observaciones"));
                cur.setIdcursoacademico(rs.getInt("idcursoacademico"));
                result.add(cur);
            }

        }
        return result;
    }

    @Override
    public List<Curso> getAllByCursoAcademico(int idcursoacademico) throws SQLException {
        Curso cur = null;
        String sql = "select * from curso where idcursoacademico = ?";

        List<Curso> result = new ArrayList();

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {
            pstm.setInt(1, idcursoacademico);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cur = new Curso();

                cur.setId(rs.getInt("id"));
                cur.setCodigo(rs.getString("codigo"));
                cur.setNombre(rs.getString("nombre"));
                cur.setObservaciones(rs.getString("Observaciones"));
                cur.setIdcursoacademico(rs.getInt("idcursoacademico"));
                result.add(cur);
            }

        }
        return result;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                   delete from centroeducativo.curso where id=?;
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
