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
import java.sql.SQLException;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class frmRegComprador extends JFrame {

	private JPanel contentPane;

	JButton btnVoltar = new JButton("Voltar");
	JButton btnInc = new JButton("Cadastrar");
	JButton btnLimp = new JButton("Limpar");
	private JTextField txtNome;
	private final JTextField txtCpf = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegComprador frame = new frmRegComprador();
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
	public frmRegComprador() {
		txtCpf.setBounds(158, 114, 76, 22);
		txtCpf.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar");
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
		btnVoltar.setBounds(101, 214, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(55, 80, 72, 23);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCpf.setBounds(55, 113, 72, 23);
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
		btnInc.setBounds(26, 178, 101, 23);
		contentPane.add(btnInc);
		btnLimp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LimparTela();
			}
		});
		
		//JButton btnLimp = new JButton("Limpar");
		btnLimp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLimp.setBounds(158, 178, 101, 23);
		contentPane.add(btnLimp);
		
		txtNome = new JTextField();
		txtNome.setBounds(158, 81, 76, 22);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		contentPane.add(txtCpf);
	}
	
	public void LimparTela()
	{
	    txtCpf.setText("");
	    txtNome.setText("");
	    btnInc.setEnabled(true);
	}
}