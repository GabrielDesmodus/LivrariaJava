import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Livros {
	private int id_livros;
    private String nome;
    private int ano;
    private String autor;
    private String tipo;
    private String genero;
    private float pre�o;
         
    public int getId_livros() {
		return id_livros;
	}



	public void setId_livros(int id_livros) {
		this.id_livros = id_livros;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getAno() {
		return ano;
	}



	public void setAno(int ano) {
		this.ano = ano;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}


	public float getPre�o() {
		return pre�o;
	}



	public void setPre�o(float pre�o) {
		this.pre�o = pre�o;
	}

	public void Incluir() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
        String Sql = "insert into livros(nome,ano,autor,tipo,genero,pre�o) values('" 
                + getNome() + "'," + getAno() + ",'" + getAutor() + "','" + getTipo() + "','" + getGenero() + "'," + getPre�o() + ")";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
        comando.execute();
        comando.close();
        JOptionPane.showMessageDialog(null,"Livro adicionado");
    }
	
	public void Consultar() throws SQLException {
        String usuario = "root";
        String senha = "";
        String url = "jdbc:mysql://localhost/bookshop";
        Connection conn = (Connection) DriverManager.getConnection(url, usuario, senha);
        String SqlCom = "select * from livros";
        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
        ResultSet resultado = comando.executeQuery();
        ArrayList<String> registros = new ArrayList<>();
        while(resultado.next())
        {
            registros.add("ID: " + resultado.getString("id_livros") + 
                    " | Nome: " + resultado.getString("nome") + 
                    " | Ano: " + resultado.getString("ano") + 
                    " | Autor: " + resultado.getString("autor") + 
                    " | Tipo: " + resultado.getString("tipo") + 
                    " | G�nero: " + resultado.getString("genero") + 
                    " | Pre�o: " + resultado.getString("pre�o"));
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
	        String SqlCom = "select * from livros where id_livros = " + getId_livros();
	        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(SqlCom);
	        ResultSet resultado = comando.executeQuery();
	        resultado.next();
	        setNome(resultado.getString("nome"));
	        setAno(Integer.parseInt(resultado.getString("ano")));
	        setAutor(resultado.getString("autor"));
	        setTipo(resultado.getString("tipo"));
	        setGenero(resultado.getString("genero"));
	        setPre�o(Float.parseFloat(resultado.getString("pre�o")));
	        
	        resultado.close();
	        comando.close();
	        conn.close();
	    }
	  
	  public void Alterar() throws SQLException {
	        String usuario = "root";
	        String senha = "";
	        String url = "jdbc:mysql://localhost/bookshop";
	        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	        String Sql = "update livros set nome = '" + getNome()
	                + "', ano  = " + getAno()
	                + ", autor  = '" + getAutor()
	                + "', tipo  = '" + getTipo()
	                + "', genero  = '" + getGenero()
	                + "', pre�o  = " + getPre�o()
	                + " where id_livros = " + getId_livros();
	        PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	        comando.execute();
	        comando.close();
	        JOptionPane.showMessageDialog(null,"Livro alterado");
	    }
	  
	  public void Excluir() throws SQLException {
	        String usuario = "root";
	        String senha = "";
	        String url = "jdbc:mysql://localhost/bookshop";
	        java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
	        String Sql = "delete from livros where id_livros = " + getId_livros();
	        if(JOptionPane.showConfirmDialog(null, "Confirma exclus�o ?", "Aten��o", JOptionPane.OK_CANCEL_OPTION) == 0) 
	        {
	        	PreparedStatement comando = (PreparedStatement) conn.prepareStatement(Sql);
	        	comando.execute();
	        	comando.close();       
	        	JOptionPane.showMessageDialog(null,"Livro exclu�do");
	        }
	        else
	        	JOptionPane.showMessageDialog(null,"Exclus�o de livro cancelada");
	    }
}

