package modelo;
import java.sql.*;

public class EjecutaLaConsulta7{
    
    public String filtraBBDD(String seccion, String pais) {
        
        
        pruebas="";
        
        if (!seccion.equals("Todos")&& pais.equals("Todos")) {
            pruebas= "Has escogido seccion";
        } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
            pruebas= "Has escogido pais";
        } else  {
            pruebas= "Has escogido seccion y pais";
        } 

        return pruebas;
    }

    private String pruebas;
}