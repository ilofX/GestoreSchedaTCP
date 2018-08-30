package View;

import View.Controls.MaxCharactersTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PannelloBase extends JPanel{
    
    protected JLabel l_IP,l_Porta,l_ConnectionStatus;
    protected JButton b_Connetti,b_Disconnetti;
    protected JTextField f_IP1,f_IP2,f_IP3,f_IP4,f_Port,f_ConnectionStatus;

    public PannelloBase() {
        this.setLayout(null);
        this.buildComponentsConnect();
        this.setComponentsConnect();
        this.addComponentsConnect();
    }
    
    public JButton getB_Connetti() {
        return this.b_Connetti;
    }
    public JButton getB_Disconnetti() {
        return this.b_Disconnetti;
    }
    public JTextField getF_IP1() {
        return this.f_IP1;
    }
    public JTextField getF_IP2() {
        return this.f_IP2;
    }
    public JTextField getF_IP3() {
        return this.f_IP3;
    }
    public JTextField getF_IP4() {
        return this.f_IP4;
    }
    public JTextField getF_Port() {
        return this.f_Port;
    }
    public JTextField getF_ConnectionStatus() {
        return this.f_ConnectionStatus;
    }
 
    private void buildComponentsConnect(){
        this.b_Connetti=new JButton("Connetti");
        this.b_Disconnetti=new JButton("Disconnetti");
        this.l_IP=new JLabel("Indirizzo IP");
        this.f_IP1=new JTextField();
        this.f_IP2=new JTextField();
        this.f_IP3=new JTextField();
        this.f_IP4=new JTextField();
        this.l_Porta=new JLabel("Porta");
        this.f_Port=new JTextField();
        this.l_ConnectionStatus=new JLabel("Stato Connessione");
        this.f_ConnectionStatus=new JTextField("Disconnesso");
    }
    
    private void setComponentsConnect(){
        this.l_IP.setBounds(10, 10, 90, 20);
        this.f_IP1.setBounds(10, 40, 40, 20);
        this.f_IP2.setBounds(60, 40, 40, 20);
        this.f_IP3.setBounds(110, 40, 40, 20);
        this.f_IP4.setBounds(160, 40, 40, 20);
        this.l_Porta.setBounds(10, 70, 40, 20);
        this.f_Port.setBounds(10, 100, 60, 20);
        this.b_Connetti.setBounds(10, 140, 85, 20);
        this.b_Disconnetti.setBounds(105, 140, 100, 20);
        this.l_ConnectionStatus.setBounds(10, 200, 150, 20);
        this.f_ConnectionStatus.setBounds(10, 220, 200, 20);
        
        this.f_IP1.setDocument(new MaxCharactersTextField(3));
        this.f_IP1.setText("192");
        this.f_IP2.setDocument(new MaxCharactersTextField(3));
        this.f_IP2.setText("168");
        this.f_IP3.setDocument(new MaxCharactersTextField(3));
        this.f_IP3.setText("4");
        this.f_IP4.setDocument(new MaxCharactersTextField(3));
        this.f_IP4.setText("9");
        this.f_Port.setDocument(new MaxCharactersTextField(5));
        this.f_Port.setText("7");
        this.b_Disconnetti.setEnabled(false);
        
        this.f_ConnectionStatus.setBackground(Color.RED);
        this.f_ConnectionStatus.setEditable(false);
        this.f_ConnectionStatus.setEnabled(false);
        this.f_ConnectionStatus.setForeground(Color.WHITE);
        this.f_ConnectionStatus.setHorizontalAlignment(JTextField.CENTER);
    }
    
    private void addComponentsConnect(){
        this.add(this.l_IP);
        this.add(this.f_IP1);
        this.add(this.f_IP2);
        this.add(this.f_IP3);
        this.add(this.f_IP4);
        this.add(this.l_Porta);
        this.add(this.f_Port);
        this.add(this.b_Connetti);
        this.add(this.b_Disconnetti);
        this.add(this.l_ConnectionStatus);
        this.add(this.f_ConnectionStatus);
    }
    
    public void bottoniAction(ActionListener l){
        this.b_Connetti.addActionListener(l);
        this.b_Disconnetti.addActionListener(l);
    }
}
