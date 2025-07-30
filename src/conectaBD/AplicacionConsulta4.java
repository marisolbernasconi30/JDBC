package conectaBD;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        botonConsulta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //resultado.setText(""); //LIMPIA EL JTEXTAREA
                ejecutaConsulta(); //EJECUTA LA CONSULTA
            }
        }); //AL HACER CLICK EN EL BOTON SE EJECUTA LA CONSULTA
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		//------CONEXION CON LA BASE DE DATOS-----------

    try {

         conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
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
		
    private void ejecutaConsulta(){
        ResultSet rs=null;
        try {
            resultado.setText(""); //LIMPIA EL JTEXTAREA

            String seccion=(String)secciones.getSelectedItem(); //GUARDAMOS EL ELEMENTO SELECCIONADO EN EL PRIMER JCOMBOBOX
            String pais=(String)paises.getSelectedItem(); //GUARDAMOS EL ELEMENTO SELECCIONADO EN EL SEGUNDO JCOMBOBOX


            if(!seccion.equals("Todos")&& pais.equals("Todos")){ //PRIMER OPCION
               enviaConsultaSeccion=conexion.prepareStatement(consultaSeccion);
               enviaConsultaSeccion.setString(1, seccion); //PARAMETRIZAMOS LA CONSULTA CON EL ELEMENTO SELECCIONADO
               rs=enviaConsultaSeccion.executeQuery(); //EJECUTAMOS LA CONSULTA
            }else if(seccion.equals("Todos")&& !pais.equals("Todos")){
               enviaConsultaPais=conexion.prepareStatement(consultaPais);
               enviaConsultaPais.setString(1, pais); //PARAMETRIZAMOS LA CONSULTA CON EL ELEMENTO SELECCIONADO
               rs=enviaConsultaPais.executeQuery(); //EJECUTAMOS LA CONSULTA
            }else if(!seccion.equals("Todos")&& !pais.equals("Todos")){
               enviaConsultaTodos=conexion.prepareStatement(consultaTodos);
               enviaConsultaTodos.setString(1, seccion);
               enviaConsultaTodos.setString(2, pais);
                //PARAMETRIZAMOS LA CONSULTA CON EL ELEMENTO SELECCIONADO
               rs=enviaConsultaTodos.executeQuery(); //EJECUTAMOS LA CONSULTA
            }
           

            while(rs.next()){
                //AQUI AÑADIMOS LOS RESULTADOS AL JTEXTAREA
                resultado.append(rs.getString("NOMBREARTICULO") + " | " + rs.getString("SECCION") + " | " + rs.getInt("PRECIO") + " | " + rs.getString("PAISORIGEN") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }

 //------NOMBRE DE LAS VARIABLES -------
 
    private Connection conexion;   

    private PreparedStatement enviaConsultaPais; // ACA ALMACENO LA CONSULTA PREPARADA PARA EL PAIS

    private PreparedStatement enviaConsultaTodos; // ACA ALMACENO LA CONSULTA PREPARADA PARA LA SECCION

	private PreparedStatement enviaConsultaSeccion; // ACA ALMACENO LA CONSULTA PREPARADA

    private final String consultaSeccion="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE SECCION=?" ; //PARA LA CONSULTA PARAMETRIZADA

    private final String consultaPais="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE PAISORIGEN=?" ; //PARA LA CONSULTA PARAMETRIZADA
    
    private final String consultaTodos="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE PAISORIGEN=? AND SECCION=?" ; //PARA LA CONSULTA PARAMETRIZADA
    
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


