package mz.atarzan.sgv.model;
/**
 * @author Filipe Emanuel Da Julieta Hafo Mangue
 */
public class ModelProductsProvider {
    String name;
    String contact;
    String address;
    String product;

    public ModelProductsProvider(String name, String contact, String address,String product) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
    
    
}
