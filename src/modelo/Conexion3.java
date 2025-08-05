package modelo;
import java.sql.*;


public class Conexion3 {

    //AQUI HAREMOS LA CONEXION A LA BASE DE DATOS, PERO NO LO HAREMOS DESDE EL MAIN, SINO QUE LO HAREMOS DESDE UN METODO QUE SE LLAMARA DAMECONEXION
    //ESTE METODO NOS DEVOLVERA UN OBJETO DE TIPO CONNECTION, QUE ES EL QUE NOS PERMITE HACER LAS CONSULTAS A LA BASE DE DATOS

    Connection miconexion;

    //CONSTRUCTOR;
  public  Conexion3(){

    }

    public Connection dameConexion(){
    
        try {
            miconexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miconexion;
    }



}


