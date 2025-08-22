package ejercicioPracticoFinal;
import java.io.*;

public class FicheroExternoApp2 {
    
     public static void main (String [] args){


       File archivo=new File("/" + File.separator + "home" + File.separator + "marisol" + File.separator + "eclipse-workspace"  + File.separator + "PROYECTO" + File.separator + "JDBC" + File.separator + "JavaDataBaseConnectivity" + File.separator + "datos_config.txt");   
       //para meterme en cualquier sistema operativo

       String archivo_destino=archivo.getAbsolutePath();

       try {
          archivo.createNewFile();  //creamos el archivo si no existe
          System.out.println("Archivo creado: " + archivo_destino);
       } catch (Exception e) {
           System.out.println("no fue posible crear el archivo txt");
       }
     
     //  Escribiendo accede_es=new Escribiendo();
      // accede_es.escribir(archivo_destino);

   }

}

/*class Escribiendo{
   public void escribir(String ruta_archivo){ //lo que hay almacenado en archivo_destino, viaja y se almacena en ruta_archivo cuando lo llame
       //lo que estamos almacenando en ruta_archivo es la ruta de la carpeta a la que quiero crear el archivo y escribirlo

       String frase= "Esto es un ejemplo. Esperemos que salga bien. ";

       try {

           FileWriter escritura=new FileWriter(ruta_archivo);


           for (int i=0; i<frase.length(); i++){
               escritura.write(frase.charAt(i));
           }

           escritura.close();

       } catch (Exception e) {
           // TODO: handle exception
       }

   }
}
 */
 