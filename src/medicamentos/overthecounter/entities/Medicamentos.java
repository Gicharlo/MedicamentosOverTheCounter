package medicamentos.overthecounter.entities;

public class Medicamentos {

    private boolean ativado = false;

    private String nome;
    private String sintoma;
    private String principio_ativo;
    private String uso;
    private String doencas;
    private String partes_do_corpo;
    private String classificacao;
    private String descricao;
    private String preco;
    private int estoque;

    public Medicamentos(String nome, String preco, int estoque, boolean ativado) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.ativado = ativado;

    }


    public boolean isAtivado() {
        return ativado;
    }

    public void setAtivado(boolean ativado) {
        this.ativado = ativado;
    }

    public String getNome() {
        return nome;
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

    public String getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

}
