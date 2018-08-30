package Model.Thread;

import Model.Connection;
import View.Frame;
import View.PannelloBase;
import java.awt.Color;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Connect extends Thread{
    
    private final Connection cn;
    private final byte ip[];
    private final int port;
    private final Frame f;

    public Connect(Connection cn,byte Ip1,byte Ip2,byte Ip3,byte Ip4,int port,Frame f) {
        this.cn = cn;
        this.ip = new byte[4];
        this.ip[0] = Ip1;
        this.ip[1] = Ip2;
        this.ip[2] = Ip3;
        this.ip[3] = Ip4;
        this.port = port;
        this.f = f;
    }

    @Override
    public void run() {
        try {
            this.cn.setScheda(InetAddress.getByAddress(this.ip));
            this.cn.getSocket().connect(new InetSocketAddress(this.cn.getScheda(), this.port));
            this.cn.OpenChannels();
            this.cn.setConnection(true);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this.f, "Impossibile Connettersi all'indirizzo "+this.cn.getScheda().getHostAddress()+" sulla porta "+this.port+"\n"+ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this.f, "Impossibile Connettersi all'indirizzo "+this.cn.getScheda().getHostAddress()+" sulla porta "+this.port+"\n"+ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        } finally{
            if(this.cn.getConnection()){
                System.out.println("Connected to "+this.cn.getScheda().getHostAddress()+" on port "+this.port);
                //this.cn.sendMessage("Hello",0);
                ((PannelloBase)this.f.getContentPane()).getF_ConnectionStatus().setBackground(Color.GREEN);
                ((PannelloBase)this.f.getContentPane()).getF_ConnectionStatus().setText("Connesso");
                ((PannelloBase)this.f.getContentPane()).getF_ConnectionStatus().setForeground(Color.BLACK);
                ((PannelloBase)this.f.getContentPane()).getB_Connetti().setEnabled(false);
                ((PannelloBase)this.f.getContentPane()).getB_Disconnetti().setEnabled(true);
            }
        }
    }
   
}
