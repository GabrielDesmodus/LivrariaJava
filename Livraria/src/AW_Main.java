import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class AW_Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AW_Main window = new AW_Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AW_Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Livraria");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnuCadastros = new JMenu("\u00C1rea para funcion\u00E1rios");
		menuBar.add(mnuCadastros);
		
		JMenu mnuLivros = new JMenu("Livros");
		mnuLivros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLivros fl = new frmLivros();
				fl.setVisible(true);
			}
		});
		
		mnuCadastros.add(mnuLivros);
		
		JMenu mnuCompradores = new JMenu("Clientes");
		mnuCompradores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmComprador fc = new frmComprador();
				fc.setVisible(true);
			}
		});
		
		mnuCadastros.add(mnuCompradores);
		
		JMenu mnuCompras = new JMenu("Compras");
		mnuCompras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmCompras fcs = new frmCompras();
				fcs.setVisible(true);
			}
		});
		
		mnuCadastros.add(mnuCompras);
		
		JMenu mnuReserva = new JMenu("\u00C1rea do Comprador");
		menuBar.add(mnuReserva);
		
		JMenu mnuRegistro = new JMenu("Registro");
		mnuRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRegComprador frc = new frmRegComprador();
				frc.setVisible(true);
			}
		});
		mnuReserva.add(mnuRegistro);
		
		JMenu mnuComprar = new JMenu("Comprar");
		mnuComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmComprar fcr = new frmComprar();
				fcr.setVisible(true);
			}
		});
		mnuReserva.add(mnuComprar);
		
		JMenu mnuSair = new JMenu("Sair");
		mnuSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mnuSair);
	}
}
