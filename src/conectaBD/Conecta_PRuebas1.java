package conectaBD;
import java.sql.*;
import javax.sql.*;

public class Conecta_PRuebas1 {
    public static void main(String[] args) {
        
        try {

             // PASO 1: CARGAMOS EL DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            //PASO 1: CREAMOS LA CONEXION
            Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "newyorkcode");

            //PASO 2: CREAMOS EL STATEMENT
            Statement mystatement=miconexion.createStatement();

            //PASO 3: EJECUTAMOS LA CONSULTA SQL 
            ResultSet myresultset=mystatement.executeQuery("SELECT * FROM PRODUCTOS");

            //PASO 4: RECORREMOS EL RESULTSET
            while(myresultset.next()) { //MIENTRAS HAYA UN REGISTRO MAS HACIA ADELANTE DEL CURSOR
                System.out.println(myresultset.getString("CODIGOPRODUCTO") + " - " + myresultset.getString("NOMBREARTICULO") + " - " + myresultset.getString("PAISORIGEN")); //PARA QUE NOS DEVUELVA EL CONTENIDO DE CADA COLUMNA DEL REGISTRO
            }

        } catch (Exception e) {
            System.out.println("ERROR, NO CONECTA!");
            e.printStackTrace(); //IMPRIME EL ERROR EN PANTALLA
        }

        
    }
}
