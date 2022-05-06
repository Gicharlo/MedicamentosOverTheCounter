package medicamentos.overthecounter.application;

import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import medicamentos.overthecounter.services.Db;

public class ProgramCliente extends Application {
    
 
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("DescansoT.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
        Db conecta = new Db();
        try {
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM MEDICAMENTO"));
            conecta.RetornaMed(conecta.getMed());
            
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco" + e.getMessage());
        } finally {
            if (conecta.getConexao() != null) {
                conecta.getConexao().close();
            }
        }
    }
}
