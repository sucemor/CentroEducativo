package com.mycompany.centroeducativo2.controladorDao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.entidades.Matricula;
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
            pstm.setInt(2, m.getIdunidas());
            pstm.setString(3, m.getDescripcion());
            pstm.setDate(4, m.getfMatricula());

            result = pstm.executeUpdate();
        }

        return result;

    }

    @Override
    public Matricula getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.matricula WHERE id=? and matricula is null";
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
                matr.setfMatricula(rs.getDate("fMatricula"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        
        return matr;
    }

    @Override
    public List<Matricula> getAll() throws SQLException {
        Matricula matr=null;
        String sql="select * from Matricula";
        
        List<Matricula> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                matr=new Matricula();
                
                matr.setId(rs.getInt("id"));
                matr.setDni(rs.getString("dni"));
                matr.setNombre(rs.getString("nombre"));
                matr.setApellido1(rs.getString("apellido1"));
                matr.setApellido2(rs.getString("apellido2"));
                matr.setTipo(rs.getInt("tipo"));
                matr.setTelefono(rs.getString("telefono"));
                matr.setEmail(rs.getString("email"));
                matr.setDireccion(rs.getString("direccion"));
                matr.setCp(rs.getString("cp"));
                matr.setPoblacion(rs.getString("poblacion"));
                matr.setProvincia(rs.getString("provincia"));
                
                result.add(matr);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Matricula m) throws SQLException {
        String sql = """
                   update centroeducativo.Matricula
                   set dni=?, nombre=?, apellido1=?, apellido2=?,
                   tipo=?, telefono=?, email=?, direccion=?, cp=?, poblacion=?,
                   provincia=?
                   where id = ?;
                   """;

        try (Connection cn = MyDataSource.getConnection();) {
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setString(1, m.getDni());
            pstm.setString(2, m.getNombre());
            pstm.setString(3, m.getApellido1());
            pstm.setString(4, m.getApellido2());
            pstm.setInt(5, m.getTipo());
            pstm.setString(6, m.getTelefono());
            pstm.setString(7, m.getEmail());
            pstm.setString(8, m.getDireccion());
            pstm.setString(9, m.getCp());
            pstm.setString(10, m.getPoblacion());
            pstm.setString(11, m.getProvincia());
            pstm.setInt(12, m.getId());

            return pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                   delete from centroeducativo.Matricula where id=?;
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
