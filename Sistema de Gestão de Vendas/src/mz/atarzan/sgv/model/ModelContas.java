package mz.atarzan.sgv.model;
import java.sql.Date;

/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ModelContas {
    String tipo;
    double valor;
    Date data;
    String referente_a;
    boolean estado;

    public ModelContas(String tipo, double valor, Date data, String referente_a, boolean estado) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.referente_a = referente_a;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getReferente_a() {
        return referente_a;
    }

    public void setReferente_a(String referente_a) {
        this.referente_a = referente_a;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
