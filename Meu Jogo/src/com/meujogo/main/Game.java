package com.meujogo.main;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.meujogo.main.input.KeyInput;
import com.meujogo.main.input.MouseInput;
import com.meujogo.sprite.Back;
import com.meujogo.sprite.Sprite;
import com.meujogo.sprite.SpriteSheet;

public class Game extends Canvas implements Runnable {

	private boolean running=false;
	private ExecutorService executor;
	private  int width;
	private  int height;
	private SpriteSheet sheet;
	private Sprite sprite;
	private Back back;
	private int sX=200,sY=200;
	
	public Game(int w, int h){
		executor = Executors.newFixedThreadPool(1);
		width = w;
		height = h;
		sheet = new SpriteSheet(new Texture("sprite_player"),64);
		back = new Back(new Texture("back"),w,h);
		sprite = new Sprite(sheet,3,1);
		addKeyListener(new KeyInput());
		MouseInput mi = new MouseInput();
		addMouseListener(mi);
		addMouseMotionListener(mi);
	}
	
	@Override
	public void run() {
		long startTime = 0;
		double perTick=1000/60;
		double num = 0;
		long count=0;
		while(running){
			
			startTime = System.currentTimeMillis();
			//////////////////////////////////////
			
			count+=num;
			segundo+=num;
			if (count>=perTick){
				count=0;
				fps++;
				second();
				update();
				render();
			}
			//////////////////////////////////////
			/*try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			num=System.currentTimeMillis()-startTime;
		}
	}
	
	private int fps=0;
	private int segundo=0;
	
	private void second() {
		
		if (segundo>=1000){
			System.out.printf("\tFPS : %d\n",fps);
			fps=0;
			segundo=0;
		}
	}

	public boolean isRunning() {
		return running;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void encerra(){
		setRunning(false);
		executor.shutdown();
	}
	
	public void inicia(){
		setRunning(true);
		executor.execute(this);
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs==null){
			createBufferStrategy(2);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		/////////////////////////////////
		back.render(g, 0, 0);
		sprite.render(g, sX, sY);
		////////////////////////////////
		
		g.dispose();
		bs.show();
	}
	
	public void update(){
		//KeyInput
		///////////////////////////////////////////////////
		if (KeyInput.isKeyDown(KeyEvent.VK_UP)){
			sY-=2;
			sprite.setYps(3);
			System.out.println("UP Ativado");
		}
		
		if (KeyInput.isKeyDown(KeyEvent.VK_DOWN)){
			sY+=2;
			sprite.setYps(4);
			System.out.println("DOWN Ativado");
		}
		
		if (KeyInput.isKeyDown(KeyEvent.VK_LEFT)){
			sX-=2;
			sprite.setYps(1);
			System.out.println("LEFT Ativado");
		}
		
		if (KeyInput.isKeyDown(KeyEvent.VK_RIGHT)){
			sX+=2;
			sprite.setYps(2);
			System.out.println("RIGHT Ativado");
		}
		
		if (KeyInput.wasPressed(KeyEvent.VK_ENTER)){
			sY=100;sX+=1;
			System.out.println("Enter Ativado");
		}
		
		KeyInput.update();
		///////////////////////////////////////////////////
		////sprite
		//////////////////////////////////////////////////
		sprite.update();
	}
}
