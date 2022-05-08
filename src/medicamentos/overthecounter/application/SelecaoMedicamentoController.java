/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package medicamentos.overthecounter.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.images.Images;
import medicamentos.overthecounter.services.Db;

/**
 * FXML Controller class
 *
 * @author giova
 */
public class SelecaoMedicamentoController implements Initializable {

    Db conecta = new Db();
    Images imagens = new Images();

    @FXML
    private Label titulo;
    
    @FXML
    private ImageView img1;

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

    @FXML
    private void Avaliacao(ActionEvent event) throws SQLException {
        /*Sempre que clicar em cancelar, ela da a msg Tchau.*/
        String avaliacao = JOptionPane.showInputDialog(null, "Digite a sua avaliação", "Digite aqui...");
        conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
        conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='Dor de cabeça';"));
        conecta.NomeP(conecta.getMed());

        if (avaliacao == null) {
            JOptionPane.showMessageDialog(null, "Tchau...");
        } else {
            JOptionPane.showMessageDialog(null, "Avaliação recebida com sucesso.", "Mensagem recebida", JOptionPane.INFORMATION_MESSAGE);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         InputStream is = null;
        try {            
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='Dor de cabeça';"));
            conecta.RetornaNomeMed(conecta.getMed());

            String tl = conecta.getNomesMed().get(0);
            titulo.setText(tl);
            String[] aspirina = imagens.getAspirina().getName().split(".png");
             is = new FileInputStream(imagens.getAspirina().getAbsolutePath());
             Image image = new Image(is);
             img1.setImage(image);
                
         
             
             
        } catch (SQLException ex) {
            Logger.getLogger(SelecaoMedicamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelecaoMedicamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
