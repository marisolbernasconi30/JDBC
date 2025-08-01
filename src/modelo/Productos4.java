package modelo;
import java.sql.Connection;

public class Productos4 {

    private String codigoArticulo;
    private String seccionArticulo;
    private String nombreArticulo;
    private int precioArticulo;
    private String paisOrigen;

    public Productos4() {
        codigoArticulo = "";
        seccionArticulo = "";
        precioArticulo = 0;
        nombreArticulo = "";
        paisOrigen = "";
    }

    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    public String getSeccionArticulo() {
        return seccionArticulo;
    }
    public void setSeccionArticulo(String seccionArticulo) {
        this.seccionArticulo = seccionArticulo;
    }
    public int getPrecioArticulo() {
        return precioArticulo;
    }
    public void setPrecioArticulo(int precioArticulo) {
        this.precioArticulo = precioArticulo;
    }
        
}







