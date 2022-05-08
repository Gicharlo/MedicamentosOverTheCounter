package medicamentos.overthecounter.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Db {
    
    private Connection conexao = null;
    private String url = "jdbc:mysql://localhost:3306/db_projeto?user=root&password=Giovanna@22";
    private ResultSet med;
    private List<String> nomesMed = new ArrayList<>();
    private PreparedStatement stmt;
    
    public void RetornaMed(ResultSet med) throws SQLException{
       
         while(med.next()){
              getNomesMed().add(med.getString("nome"));      
            }
    }
    public String getUrl() {
        return url;
    }

    /**
     * @return the med
     */
    public ResultSet getMed() {
        return med;
    }

    /**
     * @return the conexao
     */
    public Connection getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param med the med to set
     */
    public void setMed(ResultSet med) {
        this.med = med;
    }

    /**
     * @return the nomesMed
     */
    public List<String> getNomesMed() {
        return nomesMed;
    }

    /**
     * @param nomesMed the nomesMed to set
     */
    public void setNomesMed(List<String> nomesMed) {
        this.nomesMed = nomesMed;
    }

    /**
     * @return the stmt
     */
    public PreparedStatement getStmt() {
        return stmt;
    }
}

