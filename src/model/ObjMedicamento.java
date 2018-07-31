
package model;

import java.util.Date;


public class ObjMedicamento {
    private int codigo; 
    private double quantidade; 
    private String nome;
    private ObjCategoria categoria;
    private Date data_de_cadastro , data_de_vencimento;
   
    public ObjMedicamento() { 
    }

   
    public ObjMedicamento(String nome) { 
        this.nome = nome;
    }

    public ObjMedicamento(int codigo, double quantidade, String nome, String tipo,Date data_de_cadastro,Date data_de_vencimento) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.nome = nome;
        this.categoria = categoria; 
        this.data_de_cadastro =  data_de_cadastro; 
        this.data_de_vencimento= data_de_vencimento; 
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


    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ObjCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(ObjCategoria categoria) {
        this.categoria = categoria;
    }

    public Date getData_de_cadastro() {
        return data_de_cadastro;
    }

    public void setData_de_cadastro(Date data_de_cadastro) {
        this.data_de_cadastro = data_de_cadastro;
    }

    public Date getData_de_vencimento() {
        return data_de_vencimento;
    }

    public void setData_de_vencimento(Date data_de_vencimento) {
        this.data_de_vencimento = data_de_vencimento;
    }
    

  


    
    
    
}
