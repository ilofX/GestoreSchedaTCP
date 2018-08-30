package Model.Thread;

import Model.Connection;
import View.Frame;
import View.PannelloBase;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Disconnect extends Thread {
    
    private final Connection cn;
    private final Frame f;
    
    public Disconnect(Connection cn,Frame f) {
        this.cn = cn;
        this.f = f;
    }

    @Override
    public void run() {
        try { 
            this.cn.getSocket().close();
            this.cn.setConnection(false);
            this.cn.socketToNull();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this.f,"Impossibile Terminare la connessione con "+this.cn.getScheda().getHostAddress()+" sulla porta "+this.cn.getSocket().getPort()+"\n"+ex.getMessage() ,"Errore" , JOptionPane.ERROR_MESSAGE);
        }
        finally{
            if(this.cn.getConnection()==false){
                System.out.println("Socket Closed");
                ((PannelloBase)this.f.getContentPane()).getF_ConnectionStatus().setBackground(Color.RED);
                ((PannelloBase)this.f.getContentPane()).getF_ConnectionStatus().setText("Disconnesso");
                ((PannelloBase)this.f.getContentPane()).getF_ConnectionStatus().setForeground(Color.BLACK);
                ((PannelloBase)this.f.getContentPane()).getB_Connetti().setEnabled(true);
                ((PannelloBase)this.f.getContentPane()).getB_Disconnetti().setEnabled(false);
            }    
        }
    }
    
    
    
}
