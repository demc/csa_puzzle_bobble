import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * Write a description of class Game here.
 * http://www.shooter-bubble.com/puzzle-bobble.php
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game extends PApplet
{
    private ObjectManager objectManager;
    private final int WALL_X = 150;
    private final int WALL_WIDTH = 300;
    
    public void settings() {
        size(600, 480);
    }
    
    public void setup() {
        objectManager = new ObjectManager(this);
        
        Cannon cannon = new Cannon(width / 2, height - 25, 5, 150, color(255));
        cannon.setMinAngle(100);
        cannon.setMaxAngle(260);
        cannon.setAngle(180);
        cannon.setBubble(new Bubble(width / 2, height - 25, 15, randomColor()));
        
        objectManager.setCannon(cannon);
        
        int x = WALL_X + 15;
        int y = 10;
        
        for (int row = 0; row < 4; row++) {
            for (; x < WALL_X + WALL_WIDTH; x += 30) {
                Bubble bubble = new Bubble(x, y, 15, randomColor());
                objectManager.addBubble(bubble);
            }
            
            if (row % 2 == 0) {
                x = WALL_X + 30;
            }
            else {
                x = WALL_X + 15;
            }
            
            y += 30;
        }
    }
    
    public void draw() {
        background(75);
        fill(color(99, 7, 99));
        rect(WALL_X, 0, WALL_WIDTH, 480);
    }
    
    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        
        if (keyCode == LEFT) {
            objectManager.changeCannonAngleBy(-10);
        }
        
        if (keyCode == RIGHT) {
            objectManager.changeCannonAngleBy(10);
        }
    }
    
    public int randomColor() {
        int r = (int) random(0, 5);
        
        switch (r) {
            case 0:
                return color(255, 0, 0);
            case 1:
                return color(0, 0, 255);
            case 2:
                return color(0, 255, 0);
            case 3: 
                return color(255, 127, 0);
            case 4:
                return color (255, 255, 0);
            default:
                return color(0);
        }
    }
}
