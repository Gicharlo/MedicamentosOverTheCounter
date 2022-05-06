package medicamentos.overthecounter.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {
    
    private Connection conexao = null;
    private String url = "jdbc:mysql://localhost:3306/db_projeto?user=root&password=Giovanna@22";
    private ResultSet med;

    /**
     * @return the url
     */
    public void RetornaMed(ResultSet med) throws SQLException{  
         /*while (med.next()) {
                System.out.println("Nome:" + med.getString("nome"));
            }*/
         while(med.next()){
              System.out.println("Nome:" + med.getString("nome"));
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
     
    
  
}

