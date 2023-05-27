/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudjdbc.produtoDAO;

import classeProduto.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author murilo.scantante
 */
public class ProdutoDAO {
    
        public static boolean salvarProd(Produto obj){
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";
            
            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");
            
            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produto "
                        + "(nomeProd, descProd, catProd, validadeProd, qtdProd, valProd) VALUES(?,?,?,?,?,?)"); 
            
            
            comandoSQL.setString(1, obj.getNomeProduto());
            comandoSQL.setString(2, obj.getDescricao());
            comandoSQL.setString(3, obj.getCategoria());
            comandoSQL.setString(4, obj.getValidade());
            comandoSQL.setString(5, obj.getQuantidade());
            comandoSQL.setFloat(6, Float.parseFloat(obj.getValorProduto().replaceAll(",", ".")));
            
            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
                JOptionPane.showMessageDialog(null, "Produto Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao carregar o Driver" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, informe esta mensagem ao suporte: '" + ex.getMessage() + "' ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    
        return retorno;
    }
}
