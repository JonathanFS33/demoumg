/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apppacientes.modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan
 */
public class Conexion {
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    Connection con;
    Statement stat = null;
    String Base = "UMG";
    String DB_URL = "jdbc:mysql://localhost:3306/" + Base + "?useSSL=false&serverTimezone=UTC";
    static final String user = "root";
    static final String pass = "Franc0#332004";
    
    public Conexion(){
        try {
            con = DriverManager.getConnection(DB_URL,user,pass);
            System.out.println("CONECTADO A LA BASE DE DATOS");
        
        } catch(SQLException ex){
            System.out.println("Error al conectarme por "+ex.getMessage());
        }
    }
    public void guardarPaciente(Pacientes paciente){
        try{
            
            if(con!=null){
                //prepara la sentencia sql para insertar
                PreparedStatement st = con.prepareStatement("insert into pacientes(nombre,direccion,telefono) value (?, ?, ?)");
                st.setString(1, paciente.getNombre());
                st.setString(2, paciente.getDireccion());
                st.setString(3, paciente.getTelefono());
                
                st.execute();
            } else {
                System.out.println("No fue posible guardar el paciente");
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar el paciente " + ex.getMessage());
        }
    }
    public boolean actualizarPaciente(Pacientes paciente, int id_paciente){
        boolean res = false;
        try{
            if(con!=null){
                //prepara la sentencia sql para insertar
                PreparedStatement st = con.prepareStatement("update pacientes set nombre=?,direccion=?,telefono=? where id = "+id_paciente+"");
                st.setString(1, paciente.getNombre());
                st.setString(2, paciente.getDireccion());
                st.setString(3, paciente.getTelefono());
                
                st.executeUpdate();
                res = true;
            } else {
                res = false;
                System.out.println("No fue posible actualizar el paciente");
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al guardar el paciente " + ex.getMessage());
        }
        return res;
    }
}
   
