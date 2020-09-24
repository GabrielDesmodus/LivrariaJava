import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Comprador {
	
	private int id_comprador;
	private String nome;
	private String cpf;
	
	public int getId_comprador() {
		return id_comprador;
	}

	public void setId_comprador(int id_comprador) {
		this.id_comprador = id_comprador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void Incluir() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        
        String SqlCom = "select cpf from comprador where cpf = '" + getCpf() +"'";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        
        if(resultado.next()) {
        	JOptionPane.showMessageDialog(null,"Esse CPF já foi registrado!");
        }else {
        	String Sql = "insert into comprador values(" + getId_comprador() + ",'" + getNome() + "','" + getCpf() + "')";
            PreparedStatement comando2 = (PreparedStatement) conn.prepareStatement(Sql);
            comando2.execute();
            comando2.close();
            JOptionPane.showMessageDialog(null,"Comprador registrado");
        }
    }
    
    public void Consultar() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        Connection conn = (Connection) DriverManager.getConnection(url, usuario, senha);
        String SqlCom = "select * from comprador";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        ArrayList<String> registros = new ArrayList<>();
        while(resultado.next())
        {
            registros.add(("ID: " + resultado.getString("id_comprador") + 
                    " | Nome: " + resultado.getString("nome") + " " +
                    " | CPF: " + resultado.getString("cpf")));
        }
        String lista = "";
        int j;
        for(j=0; j<registros.size(); j++) {
            lista = lista + registros.get(j) + "\n";
        }
        JOptionPane.showMessageDialog(null, lista);
        resultado.close();
        comando.close();
        conn.close();
    }
    
    public void Pesquisar() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        Connection conn = (Connection) DriverManager.getConnection(url, usuario, senha);
        String SqlCom = "select * from comprador where id_comprador = " + getId_comprador();
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        resultado.next();
        setNome(resultado.getString("nome"));
        setCpf(resultado.getString("cpf"));

        resultado.close();
        comando.close();
        conn.close();
    }
    
    public void Alterar() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        
        String Sql = "update comprador set nome = '" + getNome() + "', cpf = '" + getCpf() 
                + "' where id_comprador = " + getId_comprador();
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        comando.close();
        JOptionPane.showMessageDialog(null,"Comprador alterado");
    }
    
    public void Excluir() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        String Sql = "delete from comprador where id_comprador = " + getId_comprador();
        if(JOptionPane.showConfirmDialog(null, "Confirma exclusão ?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == 0) 
        {
        	PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        	comando.execute();
        	comando.close();       
        	JOptionPane.showMessageDialog(null,"Comprador excluído");
        }
        else
        	JOptionPane.showMessageDialog(null,"Exclusão de comprador cancelada");
    }
}
