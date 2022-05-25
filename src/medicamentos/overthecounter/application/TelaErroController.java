/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package medicamentos.overthecounter.application;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.entities.Medicamentos;
import medicamentos.overthecounter.services.Db;


public class TelaErroController implements Initializable {
   Db conecta = new Db();
      
   Medicamentos sintomas = new Medicamentos();
    @FXML
    private TextField txtPesquisa;

      @FXML
    public void AbrirCesta(ActionEvent event) {
        ProgramCliente.changeScreen("cesta");
    }

    @FXML
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
    public void DordeCabeca(ActionEvent event) throws SQLException {
        ProgramCliente.changeScreen("dorDeCabeca");
    }
@FXML
    public void Busca(ActionEvent event) {
        sintomas.getSintoma().add("dor de cabeça");
        sintomas.getSintoma().add("gripe");
        sintomas.getSintoma().add("febre");
        sintomas.getSintoma().add("congestão");
        sintomas.getSintoma().add("dor abdoniminal");
        sintomas.getSintoma().add("dor de estomâgo");
        sintomas.getSintoma().add("dor de garganta");
        sintomas.getSintoma().add("dor muscular");

        for (int i = 0; i < sintomas.getSintoma().size(); i++) {
            if (sintomas.getSintoma().get(i).contains(txtPesquisa.getText())) {
                switch (txtPesquisa.getText()) {
                    case "dor de cabeça":
                         ProgramCliente.changeScreen("dorDeCabeca");
                        break;                     
                    default:
                       ProgramCliente.changeScreen("erro");
                       break;
                }
            } 
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
