package medicamentos.overthecounter.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Db {
    private Connection conexao = null;
    private String url = "jdbc:mysql://localhost:3306/projeto?user=root&password=Giovanna@22";
    private ResultSet med;
    private List<String> nomesMed = new ArrayList<>();
    private List<String> avaliacoes = new ArrayList<>();
    private List<String> pAtivo = new ArrayList<>();
    private List<String> pcorpo = new ArrayList<>();
    private List<String> classi = new ArrayList<>();
    private List<String> modoUso = new ArrayList<>();
    private List<String> desc = new ArrayList<>();
    private List<String> doencasCom = new ArrayList<>();
    private List<String> preco = new ArrayList<>(); 
    private List<String> qtt = new ArrayList<>();
    private List<String> nomeC = new ArrayList<>();  
    private List<String> qttC = new ArrayList<>();   
    private List<String> qttTC = new ArrayList<>();   
    private List<String> precoqtt = new ArrayList<>();  
    private Map<String, String> nomeP = new HashMap<>();
    
     public List<String> getDoencasCom() {
        return doencasCom;
    }
    private PreparedStatement stmt;

    public void RetornaNomeMed(ResultSet med) throws SQLException {

        while (med.next()) {
            getpAtivo().add(med.getString("principio_ativo"));
            getModoUso().add(med.getString("modo_uso"));
            getDoencasCom().add(med.getString("problema"));
            getPcorpo().add(med.getString("partes_do_corpo"));
            getClassi().add(med.getString("classificacao"));
            getDesc().add(med.getString("descricao"));
            getNomesMed().add(med.getString("nome"));
            getPreco().add(med.getString("preco"));
             getQtt().add(med.getString("estoque"));

        }
    }
      public void RetornaAvalia????o(ResultSet med) throws SQLException {

        while (med.next()) {
         getAvaliacoes().add(med.getString("avaliacao"));
        }
    }

    public void NomeP(ResultSet med) throws SQLException {

        try {
            while (med.next()) {
                getNomeP().put(med.getString("nome"), med.getString("preco"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
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
    
   public List<String> getPrinAtivo() {
        return getpAtivo();
    }

    public List<String> getPreco() {
        return preco;
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

    /**
     * @return the nomeP
     */
    public Map<String, String> getNomeP() {
        return nomeP;
    }

    /**
     * @return the pAtivo
     */
    public List<String> getpAtivo() {
        return pAtivo;
    }


    public List<String> getModoUso() {
        return modoUso;
    }


    public List<String> getPcorpo() {
        return pcorpo;
    }

    public List<String> getClassi() {
        return classi;
    }
    public List<String> getDesc() {
        return desc;
    }
    public void setpAtivo(List<String> pAtivo) {
        this.pAtivo = pAtivo;
    }

    /**
     * @return the qtt
     */
    public List<String> getQtt() {
        return qtt;
    }

    /**
     * @return the avaliacoes
     */
    public List<String> getAvaliacoes() {
        return avaliacoes;
    }

    /**
     * @param avaliacoes the avaliacoes to set
     */
    public void setAvaliacoes(List<String> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    /**
     * @return the nomeC
     */
    public List<String> getNomeC() {
        return nomeC;
    }

    /**
     * @param nomeC the nomeC to set
     */
    public void setNomeC(List<String> nomeC) {
        this.nomeC = nomeC;
    }

    /**
     * @return the qttC
     */
    public List<String> getQttC() {
        return qttC;
    }

    /**
     * @param qttC the qttC to set
     */
    public void setQttC(List<String> qttC) {
        this.qttC = qttC;
    }

    /**
     * @return the qttTC
     */
    public List<String> getQttTC() {
        return qttTC;
    }

    /**
     * @param qttTC the qttTC to set
     */
    public void setQttTC(List<String> qttTC) {
        this.qttTC = qttTC;
    }
}
