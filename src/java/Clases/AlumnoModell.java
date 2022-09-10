package Clases;


public class AlumnoModell{
    private String code;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String tipo;
    
    public AlumnoModell(String code, String name, String address, String email, String phone, String tipo){
    this.code = code;
    this.name = name;
    this.address = address;
    this.email = email;
    this.phone = phone;
    this.tipo = tipo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
        public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
