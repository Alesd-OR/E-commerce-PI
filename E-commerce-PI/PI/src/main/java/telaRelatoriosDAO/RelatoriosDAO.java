/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telaRelatoriosDAO;

import com.mycompany.pi.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author murilo.scantante
 */
public class RelatoriosDAO {
           
    public static boolean salvar(Cliente obj){
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/javamarketbd";
            
            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO cliente "
                        + "(nomeClie, genero, cpf, email, endereco, telefone) VALUES(?,?,?,?,?,?)"); 
            
            
            comandoSQL.setString(1, obj.getNome());
            comandoSQL.setString(2, obj.getGenero());
            comandoSQL.setString(3, obj.getCpf());
            comandoSQL.setString(4, obj.getEmail());
            comandoSQL.setString(5, obj.getEndereco());
            comandoSQL.setString(6, obj.getTelefone());
            
            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
                JOptionPane.showMessageDialog(null, "Cliente Cadastrado", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao" + ex.getMessage());
        }
        
    
        return retorno;
    }
}
