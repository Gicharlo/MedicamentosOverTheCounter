package medicamentos.overthecounter.application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.entities.Filtro;
import medicamentos.overthecounter.services.Db;

public class InicialClienteController implements Initializable {

    @FXML
    private MenuItem m1;
    @FXML
    private MenuItem m2;
    @FXML
    private MenuItem m3;
    @FXML
    private MenuItem m4;
    @FXML
    private MenuItem m5;
    
    @FXML
    private MenuItem m7;
    
    @FXML
    private MenuItem m8;

    Filtro filt = new Filtro();
    Db conecta = new Db();
    
    @FXML
    private Label lmed1;
    
    
@FXML
    private void Avaliacao(ActionEvent event) {
	/*Sempre que clicar em cancelar, ela da a msg Tchau.*/
        String avaliacao = JOptionPane.showInputDialog(null, "Digite a sua avaliação", "Digite aqui...");
        if (avaliacao == null) {
            JOptionPane.showMessageDialog(null, "Tchau...");
        } else {
            JOptionPane.showMessageDialog(null, "Avaliação recebida com sucesso.", "Mensagem recebida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

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
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("SelecaoCab.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Medicamentos");
            stage.setScene(new Scene(root1));
            stage.show();
  
 
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
