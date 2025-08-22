package ejercicioPracticoFinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;


public class AppTrabajoFinal1 {
    
    public static void main(String[] args) {

       JFrame mimarco=new Marco_AplicacionFinal();
       mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mimarco.setVisible(true);
   }
}
class Marco_AplicacionFinal extends JFrame{


   public Marco_AplicacionFinal(){
       setTitle ("Aplicacion Final BBDD");
       setBounds(500,300,400,400);     
       setLayout(new BorderLayout());
       JPanel menus=new JPanel();
       menus.setLayout(new FlowLayout());

       tablasConsulta=new JComboBox();
       tablasConsulta.setEditable(false);
       tablasConsulta.addItem("Todos");
       
       resultado= new JTextArea(4,50);
       resultado.setEditable(false);
       add(resultado);
       menus.add(tablasConsulta);
    
       add(menus, BorderLayout.NORTH);
       add(resultado, BorderLayout.CENTER);
       JButton botonConsulta=new JButton("Consulta"); 
       add(botonConsulta, BorderLayout.SOUTH); 
       //------CONEXION CON LA BASE DE DATOS-----------

   try {

       Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
       Statement sentencia=conexion.createStatement();
       //------PRIMER JCOMBOBOX DE SECCION-------
       String consultaSQL= "SELECT DISTINCTROW * FROM PRODUCTOS";
       ResultSet rs=sentencia.executeQuery(consultaSQL);
       while(rs.next()){
           tablasConsulta.addItem(rs.getString("*"));
       }
       rs.close();
       
   } catch (Exception e) {
      
       e.printStackTrace();
   }   
   }  
//------NOMBRE DE LAS VARIABLES -------
   private JComboBox tablasConsulta;
  
   private JTextArea resultado;     


/*
*  pwd
*
* cd /home/marisol/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity
*
* ls lib/mysql-connector-java-9.4.0.jar
*
* ls ~/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity/lib/mysql-connector-java-9.4.0.jar
*
javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/ejercicioPracticoFinal/AppTrabajoFinal1.java
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" ejercicioPracticoFinal.AppTrabajoFinal1
*/

}

