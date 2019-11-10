package mz.atarzan.sgv.model;
/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ModelFornecedores {
    int codigo;
    String nome;
    String endereco;
    String telemovel;
    String pais;
    String data_de_registo;
    String registado_por;
    String alterado_por;
    String alterado_em;
    String email;

    public ModelFornecedores(int codigo, String nome, String endereco, String telemovel, String pais, String data_de_registo, String registado_por, String alterado_por, String alterado_em, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telemovel = telemovel;
        this.pais = pais;
        this.data_de_registo = data_de_registo;
        this.registado_por = registado_por;
        this.alterado_por = alterado_por;
        this.alterado_em = alterado_em;
        this.email = email;
    }

    public ModelFornecedores(String nome, String endereco, String telemovel, String pais, String data_de_registo, String registado_por, String alterado_por, String alterado_em, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telemovel = telemovel;
        this.pais = pais;
        this.data_de_registo = data_de_registo;
        this.registado_por = registado_por;
        this.alterado_por = alterado_por;
        this.alterado_em = alterado_em;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getData_de_registo() {
        return data_de_registo;
    }

    public void setData_de_registo(String data_de_registo) {
        this.data_de_registo = data_de_registo;
    }

    public String getRegistado_por() {
        return registado_por;
    }

    public void setRegistado_por(String registado_por) {
        this.registado_por = registado_por;
    }

    public String getAlterado_por() {
        return alterado_por;
    }

    public void setAlterado_por(String alterado_por) {
        this.alterado_por = alterado_por;
    }

    public String getAlterado_em() {
        return alterado_em;
    }

    public void setAlterado_em(String alterado_em) {
        this.alterado_em = alterado_em;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
