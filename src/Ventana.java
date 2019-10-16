import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class Ventana extends Frame implements KeyListener {
	Graphics g;
	Image img;
	Juego j;
	JButton botones[];
	String jugador;
	int ANCHO=800, ALTO=800;

	public static void main(String[] args) {
		new Ventana();
	}
	
	Ventana(){
		setTitle("Pacman");
		setSize(ANCHO,ALTO);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);   
		
		img = createImage(ANCHO, ALTO);
		g = img.getGraphics();
		
	    j = new Juego(this);
	    j.start();
	         
	    addKeyListener(this);
        setFocusable(true);
	    
		}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		g.drawImage(img, 0,0, null);
	}
	
	
	public void keyPressed(KeyEvent e) {
		if(j.juegoiniciado == true){
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				if(j.mat[j.c.x-1][j.c.y]==1 || j.mat[j.c.x-1][j.c.y]==0){
					j.c.left = true;
					j.c.right = false;
					j.c.up = false;
					j.c.down = false;
					j.pulsador=true;
				}
			} 
	    	if (e.getKeyCode() == KeyEvent.VK_RIGHT){
	    		if(j.mat[j.c.x+1][j.c.y]==1 || j.mat[j.c.x+1][j.c.y]==0){
					j.c.left = false;
					j.c.right = true;
					j.c.up = false;
					j.c.down = false;
					j.pulsador=true;
				}
	    	} 
	    	if (e.getKeyCode() == KeyEvent.VK_UP){
	    		if(j.mat[j.c.x][j.c.y-1]==1 || j.mat[j.c.x][j.c.y-1]==0){
					j.c.left = false;
					j.c.right = false;
					j.c.up = true;
					j.c.down = false;
					j.pulsador=true;
				}
	    	} 
	    	if (e.getKeyCode() == KeyEvent.VK_DOWN){
	    		if(j.mat[j.c.x][j.c.y+1]==1 || j.mat[j.c.x][j.c.y+1]==0){
					j.c.left = false;
					j.c.right = false;
					j.c.up = false;
					j.c.down = true;
					j.pulsador=true;
				}
	    	} 
		}
		
		if (e.getKeyCode() == KeyEvent.VK_C && j.juegoiniciado == false) {
            j.controls = true;
        }
		
		if (e.getKeyCode() == KeyEvent.VK_B && j.juegoiniciado == false) {
            j.controls = false;
        }
		
		if (e.getKeyCode() == KeyEvent.VK_P && j.pausar == false && j.juegoiniciado == true) {
            j.pausar = true;
        }
		
		else if (e.getKeyCode() == KeyEvent.VK_P && j.pausar == true && j.juegoiniciado == true) {
            j.pausar = false;
        }
		
		if (e.getKeyCode() == KeyEvent.VK_J && j.juegoiniciado == false) {
			j.juegoiniciado = true;
			j.play(j.inicio);
		}
		
	    if (e.getKeyCode() == KeyEvent.VK_S) System.exit(0);
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {  
	}
}