package transacciones;

import java.sql.*;

import javax.swing.JOptionPane;

public class TransaccionProductos2 {
    public static void main(String[] args) {
        Connection conexion = null;
     
        try {

            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            conexion.setAutoCommit(false); // Desactivamos el auto-commit para manejar transacciones y me lo reconozca como bloque. 

            Statement miSentencia = conexion.createStatement();

            String sentenciaSQL1="DELETE FROM PRODUCTOS WHERE  PAISORIGEN =  'GUATEMALA'";
            
            String sentenciaSQL2="DELETE FROM PRODUCTOS WHERE PRECIO>15000";
          
            String sentenciaSQL3="UPDATE PRODUCTOS SET PRECIO= PRECIO*0.15";

            boolean ejecutar= ejecutar_transaccion();

            if (ejecutar) {
                miSentencia.executeUpdate(sentenciaSQL1);
                miSentencia.executeUpdate(sentenciaSQL2);
                miSentencia.executeUpdate(sentenciaSQL3);
                conexion.commit(); // Si todo ha ido bien, confirmamos los cambios en la base de datos.
                System.out.println("Transacción realizada correctamente.");
            } else {
                
                System.out.println("Transacción fallida, cambios deshechos.");
            }

            
            
    }catch (Exception e) {
            try {
                conexion.rollback();
            } catch (SQLException e1) {
            
                e1.printStackTrace();
            } // Si hay un error, deshacemos los cambios
            e.printStackTrace();
            System.out.println("No se ha podido realizar la transacción.");
        }   

}
static boolean ejecutar_transaccion() {
    String ejecucion=JOptionPane.showInputDialog("Ejecutamos la transaccion?");
    if(ejecucion.equalsIgnoreCase("si")) {
        return true;
    }else {
        return false;

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
# Compilar todo
javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" $(find src -name "*.java")

# Ejecutar

java -cp "bin:lib/mysql-connector-java-9.4.0.jar" transacciones.TransaccionProductos2

*/