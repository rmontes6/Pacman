import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Juego extends Thread {

	Ventana v;
	Comecocos c;
	Fantasmas f[] = new Fantasmas[4];
	boolean juegoiniciado = false, pausar = false, ganar=false, perder=false, controls=false, pulsador=false;
	BufferedImage fondo=null, moneda=null, muro=null, vidas=null, controles=null;
	int puntos = 0;
	int lives = 3;
	File comida, inicio, muerte, main;
	int mat[][]= {
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,2,1,2,2,1,2,2,1,2,1,2,1,2,2,2,2,2,1,2},
			{2,1,2,1,2,2,1,2,2,1,2,1,2,1,2,1,1,1,2,1,2},
			{2,1,2,1,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2},
			{2,1,1,1,2,2,1,2,2,1,2,1,2,1,2,1,2,1,2,1,2},
			{2,1,2,1,2,2,1,1,1,1,2,1,2,1,2,1,2,1,2,1,2},
			{2,1,2,1,2,2,1,2,2,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,2,1,2,2,1,2,2,1,2,1,2,2,1,2,2,2,2,1,2},
			{2,1,1,1,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,1,2},
			{2,2,2,1,2,2,2,2,2,1,1,1,1,1,1,2,2,2,2,0,2},
			{2,1,1,1,2,2,1,1,1,1,2,1,2,2,1,1,1,1,1,1,2},
			{2,1,2,1,1,1,1,2,2,1,2,1,2,2,1,2,2,2,2,1,2},
			{2,1,2,1,2,1,2,2,1,1,1,1,1,1,1,1,1,1,1,1,2},
			{2,1,2,1,2,1,2,2,1,2,1,2,2,1,2,1,2,1,2,1,2},
			{2,1,2,1,1,1,1,1,1,2,1,2,2,1,1,1,1,1,1,1,2},
			{2,1,1,1,2,1,2,2,1,2,1,2,2,1,2,1,2,1,2,1,2},
			{2,2,1,2,2,1,2,2,1,2,1,2,2,1,1,1,1,1,1,1,2},
			{2,2,1,2,2,1,2,2,1,2,1,2,2,2,2,2,1,2,1,2,2},
			{2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			};
	
	Juego(Ventana v){
		this.v = v;
		
		try{
			fondo = ImageIO.read(new File("Pacman_Imagenes/Fondo.png"));
        } 
		
        catch (IOException e) {
            e.printStackTrace();
        }
		
		try{
            moneda = ImageIO.read(new File("Pacman_Imagenes/1.png"));
        } 
		
        catch (IOException e){
            e.printStackTrace();
        }
		
		try{
			muro = ImageIO.read(new File("Pacman_Imagenes/2.png"));
        } 
		
        catch (IOException e){
            e.printStackTrace();
        }
		
		try{
			vidas = ImageIO.read(new File("Pacman_Imagenes/Vidas.png"));
        } 
		
        catch (IOException e) {
            e.printStackTrace();
        }
		
		try{
			controles = ImageIO.read(new File("Pacman_Imagenes/Controles.png"));
        } 
		
        catch (IOException e) {
            e.printStackTrace();
        }
		comida = new File("audio/comida.WAV");
		inicio = new File("audio/inicio.WAV");
		muerte = new File("audio/muerte.WAV");
		main = new File("audio/main.WAV");
	}
	
	void play(File audio) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(audio));
			clip.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Thread movimientosFantasmas1 = new Thread(){
		public void run(){
			while(true) {
				if(pulsador==true && pausar==false) {
						f[0].movimiento(mat);
				}
				
				try {
					sleep(600);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public Thread movimientosFantasmas2 = new Thread(){
		public void run(){
			while(true) {
				if(pulsador==true && pausar==false) {
						f[1].movimiento(mat);
				}
				
				try {
					sleep(500);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public Thread movimientosFantasmas3 = new Thread(){
		public void run(){
			while(true) {
				if(pulsador==true && pausar==false) {
						f[2].movimiento(mat);
				}
				
				try {
					sleep(400);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public Thread movimientosFantasmas4 = new Thread(){
		public void run(){
			while(true) {
				if(pulsador==true && pausar==false) {
						f[3].movimiento(mat);
				}
				
				try {
					sleep(300);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	public Thread movimientosComecocos = new Thread(){
		public void run(){
			while(true) {
				if(pausar==false) {
					c.movimiento(mat);
				}
				try {
					sleep(220);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}
	};
	
	public Thread comprobaciones = new Thread() {
		public void run() {
			while(perder==false && ganar==false) {
				if(juegoiniciado==true && pausar==false) {
					ganar();
					perder();
					compruebaChoques();
				}
				if(juegoiniciado==true) {
					imprimirMapa(mat);
				}
					
				try {
					sleep(220);
				}
				
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	void pantallaInicio() {
	    while(true) {
			v.g.drawImage(fondo, 0, 0, v.ANCHO, v.ALTO, null, null);
			v.g.setColor(Color.BLACK);
			v.g.fillRect(315, 590, 170, 40);
			v.g.fillRect(315, 650, 170, 40);
			v.g.fillRect(300, 710, 200, 40);
			v.g.setColor(Color.YELLOW);
		    v.g.drawRect(315, 590, 170, 40);
		    v.g.setColor(Color.RED);
		    v.g.drawRect(315, 650, 170, 40);
		    v.g.setColor(Color.BLUE);
		    v.g.drawRect(300, 710, 200, 40);
		    v.g.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		    v.g.setColor(Color.YELLOW);
		    v.g.drawString("Presiona 'J' para jugar", 330, 615);
		    v.g.setColor(Color.RED);
		    v.g.drawString("Presiona 'S' para salir", 330, 675);    
		    v.g.setColor(Color.BLUE);
		    v.g.drawString("Presiona 'C' para controles", 315, 735); 
		    v.repaint();
		    
		    if (controls == true) {
		    	pantallaControles();
		    	break;
		    }
		    
		    if (juegoiniciado == true) {
		    	pantallaPartida();
		    	break;
		    }
	    }
	}
	
	void pantallaControles() {
		while(true) {
			v.g.drawImage(controles, 0, 0, v.ANCHO, v.ALTO, null, null);
			v.g.setColor(Color.BLACK);
			v.g.fillRect(290, 390, 170, 40);
			v.g.setColor(Color.YELLOW);
		    v.g.drawRect(290, 390, 170, 40);
		    v.g.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		    v.g.setColor(Color.YELLOW);
		    v.g.drawString("    Back - Botton 'B' ", 305, 415);
			v.repaint();
			
			if (controls == false) {
				pantallaInicio();
				break;
			}
		}
	}
	
	void pantallaPartida() {
		inicializar();
		
		while(lives>0) {
			comprobaciones.start();
			movimientosComecocos.start();
			movimientosFantasmas1.start();
			movimientosFantasmas2.start();
			movimientosFantasmas3.start();
			movimientosFantasmas4.start();
			while(true) {
				if(perder==true || ganar==true) {
					imprimirMapa(mat);
					movimientosComecocos.stop();
					movimientosFantasmas1.stop();
					movimientosFantasmas2.stop();
					movimientosFantasmas3.stop();
					movimientosFantasmas4.stop();
					comprobaciones.stop();
					try {
						sleep(10);
					}
					catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	void inicializar() {
		
		puntos=0;
		lives=3;
		pausar = false;
		ganar = false;
		perder = false;
		controls=false;
		pulsador=false;
		
		
		c = new Comecocos(10,19,20,20);
		
		f[0] = new Fantasmas(1,1,20,20,c);
		f[1] = new Fantasmas(19,2,20,20,c);
		f[2] = new Fantasmas(11,1,20,20,c);
		f[3] = new Fantasmas(6,6,20,20,c);
		
	}
	
	
	public void imprimirMapa(int mat[][]) {
		
		int i=0, j=0, k=0;
		v.g.setColor(Color.BLACK);
		v.g.fillRect(0, 0, v.ANCHO, v.ALTO);
		v.g.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		v.g.setColor(Color.YELLOW);
		
		for(k=0;k<lives;k++) {
			v.g.drawImage(vidas, 690, 200+50*k, 40, 40, null, null);
		}
		
		v.g.drawString("SCORE:  " + puntos, 280, 80);
		
		for (i=0; i<21; i++) {
			for(j = 0; j<21; j++) {
				
				if(mat[i][j]==1) {
					v.g.drawImage(moneda, 100+i*25, 150+j*25, 20, 20, null, null);
				}
				
				if(mat[i][j]==2) {
					v.g.drawImage(muro, 100+i*25, 150+j*25, 20, 20, null, null);
				}
			}
		}
		
		if(c.up==true) {
			c.pinta1(v.g);
			if(mat[c.x][c.y]==1){
				puntos+=5;
				play(comida);
				mat[c.x][c.y]=0;
			}
		}
		
		if(c.down==true) {
			c.pinta2(v.g);
			if(mat[c.x][c.y]==1){
				puntos+=5;
				play(comida);
				mat[c.x][c.y]=0;
			}
		}
		
		if(c.left==true) {
			c.pinta3(v.g);
			if(mat[c.x][c.y]==1){
				puntos+=5;
				play(comida);
				mat[c.x][c.y]=0;
			}
		}
		
		if(c.right==true) {
			c.pinta4(v.g);
			if(mat[c.x][c.y]==1){
				puntos+=5;
				play(comida);
				mat[c.x][c.y]=0;
			}
		}
				
		f[0].pintaYellow(v.g);
				
		f[1].pintaPurple(v.g);
				
		f[2].pintaRed(v.g);
				
		f[3].pintaGreen(v.g);
		
		if (pausar == true) {
            v.g.setColor(Color.BLACK);
            v.g.fillRect(310, 100, 100, 40);
            v.g.setColor(Color.GREEN);
            v.g.drawRect(310, 100, 100, 40);
            v.g.setFont(new Font("Century Gothic", Font.PLAIN, 15));
            v.g.drawString("PAUSA", 337, 125);
        }
		
		if(ganar==true) {
			 v.g.setColor(Color.BLACK);
	         v.g.fillRect(100, 100, 100, 40);
	         v.g.setColor(Color.GREEN);
	         v.g.drawRect(100, 100, 100, 40);
	         v.g.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	         v.g.drawString("YOU WIN", 120, 125);
	         v.g.drawString("CLOSE - PRESS 'S'", 485, 125);
		}
		
		if(perder==true) {
			v.g.setColor(Color.BLACK);
			v.g.fillRect(100, 100, 100, 40);
			v.g.setColor(Color.GREEN);
			v.g.drawRect(100, 100, 100, 40);
			v.g.setFont(new Font("Century Gothic", Font.PLAIN, 15));
			v.g.drawString("YOU LOSE!", 110, 125);
			v.g.drawString("CLOSE - PRESS 'S'", 485, 125);
			
		}
		
		v.repaint();
	}
	
	
	 void compruebaChoques() {
		 
		 for(int i=0;i<4;i++) {
			 if (c.x == f[i].x && c.y == f[i].y) {
				 play(muerte);
				 lives=lives-1;
				 c.x=10;
				 c.y=19;
				 f[0].y=1; f[0].x=1;
				 f[1].y=2; f[1].x=19;
				 f[2].y=1; f[2].x=11;
				 f[3].y=6; f[3].x=6;
			 }
		 }
	 }
	 
	 void ganar() {
		 
		 int c = 0;
		 for(int i = 0; i < mat.length; i++) {
			 for(int j = 0; j < mat.length; j++) {
				 if(mat[i][j]==1) c = 1;	
			 }
		 }
		 
		 if(c==0) {
			 ganar=true;
			 play(main);
		 }
	 }
	 
	 void perder() {
		 if(lives==0) {
			 perder=true;
			 play(muerte);
		 }
	 }
	 
	public void run() {
		while(true) {
		pantallaInicio();
		}
	}
}
