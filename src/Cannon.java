import processing.core.PApplet;

/**
 * Write a description of class Cannon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cannon
{
    private int x;
    private int y;
    private int width;
    private int height;
    private int color;
    private float angle;
    private float minAngle;
    private float maxAngle;
    private Bubble bubble;
    
    public Cannon(int x, int y, int width, int height, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    public float getAngle() {
        return angle;
    }
    
    public void setAngle(float a) {
        if (a >= this.minAngle && a <= this.maxAngle) {
            this.angle = a;
        }
    }
    
    public void setMinAngle(float angle) {
        this.minAngle = angle;
    }
    
    public void setMaxAngle(float angle) {
        this.maxAngle = angle;
    }
    
    public void setBubble(Bubble bubble) {
        this.bubble = bubble;
    }

    public Bubble launchBubble(int initialVelocity) {
        Bubble b = bubble;

        // clear bubble
        bubble = null;

        // TODO
        b.setVelocityX(initialVelocity);
        b.setVelocityY(initialVelocity);

        return b;
    }

    public void draw(PApplet app) {
        app.pushStyle();
        app.pushMatrix();
        app.rectMode(app.CENTER);
        app.translate(x, y);
        app.rotate(app.radians(angle));
        app.noStroke();
        app.fill(color);
        app.rect(0, 0, width, height);
        app.triangle(0, height / 2 + 15, 7, height / 2, -7, height / 2);
        app.popMatrix();
        app.popStyle();

        if (bubble != null) {
            bubble.draw(app);
        }
    }
}
