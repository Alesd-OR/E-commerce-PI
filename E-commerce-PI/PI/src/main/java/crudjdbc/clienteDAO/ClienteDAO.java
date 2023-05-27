/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudjdbc.clienteDAO;

import classeCliente.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Murilo
 */
public class ClienteDAO {
    
  
    public static boolean salvar(Cliente obj){
        
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";
            
            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");
            
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
            JOptionPane.showMessageDialog(null,"Erro ao carregar o Driver" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados, informe esta mensagem ao suporte: '" + ex.getMessage() + "' ", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    
        return retorno;
    }//fim do método salvar
    
    
}
