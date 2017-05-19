import java.util.ArrayList;
import processing.core.PApplet;

/**
 * Write a description of class ObjectManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ObjectManager
{
    private PApplet app;
    private ArrayList<Bubble> objects;
    private Cannon cannon;
    
    public ObjectManager(PApplet app) {
        this.app = app;
        objects = new ArrayList();
        
        app.registerMethod("draw", this);
    }
    
    public void addBubble(Bubble bubble) {
        objects.add(bubble);
    }
    
    public void setCannon(Cannon cannon) {
        this.cannon = cannon;
    }
    
    public void changeCannonAngleBy(int da) {
        cannon.setAngle(cannon.getAngle() + da);
    }
    
    public void draw() {
        for (Bubble bubble : objects) {
            bubble.draw(app);
        }
        
        if (cannon != null) {
            cannon.draw(app);
        }
    }
}
