
package mz.atarzan.sgv.model;

/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ModelClient {
    int cod;
    boolean type;
    String name;
    int birth;
    String email;
    String tell;
    byte age;
    String address;
    String comment;

    public ModelClient(int cod, boolean type, String name, int birth, String email, String tell, byte age, String address, String comment) {
        this.cod = cod;
        this.type = type;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.tell = tell;
        this.age = age;
        this.address = address;
        this.comment = comment;
    }
    
    public ModelClient(boolean type, String name, int birth, String email, String tell, byte age, String address, String comment) {
        this.type = type;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.tell = tell;
        this.age = age;
        this.address = address;
        this.comment = comment;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
