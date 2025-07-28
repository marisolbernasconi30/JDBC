public class ProbarDriver {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Driver cargado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ No se pudo cargar el driver.");
            e.printStackTrace();
        }
    }
}

