
package medicamentos.overthecounter.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.entities.Medicamentos;
import medicamentos.overthecounter.images.Images;
import medicamentos.overthecounter.services.Db;

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
    private TextField txtPesquisa;

    Medicamentos sintomas = new Medicamentos();
    
       @FXML
    private void Institucional(ActionEvent event) {
        ProgramCliente.changeScreen("institicional");
    }
    
    @FXML
    public void AbrirCesta(ActionEvent event) {
        ProgramCliente.changeScreen("cesta");
    }
    @FXML
    private void CancelarConsulta(ActionEvent event) {
        ProgramCliente.changeScreen("main");
    }
    @FXML
     private void telaInicial(ActionEvent event) {
         ProgramCliente.changeScreen("inicialCliente");
    }
     
    @FXML
    public void DordeCabeca(ActionEvent event) throws SQLException {
          ProgramCliente.changeScreen("dorDeCabeca");

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
    
        @FXML
    public void SelecionarMed(ActionEvent event) {
    ProgramCliente.changeScreen("cabecaSelecaoUn");
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
