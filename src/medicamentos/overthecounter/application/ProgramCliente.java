package medicamentos.overthecounter.application;

import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import medicamentos.overthecounter.services.Db;

public class ProgramCliente extends Application {

    private static Stage stage;
    private static Scene mainScene;
    private static Scene inicialClienteScene;
    private static Scene institucionalScene;
    private static Scene cestaScene;
    private static Scene dorDeCabecaScene;
    private static Scene cabecaSelecaoScene;
    private static Scene selecaoMedicamentCbScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

       // primaryStage.setTitle("Tela inicial");
        Parent main = FXMLLoader.load(getClass().getResource("DescansoT.fxml"));
        mainScene = new Scene(main);

        Parent inicialCliente = FXMLLoader.load(getClass().getResource("InicialCliente.fxml"));
        inicialClienteScene = new Scene(inicialCliente);

        Parent institucional = FXMLLoader.load(getClass().getResource("Institucional.fxml"));
        institucionalScene = new Scene(institucional);

        Parent dorDeCabeca = FXMLLoader.load(getClass().getResource("SelecaoCab.fxml"));
        dorDeCabecaScene = new Scene(dorDeCabeca);

        Parent cesta = FXMLLoader.load(getClass().getResource("Cesta.fxml"));
        cestaScene = new Scene(cesta);     
        
        Parent selecaoMedicamentoCb= FXMLLoader.load(getClass().getResource("SelecaoMedicamento.fxml"));
        selecaoMedicamentCbScene = new Scene(selecaoMedicamentoCb);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    public static void changeScreen(String scr) {
        switch (scr) {
            case "main":
                stage.setScene(mainScene);
                break;
            case "inicialCliente":
                stage.setScene(inicialClienteScene);
                break;
            case "institicional":
                stage.setScene(institucionalScene);
                break;
            case "cesta":
                stage.setScene(cestaScene);
                break;
            case "dorDeCabeca":
                stage.setScene(dorDeCabecaScene);
                break;
              case "cabecaSelecaoUn":
                stage.setScene( selecaoMedicamentCbScene);
                break;
                
               
        }
    }

    public static void main(String[] args) throws SQLException {
        launch(args);
        Db conecta = new Db();
    }
}
