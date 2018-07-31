
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;
import model.ObjMedicamento;



public class MedicamentoDAO {
    public static void inserir(ObjMedicamento med){
        String sql = "INSERT INTO medicamentos "
                + " ( nome, quantidade, data_de_cadastro, data_de_vencimento, codCategoria ) VALUES ("
                + " '" + med.getNome()                  + "' ,"
                + " '" + med.getQuantidade()            + "' ,"
                + " '" + med.getData_de_cadastro()      + "' ,"
                + " '" + med.getData_de_vencimento()    + "' ,"
                + "  " + med.getCategoria().getCodigo() + "   "
                + " );";
        Conexao.executar(sql);
        
    }
    
    public static void editar(ObjMedicamento med){
        String sql = "UPDATE medicamentos SET "              
                + " nome =               '"  + med.getNome()                  + "' ,"
                + " quantidade =         '"  + med.getQuantidade()            + "' ,"
                + " data_de_cadastro =   '"  + med.getData_de_cadastro()      + "' ,"
                + " data_de_vencimento = '"  + med.getData_de_vencimento()    + "' ,"
                + " codCategoria =        "  + med.getCategoria().getCodigo() + "   "
                + " WHERE codigo =        "  + med.getCodigo();
        Conexao.executar(sql);
        
    }
    
    public static void excluir(ObjMedicamento med){
        String sql = "DELETE FROM medicamentos "              
                + " WHERE codigo =  "  + med.getCodigo();
        Conexao.executar(sql);
        
    }    
    
    public static List<ObjMedicamento> getMedicamentos(){
        List<ObjMedicamento> lista = new ArrayList<ObjMedicamento>();
        String sql = " SELECT m.codigo, c.codigo, m.nome, c.nome,        "  
                + " m.quantidade, m.data_de_cadastro, m.data_de_vencimento "
                + " FROM medicamento m                                      "
                + " INNER JOIN categorias c ON p.codCategoria=c.codigo        "
                + " ORDER BY m.nome ";
        ResultSet rs = Conexao.consultar(sql);
        
        if( rs != null){
            
            try {
                while(rs.next()){
                    ObjMedicamento med = new ObjMedicamento();
                    med.setCodigo(rs.getInt(1));
                    med.setNome(rs.getString(3));
                    med.setQuantidade(rs.getDouble(5));
                    med.setData_de_cadastro(rs.getDate(6));
                    med.setData_de_vencimento(rs.getDate(7));
                    
                    
                    
                    ObjCategoria cat = new ObjCategoria();
                    cat.setCodigo(rs.getInt(2));
                    cat.setNome(rs.getString(4));
                    
                    med.setCategoria(cat);
                    
                    lista.add(med);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    
}
