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

    public ModelContas(String tipo, double valor, Date data, String referente_a) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.referente_a = referente_a;
    }
    
    
}
