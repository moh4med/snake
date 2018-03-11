package snakegame;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Game {
	public Snake msnake;
	JPanel mjpanel;
	rec menemy;

	Game() {
		msnake = new Snake(0, 10, 10);
		msnake.move();
		addenemy();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				while(true) {
					msnake.move();
					MainGAME.comp.revalidate();
					MainGAME.comp.repaint();	
					int x1=msnake.recs.get(0).x1;
	     			int y1=msnake.recs.get(0).y1;
	     			int x1enemy=menemy.x1;
	     			int y1enemy=menemy.x1;
	     			if(x1==x1enemy&&y1==y1enemy) {
	     				msnake.additem();
	     				addenemy();
	     			}
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}		
			}
		}, 1000,1000);
/*		final Thread t = new Thread(new Runnable() {
		    public void run() {
		    	while(true) {
					msnake.move();
					MainGAME.comp.revalidate();
					MainGAME.comp.repaint();	
					try {
						t.wait(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}		
		    }
		});

		t.start();*/
		/*new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					msnake.move();
					MainGAME.comp.revalidate();
					MainGAME.comp.repaint();	
					try {
						wait(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}			
			}
			
		};*/
	}

	void setjpanel(JPanel mjpanel) {
		this.mjpanel = mjpanel;
	}

	void addenemy() {
		int x1 = (int) (Math.random() * 30.0) * 10;
		menemy = new rec(x1, x1, 10);
	}
}
