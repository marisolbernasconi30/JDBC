package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;

public class ControladorBotonEjecuta8 implements ActionListener{
    
    public ControladorBotonEjecuta8(Marco_Aplicacion1 elmarco) {
        this.elmarco = elmarco;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seleccionSeccion = (String)elmarco.secciones.getSelectedItem();
        String seleccionPais = (String)elmarco.paises.getSelectedItem(); //para almacenar lo que escoje el usuario en el JComboBox
        
        //esto escribe en el JTextArea lo que el usuario eligio
        elmarco.resultado.append(nueva_consulta.filtraBBDD(seleccionSeccion, seleccionPais));
        elmarco.resultado.append("\n"); //para que cada vez que pulse el boton de consulta, me lo escriba en una nueva linea
    }
    
    EjecutaLaConsulta7 nueva_consulta= new EjecutaLaConsulta7();
    private Marco_Aplicacion1 elmarco;


    
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