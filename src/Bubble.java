import processing.core.PApplet;

/**
 * Write a description of class Bubble here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bubble
{
    private int x;
    private int y;
    private int radius;
    private int color;
    private int velocityX;
    private int velocityY;
    private Bubble[] connectedBubbles;
    
    public Bubble(int x, int y, int radius, int color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.connectedBubbles = new Bubble[8];
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getColor() {
        return color;
    }
        
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setVelocityX(int vx) {
        this.velocityX = vx;
    }
    
    public void setVelocityY(int vy) {
        this.velocityY = vy;
    }
    
    public void draw(PApplet app) {
        app.noStroke();
        app.fill(color);
        app.ellipse(x, y, radius * 2, radius * 2);
        
        x += velocityX;
        y += velocityY;      
    }
}
