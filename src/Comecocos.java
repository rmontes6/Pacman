import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Comecocos {
		
	int x, y, ancho, alto;
	boolean up=true, down=false, left=false, right=false;
	BufferedImage comecocosup = null, comecocosdown = null, comecocosleft = null, comecocosright = null;
	     
	public Comecocos (int x, int y, int ancho, int alto) {
		this.x = x;
	    this.y = y;
	    this.ancho = ancho;
	    this.alto = alto;
	    try{
	    	comecocosup = ImageIO.read(new File("Pacman_Imagenes/arriba.png"));
	    	comecocosdown = ImageIO.read(new File("Pacman_Imagenes/abajo.png"));
	    	comecocosleft = ImageIO.read(new File("Pacman_Imagenes/izquierda.png"));
	    	comecocosright = ImageIO.read(new File("Pacman_Imagenes/derecha.png"));
	    } 
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	     
	public void movimiento(int mat[][]) {
	    		
		if(up == true && (mat[x][y-1]==1 || mat[x][y-1]==0)) {
			y=y-1;	
		}
		
		if(down == true && (mat[x][y+1]==1 || mat[x][y+1]==0)) {
			y=y+1;	
		}
		
		if(left == true && (mat[x-1][y]==1 || mat[x-1][y]==0)) {
			x=x-1;
		}
		
		if(right == true && (mat[x+1][y]==1 || mat[x+1][y]==0)) {
			x=x+1;	
		}
	}
	   
	   
	void pinta1(Graphics g) {
		g.drawImage(comecocosup, 100+x*25, 150+y*25, 20, 20, null, null);
	}
	void pinta2(Graphics g) {
		g.drawImage(comecocosdown, 100+x*25, 150+y*25, 20, 20, null, null);
	}
	void pinta3(Graphics g) {
		g.drawImage(comecocosleft, 100+x*25, 150+y*25, 20, 20, null, null);    
	}
	void pinta4(Graphics g) {
		g.drawImage(comecocosright, 100+x*25, 150+y*25, 20, 20, null, null);
	}    
}