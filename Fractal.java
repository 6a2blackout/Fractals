import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fractal
{
	private int panelHeight, panelWidth;
 
	public Fractal(int panelHeight, int panelWidth)
	{	this.panelHeight = panelHeight;
		this.panelWidth = panelWidth;
	}

    private void drawFractal(Graphics g, int level, int size, 
                             int x, int y,
                             int red, int green, int blue)
    { 
		if(level > 1){
			if((level % 2 == 0)){
				drawFractal(g, level-1, size-4, x+(size*size), y-(size*(size)), red+30, green-10, blue-10);
			}
			else{
				drawFractal(g, level-1, size-4, x-(size*size), y+(size*(size)), red-30, green+10, blue+10);
			}
		}
		
        g.setColor(new Color(red, green, blue));
        
 		
		
		int[] xPt = {x, x+size, x-size};
		int[] yPt = {y, y+size*2, y+size*2};
		
		g.fillPolygon(xPt, yPt, xPt.length);

		int[] xPt2 = {x, x+size, x-size};
		int[] yPt2 = {y, y-size*2, y-size*2};

		g.fillPolygon(xPt2, yPt2, xPt2.length);

		g.fillRect(x, y, size*3, size/2);
		g.fillRect(x-(size*3), y, size*3, size/2);





		
		
		
		
    } // end drawFractal method

    /**
     * draw() is the public method that handles drawing of the fractal 
     * @param g is a reference to the current Graphics object
     */
    public void draw(Graphics g)
    {   int initialLevel = 5;
    	int size = 20;
    	int initialX = (panelWidth/2); // Where do you want your image?
    	int initialY = panelHeight/2;
    	int initialRed = 200;  // red == green == blue is gray
    	int initialGreen = 150;
    	int initialBlue = 150;

    	drawFractal(g, initialLevel, size, 
    	           initialX, initialY,
    	           initialRed, initialGreen, initialBlue);
    } // end draw method

    public static void main(String args[])
    {   new DrawingFrame("Fractal");
    }
} // end Fractal class

class DrawingFrame extends JFrame
{
    public DrawingFrame(String title)
    {   // You can set the width and height of your window
    	// to be whatever size you need
    	int width  = 1780;
    	int height = 1060;
    	setTitle(title); // This appears in the title bar
        setVisible(true);
        setSize(width, height);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new DrawingPanel());
    }
}

class DrawingPanel extends JPanel
{   
	public void paintComponent(Graphics g)
	{   this.setBackground(Color.black);  // You can change this
										  // background color...
		Fractal f = new Fractal(this.getHeight(), this.getWidth());
		f.draw(g); // This calls draw(), which calls drawFractal()
    }
}
