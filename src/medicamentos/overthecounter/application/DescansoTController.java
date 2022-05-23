
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

public class DescansoTController implements Initializable {
    
    Db conecta = new Db();
    @FXML
    private void IniciarConsulta(ActionEvent event) {
        ProgramCliente.changeScreen("inicialCliente");
   
    }
    
    
    @FXML
    private void Institucional(ActionEvent event) {
         ProgramCliente.changeScreen("institicional");
        /*
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("Institucional.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Institucional");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DescansoTController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
 @FXML
    private void Avaliacao(ActionEvent event) throws SQLException {
	/*Sempre que clicar em cancelar, ela da a msg Tchau.*/
        String avaliacao = JOptionPane.showInputDialog(null, "Digite a sua avaliação", "Digite aqui...");
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='Dor de cabeça';"));
            conecta.NomeP(conecta.getMed());

        if (avaliacao == null) {
            JOptionPane.showMessageDialog(null, "Digite a sua avaliação!");
        } else {
            JOptionPane.showMessageDialog(null, "Avaliação recebida com sucesso.", "Mensagem recebida", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    }
}
