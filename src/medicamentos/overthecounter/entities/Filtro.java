package medicamentos.overthecounter.entities;

import java.sql.DriverManager;
import java.sql.SQLException;
import medicamentos.overthecounter.services.Db;

public class Filtro {
    
    Db conecta = new Db();
    private String[] nomesMed = new String[20];
    public String sintoma;
    
    
    public Filtro(){
        
    }
    public void BarraCategorias(String s) throws SQLException {
         this.sintoma = s;   
    }

    /**
     * @return the nomesMed
     */
    public String[] getNomesMed() {
        return nomesMed;
    }

    /**
     * @param nomesMed the nomesMed to set
     */
    public void setNomesMed(String[] nomesMed) {
        this.nomesMed = nomesMed;
    }

    /**
     * @return the sintoma
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * @param sintoma the sintoma to set
     */
    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

}
