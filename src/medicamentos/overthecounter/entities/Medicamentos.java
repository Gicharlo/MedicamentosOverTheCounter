package medicamentos.overthecounter.entities;



public class Medicamentos {

    private boolean ativado = false;
    private String nome;
    private String preco;
    private String qtt;
    private String sintoma;
    private String principio_ativo;
    private String uso;
    private String doencas;
    private String partes_do_corpo;
    private String classificacao;
    private String descricao;

    private int estoque;

    public Medicamentos(String nome, String preco, String qtt) {
         this.nome = nome;
         this.preco = preco;
         this.qtt = qtt;

    }

    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

 

    public String getSintoma() {
        return sintoma;
    }

    public String getPrincipio_ativo() {
        return principio_ativo;
    }

    public String getUso() {
        return uso;
    }

    public String getDoencas() {
        return doencas;
    }

    public String getPartes_do_corpo() {
        return partes_do_corpo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the preco
     */
    public String getPreco() {
        return preco;
    }

    /**
     * @return the qtt
     */
    public String getQtt() {
        return qtt;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @param qtt the qtt to set
     */
    public void setQtt(String qtt) {
        this.qtt = qtt;
    }

}
