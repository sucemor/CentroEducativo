/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.centroeducativo2.controladorDao;

import com.mycompany.centroeducativo2.controladorDao.entidades.Personal;
import com.mycompany.centroeducativo2.BD.MyDataSource;
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
public class PersonalDaoImp implements PersonalDao{
    private static PersonalDaoImp instance;

    static {
        instance = new PersonalDaoImp();
    }

    private PersonalDaoImp() {
    }

    public static PersonalDaoImp getInstance() {
        return instance;
    }

    @Override
    public int add(Personal p) throws SQLException {
        
        String sql = "insert into personal (dni, nombre, apellido1, apellido2,"
                + " tipo, telefono, email, direccion, cp, poblacion,"
                + " provincia) values (?,?,?,?,?,?,?,?,?,?,?)";
        int result = 0;

        try (Connection cn = MyDataSource.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {

            pstm.setString(1, p.getDni());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido1());
            pstm.setString(4, p.getApellido2());
            pstm.setInt(5, p.getTipo());
            pstm.setString(6, p.getTelefono());
            pstm.setString(7, p.getEmail());
            pstm.setString(8, p.getDireccion());
            pstm.setString(9, p.getCp());
            pstm.setString(10, p.getPoblacion());
            pstm.setString(11, p.getProvincia());

            result = pstm.executeUpdate();
        }

        return result;

    }

    @Override
    public Personal getById(int id) throws SQLException {
        String sql="SELECT * FROM centroeducativo.personal WHERE id=?";
        Personal pers=null;
        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
            pstm.setInt(1, id);
            
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){  //Creamos una instancia para pasar los datos por un id
                pers=new Personal();
                pers.setId(rs.getInt("id"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellido1(rs.getString("apellido1"));
                pers.setApellido2(rs.getString("apellido2"));
                pers.setTipo(rs.getInt("tipo"));
                pers.setTelefono(rs.getString("telefono"));
                pers.setEmail(rs.getString("email"));
                pers.setDireccion(rs.getString("direccion"));
                pers.setCp(rs.getString("cp"));
                pers.setPoblacion(rs.getString("poblacion"));
                pers.setProvincia(rs.getString("provincia"));
            }
            
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
        
        return pers;
    }

    @Override
    public List<Personal> getAll() throws SQLException {
        Personal pers=null;
        String sql="select * from personal";
        
        List<Personal> result=new ArrayList();

        try(Connection cn=MyDataSource.getConnection();
            PreparedStatement pstm=cn.prepareStatement(sql);){
         
            ResultSet rs=pstm.executeQuery();
            
            while (rs.next()){
                pers=new Personal();
                
                pers.setId(rs.getInt("id"));
                pers.setDni(rs.getString("dni"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellido1(rs.getString("apellido1"));
                pers.setApellido2(rs.getString("apellido2"));
                pers.setTipo(rs.getInt("tipo"));
                pers.setTelefono(rs.getString("telefono"));
                pers.setEmail(rs.getString("email"));
                pers.setDireccion(rs.getString("direccion"));
                pers.setCp(rs.getString("cp"));
                pers.setPoblacion(rs.getString("poblacion"));
                pers.setProvincia(rs.getString("provincia"));
                
                result.add(pers);
            }
            
        }
        
        return result; 
    }

    @Override
    public int update(Personal p) throws SQLException {
        String sql = """
                   update centroeducativo.personal
                   set dni=?, nombre=?, apellido1=?, apellido2=?,
                   tipo=?, telefono=?, email=?, direccion=?, cp=?, poblacion=?,
                   provincia=?
                   where id = ?;
                   """;

        try (Connection cn = MyDataSource.getConnection();) {
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setString(1, p.getDni());
            pstm.setString(2, p.getNombre());
            pstm.setString(3, p.getApellido1());
            pstm.setString(4, p.getApellido2());
            pstm.setInt(5, p.getTipo());
            pstm.setString(6, p.getTelefono());
            pstm.setString(7, p.getEmail());
            pstm.setString(8, p.getDireccion());
            pstm.setString(9, p.getCp());
            pstm.setString(10, p.getPoblacion());
            pstm.setString(11, p.getProvincia());
            pstm.setInt(12, p.getId());

            return pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = """
                   delete from centroeducativo.personal where id=?;
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
