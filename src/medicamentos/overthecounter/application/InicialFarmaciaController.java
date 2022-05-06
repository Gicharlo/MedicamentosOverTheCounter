
package medicamentos.overthecounter.application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicialFarmaciaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Institucional(ActionEvent event) {
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("Institucional.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Institucional");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicialFarmaciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void btncHistorico (ActionEvent event) {   
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("HistoricoConsulta.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Histórico de Consulta");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicialFarmaciaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }


    @FXML
    private void btncAtualizar(ActionEvent event) {

    }

    @FXML
    private void btncVisualizar(ActionEvent event) {

    }

}
