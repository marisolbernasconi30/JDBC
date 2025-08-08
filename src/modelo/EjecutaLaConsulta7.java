package modelo;
import java.sql.*;

public class EjecutaLaConsulta7{

    public EjecutaLaConsulta7() {
        conexion = new Conexion3();
       
    }

    public ResultSet filtraBBDD(String seccion, String pais) {
        
        
      //  pruebas="";

         Connection con = conexion.dameConexion();

        rs = null;

    try{

        if (!seccion.equals("Todos")&& pais.equals("Todos")) {
        enviaConsultaSeccion=con.prepareStatement(consultaSeccion);
        enviaConsultaSeccion.setString(1, seccion);
        rs=enviaConsultaSeccion.executeQuery();
            //   pruebas= "Has escogido seccion";
        } else if (seccion.equals("Todos") && !pais.equals("Todos")) {
           // pruebas= "Has escogido pais";
        } else  {
           // pruebas= "Has escogido seccion y pais";
        } 

    }catch(Exception e){
        e.printStackTrace();
    }
     //   return pruebas;
     return rs;
    }

   // private String pruebas;
   private Conexion3 conexion;
   private ResultSet rs;
   private PreparedStatement enviaConsultaSeccion;
   private final String consultaSeccion="SELECT NOMBREARTICULO, SECCION, PRECIO, PAISORIGEN FROM PRODUCTOS WHERE SECCION=?";
}

