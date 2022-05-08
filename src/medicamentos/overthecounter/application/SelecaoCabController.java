/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package medicamentos.overthecounter.application;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        InputStream is = null;
        try {
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='Dor de cabeça';"));
            conecta.RetornaMed(conecta.getMed());

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
            String frase = imagens.getDorflex().getName();
            String[] parts = frase.split(".png");
            String nome = parts[0];

            if (nome.contains(lmed1.getText())) {
            is = new FileInputStream(imagens.getDorflex().getAbsolutePath());
            Image image = new Image(is);
            med1.setImage(image);
            
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelecaoCabController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SelecaoCabController.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }
}
