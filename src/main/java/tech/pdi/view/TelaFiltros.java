package tech.pdi.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TelaFiltros extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static JTextField txtArquivoSelecionado;
	
	private LeitorDeImagem imagem = new LeitorDeImagem();
	private ApresentadorDeImagem apresentador; 
	
	/* Carregando objetos */
	private JPanel pnlFotoProcessada = new JPanel();
	private JComboBox comboBoxFiltro = new JComboBox();
	private JPanel pnlFotoOriginal = new JPanel();
	private JPanel pnlOpcaoRobert = new JPanel();		
	private JRadioButton radioEmX = new JRadioButton("Em X");
	private JRadioButton radioEmY = new JRadioButton("Em Y");
	private JRadioButton radioEmXY = new JRadioButton("Em X e Y");
	private JTextField txtFator = new JTextField();
	private JPanel pnlFator = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFiltros frame = new TelaFiltros();
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
	
	private void desabilitarPainelOpcoes(boolean opcao){ 
		pnlOpcaoRobert.setEnabled(!opcao);
		radioEmX.setEnabled(!opcao);
		radioEmY.setEnabled(!opcao);
		radioEmXY.setEnabled(!opcao);
	}
	
	private void desabilitarPainelFator(boolean opcao){ 
		txtFator.setText("");
		txtFator.setEnabled(!opcao);
		pnlFator.setEnabled(!opcao);				
	}

	/**
	 * Create the frame.
	 */
	public TelaFiltros() {
		getContentPane().setEnabled(false);
		setTitle("Tela de Filtros");
		setResizable(false);
		desabilitarPainelOpcoes(true);
		desabilitarPainelFator(true);
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		pnlFotoProcessada.setBounds(577, 202, 255, 262);
		getContentPane().add(pnlFotoProcessada);
	
		pnlFotoOriginal.setBounds(10, 202, 255, 262);
		getContentPane().add(pnlFotoOriginal);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 490, 842, 4);
		getContentPane().add(panel_2);
		
		comboBoxFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxFiltro.getSelectedIndex()<=3){
					desabilitarPainelOpcoes(true);
					desabilitarPainelFator(true);
				} else if ((comboBoxFiltro.getSelectedIndex()==4) || (comboBoxFiltro.getSelectedIndex()==5) 
						    || (comboBoxFiltro.getSelectedIndex()==7) || (comboBoxFiltro.getSelectedIndex()==8)) {
					desabilitarPainelOpcoes(false);
					desabilitarPainelFator(true);
					
				} else if (comboBoxFiltro.getSelectedIndex()==6){
					desabilitarPainelOpcoes(true);
					desabilitarPainelFator(false);
				}
				
			}
		});
		
		comboBoxFiltro.setForeground(Color.WHITE);
		comboBoxFiltro.setBackground(Color.DARK_GRAY);
		comboBoxFiltro.setModel(new DefaultComboBoxModel(new String[] {"---- Escolha ----", "M\u00E9dia", "Mediana", "Passa alta b\u00E1sico", "Robert", "Robert cruzado", "Alto refor\u00E7o", "Prewitt ", "Sobel"}));
		comboBoxFiltro.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		comboBoxFiltro.setBounds(275, 202, 292, 33);
		getContentPane().add(comboBoxFiltro);
		
		JLabel lblFiltro = new JLabel("Filtro:");
		lblFiltro.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		lblFiltro.setBounds(275, 174, 89, 14);
		getContentPane().add(lblFiltro);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 44, 842, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtArquivoSelecionado = new JTextField();
		txtArquivoSelecionado.setToolTipText("Selecionar");
		txtArquivoSelecionado.setForeground(Color.WHITE);
		txtArquivoSelecionado.setColumns(10);
		txtArquivoSelecionado.setBackground(Color.DARK_GRAY);
		txtArquivoSelecionado.setBounds(10, 36, 404, 33);
		panel.add(txtArquivoSelecionado);
		
		JButton button = new JButton("Selecionar");
		button.setIcon(new ImageIcon(TelaFiltros.class.getResource("/imgs/btn_selecionar_pequeno.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser chooser = new JFileChooser();
				String path = "/imgs";
				File file = new File(path);
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "PGM Images", "pgm");
			    chooser.setFileFilter(filter);
			    chooser.setCurrentDirectory(file);
			    
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       txtArquivoSelecionado.setText(chooser.getSelectedFile().getAbsolutePath());
			       	//Cria um file onde eh armazenada a imagem
					File fileSelected = chooser.getSelectedFile();
					imagem.carregarImagem(fileSelected.getPath());		
					imagem.setBounds(10, 202, 256, 256);
					getContentPane().add(imagem);
					pnlFotoOriginal.setVisible(false);
					imagem.repaint();
			    }
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		button.setBackground(new Color(51, 102, 255));
		button.setBounds(424, 36, 150, 33);
		panel.add(button);
		
		JLabel label = new JLabel("Selecione a imagem:");
		label.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		label.setBounds(10, 11, 154, 14);
		panel.add(label);
		
		JLabel lblImagemOriginal = new JLabel("Imagem original:");
		lblImagemOriginal.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		lblImagemOriginal.setBounds(10, 171, 166, 17);
		getContentPane().add(lblImagemOriginal);
		
		JLabel lblImagemProcessada = new JLabel("Imagem processada:");
		lblImagemProcessada.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		lblImagemProcessada.setBounds(577, 174, 166, 17);
		getContentPane().add(lblImagemProcessada);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(0, 490, 842, 81);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton button_2 = new JButton("Sair");
		button_2.setIcon(new ImageIcon(TelaFiltros.class.getResource("/imgs/btn_cancelar.png")));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		button_2.setBackground(new Color(51, 102, 255));
		button_2.setBounds(709, 19, 123, 48);
		panel_3.add(button_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon(TelaFiltros.class.getResource("/imgs/btn_baixar.png")));
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		btnSalvar.setBackground(new Color(51, 102, 255));
		btnSalvar.setBounds(580, 19, 123, 48);
		panel_3.add(btnSalvar);
		
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.setBounds(10, 19, 254, 48);
		panel_3.add(btnAplicar);
		btnAplicar.setIcon(new ImageIcon(TelaFiltros.class.getResource("/imgs/btn_aplicar.png")));
		btnAplicar.setForeground(Color.WHITE);
		btnAplicar.setBackground(new Color(51, 102, 255));
		btnAplicar.setFont(new Font("Source Code Pro", Font.PLAIN, 14));
		
		pnlOpcaoRobert.setBackground(Color.DARK_GRAY);
		pnlOpcaoRobert.setBounds(275, 243, 292, 39);
		getContentPane().add(pnlOpcaoRobert);
		pnlOpcaoRobert.setLayout(null);
		
		desabilitarPainelOpcoes(true);
				
		radioEmX.setBackground(Color.DARK_GRAY);
		radioEmX.setForeground(Color.WHITE);

		radioEmY.setBackground(Color.DARK_GRAY);
		radioEmY.setForeground(Color.WHITE);
		radioEmY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioEmX.setSelected(false);
				radioEmXY.setSelected(false);
			}
		});
		
		radioEmX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioEmY.setSelected(false);
				radioEmXY.setSelected(false);
			}
		});
		radioEmX.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		radioEmX.setBounds(123, 7, 68, 23);
		pnlOpcaoRobert.add(radioEmX);
		
		radioEmY.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		radioEmY.setBounds(201, 7, 68, 23);
		pnlOpcaoRobert.add(radioEmY);
		
		radioEmXY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioEmX.setSelected(false);
				radioEmY.setSelected(false);
			}
		});
		radioEmXY.setForeground(Color.WHITE);
		radioEmXY.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		radioEmXY.setBackground(Color.DARK_GRAY);
		radioEmXY.setBounds(18, 7, 92, 23);
		pnlOpcaoRobert.add(radioEmXY);
		
		pnlFator.setBackground(Color.DARK_GRAY);
		pnlFator.setBounds(275, 288, 292, 39);
		getContentPane().add(pnlFator);
		pnlFator.setLayout(null);
		
		JLabel lblValorDeA = new JLabel("Valor de A:");
		lblValorDeA.setForeground(Color.WHITE);
		lblValorDeA.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		lblValorDeA.setBounds(27, 11, 95, 14);
		pnlFator.add(lblValorDeA);
		
		txtFator.setFont(new Font("Source Code Pro", Font.BOLD, 14));
		txtFator.setBounds(121, 8, 70, 20);
		pnlFator.add(txtFator);
		txtFator.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 842, 43);
		getContentPane().add(panel_1);
		
		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setForeground(new Color(0, 102, 255));
		lblFiltros.setFont(new Font("Source Code Pro", Font.BOLD, 18));
		lblFiltros.setBackground(new Color(255, 102, 51));
		lblFiltros.setBounds(23, 11, 210, 20);
		panel_1.add(lblFiltros);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setBounds(109, 30, 723, 2);
		panel_1.add(separator);
		setBounds(100, 100, 848, 600);

	}
}
