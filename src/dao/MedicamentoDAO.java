package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCategoria;
import model.ObjMedicamento;

public class MedicamentoDAO {

    public static void inserir(ObjMedicamento med) {
        int dia = med.getData_de_cadastro().getDate();
        int mes = med.getData_de_cadastro().getMonth();
        int ano = med.getData_de_cadastro().getYear();
        String cadastro = "" + ano + "-" + (mes + 1) + "-" + dia;

        dia = med.getData_de_vencimento().getDate();
        mes = med.getData_de_vencimento().getMonth();
        ano = med.getData_de_vencimento().getYear();
        String vencimento = "" + ano + "-" + (mes + 1) + "-" + dia;

        String sql = "INSERT INTO medicamentos "
                + " ( nome, quantidade, data_de_cadastro, data_de_vencimento, codCategoria ) VALUES ("
                + " '" + med.getNome() + "' ,"
                + "  " + med.getQuantidade() + "  ,"
                + " '" + cadastro + "' ,"
                + " '" + vencimento + "' ,"
                + "  " + med.getCategoria().getCodigo() + "   "
                + " );";
        Conexao.executar(sql);

    }

    public static void editar(ObjMedicamento med) {

        int dia = med.getData_de_cadastro().getDate();
        int mes = med.getData_de_cadastro().getMonth();
        int ano = med.getData_de_cadastro().getYear();
        String cadastro = "" + ano + "-" + (mes + 1) + "-" + dia;

        dia = med.getData_de_vencimento().getDate();
        mes = med.getData_de_vencimento().getMonth();
        ano = med.getData_de_vencimento().getYear();
        String vencimento = "" + ano + "-" + (mes + 1) + "-" + dia;

        String sql = "UPDATE medicamentos SET "
                + " nome =               '" + med.getNome() + "' ,"
                + " quantidade =          " + med.getQuantidade() + "  ,"
                + " data_de_cadastro =   '" + cadastro + "' ,"
                + " data_de_vencimento = '" + vencimento + "' ,"
                + " codCategoria =        " + med.getCategoria().getCodigo() + "   "
                + " WHERE codigo =        " + med.getCodigo();
        Conexao.executar(sql);

    }

    public static void excluir(ObjMedicamento med) {
        String sql = "DELETE FROM medicamentos "
                + " WHERE codigo =  " + med.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjMedicamento> getMedicamentos() {
        List<ObjMedicamento> lista = new ArrayList<ObjMedicamento>();
        String sql = " SELECT m.codigo, c.codigo, m.nome, c.nome,        "
                + " m.quantidade,DATE_FORMAT( m.data_de_cadastro, '%d')AS DCADASTRO,DATE_FORMAT( m.data_de_cadastro, '%m')AS MCADASTRO,DATE_FORMAT( m.data_de_cadastro, '%Y')AS ACADASTRO, "
                + " DATE_FORMAT( m.data_de_vencimento, '%d')AS DVENCIMENTO , DATE_FORMAT( m.data_de_vencimento, '%m')AS MVENCIMENTO ,DATE_FORMAT( m.data_de_vencimento, '%Y')AS AVENCIMENTO  "
                + " FROM medicamentos m                                      "
                + " INNER JOIN categorias c ON m.codCategoria=c.codigo        "
                + " ORDER BY m.nome ";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {

            try {
                while (rs.next()) {
                    ObjMedicamento med = new ObjMedicamento();
                    med.setCodigo(rs.getInt(1));
                    med.setNome(rs.getString(3));
                    med.setQuantidade(rs.getDouble(5));
                    Date cadastro = new Date(rs.getInt(8), (rs.getInt(7) - 1), rs.getInt(6));
                    Date vencimento = new Date(rs.getInt(11), (rs.getInt(10) - 1), rs.getInt(9));
                    med.setData_de_cadastro(cadastro);
                    med.setData_de_vencimento(vencimento);

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

    public static ObjMedicamento getMedicamentoByCodigo(int codigo) {
        ObjMedicamento med = new ObjMedicamento();

        String sql = " SELECT m.codigo, c.codigo, m.nome, c.nome,        "
                + " m.quantidade,DATE_FORMAT( m.data_de_cadastro, '%d')AS DCADASTRO,DATE_FORMAT( m.data_de_cadastro, '%m')AS MCADASTRO,DATE_FORMAT( m.data_de_cadastro, '%Y')AS ACADASTRO, "
                + " DATE_FORMAT( m.data_de_vencimento, '%d')AS DVENCIMENTO , DATE_FORMAT( m.data_de_vencimento, '%m')AS MVENCIMENTO ,DATE_FORMAT( m.data_de_vencimento, '%Y')AS AVENCIMENTO  "
                + " FROM medicamentos m                                      "
                + " INNER JOIN categorias c ON m.codCategoria=c.codigo        "
                + " WHERE m.codigo = " + codigo
                + " ORDER BY m.nome ";
        ResultSet rs = Conexao.consultar(sql);
        try {
            rs.first();

            med.setCodigo(rs.getInt(1));
            med.setNome(rs.getString(3));
            med.setQuantidade(rs.getDouble(5));
            Date cadastro = new Date(rs.getInt(8), (rs.getInt(7) - 1), rs.getInt(6));
            Date vencimento = new Date(rs.getInt(11), (rs.getInt(10) - 1), rs.getInt(9));
            med.setData_de_cadastro(cadastro);
            med.setData_de_vencimento(vencimento);

            ObjCategoria cat = new ObjCategoria();
            cat.setCodigo(rs.getInt(2));
            cat.setNome(rs.getString(4));

            med.setCategoria(cat);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());

        }
        return med;

    }

}
