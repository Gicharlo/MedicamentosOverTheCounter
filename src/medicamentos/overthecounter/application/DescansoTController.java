
package medicamentos.overthecounter.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class DescansoTController implements Initializable {
    

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
    /*
       @FXML
    private void Avaliaçao(ActionEvent event) {
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("Institucional.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Institucional");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DescansoTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    }
}
