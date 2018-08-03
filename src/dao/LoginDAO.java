
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;
import model.ObjLogin;

public class LoginDAO {
    
    public static void inserir(ObjLogin log){
        String sql = "INSERT INTO login "
                + " ( nome )  VALUES  "
                + " ( senha ) VALUES "
                + "( '" + log.getNome() + "' )"
                + "( '" + log.getSenha()+ "' )";
        Conexao.executar(sql);
        
    }
    
    public static void editar(ObjLogin log){
        String sql = "UPDATE login SET "
                + " nome = '" + log.getNome() + "' "
                + " senha = '" + log.getSenha()+ "' "
                + " WHERE codigo = " + log.getCodigo(); 
        Conexao.executar(sql);
        
    }
    
    public static void excluir(ObjCategoria cat){
        String sql = "DELETE FROM login "
                 + " WHERE codigo = " + cat.getCodigo(); 
        Conexao.executar(sql);
        
    }
    
    public static List<ObjLogin> getLogin(){
        List<ObjLogin> lista = new ArrayList<>();
        String sql = "SELECT * FROM login ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        
        if(rs != null){
            
            try {
                
                while( rs.next() ){
                    ObjLogin log = new ObjLogin();
                    log.setCodigo( rs.getInt(1) );
                    log.setNome( rs.getString(2) );
                    log.setSenha(rs.getString(3) );
                    lista.add(log);
                    
                }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }
    
}
