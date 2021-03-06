import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Window extends JFrame implements Runnable {
	
	Graphics2D g2;
	KeyHandler kh = new KeyHandler();

	public Window() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(Constants.title);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setVisible(true);
		this.addKeyListener(kh);
		g2 = (Graphics2D) this.getGraphics();
	}
	
	public void update(double dt) {
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		System.out.println(1 / dt + " fps");
		
		Rect rect = new Rect(50, 100, 80, 80, Color.BLUE);
		rect.draw(g2);
//		if(kh.isKeyPressed(KeyEvent.VK_UP)) {
//			System.out.println("Up key is currently pressed");
//		}
//		else if(kh.isKeyPressed(KeyEvent.VK_DOWN)) {
//			System.out.println("Down key is currently pressed");
//		}
	}
	
	@Override
	public void run() {
		double latestFrameTime = 0.0;
		while(true) {
			double time = Time.getTime();
			double deltaTime = time - latestFrameTime;
			latestFrameTime = time;
			
			update(deltaTime);
			
			try {
				Thread.sleep(15);
			} catch(Exception e) {
				
			}
		}
	}

}
