/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;

/**
 *
 * @author 181710089
 */
public class CategoriaDAO {
    public static void inserir(ObjCategoria cat){
        String sql = "INSERT INTO categorias "
                + " ( nome ) VALUES "
                + "( '" + cat.getNome() + "' )";
        Conexao.executar(sql);
        
    }
    
    public static void editar(ObjCategoria cat){
        String sql = "UPDATE categorias SET "
                + " nome = '" + cat.getNome() + "' "
                + " WHERE codigo = " + cat.getCodigo(); 
        Conexao.executar(sql);
        
    }
    
    public static void excluir(ObjCategoria cat){
        String sql = "DELETE FROM categorias "
                 + " WHERE codigo = " + cat.getCodigo(); 
        Conexao.executar(sql);
        
    }
    
    public static List<ObjCategoria> getCategorias(){
        List<ObjCategoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        
        if(rs != null){
            
            try {
                
                while( rs.next() ){
                    ObjCategoria cat = new ObjCategoria();
                    cat.setCodigo( rs.getInt(1) );
                    cat.setNome( rs.getString(2) );
                    lista.add(cat);
                    
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }
    public static ObjCategoria getCategoriaByCodigo(int codigo){
        ObjCategoria categoria = new ObjCategoria();
        
        String sql = "SELECT codigo, nome FROM categorias "
                   + "WHERE codigo = " + codigo;
        ResultSet rs = Conexao.consultar(sql);
        try {
            rs.first();
            categoria.setCodigo(rs.getInt( 1 ));
            categoria.setNome(rs.getString( 2 ));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
                
        return categoria;
    }
    
}
