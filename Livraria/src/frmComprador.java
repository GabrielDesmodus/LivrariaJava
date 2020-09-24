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
public class frmComprador extends JFrame {

	private JPanel contentPane;

	JButton btnVoltar = new JButton("Voltar");
	JButton btnInc = new JButton("Incluir");
	JButton btnAlt = new JButton("Alterar");
	JButton btnExc = new JButton("Excluir");
	JButton btnCons = new JButton("Consultar");
	JButton btnLimp = new JButton("Limpar");
	JButton btnPesq = new JButton("");
	private JTextField txtIdcomprador;
	private JTextField txtNome;
	private final JTextField txtCpf = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmComprador frame = new frmComprador();
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
	public frmComprador() {
		txtCpf.setBounds(96, 135, 76, 22);
		txtCpf.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Clientes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 276, 29);
		contentPane.add(lblNewLabel);
		
		//JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(100, 301, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("ID para pesquisa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 53, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(20, 102, 72, 23);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(20, 134, 72, 23);
		contentPane.add(lblCpf);
		btnInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comprador a = new Comprador();
		        a.setNome(txtNome.getText());
		        a.setCpf(txtCpf.getText());
		        
		        try {
		            a.Incluir();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		
		btnInc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInc.setBounds(10, 229, 83, 23);
		contentPane.add(btnInc);
		btnAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comprador a = new Comprador();
				a.setId_comprador(Integer.parseInt(txtIdcomprador.getText()));
				a.setNome(txtNome.getText());
		        a.setCpf(txtCpf.getText());

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
		btnAlt.setBounds(100, 229, 89, 23);
		contentPane.add(btnAlt);
		btnExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comprador a = new Comprador();
				a.setId_comprador(Integer.parseInt(txtIdcomprador.getText()));
				
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
		btnExc.setBounds(197, 229, 89, 23);
		contentPane.add(btnExc);
		btnCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comprador a = new Comprador();
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
		btnCons.setBounds(35, 265, 108, 23);
		contentPane.add(btnCons);
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		
		//JButton btnLimp = new JButton("Limpar");
		btnLimp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimp.setBounds(145, 265, 89, 23);
		contentPane.add(btnLimp);
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Comprador a = new Comprador();
		        if(txtIdcomprador.getText().trim().isEmpty())
		                a.setId_comprador(0);
		            else
		                a.setId_comprador(Integer.parseInt(txtIdcomprador.getText()));
		        try {
		            a.Pesquisar();
		            txtIdcomprador.setEnabled(false);	          
		            txtNome.setText(a.getNome());
		            txtCpf.setText(String.valueOf(a.getCpf()));  
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
		
		txtIdcomprador = new JTextField();
		txtIdcomprador.setBounds(164, 54, 76, 22);
		contentPane.add(txtIdcomprador);
		txtIdcomprador.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(96, 103, 76, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		contentPane.add(txtCpf);
	}
	
	public void LimparTela()
	{
		txtIdcomprador.setText("");
	    txtIdcomprador.setEnabled(true);
	    txtCpf.setText("");
	    txtNome.setText("");
	    btnInc.setEnabled(true);
	    btnAlt.setEnabled(false);
	    btnExc.setEnabled(false);
	    txtIdcomprador.requestFocus();
	}
}