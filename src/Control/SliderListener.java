package Control;

import Model.Connection;
import View.Frame;
import View.Pannello;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class SliderListener implements MouseListener{
    
    private final Frame mainFrame;
    private final Pannello mainPannello;
    private final Connection cn;

    public SliderListener(Frame mainFrame, Pannello mainPannello, Connection cn) {
        this.mainFrame = mainFrame;
        this.mainPannello = mainPannello;
        this.cn = cn;
        this.mainPannello.sliderAction(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        int temp;
        if(me.getSource()==this.mainPannello.getSl_a0()){
            if(this.cn.getConnection()){
                //System.out.println(this.mainPannello.getSl_a0().getValue());
                temp=((65534/100)*this.mainPannello.getSl_a0().getValue());
                this.cn.sendMessage("analog0="+temp, 0);
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
                this.mainPannello.getSl_a0().setValue(0);
            }
        }
        if(me.getSource()==this.mainPannello.getSl_a1()){
            if(this.cn.getConnection()){
                //System.out.println(this.mainPannello.getSl_a1().getValue());
                temp=((65534/100)*this.mainPannello.getSl_a1().getValue());
                this.cn.sendMessage("analog1="+temp, 0);
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
                this.mainPannello.getSl_a1().setValue(0);
            }
        }
        if(me.getSource()==this.mainPannello.getSl_a2()){
            if(this.cn.getConnection()){
                //System.out.println(this.mainPannello.getSl_a2().getValue());
                temp=((65534/100)*this.mainPannello.getSl_a2().getValue());
                this.cn.sendMessage("analog2="+temp, 0);
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
                this.mainPannello.getSl_a2().setValue(0);
            }
        }
        if(me.getSource()==this.mainPannello.getSl_a3()){
            if(this.cn.getConnection()){
                //System.out.println(this.mainPannello.getSl_a3().getValue());
                temp=((65534/100)*this.mainPannello.getSl_a3().getValue());
                this.cn.sendMessage("analog3="+temp, 0);
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
                this.mainPannello.getSl_a3().setValue(0);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }
    
}
