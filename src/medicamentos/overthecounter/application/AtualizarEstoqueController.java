package medicamentos.overthecounter.application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.entities.Medicamentos;
import medicamentos.overthecounter.services.Db;

public class AtualizarEstoqueController implements Initializable {

    Db conecta = new Db();
    @FXML
    private TableView<Medicamentos> tabela;
    @FXML
    private TableColumn<Medicamentos, Boolean> checkbox;
    @FXML
    private TableColumn<Medicamentos, String> produto;
    @FXML
    private TableColumn<Medicamentos, Float> preco;
    @FXML
    private TableColumn<Medicamentos, Integer> quantidade;

    private List<Medicamentos> ListMedicamentos = new ArrayList();
    Medicamentos med;
    private ObservableList<Medicamentos> observableListMedicamentos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            checkbox.setCellValueFactory(new PropertyValueFactory<>("ativado"));
            produto.setCellValueFactory(new PropertyValueFactory<>("nome"));
            preco.setCellValueFactory(new PropertyValueFactory<>("preco"));
            quantidade.setCellValueFactory(new PropertyValueFactory<>("estoque"));
            checkbox.setCellFactory(CheckBoxTableCell.forTableColumn(checkbox));

            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO"));
            conecta.RetornaNomeMed(conecta.getMed());
             System.out.println(conecta.getNomesMed());

            for (int i = 0; i < conecta.getNomesMed().size(); i++) {
                String medb = conecta.getNomesMed().get(i);
                String precob = conecta.getPreco().get(i);
                String qtt = conecta.getQtt().get(i);
                ListMedicamentos.add(new Medicamentos(medb, precob, qtt));
            }
     
            observableListMedicamentos = FXCollections.observableArrayList(ListMedicamentos);
            tabela.setItems(observableListMedicamentos);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarTableViewMedicamentos() throws SQLException {

        /*
        Medicamentos m1 = new Medicamentos("dipirona", "R$ 30,00", 18, false);
        Medicamentos m2 = new Medicamentos( "daproxeno", "R$ 12,00", 0, false);
        Medicamentos m3 = new Medicamentos("saproxeno", "R$ 12,25", 0, false);
        Medicamentos m4 = new Medicamentos( "faproxeno", "R$ 13,35", 0, false);
        Medicamentos m5 = new Medicamentos("faproxeno", "R$ 10,50", 0, false);
        Medicamentos m6 = new Medicamentos("aaproxeno", "R$ 58,54", 0, false);
        Medicamentos m7 = new Medicamentos( "naproxeno", "R$ 5,50", 0, false);
        Medicamentos m8 = new Medicamentos( "gaproxeno", "R$ 1,50", 0, false);
        Medicamentos m9 = new Medicamentos( "qaproxeno", "R$ 14,56", 0, false);
        Medicamentos m10 = new Medicamentos("vaproxeno", "R$ 18,55", 0, false);
        Medicamentos m11 = new Medicamentos("saproxeno", "R$ 6,65", 0, false);

        ListMedicamentos.add(m1);
        ListMedicamentos.add(m2);
        ListMedicamentos.add(m3);
        ListMedicamentos.add(m4);
        ListMedicamentos.add(m5);
        ListMedicamentos.add(m6);
        ListMedicamentos.add(m7);
        ListMedicamentos.add(m8);
        ListMedicamentos.add(m9);
        ListMedicamentos.add(m10);
        ListMedicamentos.add(m11);
        
         */
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
    private void Avaliacao(ActionEvent event) throws SQLException {
        /*Sempre que clicar em cancelar, ela da a msg Tchau.*/
        String avaliacao = JOptionPane.showInputDialog(null, "Digite a sua avaliação", "Digite aqui...");
        if (avaliacao == null) {
            JOptionPane.showMessageDialog(null, "Tchau...");
        } else {
            JOptionPane.showMessageDialog(null, "Avaliação recebida com sucesso.", "Mensagem recebida", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @FXML
    private void btncHistorico(ActionEvent event) {
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
        try {
            FXMLLoader tela2 = new FXMLLoader(getClass().getResource("AtualizarEstoque.fxml"));
            Parent root1 = ((Parent) tela2.load());
            Stage stage = new Stage();
            stage.setTitle("Atualizar Estoque");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(InicialFarmaciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btncVisualizar(ActionEvent event) {

    }

    @FXML
    private void btncAdicionar(ActionEvent event) {

    }

    @FXML
    private void btncAlterar(ActionEvent event) {

    }

    @FXML
    private void btncRemover(ActionEvent event) {

    }

}
