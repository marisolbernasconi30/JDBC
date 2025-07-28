package conectaBD;
import java.sql.*;
import javax.sql.*;

public class Conecta_PRuebas1 {
    public static void main(String[] args) {
        
        try {

            //PASO 1: CREAMOS LA CONEXION
            Connection miconexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "newyorkcode");
        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }
}
