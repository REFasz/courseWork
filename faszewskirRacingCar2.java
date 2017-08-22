import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;




public class RacingCar2 extends JFrame {
	public RacingCar2(){
		
		add(new MovingCarPanel());
	}
   
   public static int randInt(int min, int max) {


       Random rand = new Random();
   
       int randomNum = rand.nextInt((max - min) + 1) + min;
   
       return randomNum;
   }
	public static void main(String[] args){
		RacingCar2 frame = new RacingCar2();
		frame.setTitle("Racing Car");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	static class MovingCarPanel extends JPanel{
			private int xCoord = 0;
			private int polyX1 = 110;
			private int polyX2 = 130;
			private int polyX3 = 150;
			private int polyX4 = 170;
			private int polyY1 = 50;
			private int polyY2 = 40;
			private int rectX1 = 90;
			private int rectY1 = 50;
			private int rectW = 100;
			private int rectH = 20;
			private int tire1X = 110;
			private int tireY = 69;
			private int tireW = 20;
			private int tireH = 20;
			private int tire2X = 140;
			private int poly2X1 = 110;
			private int poly2X2 = 130;
			private int poly2X3 = 150;
			private int poly2X4 = 170;
			private int poly2Y1 = 200;
			private int poly2Y2 = 190;
			private int rect2X1 = 90;
			private int rect2Y1 = 200;
			private int rect2W = 100;
			private int rect2H = 20;
			private int tire1X2 = 110;
			private int tire2Y = 219;
			private int tire2W = 20;
			private int tire2H = 20;
			private int tire2X2 = 140;
         private int car1speed = 0;
         private int car2speed = 0;
			
		public MovingCarPanel(){
			Timer timer = new Timer(100, new TimerListener());
			timer.start();
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(rectX1 > getWidth()) {
				polyX1 = 0; 
				polyX2 = 20; 
				polyX3 = 40; 
				polyX4 = 60; 
				rectX1 = -20;
				tire1X = 0;
				tire2X = 30; 
				
				poly2X1 = 0;
				poly2X2 = 20;
				poly2X3 = 40;
				poly2X4 = 60;
				rect2X1 = -20;
				tire1X2 = 0;
				tire2X2 = 30;
				
			}
         
         car1speed = randInt(1, 10);
			polyX1 += car1speed;
			polyX2 += car1speed;
			polyX3 += car1speed;
			polyX4 += car1speed;
			rectX1 += car1speed;
			tire1X += car1speed;
			tire2X += car1speed;  
         g.setColor(Color.green);
			Polygon polygon = new Polygon();
			polygon.addPoint(polyX1, polyY1);
			polygon.addPoint(polyX2, polyY2);
			polygon.addPoint(polyX3, polyY2);
			polygon.addPoint(polyX4, polyY1);
		   g.fillPolygon(polygon);
			g.fillRect(rectX1,rectY1,rectW,rectH);
			g.fillOval(tire1X,tireY,tireW,tireH);
			g.fillOval(tire2X,tireY,tireW,tireH);
			
			car2speed = randInt(1, 10);
         poly2X1 += car2speed;
			poly2X2 += car2speed;
			poly2X3 += car2speed;
			poly2X4 += car2speed;
			rect2X1 += car2speed;
			tire1X2 += car2speed;
			tire2X2 += car2speed;  
         g.setColor(Color.red);
			Polygon polygon2 = new Polygon();
			polygon2.addPoint(poly2X1, poly2Y1);
			polygon2.addPoint(poly2X2, poly2Y2);
			polygon2.addPoint(poly2X3, poly2Y2);
			polygon2.addPoint(poly2X4, poly2Y1);
		   g.fillPolygon(polygon2);
			g.fillRect(rect2X1,rect2Y1,rect2W,rect2H);
			g.fillOval(tire1X2,tire2Y,tire2W,tire2H);
			g.fillOval(tire2X2,tire2Y,tire2W,tire2H);
         
       
		}
		class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			repaint();
		}
	}
 }
}