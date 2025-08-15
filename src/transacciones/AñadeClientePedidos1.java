package transacciones;

import java.sql.*;

public class AñadeClientePedidos1 {
    
    public static void main(String[] args) {
        

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");

            Statement miSentencia = conexion.createStatement();

            // SUPONGAMOS QUE YO LO HAGO ASÍ:
            //ESTA SENTENCIA ESTÁ BIEN ESCRITA.
            String sentenciaSQL1="INSERT INTO CLIENTES (CODIGOCLIENTE, EMPRESA, DIRECCION, POBLACION, TELEFONO, RESPONSABLE, HISTORIAL) VALUES ('CL023', 'Ejemplo', 'Calle Falsa 123', 'MADRID', '856932147', 'MONICA IBAÑEZ', '45 COMPRAS')";
            miSentencia.executeUpdate(sentenciaSQL1);

            //ESTA SENTENCIA ESTÁ MAL ESCRITA PORQUE ESTÁ MAL EL NOMBRE DE LA COLUMNA (VA SIN EL _)
            String sentenciaSQL2="INSERT INTO PEDIDOS (NUMERO_PEDIDO, CODIGOCLIENTE, FECHAPEDIDO, FORMAPAGO, DESCUENTO, ENVIADO) VALUES ('023', 'CL023', '2024-06-20', 'TRANSFERENCIA', '0.15', 'FALSO')";
            miSentencia.executeUpdate(sentenciaSQL2);
            
            System.out.println("Cliente y pedido añadidos correctamente.");

            /*
             * ME VA A DAR ERROR EN LA SEGUNDA SENTENCIA PORQUE ESTÁ MAL ESCRITO
             * PERO LA PRIMER SENTENCIA SE VA A EJECUTAR CORRECTAMENTE. 
             * ESTO, NO ES UNA TRANSACTION.
             * EN UNA TRANSACTION, SI UNA FALLA, TODAS FALLAN.
             */
        
            
                
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("No se ha podido añadir el cliente y el pedido.");

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

java -cp "bin:lib/mysql-connector-java-9.4.0.jar" transacciones.AñadeClientePedidos1

*/




    }
}
