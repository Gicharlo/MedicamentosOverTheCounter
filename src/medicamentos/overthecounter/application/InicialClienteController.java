package medicamentos.overthecounter.application;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import medicamentos.overthecounter.entities.Filtro;
import medicamentos.overthecounter.entities.Medicamentos;
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
    private TextField txtPesquisa;

    Medicamentos sintomas = new Medicamentos();

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
    public void AbrirCesta(ActionEvent event) {
        ProgramCliente.changeScreen("cesta");
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
    public void DordeCabeca(ActionEvent event) throws SQLException {
        ProgramCliente.changeScreen("dorDeCabeca");

    }

    @FXML
    private void Institucional(ActionEvent event) {
        ProgramCliente.changeScreen("institicional");
    }

    @FXML
    private void CancelarConsulta(ActionEvent event) {
        ProgramCliente.changeScreen("main");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
