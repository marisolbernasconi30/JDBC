package ejercicioPracticoFinal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;

public class AppTrabajoFinal1 {
    
    public static void main(String[] args) {

       JFrame mimarco=new Marco_AplicacionFinal();
       mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mimarco.setVisible(true);

   }
}
class Marco_AplicacionFinal extends JFrame{ //CLASE MARCO


   public Marco_AplicacionFinal(){
       setTitle ("Aplicacion Final BBDD");
       setBounds(500,300,400,400);     
       setLayout(new BorderLayout());
       Lamina milamina=new Lamina();
       add(milamina);
    }

}

class Lamina extends JPanel{ //CLASE LAMINA
    public Lamina(){ //METODO CONSTRUCTOR
         setLayout(new BorderLayout());
         combo1=new JComboBox();
         area_texto=new JTextArea(8,20);

         conectarConBaseDatos(); //LLAMO A ESTE MÉTODO PARA QUE ME CONECTE A LA BASE DE DATOS
         obtenerTablas(); //LLAMO A ESTE MÉTODO PARA QUE ME CARGUE LAS TABLAS

         combo1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(java.awt.event.ActionEvent e) {
                 // Acción a realizar cuando se selecciona un elemento del combo
                 String nombreTablas=((String)combo1.getSelectedItem()); // OBTENGO EL NOMBRE DE LA TABLA SELECCIONADA por el usuario
                 mostrarDatosTabla(nombreTablas); //LLAMO A ESTE MÉTODO PARA QUE ME MUESTRE LOS DATOS DE LA TABLA SELECCIONADA
             }
         });
         add(combo1, BorderLayout.NORTH);

         add(area_texto, BorderLayout.CENTER);
         
    }

    public void conectarConBaseDatos(){ // ESTE MÉTODO ME CONECTA A LA BASE DE DATOS

        miConexion=null;

        String datosArray [] = new String[3];

        try{

            //ESTA MAL EL NOMBRE DEL TXT, ENTONCES SE VA AL CATCH Y ME ABRE EL EXPLORADOR DE ARCHIVOS
            entrada=new FileReader("/home/marisol/eclipse-workspace/PROYECTO/JDBC/JavaDataBaseConnectivity/datosss_config.txt"); // LEO EL ARCHIVO que ya esta creado con los datos dentro
            
        
         } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo de configuración, por favor seleccione el archivo");
            JFileChooser chooser = new JFileChooser(); //ABRO EL EXPLORADOR DE ARCHIVOS PARA QUE EL USUARIO BUSQUE EL ARCHIVO
            FileNameExtensionFilter filter = new FileNameExtensionFilter( "Archivo txt ", "txt"); //FILTRO PARA QUE SOLO APAREZCAN LOS ARCHIVOS TXT
            chooser.setFileFilter(filter); //AÑADO EL FILTRO AL EXPLORADOR
            int returnVal = chooser.showOpenDialog(this);  //ABRO EL EXPLORADOR
   
            if(returnVal == JFileChooser.APPROVE_OPTION) { //
            //System.out.println("You chose to open this file: " + chooser.getSelectedFile().getAbsolutePath()); //ME DA LA RUTA DEL ARCHIVO
              try {
                entrada=new FileReader(chooser.getSelectedFile().getAbsolutePath());
              } catch (FileNotFoundException e1) {
                e1.printStackTrace();
              } //LEO EL ARCHIVO QUE HA SELECCIONADO EL USUARIO
            }

        }   
            
           try{

            
            BufferedReader mibuffer=new BufferedReader(entrada); // PARA LEER EL ARCHIVO
            for (int i=0;i<=2;i++){ //VA DE CERO A DOS PORQUE TENGO QUE LEER DOS LÍNEAS (fichero y usuario, no la contraseña)
                datosArray[i]=mibuffer.readLine(); // ALMACENO CADA LINEA DEL ARCHIVO EN CADA POSICION DEL ARRAY
            }

            //hasta acá tengo todos los datos en el array 


            //se conecta con la base de datos solamente  y le paso los parametros del array que recien creé. 
            miConexion=DriverManager.getConnection(datosArray[0],datosArray[1],datosArray[2]); //ME CONECTO A LA BASE DE DATOS
            
            entrada.close(); //cierro el archivo


        } catch(Exception e){
            e.printStackTrace();

        } 
    }   
    

    public void obtenerTablas(){ // ESTE MÉTODO ME OBTIENE LAS TABLAS DE LA BASE DE DATOS
        ResultSet miResultet=null; 
        try{

            DatabaseMetaData datosBDD=miConexion.getMetaData(); //ESTE OBJETO ME LEE LAS TABLAS DE LA BASE DE DATOS
            //El método getTables me devuelve las tablas de la base de datos
            miResultet=datosBDD.getTables(null,null,null,null);
            while(miResultet.next()){
                combo1.addItem(miResultet.getString("TABLE_NAME")); //AÑADO LAS TABLAS AL COMBO
            }
        }catch(Exception e){
            e.printStackTrace();
    }
    }

    public void mostrarDatosTabla(String Tabla){ // ESTE MÉTODO ME MUESTRA LOS DATOS DE LA TABLA SELECCIONADA
       ArrayList<String> datos=new ArrayList<String>();
       String consulta="SELECT * FROM " + Tabla; //CONSULTA PARA OBTENER TODOS LOS DATOS DE LA TABLA SELECCIONADA
       try{

        area_texto.setText(""); //LIMPIO LA CAJA DE TEXTO CADA VEZ QUE SE SELECCIONA UNA TABLA DIFERENTE
        Statement miStatement=miConexion.createStatement(); //OBJETO QUE ME PERMITE EJECUTAR SENTENCIAS SQL PREPARADAS
        ResultSet miResultSet=miStatement.executeQuery(consulta); //para que ejecute la consulta
        //objetivo del resultet: almacenar el resultado de la consulta (saber cuantas filas y columnas tiene el resultado)
        ResultSetMetaData rsBDD=miResultSet.getMetaData(); //OBJETO QUE ME PERMITE SABER CUANTAS COLUMNAS TIENE LA TABLA
        for (int i=1;i<=rsBDD.getColumnCount();i++){ //RECORRO TODAS LAS COLUMNAS
            datos.add(rsBDD.getColumnLabel(i)); //AÑADO EL NOMBRE DE CADA COLUMNA AL ARRAYLIST
        }
        //hasta aca, tengo los nombres de las columnas en el arraylist
        //ahora me tiene que recorrer el resultset para obtener los datos del arraylist 



        while(miResultSet.next()){ //RECORRO TODAS LAS FILAS
            for (String nombreColumna:datos){ //RECORRO EL ARRAYLIST
                area_texto.append(miResultSet.getString(nombreColumna) + " "); //AÑADO LOS DATOS DE CADA COLUMNA A LA CAJA DE TEXTO 
            }
            area_texto.append("\n"); //SALTO DE LINEA PARA QUE LOS DATOS DE CADA FILA SALGAN EN UNA LINEA DIFERENTE
        }

        /* CUANDO EL BUCLE ENTRA EN EL WHILE, SE LEE EL PRIMER REGISTRO DEL RESULTSET
         * LUEGO CON EL BUCLE FOR EACH, LE DECIMOS QUE NOS EXTRAIGA DEL ARRAYLIST EL NOMBRE DEL PRIMER CAMPO 
         * Y LO QUE TIENE QUE HACER EL FOR ES:
         * QUE SAQUE EL TEXTO (getString) DEL PRIMER CAMPO (nombreColumna) DEL RESULTSET (miResultSet)
         */

       }catch(Exception e){
        e.printStackTrace();
       }
    }


    //VARIABLES
    private JTextArea area_texto;
    private JComboBox combo1;
    private Connection miConexion;
    private FileReader entrada;
    
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
javac -d bin -cp "lib/mysql-connector-java-9.4.0.jar" src/ejercicioPracticoFinal/AppTrabajoFinal1.java
java -cp "bin:lib/mysql-connector-java-9.4.0.jar" ejercicioPracticoFinal.AppTrabajoFinal1
*/

