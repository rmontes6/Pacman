import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Fantasmas {
	
	int x, y, ancho, alto;
	boolean up=false, down=false, left=false, right=false, fantasma=false;
	BufferedImage fantasma1 = null, fantasma2 = null, fantasma3 = null, fantasma4 = null;
	Comecocos c;
	
	public Fantasmas(int x, int y, int ancho, int alto, Comecocos c) {
		
		this.c=c;
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		
		try{
            fantasma1 = ImageIO.read(new File("Pacman_Imagenes/5.png"));
            fantasma2 = ImageIO.read(new File("Pacman_Imagenes/6.png"));
            fantasma3 = ImageIO.read(new File("Pacman_Imagenes/7.png"));
            fantasma4 = ImageIO.read(new File("Pacman_Imagenes/8.png"));
        } 
		
        catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public void movimiento(int mat[][]){
		int direcciones[] = {0,0,0,0};
		
		direcciones[0] = c.y-y;
		direcciones[1] = y-c.y;
		direcciones[2] = c.x-x;
		direcciones[3] = x-c.x;
				
		if(mat[x][y+1]==2) {
			direcciones[0]=-100; //Abajo
		}
		if(mat[x][y-1]==2) {
			direcciones[1]=-100; //Arriba
		}
		if(mat[x+1][y]==2) {
			direcciones[2]=-100; //Derecha
		}
		if(mat[x-1][y]==2) {
			direcciones[3]=-100; //Izquierda
		}
		
		if(direcciones[0] >= direcciones[1] && direcciones[0] >= direcciones[2] && direcciones[0] >= direcciones[3]) {
			y = y+1;
		}
		else {
			if(direcciones[1] >= direcciones[2] && direcciones[1] >= direcciones[3]) {
				y = y-1;
			}
			else {
				if(direcciones[2] >= direcciones[3]) {
					x = x+1;
				}
				else {
					x = x-1;
				}
			}
		}
	}
	
	void pintaYellow(Graphics g) {
		g.drawImage(fantasma1, 100+x*25, 150+y*25, 20, 20, null, null);
	}
	void pintaPurple(Graphics g) {
		g.drawImage(fantasma2, 100+x*25, 150+y*25, 20, 20, null, null);
	}
	void pintaRed(Graphics g) {
		g.drawImage(fantasma3, 100+x*25, 150+y*25, 20, 20, null, null);
	}
	void pintaGreen(Graphics g) {
        g.drawImage(fantasma4, 100+x*25, 150+y*25, 20, 20, null, null);
    }
}