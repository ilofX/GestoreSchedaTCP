package Control;

import View.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import static java.lang.System.exit;
import javax.swing.JOptionPane;

public class ListenerFrame implements WindowListener{
    
    private final Frame mainFrame;

    public ListenerFrame(Frame mainFrame) {
        this.mainFrame = mainFrame;
        mainFrame.windowAction(this);
    }

    @Override
    public void windowOpened(WindowEvent we) {
        
    }

    @Override
    public void windowClosing(WindowEvent we) {
        if(JOptionPane.showConfirmDialog(this.mainFrame, "Sicuro di voler Uscire?", "Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
            exit(0);
        }  
    }

    @Override
    public void windowClosed(WindowEvent we) {

    }

    @Override
    public void windowIconified(WindowEvent we) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
        
    } 
    
}
