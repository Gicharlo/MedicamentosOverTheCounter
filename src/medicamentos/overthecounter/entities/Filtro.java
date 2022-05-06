package medicamentos.overthecounter.entities;

import java.sql.DriverManager;
import java.sql.SQLException;
import medicamentos.overthecounter.services.Db;

public class Filtro {
    
    Db conecta = new Db();
    
    public Filtro(){
        
    }
    public void BarraCategorias(String sintoma) throws SQLException {
            conecta.setConexao(DriverManager.getConnection(conecta.getUrl()));
            conecta.setMed(conecta.getConexao().createStatement()
                    .executeQuery("SELECT * FROM MEDICAMENTO WHERE SINTOMA='" +
                                        sintoma+"'"));
            conecta.RetornaMed(conecta.getMed());
    }

}
