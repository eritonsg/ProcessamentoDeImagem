package tech.pdi.view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JPanel contentPanePrincipal = new JPanel();

	public void setPosicao() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(((d.width - this.getSize().width) / 2),
				((d.height - this.getSize().height) / 2) - 6);
	}
	
	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle("PDI - Processamento Digital de Imagem");
		setResizable(false);
		setAlwaysOnTop(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 697);
		setPosicao();
		
		contentPanePrincipal.setBackground(Color.WHITE);
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanePrincipal);
		contentPanePrincipal.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-4, 0, 900, 111);
		contentPanePrincipal.add(panel);
		
		JLabel label = new JLabel("PROCESSAMENTO DIGITAL DE IMAGEM");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Source Code Pro", Font.PLAIN, 26));
		label.setBounds(200, 41, 542, 29);
		panel.add(label);
		
		
		JButton btnFiltros = new JButton("");
		btnFiltros.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/btn_filtros.png")));
		btnFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFiltros telafiltro = new TelaFiltros();
				telafiltro.setVisible(true);
				telafiltro.setPosicao();
			}
		});
		btnFiltros.setForeground(Color.WHITE);
		btnFiltros.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnFiltros.setBackground(new Color(51, 102, 255));
		btnFiltros.setBounds(38, 134, 400, 130);
		contentPanePrincipal.add(btnFiltros);
		
		JButton btnOperadores = new JButton("");
		btnOperadores.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/btn_operadores.png")));
		btnOperadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaOperadores telaOp = new TelaOperadores();
				telaOp.setVisible(true);
				telaOp.setPosicao();
			}
		});
		btnOperadores.setForeground(Color.WHITE);
		btnOperadores.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnOperadores.setBackground(new Color(255, 102, 51));
		btnOperadores.setBounds(451, 134, 400, 130);
		contentPanePrincipal.add(btnOperadores);
		
		JButton btnGatoDeArnould = new JButton("");
		btnGatoDeArnould.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/btn_gato.png")));
		btnGatoDeArnould.setForeground(Color.WHITE);
		btnGatoDeArnould.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnGatoDeArnould.setBackground(new Color(255, 51, 51));
		btnGatoDeArnould.setBounds(38, 275, 400, 130);
		contentPanePrincipal.add(btnGatoDeArnould);
		
		JButton btnHistograma = new JButton("");
		btnHistograma.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/btn_histograma.png")));
		btnHistograma.setForeground(Color.WHITE);
		btnHistograma.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnHistograma.setBackground(new Color(102, 204, 102));
		btnHistograma.setBounds(451, 275, 400, 130);
		contentPanePrincipal.add(btnHistograma);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(-4, 600, 888, 47);
		contentPanePrincipal.add(panel_1);
		
		JLabel label_2 = new JLabel("Computa\u00E7\u00E3o Gr\u00E1fica");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		label_2.setBounds(21, 12, 250, 29);
		panel_1.add(label_2);
		
		JLabel lblEritonSantos = new JLabel("Eriton Santos");
		lblEritonSantos.setForeground(Color.WHITE);
		lblEritonSantos.setFont(new Font("Source Code Pro", Font.PLAIN, 16));
		lblEritonSantos.setBounds(754, 11, 137, 29);
		panel_1.add(lblEritonSantos);
		
		JButton btnGraficos = new JButton("");
		btnGraficos.setIcon(new ImageIcon(TelaInicial.class.getResource("/imgs/btn_graficos.png")));
		btnGraficos.setForeground(Color.WHITE);
		btnGraficos.setFont(new Font("Source Code Pro", Font.PLAIN, 30));
		btnGraficos.setBackground(new Color(153, 102, 153));
		btnGraficos.setBounds(38, 416, 400, 130);
		contentPanePrincipal.add(btnGraficos);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.DARK_GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnOpcoes = new JMenu("Op\u00E7\u00F5es");
		mnOpcoes.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mnOpcoes.setForeground(Color.WHITE);
		mnOpcoes.setBackground(Color.DARK_GRAY);
		menuBar.add(mnOpcoes);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setForeground(Color.WHITE);
		mntmSair.setBackground(Color.DARK_GRAY);
		mntmSair.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mnOpcoes.add(mntmSair);
		
		JMenu mnProcessamento = new JMenu("Processamento");
		mnProcessamento.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mnProcessamento.setBackground(Color.DARK_GRAY);
		mnProcessamento.setForeground(Color.WHITE);
		menuBar.add(mnProcessamento);
		
		JMenuItem mntmFiltros = new JMenuItem("Filtros");
		mntmFiltros.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mntmFiltros.setBackground(Color.DARK_GRAY);
		mntmFiltros.setForeground(Color.WHITE);
		mntmFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
		});
		mnProcessamento.add(mntmFiltros);
		
		JMenuItem mntmOperadores = new JMenuItem("Operadores");
		mntmOperadores.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mntmOperadores.setForeground(Color.WHITE);
		mntmOperadores.setBackground(Color.DARK_GRAY);
		mnProcessamento.add(mntmOperadores);
		
		JMenuItem mntmGatoDeArnould = new JMenuItem("Gato de Arnould");
		mntmGatoDeArnould.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mntmGatoDeArnould.setForeground(Color.WHITE);
		mntmGatoDeArnould.setBackground(Color.DARK_GRAY);
		mnProcessamento.add(mntmGatoDeArnould);
		
		JMenuItem mntmHistograma = new JMenuItem("Histograma");
		mntmHistograma.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mntmHistograma.setForeground(Color.WHITE);
		mntmHistograma.setBackground(Color.DARK_GRAY);
		mnProcessamento.add(mntmHistograma);
		
		JMenuItem mntmGrficos = new JMenuItem("Gr\u00E1ficos");
		mntmGrficos.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		mntmGrficos.setForeground(Color.WHITE);
		mntmGrficos.setBackground(Color.DARK_GRAY);
		mnProcessamento.add(mntmGrficos);
	}
}
