
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
import medicamentos.overthecounter.images.Images;
import medicamentos.overthecounter.services.Db;

/**
 * FXML Controller class
 *
 * @author giova
 */
public class SelecaoCabController implements Initializable {

    @FXML
    private ImageView med1;

    @FXML
    private ImageView med2;
    @FXML
    private ImageView med3;
    @FXML
    private ImageView med4;
    @FXML
    private ImageView med5;

    @FXML
    private Label lmed1;

    @FXML
    private Label lmed2;

    @FXML
    private Label lmed3;

    @FXML
    private Label lmed4;
    @FXML
    private Label lmed5;

    Db conecta = new Db();
    Images imagens = new Images();
    
        @FXML
    public void SelecionarMed(ActionEvent event) {
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("SelecaoMedicamento.fxml"));
            Parent root1 = ((Parent) tela2.load( ));
            Stage stage = new Stage();
            stage.setTitle("Cesta");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SelecaoCabController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        InputStream is = null;
        try {
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='Dor de cabeça';"));
            conecta.RetornaNomeMed(conecta.getMed());

            for (int i = 0; i < conecta.getNomesMed().size(); i++) {
                switch (i) {
                    case 0:
                        String nome = conecta.getNomesMed().get(i);
                        lmed1.setText(nome);
                        break;
                    case 1:
                        String nome2 = conecta.getNomesMed().get(i);
                        lmed2.setText(nome2);
                        break;
                    case 2:
                        String nome3 = conecta.getNomesMed().get(i);
                        lmed3.setText(nome3);
                        break;
                    default:
                        break;
                }
            }
            String[] dorflex = imagens.getDorflex().getName().split(".png");
            String[] doril = imagens.getDoril().getName().split(".png");
            String[] dipirona = imagens.getDipirona().getName().split(".png");
            String[] aspirina = imagens.getAspirina().getName().split(".png");
            String[] novalgina = imagens.getNeosaldina().getName().split(".png");
            
            if (lmed1.getText().contains(aspirina[0])||lmed2.getText().contains(aspirina[0]) ||lmed3.getText().contains(aspirina[0])) {
                is = new FileInputStream(imagens.getAspirina().getAbsolutePath());
                Image image = new Image(is);
                med1.setImage(image);
            }
            if (lmed1.getText().contains(dorflex[0])||lmed2.getText().contains(dorflex[0]) ||lmed3.getText().contains(dorflex[0])) {
                is = new FileInputStream(imagens.getDorflex().getAbsolutePath());
                Image image = new Image(is);
                med2.setImage(image);
            }
            if (lmed1.getText().contains(novalgina[0])||lmed2.getText().contains(novalgina[0]) ||lmed3.getText().contains(novalgina[0])) {
                is = new FileInputStream(imagens.getNeosaldina().getAbsolutePath());
                Image image = new Image(is);
                med3.setImage(image);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelecaoCabController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelecaoCabController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
