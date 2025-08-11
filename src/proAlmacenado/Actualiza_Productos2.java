package proAlmacenado;
import java.sql.*;

import javax.swing.JOptionPane;

public class Actualiza_Productos2 {
    public static void main(String[] args) {

        int nPrecio=Integer.parseInt(JOptionPane.showInputDialog("Escribe el nuevo precio"));
        String nArticulo=JOptionPane.showInputDialog("Escribe el nombre del articulo a actualizar");

        try {
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            // Crear un objeto CallableStatement para llamar al procedimiento almacenado
            CallableStatement miSentencia = conexion.prepareCall("{call ACTUALIZA_PROD(?, ?)}");    //ASI ES CON ENVIO DE PARAMETROS

            // Ejecutar la consulta
            miSentencia.setInt(1, nPrecio); //ACA SE ALMACENA EL PRECIO EN EL PRIMER ?
            miSentencia.setString(2, nArticulo); // ACA SE ALMACENA EL ARTICULO EN EL SEGUNDO ?

            miSentencia.execute(); //PARA EJECUTARLO SOLAMENTE 
            System.out.println("Productos actualizados correctamente.");
            // Cerrar la conexión
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
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
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" proAlmacenado.Actualiza_Productos2


*/