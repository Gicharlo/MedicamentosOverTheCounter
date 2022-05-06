package medicamentos.overthecounter.application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import medicamentos.overthecounter.entities.Filtro;

public class InicialClienteController implements Initializable {

    MenuItem mi1 = new MenuItem("Dor de Cabeça");

    Filtro filt = new Filtro();

    @FXML
    public void AbrirCesta(ActionEvent event) {
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("Cesta.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Cesta");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DescansoTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void DordeCabeca(ActionEvent event) throws SQLException {
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("SelecaoMed.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Medicamentos");
            stage.setScene(new Scene(root1));
            stage.show();
            String categoria = mi1.getText();
            filt.BarraCategorias(categoria);

        } catch (IOException ex) {
            Logger.getLogger(DescansoTController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(DescansoTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void CancelarConsulta(ActionEvent event) {
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("DescansoT.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Descanso");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DescansoTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
