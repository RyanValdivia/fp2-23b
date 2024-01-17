import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    private static final String URL = "jdbc:mysql://localhost:3306/fp2_23b";
    private static final String USUARIO = "fp2_23b";
    private static final String CONTRASENA = "1604";

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            // Establecer conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            // Consulta SELECT
            String consultaSelect = "SELECT * FROM owners";
            PreparedStatement statement = conexion.prepareStatement(consultaSelect);

            // Ejecutar consulta
            ResultSet resultado = statement.executeQuery();

            // Procesar resultados
            while (resultado.next()) {
                String nombre = resultado.getString("first_name");
                String apellido = resultado.getString("last_name");
                System.out.println(nombre + " " + apellido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar conexión
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}