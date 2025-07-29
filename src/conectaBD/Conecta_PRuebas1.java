package conectaBD;
import java.sql.*;
import javax.sql.*;

public class Conecta_PRuebas1 {

    
    public static void main(String[] args){
        
        
        try {

             // PASO 1: CARGAMOS EL DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            //PASO 1: CREAMOS LA CONEXION
            Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            //PASO 2: CREAMOS EL STATEMENT
            Statement mystatement=miconexion.createStatement();

            //PASO 3: EJECUTAMOS LA CONSULTA SQL 
            ResultSet myresultset=mystatement.executeQuery("SELECT * FROM PRODUCTOS");

            //PASO 4: RECORREMOS EL RESULTSET
            while(myresultset.next()) { //MIENTRAS HAYA UN REGISTRO MAS HACIA ADELANTE DEL CURSOR
                System.out.println(myresultset.getString("CODIGOARTICULO") + " - " + myresultset.getString("NOMBREARTICULO") + " - " + myresultset.getString("PAISORIGEN")); //PARA QUE NOS DEVUELVA EL CONTENIDO DE CADA COLUMNA DEL REGISTRO
            }

        } catch (Exception e) {
            System.out.println("ERROR, NO CONECTA!");
            e.printStackTrace(); //IMPRIME EL ERROR EN PANTALLA
        }

        
    }

}

/*
 * NO SE POR QUE, PERO SI YO COMPILO ESTO EN LA TERMINAL:
 * javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/conectaBD/Conecta_PRuebas1.java
 * Y LUEGO EJECUTO:
 * java -cp "bin:lib/mysql-connector-java-9.4.0.jar" conectaBD.Conecta_PRuebas1
 * AHI SI FUNCIONA. 
 * PERO SI LO HAGO DESDE EL "RUN CODE" NO FUNCIONA. 
 */


