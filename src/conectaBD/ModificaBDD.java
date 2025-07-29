package conectaBD;
import java.sql.*;
//import javax.sql.*;

public class ModificaBDD {
    public static void main(String[] args){
        
        try {

             // PASO 1: CARGAMOS EL DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            //PASO 1: CREAMOS LA CONEXION
            Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            //PASO 2: CREAMOS EL STATEMENT
            Statement mystatement=miconexion.createStatement();

           //PARA INSERTAR:
            String sqlInsert = "INSERT INTO PRODUCTOS (CODIGOARTICULO, NOMBREARTICULO, PAISORIGEN) VALUES ('AR014', 'Producto Nuevo NUEVO', 'Mexico')"; //LOS STRINGS SE DIFERENCIAN CON LAS COMILLAS 
            mystatement.executeUpdate(sqlInsert);

            //PARA ACTUALIZAR:
            String sqlUpdate = "UPDATE PRODUCTOS SET SECCION='ROPA' WHERE CODIGOARTICULO='AR013'";
            mystatement.executeUpdate(sqlUpdate);

            //PARA ELIMINAR:
            String sqlDelete = "DELETE FROM PRODUCTOS WHERE CODIGOARTICULO='AR011'";
            mystatement.executeUpdate(sqlDelete);

            //CERRAMOS LA CONEXION
            mystatement.close();
            miconexion.close();

        } catch (Exception e) {
            System.out.println("ERROR, NO CONECTA!");
            e.printStackTrace(); //IMPRIME EL ERROR EN PANTALLA
        }
    }
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
 javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/conectaBD/ModificaBDD.java
 java -cp "bin:lib/mysql-connector-java-9.4.0.jar" conectaBD.ModificaBDD
 */


