package snakegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGAME extends JComponent {

	private static Game mGame=null ;
	private static JPanel buttonsPanel;
	public static MainGAME comp;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		if(mGame==null)return;
		for (rec x : mGame.msnake.recs) {
			g.drawRect(x.x1, x.y1, x.size, x.size);
			g.setColor(Color.BLACK);
			g.fillRect(x.x1, x.y1, x.size, x.size);
		}
		g.drawRect(mGame.menemy.x1, mGame.menemy.y1, mGame.menemy.size, mGame.menemy.size);
		g.setColor(Color.RED);
		g.fillRect(mGame.menemy.x1, mGame.menemy.y1, mGame.menemy.size, mGame.menemy.size);
	}



	public static void main(String[] args) {
		JFrame testFrame = new JFrame();
		testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		comp = new MainGAME();
		comp.setPreferredSize(new Dimension(300, 300));
		testFrame.getContentPane().add(comp, BorderLayout.CENTER);
		testFrame.pack();
		testFrame.setVisible(true);
		comp.setFocusable(true);	
		comp.addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {}

             @Override
             public void keyReleased(KeyEvent e) {}
             
             @Override
     		public void keyPressed(KeyEvent e) {
     			int keyCode = e.getKeyCode();
     			switch (keyCode) {
     			case KeyEvent.VK_UP:
     				mGame.msnake.moveup();     				
     				break;
     			case KeyEvent.VK_DOWN:
     				mGame.msnake.movedown();
     				break;
     			case KeyEvent.VK_LEFT:
     				mGame.msnake.moveleft();
     				break;
     			case KeyEvent.VK_RIGHT:
     				mGame.msnake.moveright();
     				break;
     			}
     			int x1=mGame.msnake.recs.get(0).x1;
     			int y1=mGame.msnake.recs.get(0).y1;
     			int x1enemy=mGame.menemy.x1;
     			int y1enemy=mGame.menemy.x1;
     			if(x1==x1enemy&&y1==y1enemy) {
     				mGame.msnake.additem();
     				mGame.addenemy();
     			}
     			comp.revalidate();
     			comp.repaint();
     		}
         });
		mGame=new Game();
		comp.revalidate();
		comp.setBackground(Color.BLUE);
		comp.repaint();
	}

	
}