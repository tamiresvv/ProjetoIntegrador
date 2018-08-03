
package model;


public class ObjLogin {
    
    
    private int codigo;
    private String nome;
    private String senha;

    public ObjLogin() {
    }

    public ObjLogin(String nome) {
        this.nome = nome;
    }

    public ObjLogin(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = nome;
    }
    
    public String toString(){
        return nome;
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
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
