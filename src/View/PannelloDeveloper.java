package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PannelloDeveloper extends PannelloBase {
    
    private JLabel lSend,lReceive;
    private JScrollPane spSend,spReceive;
    private JTextArea taSend,taReceive;
    private JButton bSend;
    
    public PannelloDeveloper() {
        super();
        this.buildComponentSend();
        this.setComponentSend();
        this.addComponentSend();
        this.buildComponentReceive();
        this.setCOmponentReceive();
        this.addComponentReceive();
    }

    public JTextArea getTaSend() {
        return this.taSend;
    }
    public JTextArea getTaReceive() {
        return this.taReceive;
    }
    public JButton getbSend() {
        return this.bSend;
    }

        
    
    private void buildComponentSend(){
        this.lSend=new JLabel("Invia");
        this.taSend=new JTextArea();
        this.spSend=new JScrollPane(this.taSend);
        this.bSend=new JButton("Invia");
    }
    
    private void setComponentSend(){
        this.lSend.setBounds(250 , 10, 60, 20);
        this.spSend.setBounds(250, 40, 200, 100);
        this.bSend.setBounds(250, 160, 80, 20);   
    }

    private void addComponentSend(){
        this.add(this.lSend);
        this.add(this.spSend);
        this.add(this.bSend);
    }
    
    private void buildComponentReceive(){
        this.lReceive=new JLabel("Ricevi");
        this.taReceive=new JTextArea();
        this.spReceive=new JScrollPane(this.taReceive);
    }
        
    private void setCOmponentReceive(){
        this.lReceive.setBounds(500, 10, 60, 20);
        this.spReceive.setBounds(500, 40, 200, 100);
    }
    
    private void addComponentReceive(){
        this.add(this.lReceive);
        this.add(this.spReceive);
    }
    
    @Override
    public void bottoniAction(ActionListener l){
        this.b_Connetti.addActionListener(l);
        this.b_Disconnetti.addActionListener(l);
        this.bSend.addActionListener(l);
    }
}
