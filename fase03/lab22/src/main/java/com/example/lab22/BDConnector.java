package com.example.lab22;

import java.sql.*;

public class BDConnector {
    private static BDConnector instance;
    private Connection connection;
    private ResultSet resultSet;
    private String bdName = "fp2-23b";
    private String bdUser = "root";
    private String bdPassword = "";
    private String bdHost = "localhost";
    private String port = "3306";
    private String url = String.format("jdbc:mysql://%s:%s/%s", bdHost, port, bdName);

    public ResultSet executeQuery(String sql, Object... parameters) {
        resultSet = null;
        try {
            // Crear una PreparedStatement con la consulta SQL
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Establecer los parámetros (si los hay) en la PreparedStatement
            setParameters(preparedStatement, parameters);

            // Ejecutar la consulta y obtener el ResultSet
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    private BDConnector() {
        try {
            // Establecer la conexión a la base de datos
            connection = DriverManager.getConnection(url, bdUser, bdPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            // Puedes manejar la excepción de conexión aquí según tus necesidades
        }
    }
    public synchronized static BDConnector getInstance(){
        if(instance == null){
            return new BDConnector();
        }else{
            return instance;
        }
    }
    private void setParameters(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            preparedStatement.setObject(i + 1, parameters[i]);
        }
    }
}
