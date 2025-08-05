package principal;
import vista.Marco_Aplicacion1; //IMPORTO EL PAQUETE QUE CREÉ
import javax.swing.*;

public class EjecutaModeloVistaControlador2 {
public static void main(String[] args)  {
    
    Marco_Aplicacion1 mimarco = new Marco_Aplicacion1(); //CREO UN OBJETO DE LA CLASE MARCO_APLICACION1

    mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ESTABLEZCO LA OPERACIÓN DE CIERRE DEL MARCO
    
    mimarco.setVisible(true); //SIEMPRE TIENE QUE ESTAR AL FINAL PARA QUE SE MUESTRE EL MARCO

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
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" principal.EjecutaModeloVistaControlador2


*/
