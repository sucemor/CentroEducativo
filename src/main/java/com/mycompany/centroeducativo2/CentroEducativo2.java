/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.centroeducativo2;

import com.mycompany.centroeducativo2.BD.MyDataSource;
import com.mycompany.centroeducativo2.controladorDao.CursoAcademicoDaoImp;
import com.mycompany.centroeducativo2.controladorDao.entidades.CursoAcademico;
import java.sql.Connection;

/**
 *
 * @author sum27
 */
public class CentroEducativo2 {

    public static void main(String[] args) {
        Connection cnlocal = MyDataSource.getConnection();
        System.out.println("Conexion...");
        
        CursoAcademicoDaoImp hola = CursoAcademicoDaoImp.getInstance();
        CursoAcademico prueba = new CursoAcademico();
        try{
            prueba = hola.getById(1);
            System.out.println(prueba);
        }catch(Exception e){
            System.out.println("Error..." + e.getMessage());
        }
    }
}
