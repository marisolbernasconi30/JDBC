package metadatos;

import java.sql.*;

public class InfoMetadatos1 {

    public static void main(String[] args) {
     
        mostrarInfoBBDD();
    }

    static void mostrarInfoBBDD(){
        Connection miconexion=null;

        try{
            
            // Establecer la conexión
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // Obtener los metadatos de la conexión
            DatabaseMetaData metadatos = miconexion.getMetaData();

            // Mostrar información de la base de datos
            System.out.println("Gestor de BBDD: " + metadatos.getDatabaseProductName());
            System.out.println("Versión del gestor: " + metadatos.getDatabaseProductVersion());
            System.out.println("Nombre del driver: " + metadatos.getDriverName());
            System.out.println("Versión del driver: " + metadatos.getDriverVersion());
            //System.out.println("Usuario conectado: " + metadatos.getUserName());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                miconexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        
    }

}








/*

PROBAR SI ESTO FUNCIONA 

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

java -cp "bin:lib/mysql-connector-java-9.4.0.jar" metadatos.InfoMetadatos1

*/