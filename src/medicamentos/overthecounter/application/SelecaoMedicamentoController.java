/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package medicamentos.overthecounter.application;

import java.awt.Desktop;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.images.Images;
import medicamentos.overthecounter.services.Db;
import java.io.File;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import medicamentos.overthecounter.entities.Medicamentos;
import medicamentos.overthecounter.pdf.Bulas;

public class SelecaoMedicamentoController implements Initializable {

    Db conecta = new Db();
    Images imagens = new Images();
    Bulas bula = new Bulas();

    @FXML
    private Label titulo;
    @FXML
    private Label prinAtivo;
    @FXML
    private Label partesCorpo;
    @FXML
    private Label classeMed;
    
    @FXML
    private Label txtCesta;

    @FXML
    private Label doencasCom;

    @FXML
    private Label modoUso;

    @FXML
    private Label preco;
    
    @FXML
    private Spinner<Integer> qttU;
    
    int correntValue;
    
    @FXML
    private Label descricao;

    @FXML
    private ImageView img1;
       @FXML
    private TextField txtPesquisa;

    Medicamentos sintomas = new Medicamentos();

    @FXML
    public void AbrirCesta(ActionEvent event) {
        ProgramCliente.changeScreen("cesta");
    }

    @FXML
    private void Institucional(ActionEvent event) {
        ProgramCliente.changeScreen("institicional");
    }

    @FXML
    private void CancelarConsulta(ActionEvent event) {
        ProgramCliente.changeScreen("mainScene");
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
    public void Bula(ActionEvent event) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        File file = new File(bula.getAspirina());
        desktop.open(file);
    }

    @FXML
    public void EncaminharMedCesta(ActionEvent event) throws SQLException {
    
        titulo.getText();
        preco.getText();
        qttU.getValue();

        String sql;
        sql = "INSERT INTO consulta (id, nome, preco, quantidade)"
                + "VALUES (NULL, '" + titulo.getText()
                + "', '"+ preco.getText() 
                + "', '" + qttU.getValue() 
                + "');";
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.getConexao().prepareStatement(sql).execute();
            txtCesta.setText("Produto Adicionado na Cesta");
            
       // ProgramCliente.changeScreen("dorDeCabeca");
    }  
      @FXML
    public void DordeCabeca(ActionEvent event) throws SQLException {
        ProgramCliente.changeScreen("dorDeCabeca");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            InputStream is;
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='Dor de cabeça';"));
            conecta.RetornaNomeMed(conecta.getMed());

            String tl = conecta.getNomesMed().get(0);
            String pAtivo = conecta.getPrinAtivo().get(0);
            String Pcorpo = conecta.getPcorpo().get(0);
            String classi = conecta.getClassi().get(0);
            String modoUsoL = conecta.getModoUso().get(0);
            String desc = conecta.getDesc().get(0);
            String doencas = conecta.getDoencasCom().get(0);
            String precoL = conecta.getPreco().get(0);

            titulo.setText(tl);
            prinAtivo.setText(pAtivo);
            partesCorpo.setText(Pcorpo);
            classeMed.setText(classi);
            doencasCom.setText(doencas);
            preco.setText("R$" + precoL);
            modoUso.setText(modoUsoL);
            descricao.setText(desc);

            String[] aspirina = imagens.getAspirina().getName().split(".png");
            is = new FileInputStream(imagens.getAspirina().getAbsolutePath());
            Image image = new Image(is);
            img1.setImage(image);
            
          SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);
         value.setValue(1);
         qttU.setValueFactory(value);
         
        } catch (SQLException ex) {
            Logger.getLogger(SelecaoMedicamentoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelecaoMedicamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
