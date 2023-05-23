package com.mycompany.centroeducativo2.controladorDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.entidades.Matricula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sum27
 */
public class MatriculaDaoImp implements MatriculaDao{
private static MatriculaDaoImp instance;

    static {
        instance = new MatriculaDaoImp();
    }

    private MatriculaDaoImp() {
    }

    public static MatriculaDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Matricula m) throws SQLException {
        
        String sql = "insert into matricula (idalumno, idunidad, descripcion, "
                + "fMatricula) values (?,?,?,?)";
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setInt(1, m.getIdalumno());
            pstm.setInt(2, m.getIdunidad());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());

            result = pstm.executeUpdate();
        }

        return result;

    }

    @Override
    public Matricula getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.matricula WHERE idmatricula=? and matricula is null";
        Matricula matr=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                matr=new Matricula();
                matr.setIdmatricula(rs.getInt("idmatricula"));
                matr.setIdalumno(rs.getInt("idalumno"));
                matr.setIdunidad(rs.getInt("idunidad"));
                matr.setDescripcion(rs.getString("descripcion"));
                matr.setfMatricula(rs.getDate("fMatricula").toString());
            }
            
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        
        return matr;
    }

    @Override
    public List<Matricula> getAll() throws SQLException {
        Matricula matr=null;
        String sql="select * from matricula where fBaja is null";
        
        List<Matricula> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                matr=new Matricula();
                
                matr.setIdmatricula(rs.getInt("idmatricula"));
                matr.setIdalumno(rs.getInt("idalumno"));
                matr.setIdunidad(rs.getInt("idunidad"));
                matr.setDescripcion(rs.getString("descripcion"));
                matr.setfMatricula(rs.getDate("fMatricula").toString());
                
                result.add(matr);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Matricula m) throws SQLException {
        String sql = """
                   update centroeducativo.matricula
                   set idalumno=?, idunidad=?, descripcion=?, fMatricula=?,
                   fBaja=?
                   where idmatricula = ?;
                   """;

        try (Connection cn = MyDataSource.getConnection();) {
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, m.getIdalumno());
            pstm.setInt(2, m.getIdunidad());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());
            pstm.setDate(5, m.getfBaja());
            pstm.setInt(6, m.getIdmatricula());

            return pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                   update centroeducativo.matricula
                                      set fBaja=?
                                      where idmatricula = ?;
                   """;
        try (Connection cn = MyDataSource.getConnection();) {

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setDate(1, Date.valueOf(LocalDate.now()));
            pstm.setInt(2, id);

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
}
