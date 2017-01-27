import gpdraw.*;
import java.awt.Color;

public class GPDrawTest
{
    DrawingTool brush;
    SketchPad canvas;

    GPDrawTest()
    {
        canvas = new SketchPad(600, 400);
        brush = new DrawingTool(canvas);
        // draw();
    }

    public void drawCircles()
    {
        brush.drawCircle(30);
        brush.setColor(new Color(100,100,100));
        brush.fillCircle(20);
    }

    public void drawStar()
    {
        for(int i = 1; i <=5; i++)
        {
            brush.forward(100);
            brush.turn(180);
        }
    }
    
    public void snowman()
    {
        brush.up();
        brush.setColor(new Color(171,176,240));
        brush.forward(100);
        brush.down();
        brush.fillCircle(25);
        brush.up();
        brush.backward(70);
        brush.down();
        brush.fillCircle(50);
        brush.up();
        brush.backward(100);
        brush.down();
        brush.fillCircle(75);
        brush.up();
        brush.setColor(new Color(0,0,0));
        brush.forward(125);
        brush.down();
        brush.fillCircle(5);
        brush.up();
        brush.backward(25);
        brush.down();
        brush.fillCircle(5);
        brush.up();
        brush.backward(25);
        brush.down();
        brush.fillCircle(5);
        brush.up();
        brush.setColor(new Color(50,21,0));
        brush.forward(25);
        brush.turn(90);
        brush.forward(50);
        brush.down();
        brush.forward(80);
        brush.up();
        brush.backward(180);
        brush.down();
        brush.backward(80);
        brush.up();
        brush.setColor(new Color(0,0,0));
        brush.forward(130);
        brush.turn(270);
        brush.forward(85);
        brush.down();
        brush.fillRect(50,4);
        brush.up();
        brush.forward(17);
        brush.down();
        brush.fillRect(40,30);
        brush.up();
        brush.backward(25);
        brush.turn(90);
        brush.forward(10);
        brush.down();
        brush.fillCircle(3);
        brush.up();
        brush.backward(20);
        brush.down();
        brush.fillCircle(3);
        brush.up();
    }
}
