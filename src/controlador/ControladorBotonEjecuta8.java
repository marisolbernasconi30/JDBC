package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
        
        resultadoConsulta = nueva_consulta.filtraBBDD(seleccionSeccion, seleccionPais);
        try { 
            elmarco.resultado.setText(""); //limpiar el JTextArea
            while(resultadoConsulta.next()) {
                elmarco.resultado.append(resultadoConsulta.getString(1));
                elmarco.resultado.append(" - ");
                elmarco.resultado.append(resultadoConsulta.getString(2));
                elmarco.resultado.append(" - ");
                elmarco.resultado.append(resultadoConsulta.getString(3));
                elmarco.resultado.append(" - ");
                elmarco.resultado.append(resultadoConsulta.getString(4));
                elmarco.resultado.append("\n");
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    
    EjecutaLaConsulta7 nueva_consulta= new EjecutaLaConsulta7();
    private Marco_Aplicacion1 elmarco;

    private ResultSet resultadoConsulta;

    
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