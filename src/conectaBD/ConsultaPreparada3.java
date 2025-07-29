package conectaBD;
import java.sql.*;
public class ConsultaPreparada3 {

    public static void main(String[] args) {
        try {
            //1- CREO LA CONEXION
            Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            //2- CREO LA CONSULTA PREPARADA
            PreparedStatement miConsultaPreparada=miconexion.prepareStatement("SELECT NOMBREARTICULO, SECCION, PAISORIGEN FROM PRODUCTOS WHERE SECCION LIKE ? AND PAISORIGEN = ?");

            //3- AÑADO LOS VALORES A LA CONSULTA PREPARADA 
            miConsultaPreparada.setString(1, "ALMACEN"); //PRIMER ?
            miConsultaPreparada.setString(2, "ARGENTINA"); //SEGUNDO ?

            //4- EJECUTO LA CONSULTA
            ResultSet miResultSet=miConsultaPreparada.executeQuery();
            //5- RECORRO EL RESULTSET
            while(miResultSet.next()) {
                System.out.println(miResultSet.getString("SECCION") + " " + miResultSet.getString("PAISORIGEN") + " " + miResultSet.getString("NOMBREARTICULO"));
            } 

            //6- CIERRO LA CONEXION
            miResultSet.close();
        
        //REUTILIZACION DE CONSULTA SQL PREPARADA:

        System.out.println("");
        System.out.println("--------------------------------------------------");
        System.out.println("");

          //3- AÑADO LOS VALORES A LA CONSULTA PREPARADA 
            miConsultaPreparada.setString(1, "FARMACIA"); //PRIMER ?
            miConsultaPreparada.setString(2, "ARGENTINA"); //SEGUNDO ?

            //4- EJECUTO LA CONSULTA
            miResultSet=miConsultaPreparada.executeQuery();
            //5- RECORRO EL RESULTSET
            while(miResultSet.next()) {
                System.out.println(miResultSet.getString("SECCION") + " " + miResultSet.getString("PAISORIGEN") + " " + miResultSet.getString("NOMBREARTICULO"));
            } 

            //6- CIERRO LA CONEXION
            miResultSet.close();

        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("ERROR, CASI CASI MARTA");
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
 javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/conectaBD/ConsultaPreparada3.java
 java -cp "bin:lib/mysql-connector-java-9.4.0.jar" conectaBD.ConsultaPreparada3
 */