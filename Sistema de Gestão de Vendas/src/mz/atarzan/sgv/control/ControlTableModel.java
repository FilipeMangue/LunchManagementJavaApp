package mz.atarzan.sgv.control;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public final class ControlTableModel extends AbstractTableModel{
    private ArrayList lines = null;
    private String[] columns = null;

    public ControlTableModel(ArrayList lines, String[] columns) {
        setLinhas(lines);
        setColunas(columns);
    }

    public ArrayList getLinhas() {
        return lines;
    }

    public void setLinhas(ArrayList lines) {
        this.lines = lines;
    }

    public String[] getColunas() {
        return columns;
    }

    public void setColunas(String[] columns) {
        this.columns = columns;
    }

    public int getRowCount() {
        return lines.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int numCol) {
        return columns[numCol];
    }

    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }
}
