package View.Controls;

import View.Pannello;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CleanInputs extends Thread{
    
    private final Pannello p;

    public CleanInputs(Pannello p) {
        this.p = p;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<5;i++){
                this.p.getTa_input().setText(this.p.getTa_input().getText()+(5-i));
                sleep(1000);
            }
            this.p.getTa_input().setText("");
            this.p.getB_Input().setEnabled(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(CleanInputs.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    
    
}
