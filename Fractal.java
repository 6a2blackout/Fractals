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

    /** Your assignment is to modify drawFractal to be a recursive
    	method that draws a fractal of your own design.
    	
    	The code currently provided in the drawFractal method is 
    	not recursive, and it doesn't draw a fractal. The current
    	version of this method simply demonstrates how to use
    	some of the most common Java drawing methods from the 
    	Graphics class.
    	
    	You may wish to modify the parameters for this method to
    	meet your own needs.
    */
    private void drawFractal(Graphics g, int level, int size, 
                             int x, int y,
                             int red, int green, int blue)
    {   // Code the base case...
    	// if (?????)
        //	return;

		// For your recursive method, here is where to put 
		// code to draw something
		if(level > 1){
			if((level % 2 == 0)){
				drawFractal(g, level-1, size-4, x+(size*size), y-(size*(size)), red+30, green-10, blue-10);
			}
			else{
				drawFractal(g, level-1, size-4, x-(size*size), y+(size*(size)), red-30, green+10, blue+10);
			}
		}
		// The code below can be removed when you create your 
		// recursive fractal method. The code below just 
		// demonstrates how to use various Graphics methods
		
		// Use the color settings that were passed in via
		// the method's parameters
        g.setColor(new Color(red, green, blue));
        
 		// Create arrays of x and y values to show how to
 		// use the fillPolygon method
		
		int[] xPt = {x, x+size, x-size};
		int[] yPt = {y, y+size*2, y+size*2};
		
		g.fillPolygon(xPt, yPt, xPt.length);

		int[] xPt2 = {x, x+size, x-size};
		int[] yPt2 = {y, y-size*2, y-size*2};

		g.fillPolygon(xPt2, yPt2, xPt2.length);

		g.fillRect(x, y, size*3, size/2);
		g.fillRect(x-(size*3), y, size*3, size/2);





		
		// Next, draw two circles with a different color
       
        /*g.setColor(new Color(red-50, green+100, blue+25));
		g.fillOval(x-size*2, y-size*2, size, size);       
		g.fillOval(x+size, y-size*2, size, size);       */
        
        // Finally, a rectangle with yet another color
       /*g.setColor(new Color(red+80, green-100, blue+100));
		g.fillRect(x-size*2, y+size*4, size*4, size/4);  */     
        		
		// ... and then put some recursive calls to the 
		// drawFractal method here.
		//
		// Your recursive calls may have:
		//  - Different positions
		//  - Different colors
		//  - Different level
		//  - Different size
		// ... or some of those may remain the same from one
		// level to the next
		
		// drawFractal (g, level-1, etc....);
		
		
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
