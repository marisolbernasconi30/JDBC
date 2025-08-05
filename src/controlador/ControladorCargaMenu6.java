package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import vista.*;
import modelo.*;

public class ControladorCargaMenu6 extends WindowAdapter {

    //para cargar el JComboBox que está en Marco_Aplicacion1 tengo que: pasarle un objeto perteneciente a esa clase

    public ControladorCargaMenu6(Marco_Aplicacion1 elMarco) { //creo un constructor que recibe un objeto de tipo Marco_Aplicacion1
        //así puedo acceder a los atributos de esa clase
        //y así puedo cargar el JComboBox que está en esa clase
        this.elMarco = elMarco;

    }

    public void windowOpened(WindowEvent e){
    //este metodo primero tiene que ejecutar la consulta SQL
    obj.EjecutaConsulta();

    try {
        while(obj.resultado.next()){ //CON ESTE CARGO EL JCOMBOBOX DE LAS SECCIONES 
            elMarco.secciones.addItem(obj.resultado.getString(1));

        }
        while(obj.resultado2.next()){ //CON ESTE CARGO EL JCOMBOBOX DE LOS PAISES
            elMarco.paises.addItem(obj.resultado2.getString(1));
            
        }
        
    } catch (Exception e2) {
       e2.printStackTrace();
       System.out.println("Error al cargar las secciones en el JComboBox");
    }

    }

    //instancias para hacer referencia a los objetos que necesito de las clases 
    CargaMenu5 obj = new CargaMenu5();
    private Marco_Aplicacion1 elMarco;

}
