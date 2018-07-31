/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 181710089
 */
public class ObjCategoria {
    private int codigo;
    private String nome;

    public ObjCategoria() {
    }

    public ObjCategoria(String nome) {
        this.nome = nome;
    }

    public ObjCategoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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
    
    
    
    
}
