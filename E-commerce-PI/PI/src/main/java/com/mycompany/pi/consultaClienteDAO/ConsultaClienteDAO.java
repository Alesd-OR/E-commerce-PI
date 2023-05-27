/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pi.consultaClienteDAO;

import classeCliente.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angelo
 */
public class ConsultaClienteDAO {

    public static void pesquisar(JTable tabela) {

        ArrayList<Cliente> lista = ConsultaClienteDAO.listarCliente();

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        //Percorrer a lista e adicionar a tabela
        for (Cliente consumidor : lista) {
            modelo.addRow(new String[]{String.valueOf(consumidor.getId()), consumidor.getNome(), consumidor.getGenero(), consumidor.getCpf(), consumidor.getEmail(), consumidor.getEndereco(), consumidor.getTelefone()});
        }

    }

    public static void pesquisar(JTable tabela, String nome) {

        ArrayList<Cliente> lista = ConsultaClienteDAO.listarClienteNome(nome);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        //Percorrer a lista e adicionar a tabela
        for (Cliente consumidor : lista) {
            modelo.addRow(new String[]{String.valueOf(consumidor.getId()), consumidor.getNome(), consumidor.getGenero(), consumidor.getCpf(), consumidor.getEmail(), consumidor.getEndereco(), consumidor.getTelefone()});
        }
    }
    /**
     *
     * @param tabela
     * @param cpf
     */
    public static void pesquisarCpf(JTable tabela, String cpf) {

        ArrayList<Cliente> lista = ConsultaClienteDAO.listarClienteCpf(cpf);

        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        modelo.setRowCount(0);
        //Percorrer a lista e adicionar a tabela
        for (Cliente consumidor : lista) {
            modelo.addRow(new String[]{String.valueOf(consumidor.getId()), consumidor.getNome(), consumidor.getGenero(), consumidor.getCpf(), consumidor.getEmail(), consumidor.getEndereco(), consumidor.getTelefone()});
        }

    }

    /**
     *
     * @param nome
     * @return listaRetorno
     */
    public static ArrayList<Cliente> listarClienteNome(String nome) {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {
            //Carregar Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");

            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM cliente WHERE nomeClie LIKE ?");

            comandoSQL.setString(1, "%" + nome + "%");

            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                //Percorro o resultset ("tabela" na memória)
                //e passo os valores a um objeto
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nomeClie"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setGenero(rs.getString("genero"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));

                    listaRetorno.add(cliente);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao" + ex.getMessage());
        }

        return listaRetorno;

    }

    public static ArrayList<Cliente> listarClienteCpf(String cpf) {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {
            //Carregar Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");

            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM cliente WHERE cpf LIKE ?");

            comandoSQL.setString(1, "%" + cpf + "%");

            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                //Percorro o resultset ("tabela" na memória)
                //e passo os valores a um objeto
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nomeClie"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setGenero(rs.getString("genero"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));

                    listaRetorno.add(cliente);

                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao" + ex.getMessage());
        }

        return listaRetorno;

    }

    public static ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        Connection conexao = null;

        try {
            //Carregar Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");

            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("SELECT * FROM cliente");

            //Passo 4 - Executar o comando SQL
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                //Percorro o resultset ("tabela" na memória)
                //e passo os valores a um objeto
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getInt("id_cliente"));
                    cliente.setNome(rs.getString("nomeClie"));
                    cliente.setGenero(rs.getString("genero"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    cliente.setTelefone(rs.getString("telefone"));

                    listaRetorno.add(cliente);

                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao" + ex.getMessage());
        }

        return listaRetorno;

    }//Fim do método listar

    /**
     *
     * @param cliente
     * @return
     */
    public static boolean alterarCliente(Cliente cliente) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            //Carregar Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");

            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE cliente SET nomeClie = ?, genero = ?, cpf = ?, email = ?, endereco = ?, telefone = ? where id_cliente = ?");

            comandoSQL.setString(1, cliente.getNome());
            comandoSQL.setString(2, cliente.getGenero());
            comandoSQL.setString(3, cliente.getCpf());
            comandoSQL.setString(4, cliente.getEmail());
            comandoSQL.setString(5, cliente.getEndereco());
            comandoSQL.setString(6, cliente.getTelefone());
            comandoSQL.setInt(7, cliente.getId());

            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao" + ex.getMessage());
        }

        return retorno;

    }//Fim metodo alterar

    public static boolean excluirCliente(int id) {

        boolean retorno = false;
        Connection conexao = null;

        try {
            //Passo 1 - Carregaro o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/javamarketbd";

            //Passo 2 - Abrir a conexao
            conexao = DriverManager.getConnection(url, "root", "admin");

            //Passo 3 - Prepara o comando SQL
            PreparedStatement comandoSQL
                    = conexao.prepareStatement("DELETE FROM cliente WHERE id_cliente = ? ");

            comandoSQL.setInt(1, id);

            //Passo 4 - Executar comando SQL
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o Driver" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao abrir a conexao" + ex.getMessage());
        }

        return retorno;
    }//fim metodo excluir
}
