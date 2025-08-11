package proAlmacenado;
import java.sql.*;

public class ConsultaClientes1 {
    public static void main(String [] args){
        try {
            
            
            // Establecer la conexión
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
            // Crear un objeto CallableStatement para llamar al procedimiento almacenado
            CallableStatement miSentencia= conexion.prepareCall("{call MUESTRA_CLIENTES()}");
            // Ejecutar la consulta
            ResultSet resultado = miSentencia.executeQuery();
            // Procesar el resultado
            while(resultado.next()) {
                System.out.println(resultado.getString(1) + " - " + resultado.getString(2) + " - " + resultado.getString(3) + " - " + resultado.getString(4));
            } 
            // Cerrar el ResultSet y la conexión
            resultado.close();
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
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" proAlmacenado.ConsultaClientes1


*/
