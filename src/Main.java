
import Control.ListenerBottoni;
import Control.ListenerFrame;
import Control.ListenerMenu;
import Control.SliderListener;
import Model.Connection;
import View.Frame;
import View.Pannello;
import View.PannelloDeveloper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        
	try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Pannello pan=new Pannello();
        PannelloDeveloper panD=new PannelloDeveloper();
        Frame f=new Frame(pan,panD);
        Connection c=new Connection(f);
        ListenerBottoni lb=new ListenerBottoni(f,pan,c,panD);
        ListenerFrame lf=new ListenerFrame(f);
        ListenerMenu lm=new ListenerMenu(f,c);
        SliderListener sl=new SliderListener(f, pan, c);
    }
}

