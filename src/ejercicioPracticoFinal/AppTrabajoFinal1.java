package ejercicioPracticoFinal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
class Marco_AplicacionFinal extends JFrame{ //CLASE MARCO


   public Marco_AplicacionFinal(){
       setTitle ("Aplicacion Final BBDD");
       setBounds(500,300,400,400);     
       setLayout(new BorderLayout());
       Lamina milamina=new Lamina();
       add(milamina);
    }

}

class Lamina extends JPanel{ //CLASE LAMINA
    public Lamina(){ //METODO CONSTRUCTOR
         setLayout(new BorderLayout());
         combo1=new JComboBox();
         area_texto=new JTextArea(8,20);
         add(combo1, BorderLayout.NORTH);
         add(area_texto, BorderLayout.CENTER);
         conectarConBaseDatos(); //LLAMO A ESTE MÉTODO PARA QUE ME CONECTE A LA BASE DE DATOS
         obtenerTablas(); //LLAMO A ESTE MÉTODO PARA QUE ME CARGUE LAS TABLAS
    }

    public void conectarConBaseDatos(){ // ESTE MÉTODO ME CONECTA A LA BASE DE DATOS

        miConexion=null;

        try{
            //se conecta con la base de datos solamente 
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
            
        }catch(Exception e){
            e.printStackTrace();
        }   
    } 

    public void obtenerTablas(){ // ESTE MÉTODO ME OBTIENE LAS TABLAS DE LA BASE DE DATOS
        ResultSet miResultet=null; 
        try{

            DatabaseMetaData datosBDD=miConexion.getMetaData(); //ESTE OBJETO ME DA INFORMACIÓN DE LA BASE DE DATOS
            //El método getTables me devuelve las tablas de la base de datos
            miResultet=datosBDD.getTables(null,null,null,null);
            while(miResultet.next()){
                combo1.addItem(miResultet.getString("TABLE_NAME")); //AÑADO LAS TABLAS AL COMBO
            }
        }catch(Exception e){
            e.printStackTrace();
    }
    }
    //VARIABLES
    private JTextArea area_texto;
    private JComboBox combo1;
    private Connection miConexion;
    
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
javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/ejercicioPracticoFinal/AppTrabajoFinal1.java
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" ejercicioPracticoFinal.AppTrabajoFinal1
*/

