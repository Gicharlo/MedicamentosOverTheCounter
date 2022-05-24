/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package medicamentos.overthecounter.application;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.services.Db;

public class CestaController implements Initializable {

    Db conecta = new Db();
    PreparedStatement stmt;

    @FXML
    public void DordeCabeca(ActionEvent event) throws SQLException {
        ProgramCliente.changeScreen("dorDeCabeca");
    }

    @FXML
    public void AbrirCesta(ActionEvent event) {
        ProgramCliente.changeScreen("cesta");
    }

    @FXML
    private void CancelarConsulta(ActionEvent event) throws SQLException {
        ProgramCliente.changeScreen("mainScene");
    }

    private void Institucional(ActionEvent event) {
        ProgramCliente.changeScreen("institicional");
    }

    @FXML
    private void Avaliacao(ActionEvent event) throws SQLException {
   String avaliacao = JOptionPane.showInputDialog(null, "Digite a sua avaliação", "Digite aqui...");
        if (avaliacao == null) {
            JOptionPane.showMessageDialog(null, "Tchau...");
        } else {
            JOptionPane.showMessageDialog(null, "Avaliação recebida com sucesso.", "Mensagem recebida", JOptionPane.INFORMATION_MESSAGE);
            String sql = "INSERT INTO avaliacao (id_consulta, avaliacao )"
                    + "VALUES (NULL, '" + avaliacao + "');";
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.getConexao().prepareStatement(sql).execute();
        }
    }
    
   @FXML
    private void GerarToken(ActionEvent event) {
       System.out.println("oi");    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
