package ui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLimpiar;
    private JButton btnIngresar;
    private JPanel panel;
    Connection connection;

    public Login(){
        btnLimpiar.addActionListener(ActionListener -> {
            limpiar();
        });

        btnIngresar.addActionListener(ActionListener -> {
            try {
                validarCampos();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public JPanel getPanel(){
        return panel;
    }

    public void conectar(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login", "root", "truelove06");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void limpiar(){
        txtPassword.setText("");
        txtUsuario.setText("");
    }

    public void validarCampos() throws SQLException {
        conectar();
        String sql = "SELECT * FROM login WHERE usuario = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

       statement.setString(1, txtUsuario.getText());
       statement.setString(2, txtPassword.getText());

       ResultSet result = statement.executeQuery();

       if(result.next()) {
           JOptionPane.showMessageDialog(this.getPanel(), "Usuario encontrado");
       }else{
           JOptionPane.showMessageDialog(this.getPanel(), "Usuario no encontrado");
       }
       result.close();
       connection.close();
    }
}
