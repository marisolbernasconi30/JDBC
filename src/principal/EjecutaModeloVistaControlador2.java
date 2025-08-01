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
 * pwd
 * cd /home/marisol/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity/src
   javac principal/EjecutaModeloVistaControlador2.java
   java principal.EjecutaModeloVistaControlador2

 */