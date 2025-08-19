package metadatos;

import java.sql.*;

public class InfoMetadatos1 {

    public static void main(String[] args) {
     
       // mostrarInfoBBDD();
        mostrarInfoTablas();

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

    static void mostrarInfoTablas(){
        Connection miconexion=null;
        ResultSet rs=null;
         ResultSet rs1=null;

        try{
            // Establecer la conexión
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            // Obtener los metadatos de la conexión
            DatabaseMetaData metadatos = miconexion.getMetaData();

            // Obtener las tablas de la base de datos
            rs = metadatos.getTables(null, null, null, null);
            //si en el tercer parámetro le pongo "p%" es un comodin. significa que me va a devolver todas las tablas que empiecen con la letra p.

            while(rs.next()){
               System.out.println("Tabla: " + rs.getString("TABLE_NAME"));
            }

            //lista de columnas de productos:

            System.out.println("");
            System.out.println("Campos de productos:");

            rs1 = metadatos.getColumns(null, null, "PRODUCTOS", null);

            while(rs1.next()){
               System.out.println("Nombre Columna: " + rs1.getString("COLUMN_NAME"));
            }


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