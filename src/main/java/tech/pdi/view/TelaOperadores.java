package tech.pdi.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class TelaOperadores extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaOperadores frame = new TelaOperadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setPosicao() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((d.width - this.getSize().width) / 2,
				(d.height - this.getSize().height) / 2);
	}
	
	/**
	 * Create the frame.
	 */
	public TelaOperadores() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 880, 630);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 864, 43);
		contentPane.add(panel);
		
		JLabel lblOperadores = new JLabel("Operadores");
		lblOperadores.setBackground(new Color(255, 102, 51));
		lblOperadores.setForeground(new Color(255, 102, 51));
		lblOperadores.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOperadores.setBounds(23, 11, 210, 20);
		panel.add(lblOperadores);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(150, 29, 714, 3);
		panel.add(separator);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 50, 844, 539);
		contentPane.add(tabbedPane);
		
		JPanel pnlOpAritmetico = new JPanel();
		pnlOpAritmetico.setBackground(Color.WHITE);
		tabbedPane.addTab("Aritm�ticos", null, pnlOpAritmetico, null);
		pnlOpAritmetico.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 60, 256, 256);
		pnlOpAritmetico.add(panel_1);
		
		JLabel lblImagemA = new JLabel("Imagem A:");
		lblImagemA.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		lblImagemA.setBounds(21, 17, 99, 27);
		pnlOpAritmetico.add(lblImagemA);
		
		JLabel lblImagemB = new JLabel("Imagem B:");
		lblImagemB.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		lblImagemB.setBounds(296, 17, 99, 27);
		pnlOpAritmetico.add(lblImagemB);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(296, 60, 256, 256);
		pnlOpAritmetico.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(573, 60, 256, 256);
		pnlOpAritmetico.add(panel_3);
		
		JButton btnNewButton = new JButton("Selecione");
		btnNewButton.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_selecionar_pequeno.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 102, 51));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(119, 11, 158, 38);
		pnlOpAritmetico.add(btnNewButton);
		
		JButton button = new JButton("Selecione");
		button.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_selecionar_pequeno.png")));
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(255, 102, 51));
		button.setBounds(394, 11, 158, 38);
		pnlOpAritmetico.add(button);
		
		JLabel lblOperacao = new JLabel("Opera\u00E7\u00E3o:");
		lblOperacao.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		lblOperacao.setBounds(21, 327, 112, 27);
		pnlOpAritmetico.add(lblOperacao);
		
		JComboBox comboOperacoes = new JComboBox();
		comboOperacoes.setBackground(Color.DARK_GRAY);
		comboOperacoes.setForeground(Color.WHITE);
		comboOperacoes.setModel(new DefaultComboBoxModel(new String[] {"---- Selecione ----", "Adi\u00E7\u00E3o", "Subtra\u00E7\u00E3o", "Divis\u00E3o", "Multiplica\u00E7\u00E3o"}));
		comboOperacoes.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		comboOperacoes.setBounds(21, 365, 256, 27);
		pnlOpAritmetico.add(comboOperacoes);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(573, 11, 256, 38);
		pnlOpAritmetico.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		lblResultado.setBounds(82, 5, 105, 27);
		panel_4.add(lblResultado);
		
		JPanel pnlSeparador = new JPanel();
		pnlSeparador.setBackground(Color.DARK_GRAY);
		pnlSeparador.setBounds(0, 423, 839, 4);
		pnlOpAritmetico.add(pnlSeparador);
		
		JPanel pnlBotoesOp1 = new JPanel();
		pnlBotoesOp1.setBounds(0, 423, 839, 88);
		pnlOpAritmetico.add(pnlBotoesOp1);
		pnlBotoesOp1.setLayout(null);
		
		JButton button_1 = new JButton("Salvar");
		button_1.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_baixar.png")));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		button_1.setBackground(new Color(255, 102, 51));
		button_1.setBounds(573, 18, 123, 48);
		pnlBotoesOp1.add(button_1);
		
		JButton button_2 = new JButton("Sair");
		button_2.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_cancelar.png")));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		button_2.setBackground(new Color(255, 102, 51));
		button_2.setBounds(706, 18, 123, 48);
		pnlBotoesOp1.add(button_2);
		
		JButton btnProcessar = new JButton("Processar");
		btnProcessar.setBounds(21, 17, 256, 48);
		pnlBotoesOp1.add(btnProcessar);
		btnProcessar.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_aplicar.png")));
		btnProcessar.setForeground(Color.WHITE);
		btnProcessar.setBackground(new Color(255, 102, 51));
		btnProcessar.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel pnlOpBooleano = new JPanel();
		pnlOpBooleano.setBackground(Color.WHITE);
		tabbedPane.addTab("Booleanos", null, pnlOpBooleano, null);
		pnlOpBooleano.setLayout(null);
		
		JLabel label_1 = new JLabel("Imagem A:");
		label_1.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		label_1.setBounds(21, 17, 99, 27);
		pnlOpBooleano.add(label_1);
		
		JButton btnSelecionarImagemAOp2 = new JButton("Selecione");
		btnSelecionarImagemAOp2.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_selecionar_pequeno.png")));
		btnSelecionarImagemAOp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSelecionarImagemAOp2.setForeground(Color.WHITE);
		btnSelecionarImagemAOp2.setBackground(new Color(255, 102, 51));
		btnSelecionarImagemAOp2.setBounds(119, 11, 158, 38);
		pnlOpBooleano.add(btnSelecionarImagemAOp2);
		
		JLabel label_2 = new JLabel("Imagem B:");
		label_2.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		label_2.setBounds(296, 17, 99, 27);
		pnlOpBooleano.add(label_2);
		
		JButton btnSelecionarImagemBOp2 = new JButton("Selecione");
		btnSelecionarImagemBOp2.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_selecionar_pequeno.png")));
		btnSelecionarImagemBOp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSelecionarImagemBOp2.setForeground(Color.WHITE);
		btnSelecionarImagemBOp2.setBackground(new Color(255, 102, 51));
		btnSelecionarImagemBOp2.setBounds(394, 11, 158, 38);
		pnlOpBooleano.add(btnSelecionarImagemBOp2);
		
		JPanel pnlImagemAOp2 = new JPanel();
		pnlImagemAOp2.setBounds(21, 60, 256, 256);
		pnlOpBooleano.add(pnlImagemAOp2);
		
		JPanel pnlImagemBOp2 = new JPanel();
		pnlImagemBOp2.setBounds(296, 60, 256, 256);
		pnlOpBooleano.add(pnlImagemBOp2);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(573, 11, 256, 38);
		pnlOpBooleano.add(panel_7);
		
		JLabel lblResultado_1 = new JLabel("Resultado:");
		lblResultado_1.setForeground(Color.WHITE);
		lblResultado_1.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		lblResultado_1.setBounds(81, 5, 129, 27);
		panel_7.add(lblResultado_1);
		
		JPanel pnlImagemResultadoOp2 = new JPanel();
		pnlImagemResultadoOp2.setBounds(573, 60, 256, 256);
		pnlOpBooleano.add(pnlImagemResultadoOp2);
		
		JComboBox comboOperacoesOp2 = new JComboBox();
		comboOperacoesOp2.setModel(new DefaultComboBoxModel(new String[] {"---- Selecione ----", "And", "Or", "Xor"}));
		comboOperacoesOp2.setForeground(Color.WHITE);
		comboOperacoesOp2.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		comboOperacoesOp2.setBackground(Color.DARK_GRAY);
		comboOperacoesOp2.setBounds(21, 365, 256, 27);
		pnlOpBooleano.add(comboOperacoesOp2);
		
		JLabel label_4 = new JLabel("Opera\u00E7\u00E3o:");
		label_4.setFont(new Font("Source Code Pro", Font.BOLD, 16));
		label_4.setBounds(21, 327, 112, 27);
		pnlOpBooleano.add(label_4);
		
		JPanel pnlSeparador2 = new JPanel();
		pnlSeparador2.setBackground(Color.DARK_GRAY);
		pnlSeparador2.setBounds(0, 423, 839, 4);
		pnlOpBooleano.add(pnlSeparador2);
		
		JPanel pnlBotoesOp2 = new JPanel();
		pnlBotoesOp2.setBackground(SystemColor.menu);
		pnlBotoesOp2.setLayout(null);
		pnlBotoesOp2.setBounds(0, 423, 839, 88);
		pnlOpBooleano.add(pnlBotoesOp2);
		
		JButton btnSalvarOp2 = new JButton("Salvar");
		btnSalvarOp2.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_baixar.png")));
		btnSalvarOp2.setForeground(Color.WHITE);
		btnSalvarOp2.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		btnSalvarOp2.setBackground(new Color(255, 102, 51));
		btnSalvarOp2.setBounds(573, 18, 123, 48);
		pnlBotoesOp2.add(btnSalvarOp2);
		
		JButton btnSairOp2 = new JButton("Sair");
		btnSairOp2.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_cancelar.png")));
		btnSairOp2.setForeground(Color.WHITE);
		btnSairOp2.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		btnSairOp2.setBackground(new Color(255, 102, 51));
		btnSairOp2.setBounds(706, 18, 123, 48);
		pnlBotoesOp2.add(btnSairOp2);
		
		JButton btnProcessarOp2 = new JButton("Processar");
		btnProcessarOp2.setIcon(new ImageIcon(TelaOperadores.class.getResource("/imgs/btn_aplicar.png")));
		btnProcessarOp2.setForeground(Color.WHITE);
		btnProcessarOp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProcessarOp2.setBackground(new Color(255, 102, 51));
		btnProcessarOp2.setBounds(21, 17, 256, 48);
		pnlBotoesOp2.add(btnProcessarOp2);
	}
}
