
package medicamentos.overthecounter.application;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import medicamentos.overthecounter.services.Db;

public class AvaliacaoController implements Initializable {
    Db conecta = new Db();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
        conecta.setMed(conecta.getConexao().createStatement().executeQuery("SELECT * FROM AVALIACAO"));
        conecta.RetornaAvaliação(conecta.getMed());
        
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
