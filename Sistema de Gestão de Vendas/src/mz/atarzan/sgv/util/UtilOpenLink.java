package mz.atarzan.sgv.util;

import java.awt.Desktop;
import java.net.URI;

/**
 *
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 * @author Explicador Inc, Lda.
 */
public class UtilOpenLink {
    public static void contactInfo() {
        try {
            URI link = URI.create("https://linkedin.com/in/filipe-mangue-614405143/");
            Desktop.getDesktop().browse(link);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
