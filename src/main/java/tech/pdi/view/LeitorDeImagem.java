package tech.pdi.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LeitorDeImagem extends JLabel{
	
	private BufferedReader leitorImagem;
	private BufferedImage imagem;
	private int[][] matrizImagem;
	private int altura;
	private int largura;
	private static final String IMAGEM_P2 = "P2";
	
	public LeitorDeImagem() {
		setSize(new Dimension(256, 256));
	}
	
	/**
	 * M�todo para ler a imagem e desenh�-la no objeto atual
	 * @param caminhoDaImagem O caminho da imagem para leitura
	 */
	public void carregarImagem(String caminhoDaImagem){
		try {
			this.leitorImagem = new BufferedReader(new FileReader(caminhoDaImagem));
			try {
				lerImagem();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel ler a imagem.");
				e.printStackTrace();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel abrir a imagem.");
		}
	}
	
	
	private void lerImagem() throws Exception{

		// Lendo a primeira linha que refe ao tipo de imagem
		String tipoDaImagem = "";
		String linhaLida = "";
		
		try {
			tipoDaImagem = leitorImagem.readLine();
			// Lendo dimens�o da imagem
			linhaLida = leitorImagem.readLine();
			String[] dimensao = linhaLida.split(" "); 
			
	        altura  = Integer.parseInt(dimensao[0]);
	        largura = Integer.parseInt(dimensao[1]);    
	        matrizImagem = new int[altura][largura];		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel ler a imagem.");
			e.printStackTrace();
		}
		
		if (tipoDaImagem == null || !tipoDaImagem.equals(IMAGEM_P2)) {
            throw new Exception("Imagem P2 requerida - Formato da Imagem inv�lido.");
        }
		
		String [] pixels;
        int linhaAtual=0; // A linha que o leitor est� lendo
        
        /* Lendo a linha com o valor m�ximo do p�xel */
        linhaLida=leitorImagem.readLine();
        linhaLida=leitorImagem.readLine();
        
        /* Ler linha a linha e preenche a matriz da imagem */
        while(linhaLida != null ){
        	pixels = linhaLida.split(" ");
        	for(int i = 0; i<pixels.length; i++){
        		matrizImagem[linhaAtual][i] = Integer.parseInt(pixels[i]);            	
        	}
        	linhaAtual++;
        	linhaLida=leitorImagem.readLine();
        }
        
        /* Carregando os p�xels para o buffer da imagem */
        imagem = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i<altura; i++){
        	for(int j=0;j<largura;j++){
        		imagem.setRGB(j, i, corPixel(matrizImagem[i][j]));
        	}
        }
        repaint();
	
	}
	
	/**
	 * M�todo para verificar se existe a posi��o na matriz de p�xels da imagem
	 * @param i O valor da posi��o na matriz para checar
	 * @param j o valor da posi��o na matriz para checar
	 * @return
	 */
	public boolean existePosicao(int i, int j){
		if (imagem!=null){
			if ((i>=0 && i<=altura-1) && (j>=0 && j<=largura-1)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * M�todo para obter a matriz de p�xels
	 * @return A matr�z de p�xeis
	 */
	public int[][] getMatrizImagem() {
		return matrizImagem;
	}

	/**
	 * M�todo para alterar a matriz de p�xels
	 * @param A matr�z de p�xeis
	 */
	public void setMatrizImagem(int[][] matrizImagem) {
		this.matrizImagem = matrizImagem;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @return the largura
	 */
	public int getLargura() {
		return largura;
	}

	/**
	 * M�todo para obter a cor do p�xel
	 * @param corRGB A cor para verificar
	 * @return O n�mero inteiro referente a cor RGB
	 */
	public int corPixel(int corRGB){
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imagem, 0, 0, null);
		g.dispose();
	}	

}
