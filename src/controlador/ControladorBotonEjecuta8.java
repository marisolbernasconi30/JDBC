package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.*;
import vista.*;

public class ControladorBotonEjecuta8 implements ActionListener{
    
    public ControladorBotonEjecuta8(Marco_Aplicacion1 elmarco) {
        this.elmarco = elmarco;
        miConsulta = new modelo.EjecutaLaConsulta7();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String seccion = vista.VistaMenu5.caja1.getSelectedItem().toString();
        String pais = vista.VistaMenu5.caja2.getSelectedItem().toString();
        
        String resultado = miConsulta.filtraBBDD(seccion, pais);
        System.out.println(resultado);
    }
    
    private modelo.EjecutaLaConsulta7 miConsulta;
    private Marco_Aplicacion1 elmarco;


    // ME QUEDE EN EL MINUTO 13:57 DEL VIDEO 216
}