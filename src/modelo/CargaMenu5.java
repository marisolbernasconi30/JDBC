package modelo;
//import controlador.*;
import java.sql.*;
//import modelo.*;
//SE ENCARGA DE HACER LA CONSULTA SQL A LA BASE DE DATOS PARA CARGAR LAS SECCIONES
// TAMBIEN DE GUARDAR LOS REGISTROS EN EL RESULTSET

public class CargaMenu5{


    public CargaMenu5() {
      conexion = new Conexion3();  
    }

    public String EjecutaConsulta(){

        Productos4 miproducto=null;
        Connection acccesoBBDD= conexion.dameConexion(); //conecto con la base de datos 
        try{
            Statement sentencia = acccesoBBDD.createStatement();
            resultado= sentencia.executeQuery("SELECT DISTINCTROW SECCION FROM PRODUCTOS");

          //  while(resultado.next()){
               // resultado.previous(); //para que no se salte el primer registro
                miproducto = new Productos4();
                  // miproducto.setCodigoArticulo(resultado.getString("CODIGOARTICULO"));
                  //  miproducto.setNombreArticulo(resultado.getString("NOMBREARTICULO"));
                miproducto.setSeccionArticulo(resultado.getString("SECCION"));
                   //miproducto.setPrecioArticulo(resultado.getInt("PRECIO"));
                   //miproducto.setPaisOrigen(resultado.getString("PAISORIGEN"));

               // return miproducto.getSeccionArticulo();
                   // System.out.println(miproducto.getCodigoArticulo() + " - " + miproducto.getNombreArticulo() + " - " + miproducto.getSeccionArticulo() + " - " + miproducto.getPrecioArticulo() + " - " + miproducto.getPaisOrigen());
           // }
            resultado.close();


        }catch(Exception e){
            System.out.println("ERROR, NO CONECTA!");
            e.printStackTrace(); //IMPRIME EL ERROR EN PANTALLA
        }

        return miproducto.getSeccionArticulo(); //SIEMPRE TIENE QUE ESTAR ESTA LINEA. 
        // SI NO, NO SE PUEDE HACER EL RETURN DE UN METODO QUE DEVUELVE UN STRING
    }
    
    Conexion3 conexion;
    public ResultSet resultado;
}