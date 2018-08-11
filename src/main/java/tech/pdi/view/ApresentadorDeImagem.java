package tech.pdi.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ApresentadorDeImagem extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage imagem;
	private int[][] matriz;
	private int altura;
	private int largura;

	public ApresentadorDeImagem(int altura, int largura, int[][] matrizPixels) {
		this.altura = altura;
		this.largura = largura;
		this.matriz = matrizPixels;
		repaint();
	}
	
	public void limpar(){
		imagem.getGraphics().fillRect(0, 0, largura, altura);
	}

	/**
	 * @return A imagem processada
	 */
	public BufferedImage getImagemProcessada() {
		return imagem;
	}

	/**
	 * @return A altura da imagem
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @return A largura da imagem
	 */
	public int getLargura() {
		return largura;
	}

	/**
	 * @return the matriz
	 */
	public int[][] getMatriz() {
		return matriz;
	}

	/**
	 * @param matriz
	 *            the matriz to set
	 */
	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
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
		
		this.imagem = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i< altura; i++){
        	for(int j=0;j< largura;j++){
        		this.imagem.setRGB(j, i, corPixel(matriz[i][j]));
        	}
        }
		g.drawImage(imagem, 0, 0, null);
		g.dispose();
	}	

}
