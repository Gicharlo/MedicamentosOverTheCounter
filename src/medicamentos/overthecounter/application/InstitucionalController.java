
package medicamentos.overthecounter.application;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.services.Db;


public class InstitucionalController implements Initializable {
      Db conecta = new Db();
      
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
    private void Institucional(ActionEvent event) {
         ProgramCliente.changeScreen("institicional");
    }
    
    @FXML
    private void telaInicial(ActionEvent event) {
         ProgramCliente.changeScreen("inicialCliente");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
