import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Compras {
	private int id_livros;
	private int id_comprador;
	private int id_compra;
	private int qtd;
	private String data;
	private String Cpf;

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public int getId_livros() {
		return id_livros;
	}

	public void setId_livros(int id_livros) {
		this.id_livros = id_livros;
	}

	public int getId_comprador() {
		return id_comprador;
	}

	public void setId_comprador(int id_comprador) {
		this.id_comprador = id_comprador;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

	public int getId_compra() {
		return id_compra;
	}

	public void setId_compra(int id_compra) {
		this.id_compra = id_compra;
	}

	public void Incluir() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        String Sql = "insert into compra(id_livros,id_comprador,qtd,data) values(" 
                + getId_livros() + ",(SELECT id_comprador from comprador where cpf="+ getCpf() +")," + getQtd() + ", CURRENT_TIMESTAMP () )";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        comando.close();
        JOptionPane.showMessageDialog(null,"Compra registrada");
    }
	
	public void Consultar() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        Connection conn = (Connection) DriverManager.getConnection(url, usuario, senha);
        String SqlCom = "select * from compra";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        ArrayList<String> registros = new ArrayList<>();
        while(resultado.next())
        {
        	String dt = resultado.getString("data");
            dt = dt.substring(8,10) + "/" + dt.substring(5,7) + "/" + dt.substring(0,4);
            registros.add("ID da transação: " + resultado.getString("id_compra") +
            		
            		" | ID do livro: " + resultado.getString("id_livros") + 
                    " | ID do comprador: " + resultado.getString("id_comprador") + 
                    " | Quantidade: " + resultado.getString("qtd") + 
                    " | Data: " + dt);
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
	        String SqlCom = "select * from compra where id_compra = " + getId_compra();
	        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
	        ResultSet resultado = comando.executeQuery();
	        resultado.next();
	        setId_livros(Integer.parseInt(resultado.getString("id_livros")));
	        setId_comprador(Integer.parseInt(resultado.getString("id_comprador")));
	        setId_compra(Integer.parseInt(resultado.getString("id_compra")));
	        setQtd(Integer.parseInt(resultado.getString("qtd")));
	        
	        resultado.close();
	        comando.close();
	        conn.close();
	    }
	  
	  public void Excluir() throws SQLException {
	        String usuario = "root";
	        String senha = "";
	        String url = "jdbc:mysql://localhost/bookshop";
	        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	        String Sql = "delete from compra where id_compra = " + getId_compra();
	        if(JOptionPane.showConfirmDialog(null, "Confirma cancelamento ?", "Atenção", JOptionPane.OK_CANCEL_OPTION) == 0) 
	        {
	        	PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	        	comando.execute();
	        	comando.close();       
	        	JOptionPane.showMessageDialog(null,"Compra cancelada");
	        }
	        else
	        	JOptionPane.showMessageDialog(null,"Compra não cancelada");
	    }
}

