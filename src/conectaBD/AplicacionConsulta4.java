package conectaBD;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class AplicacionConsulta4 {

    public static void main(String[] args) {
       
        JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

    }

}
class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		//------CONEXION CON LA BASE DE DATOS-----------

    try {

        Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
        Statement sentencia=conexion.createStatement();

        //------PRIMER JCOMBOBOX DE SECCION-------
        String consultaSQL= "SELECT DISTINCTROW SECCION FROM PRODUCTOS";
        ResultSet rs=sentencia.executeQuery(consultaSQL);

        while(rs.next()){
            secciones.addItem(rs.getString("SECCION"));
        }
        rs.close();


        //------SEGUNDA JCOMBOBOX DE PAISES-------
        consultaSQL= "SELECT DISTINCTROW PAISORIGEN FROM PRODUCTOS";
        rs=sentencia.executeQuery(consultaSQL);

        while(rs.next()){
            paises.addItem(rs.getString("PAISORIGEN"));
        }
        rs.close();



    } catch (Exception e) {
        
        e.printStackTrace();
    }
		
	}	
		
 //------NOMBRE DE LAS VARIABLES -------
	
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

	
}


/* 
 *  pwd
 * 
 * cd /home/marisol/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity
 * 
 * ls lib/mysql-connector-java-9.4.0.jar
 * 
 * ls ~/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity/lib/mysql-connector-java-9.4.0.jar
 * 
 * 
 javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/conectaBD/AplicacionConsulta4.java
 java -cp "bin:lib/mysql-connector-java-9.4.0.jar" conectaBD.AplicacionConsulta4
 */


