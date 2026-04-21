// Importes necesarios para el programa
import java.sql.*;

// Clase Main para la ejecucion del programa
public class Main {
    public static void main(String[] args) {
        // Datos para conectarse a la base de datos
        String url = "jdbc:oracle:thin:@//localhost:1521/xe"; // Cambia según tu BD
        String usuario = "JAVA";
        String contraseña = "12345";

        // Try-catch con recursos para intentar conectarse
        try (Connection conn = DriverManager.getConnection(url, usuario, contraseña);
             // Objeto Statement para ejecutar consultas SQL
             Statement stmt = conn.createStatement()){

            // Consulta SQL que calcula el salario promedio de todos los empleados
            String sql = "SELECT AVG(SALARIO) AS PROMEDIO FROM EMPLEADO";

            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery(sql);

            // Recorrer el resultado (solo habrá una fila con el promedio)
            while (rs.next()) {
                // Obtener el valor del promedio (puede ser NULL si no hay empleados)
                double promedio = rs.getDouble("PROMEDIO");

                // Mostrar el salario promedio por pantalla
                System.out.println("Salario promedio: " + promedio);
            }

        } catch (SQLException e) {
            // Capturar y mostrar cualquier error de base de datos
            System.out.println("Error al mostrar la tabla: " + e.getMessage());
        }
    }
}