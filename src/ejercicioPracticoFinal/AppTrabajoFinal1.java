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
       Lamina milamina=new Lamina();
       add(milamina);
    }

}

class Lamina extends JPanel{
    public Lamina(){
         setLayout(new BorderLayout());
         combo1=new JComboBox();
         area_texto=new JTextArea(8,20);
            add(combo1, BorderLayout.NORTH);
            add(area_texto, BorderLayout.CENTER);
    }

    //VARIABLES
    private JTextArea area_texto;
    private JComboBox combo1;
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

