import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class frmLivros extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("rawtypes")
	JComboBox cmbTipo = new JComboBox();
	@SuppressWarnings("rawtypes")
	JComboBox cmbGenero = new JComboBox();

	JButton btnVoltar = new JButton("Voltar");
	JButton btnInc = new JButton("Incluir");
	JButton btnAlt = new JButton("Alterar");
	JButton btnExc = new JButton("Excluir");
	JButton btnCons = new JButton("Consultar");
	JButton btnLimp = new JButton("Limpar");
	JButton btnPesq = new JButton("");
	private JTextField txtIdlivros;
	private JTextField txtNome;
	private final JTextField txtAno = new JTextField();
	private final JTextField txtAutor = new JTextField();
	private final JTextField txtPreço = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLivros frame = new frmLivros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLivros() {
		txtPreço.setBounds(96, 279, 76, 22);
		txtPreço.setColumns(10);
		txtAutor.setBounds(96, 171, 76, 22);
		txtAutor.setColumns(10);
		txtAno.setBounds(96, 135, 76, 22);
		txtAno.setColumns(10);
		addComponentListener(new ComponentAdapter() {
			@SuppressWarnings("unchecked")
			@Override
			public void componentShown(ComponentEvent arg0) {

		        cmbTipo.addItem("Livro");
		        cmbTipo.addItem("Mangá");
		        cmbTipo.addItem("HQ");

		        cmbGenero.addItem("Terror");
		        cmbGenero.addItem("Suspense");
		        cmbGenero.addItem("Ação");
		        cmbGenero.addItem("Biografia");
		    
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Estoque de Livros");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 248, 29);
		contentPane.add(lblNewLabel);
		
		//JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(96, 395, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("ID para pesquisa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 53, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(20, 102, 72, 23);
		contentPane.add(lblNome);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAno.setBounds(20, 134, 72, 23);
		contentPane.add(lblAno);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor.setBounds(20, 170, 72, 23);
		contentPane.add(lblAutor);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(20, 206, 72, 23);
		contentPane.add(lblTipo);
		btnInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Livros a = new Livros();
		        a.setTipo(cmbTipo.getSelectedItem().toString());
		        a.setGenero(cmbGenero.getSelectedItem().toString());
		        a.setNome(txtNome.getText());
		        a.setAutor(txtAutor.getText());
		        a.setAno(Integer.parseInt(txtAno.getText()));
		        a.setPreço(Float.parseFloat(txtPreço.getText()));
		        
		        try {
		            a.Incluir();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		
		btnInc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInc.setBounds(10, 326, 83, 23);
		contentPane.add(btnInc);
		btnAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livros a = new Livros();
				a.setId_livros(Integer.parseInt(txtIdlivros.getText()));
		        a.setTipo(cmbTipo.getSelectedItem().toString());
		        a.setGenero(cmbGenero.getSelectedItem().toString());
		        a.setNome(txtNome.getText());
		        a.setAutor(txtAutor.getText());
		        a.setAno(Integer.parseInt(txtAno.getText()));
		        a.setPreço(Float.parseFloat(txtPreço.getText()));
		        
		        try {
		            a.Alterar();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		
		//JButton btnAlt = new JButton("Alterar");
		btnAlt.setEnabled(false);
		btnAlt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlt.setBounds(96, 326, 89, 23);
		contentPane.add(btnAlt);
		btnExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livros a = new Livros();
				a.setId_livros(Integer.parseInt(txtIdlivros.getText()));
		        try {
		            a.Excluir();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		
		//JButton btnExc = new JButton("Excluir");
		btnExc.setEnabled(false);
		btnExc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExc.setBounds(197, 326, 89, 23);
		contentPane.add(btnExc);
		btnCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Livros a = new Livros();
		        try {
		            a.Consultar();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		
		//JButton btnCons = new JButton("Consultar");
		btnCons.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCons.setBounds(34, 359, 108, 23);
		contentPane.add(btnCons);
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		
		btnLimp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimp.setBounds(151, 359, 89, 23);
		contentPane.add(btnLimp);
		
		cmbTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbTipo.setBounds(96, 206, 89, 23);
		contentPane.add(cmbTipo);
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Livros a = new Livros();
		        if(txtIdlivros.getText().trim().isEmpty())
		                a.setId_livros(0);
		            else
		                a.setId_livros(Integer.parseInt(txtIdlivros.getText()));
		        try {
		            a.Pesquisar();
		            txtIdlivros.setEnabled(false);
		            cmbTipo.setSelectedItem(a.getTipo());
		            cmbGenero.setSelectedItem(a.getGenero());
		            txtNome.setText(a.getNome());
		            txtAno.setText(String.valueOf(a.getAno()));
		            txtAutor.setText(a.getAutor());
		            DecimalFormat df = new DecimalFormat("0.00");
		            txtPreço.setText(df.format(a.getPreço()));
		            btnInc.setEnabled(false);
		            btnAlt.setEnabled(true);
		            btnExc.setEnabled(true);
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		            LimparTela();
		        }
			}
		});
		String pathToImage = "res/lupa.png";
		btnPesq.setIcon(new ImageIcon(getClass().getClassLoader().getResource(pathToImage)));
		btnPesq.setBounds(246, 47, 40, 29);
		contentPane.add(btnPesq);
		
		JLabel lblGenero = new JLabel("G\u00EAnero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGenero.setBounds(20, 242, 72, 23);
		contentPane.add(lblGenero);
		
		JLabel lblPreço = new JLabel("Pre\u00E7o");
		lblPreço.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPreço.setBounds(20, 278, 72, 23);
		contentPane.add(lblPreço);
		
		
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbGenero.setBounds(96, 242, 89, 23);
		contentPane.add(cmbGenero);
		
		txtIdlivros = new JTextField();
		txtIdlivros.setBounds(164, 54, 76, 22);
		contentPane.add(txtIdlivros);
		txtIdlivros.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(96, 103, 76, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		contentPane.add(txtAno);
		
		contentPane.add(txtAutor);
		
		contentPane.add(txtPreço);
	}
	
	public void LimparTela()
	{
		txtIdlivros.setText("");
	    txtIdlivros.setEnabled(true);
	    cmbTipo.setSelectedIndex(0);
	    cmbGenero.setSelectedIndex(0);
	    txtAutor.setText("");
	    txtAno.setText("");
	    txtNome.setText("");
	    txtPreço.setText("");
	    btnInc.setEnabled(true);
	    btnAlt.setEnabled(false);
	    btnExc.setEnabled(false);
	    txtIdlivros.requestFocus();
	}
}
