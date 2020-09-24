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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class frmComprar extends JFrame {

	private JPanel contentPane;

	JButton btnVoltar = new JButton("Voltar");
	JButton btnInc = new JButton("Comprar");
	JButton btnCons = new JButton("Mostrar Produtos");
	JButton btnLimp = new JButton("Limpar");
	private JTextField txtCpf;
	private final JTextField txtIdLivro = new JTextField();
	private final JTextField txtQtd = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmComprar frame = new frmComprar();
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
	public frmComprar() {
		txtQtd.setBounds(351, 154, 49, 22);
		txtQtd.setColumns(10);
		txtIdLivro.setBounds(164, 154, 76, 22);
		txtIdLivro.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Livraria Digital - Produtos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 418, 29);
		contentPane.add(lblNewLabel);
		
		//JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnVoltar.setBounds(20, 262, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("CPF registrado");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 53, 130, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAno = new JLabel("ID do Produto");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAno.setBounds(20, 153, 130, 23);
		contentPane.add(lblAno);
		btnInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compras a = new Compras();
		        a.setId_livros(Integer.parseInt(txtIdLivro.getText()));
		        a.setCpf(txtCpf.getText());
		        a.setQtd(Integer.parseInt(txtQtd.getText()));
		        
		        try {
		            a.Incluir();
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
		        LimparTela();
			}
		});
		
		btnInc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInc.setBounds(20, 207, 103, 23);
		contentPane.add(btnInc);
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
		btnCons.setBounds(20, 102, 165, 23);
		contentPane.add(btnCons);
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		
		//JButton btnLimp = new JButton("Limpar");
		btnLimp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimp.setBounds(311, 262, 89, 23);
		contentPane.add(btnLimp);
		
		JLabel lblQtd = new JLabel("Quantidade");
		lblQtd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQtd.setBounds(252, 153, 95, 23);
		contentPane.add(lblQtd);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(164, 54, 76, 22);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		contentPane.add(txtIdLivro);
		
		contentPane.add(txtQtd);
	}
	
	public void LimparTela()
	{
		txtCpf.setText("");
	    txtIdLivro.setText("");
	    txtQtd.setText("");
	    btnInc.setEnabled(true);
	    txtCpf.requestFocus();
	}
}
