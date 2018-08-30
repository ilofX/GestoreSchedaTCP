package Control;

import Model.Connection;
import View.Frame;
import View.Pannello;
import View.PannelloDeveloper;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;
import java.util.Random;
import javax.swing.JOptionPane;

public class ListenerMenu implements ActionListener{
    
    private final Random r;
    private final Connection c;
    private final Frame f;

    public ListenerMenu(Frame f,Connection c) {
        this.r = new Random(4);
        this.c = c;
        this.f = f;
        this.f.menuAction(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.f.getiNormal()){
            if(this.f.getContentPane()instanceof PannelloDeveloper){
                //((PannelloDeveloper)this.f.getContentPane()).getB_Disconnetti().doClick();
                if(this.c.getConnection()){
                    this.f.setNormal();
                    ((Pannello)this.f.getContentPane()).getF_ConnectionStatus().setText("Connesso");
                    ((Pannello)this.f.getContentPane()).getF_ConnectionStatus().setBackground(Color.GREEN);
                    ((Pannello)this.f.getContentPane()).getF_ConnectionStatus().setForeground(Color.BLACK);
                    ((Pannello)this.f.getContentPane()).getB_Connetti().setEnabled(false);
                    ((Pannello)this.f.getContentPane()).getB_Disconnetti().setEnabled(true);
                }
                else{
                    this.f.setNormal();
                    ((Pannello)this.f.getContentPane()).getF_ConnectionStatus().setText("Disconnesso");
                    ((Pannello)this.f.getContentPane()).getF_ConnectionStatus().setBackground(Color.RED);
                    ((Pannello)this.f.getContentPane()).getF_ConnectionStatus().setForeground(Color.BLACK);
                    ((Pannello)this.f.getContentPane()).getB_Connetti().setEnabled(true);
                    ((Pannello)this.f.getContentPane()).getB_Disconnetti().setEnabled(false);
                }
            }
        }
        else if(ae.getSource()==this.f.getiDeveloper()){      
            if(this.f.getContentPane() instanceof Pannello){
                //((Pannello)this.f.getContentPane()).getB_Disconnetti().doClick();
                if(this.c.getConnection()){
                    this.f.setDev();
                    ((PannelloDeveloper)this.f.getContentPane()).getF_ConnectionStatus().setText("Connesso");
                    ((PannelloDeveloper)this.f.getContentPane()).getF_ConnectionStatus().setBackground(Color.GREEN);
                    ((PannelloDeveloper)this.f.getContentPane()).getF_ConnectionStatus().setForeground(Color.BLACK);
                    ((PannelloDeveloper)this.f.getContentPane()).getB_Connetti().setEnabled(false);
                    ((PannelloDeveloper)this.f.getContentPane()).getB_Disconnetti().setEnabled(true);
                }
                else{
                    this.f.setDev();
                    ((PannelloDeveloper)this.f.getContentPane()).getF_ConnectionStatus().setText("Disconnesso");
                    ((PannelloDeveloper)this.f.getContentPane()).getF_ConnectionStatus().setBackground(Color.RED);
                    ((PannelloDeveloper)this.f.getContentPane()).getF_ConnectionStatus().setForeground(Color.BLACK);
                    ((PannelloDeveloper)this.f.getContentPane()).getB_Connetti().setEnabled(true);
                    ((PannelloDeveloper)this.f.getContentPane()).getB_Disconnetti().setEnabled(false);
                }
            }
        }
        else if(ae.getSource()==this.f.getiEsci()){
            if(JOptionPane.showConfirmDialog(this.f, "Sicuro di voler Uscire?", "Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                exit(0);
            }
        }
        else if(ae.getSource()==this.f.getiVersion()){
            JOptionPane.showMessageDialog(this.f, "Versione 1.5.1", "Informazioni", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(ae.getSource()==this.f.getiCredits()){
              
        }
        else if(ae.getSource()==this.f.getiEE()){
            if(this.c.getConnection()){
                for(int i=0;i<20;i++){
                    if(i%2==0){
                        this.c.sendMessage("relay"+this.r.nextInt()+"=1",1000);
                    }
                    else{
                        this.c.sendMessage("relay"+this.r.nextInt()+"=0",1000);
                    }
                }
            }
        }
        else{
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
      
}
