package Model.Thread;

import Model.Connection;
import View.Frame;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Send extends Thread {
    
    private final Semaphore sem,ser;
    private final Connection cn;
    private final String message;
    private final Frame f;
    private final int time;

    public Send(Connection cn, String message, Frame f,Semaphore sem,Semaphore ser,int time) {
        this.cn = cn;
        this.message = message;
        this.f = f;
        this.sem = sem;
        this.ser = ser;
        this.time = time;
    }

    @Override
    public void run() {
        String temp="";
        try {
            this.sem.acquire();
                this.cn.getPrintStream().println(this.message);
                temp=this.cn.getBufferReader().readLine();
                this.cn.setRis(temp);
            this.sem.release();
            this.ser.release();
            if(this.time>0){
                this.sleep(this.time);
            }
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this.f,  "Impossibile Inviare il pacchetto all'indirizzo "+this.cn.getScheda().getHostAddress()+" sulla porta "+this.cn.getSocket().getPort()+"\n"+ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        } catch (InterruptedException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
