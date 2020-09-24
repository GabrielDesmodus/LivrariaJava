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
import javax.swing.ImageIcon;
import java.sql.SQLException;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class frmCompras extends JFrame {

	private JPanel contentPane;

	JButton btnVoltar = new JButton("Voltar");
	JButton btnExc = new JButton("Cancelar Compra");
	JButton btnCons = new JButton("Consultar");
	JButton btnLimp = new JButton("Limpar");
	JButton btnPesq = new JButton("");
	private JTextField txtIdcompra;
	private JTextField txtIdlivro;
	private final JTextField txtIdcliente = new JTextField();
	private final JTextField txtQtd = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCompras frame = new frmCompras();
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
	public frmCompras() {
		txtQtd.setBounds(164, 182, 76, 22);
		txtQtd.setColumns(10);
		txtIdcliente.setBounds(164, 146, 76, 22);
		txtIdcliente.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Compras");
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
		btnVoltar.setBounds(96, 306, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("ID para pesquisa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 64, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblId_Livro = new JLabel("ID do Livro");
		lblId_Livro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId_Livro.setBounds(20, 113, 108, 23);
		contentPane.add(lblId_Livro);
		
		JLabel lblID_comprador = new JLabel("ID do Cliente");
		lblID_comprador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID_comprador.setBounds(20, 145, 108, 23);
		contentPane.add(lblID_comprador);
		
		JLabel lblAutor = new JLabel("Quantidade");
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAutor.setBounds(20, 181, 108, 23);
		contentPane.add(lblAutor);
		btnExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compras a = new Compras();
				a.setId_compra(Integer.parseInt(txtIdcompra.getText()));
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
		btnExc.setBounds(66, 229, 162, 23);
		contentPane.add(btnExc);
		btnCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compras a = new Compras();
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
		btnCons.setBounds(34, 270, 108, 23);
		contentPane.add(btnCons);
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		
		//JButton btnLimp = new JButton("Limpar");
		btnLimp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimp.setBounds(151, 270, 89, 23);
		contentPane.add(btnLimp);
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compras a = new Compras();
		        if(txtIdcompra.getText().trim().isEmpty())
		                a.setId_compra(0);
		            else
		                a.setId_compra(Integer.parseInt(txtIdcompra.getText()));
		       
		        try {
		            a.Pesquisar();
		            txtIdcompra.setEnabled(false);  
		            txtIdlivro.setText(String.valueOf(a.getId_livros()));
		            txtIdcliente.setText(String.valueOf(a.getId_comprador()));
		            txtQtd.setText(String.valueOf(a.getQtd()));
		            btnExc.setEnabled(true);
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		            LimparTela();
		        }
			}
		});
		
		String pathToImage = "res/lupa.png";
		btnPesq.setIcon(new ImageIcon(getClass().getClassLoader().getResource(pathToImage)));
		btnPesq.setBounds(246, 58, 40, 29);
		contentPane.add(btnPesq);
		
		txtIdcompra = new JTextField();
		txtIdcompra.setBounds(164, 65, 76, 22);
		contentPane.add(txtIdcompra);
		txtIdcompra.setColumns(10);
		
		txtIdlivro = new JTextField();
		txtIdlivro.setBounds(164, 114, 76, 22);
		contentPane.add(txtIdlivro);
		txtIdlivro.setColumns(10);
		
		contentPane.add(txtIdcliente);
		
		contentPane.add(txtQtd);
	}
	
	public void LimparTela()
	{
		txtIdcompra.setText("");
	    txtIdcompra.setEnabled(true);
	    txtQtd.setText("");
	    txtIdcliente.setText("");
	    txtIdlivro.setText("");
	    btnExc.setEnabled(false);
	    txtIdcompra.requestFocus();
	}
}
