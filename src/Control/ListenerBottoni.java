package Control;

import Model.Connection;
import View.Controls.CleanInputs;
import View.Frame;
import View.Pannello;
import View.PannelloDeveloper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ListenerBottoni implements ActionListener{

    private final Frame mainFrame;
    private final Pannello mainPannello;
    private final PannelloDeveloper devPannello;
    private final Connection connection;
    private String temp;

    public ListenerBottoni(Frame mainFrame,Pannello mainPannello, Connection connection, PannelloDeveloper devPanel) {
        this.mainFrame = mainFrame;
        this.mainPannello = mainPannello;
        this.devPannello= devPanel;
        this.connection = connection;
        this.devPannello.bottoniAction(this);
        this.mainPannello.bottoniAction(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) throws UnsupportedOperationException {
        if(ae.getSource()==this.mainPannello.getB_Connetti()){
            if(this.connection.getConnection()==false){
                this.connection.connectTo((byte)Integer.parseInt(this.mainPannello.getF_IP1().getText()),(byte)Integer.parseInt(this.mainPannello.getF_IP2().getText()),(byte)Integer.parseInt(this.mainPannello.getF_IP3().getText()),(byte)Integer.parseInt(this.mainPannello.getF_IP4().getText()), Integer.parseInt(this.mainPannello.getF_Port().getText()));
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "La connessione è gia stata stabilita", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource()==this.devPannello.getB_Connetti()){
            if(this.connection.getConnection()==false){
                this.connection.connectTo((byte)Integer.parseInt(this.devPannello.getF_IP1().getText()),(byte)Integer.parseInt(this.devPannello.getF_IP2().getText()),(byte)Integer.parseInt(this.devPannello.getF_IP3().getText()),(byte)Integer.parseInt(this.devPannello.getF_IP4().getText()), Integer.parseInt(this.devPannello.getF_Port().getText()));
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "La connessione è gia stata stabilita", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        
        }
        else if(ae.getSource()==this.mainPannello.getB_Disconnetti()){
            if(this.connection.getConnection()){
                this.connection.closeConnection();
                System.out.println(this.connection.getConnection());
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource()==this.devPannello.getB_Disconnetti()){
            if(this.connection.getConnection()){
                this.connection.closeConnection();
                System.out.println(this.connection.getConnection());
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource()==this.mainPannello.getB_Applica()){
            if(this.connection.getConnection()){
                if(this.mainPannello.getCb_LED1().isSelected()){
                    this.connection.sendMessage("relay1=1",0);
                }
                else if(!this.mainPannello.getCb_LED1().isSelected()){
                    this.connection.sendMessage("relay1=0",0);
                }

                if(this.mainPannello.getCb_LED2().isSelected()){
                    this.connection.sendMessage("relay2=1",0);
                }
                else if(!this.mainPannello.getCb_LED2().isSelected()){
                    this.connection.sendMessage("relay2=0",0);
                }

                if(this.mainPannello.getCb_LED3().isSelected()){
                    this.connection.sendMessage("relay3=1",0);
                }
                else if(!this.mainPannello.getCb_LED3().isSelected()){
                    this.connection.sendMessage("relay3=0",0);
                }

                if(this.mainPannello.getCb_LED4().isSelected()){
                    this.connection.sendMessage("relay4=1",0);
                }
                else if(!this.mainPannello.getCb_LED4().isSelected()){
                    this.connection.sendMessage("relay4=0",0);
                }
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource()==this.mainPannello.getB_Input()){
            if(this.connection.getConnection()){
                CleanInputs cl=new CleanInputs(this.mainPannello);
                this.mainPannello.getB_Input().setEnabled(false);
                String ris="";
                this.temp=this.connection.sendMessage("input?",0);
                Integer len=this.temp.length()-1;
                for(int i=0;i<len;i++){
                    ris+="Input"+(i+1)+"= "+this.temp.charAt(i)+"\n";
                }
                ris+="\n";
                System.out.println(this.temp);
                this.mainPannello.getTa_input().setText(ris);
                cl.start();
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getSource()==this.devPannello.getbSend()){
            if(this.connection.getConnection()){
                String ris="";
                this.temp=this.connection.sendMessage(this.devPannello.getTaSend().getText(),0);
                this.devPannello.getTaReceive().setText(this.temp);
            }
            else{
                JOptionPane.showMessageDialog(this.mainFrame, "Non si è connessi a nessuna scheda", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        
        }
        else{
            throw new UnsupportedOperationException("Operazione Non Supportata");
        }    
    }
    
}
