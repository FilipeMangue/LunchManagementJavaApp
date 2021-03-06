
package mz.atarzan.sgv.model;
/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ModelUser {
    private int id;
    private String username;
    private String password;

    public ModelUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public ModelUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }  
}
