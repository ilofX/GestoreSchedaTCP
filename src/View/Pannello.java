package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class Pannello extends PannelloBase{
    
    private JScrollPane sp_input;
    private JTextArea ta_input;
    private JCheckBox cb_LED1,cb_LED2,cb_LED3,cb_LED4;
    private JLabel l_LED,l_Input,l_Analogici,l_A0,l_A1,l_A2,l_A3;
    private JButton b_Applica,b_Input;
    private JSlider sl_a0,sl_a1,sl_a2,sl_a3;
    
    public Pannello() {
        super();
        this.buildComponetsLED();
        this.setComponetsLED();
        this.addComponentsLED();
        this.buildComponentInput();
        this.setComponentInput();
        this.addComponentInput();
        this.buildComponentiAnalogici();
        this.setComponentiAnalogici();
        this.addComponentiAnalogici();
    }

    public JTextArea getTa_input() {
        return this.ta_input;
    }
    public JCheckBox getCb_LED1() {
        return this.cb_LED1;
    }
    public JCheckBox getCb_LED2() {
        return this.cb_LED2;
    }
    public JCheckBox getCb_LED3() {
        return this.cb_LED3;
    }
    public JCheckBox getCb_LED4() {
        return this.cb_LED4;
    }
    public JButton getB_Applica() {
        return this.b_Applica;
    }
    public JButton getB_Input() {
        return this.b_Input;
    }
    public JSlider getSl_a0() {
        return this.sl_a0;
    }
    public JSlider getSl_a1() {
        return this.sl_a1;
    }
    public JSlider getSl_a2() {
        return this.sl_a2;
    }
    public JSlider getSl_a3() {
        return this.sl_a3;
    }
    

    
    private void buildComponetsLED(){
        this.l_LED=new JLabel("Stato LED");
        this.b_Applica=new JButton("Applica");
        this.cb_LED1=new JCheckBox("LED 1");
        this.cb_LED2=new JCheckBox("LED 2");
        this.cb_LED3=new JCheckBox("LED 3");
        this.cb_LED4=new JCheckBox("LED 4");
    }
    
    private void setComponetsLED(){
        this.l_LED.setBounds(250, 10, 80, 20);
        this.cb_LED1.setBounds(250, 40, 100, 20);
        this.cb_LED2.setBounds(250, 70, 100, 20);
        this.cb_LED3.setBounds(250, 100, 100, 20);
        this.cb_LED4.setBounds(250, 130, 100, 20);
        this.b_Applica.setBounds(250, 170, 80, 20);
    }
    
    private void addComponentsLED(){
        this.add(this.l_LED);
        this.add(this.cb_LED1);
        this.add(this.cb_LED2);
        this.add(this.cb_LED3);
        this.add(this.cb_LED4);
        this.add(this.b_Applica);
    }
    
    private void buildComponentInput(){
        this.l_Input=new JLabel("Stato Ingressi");
        this.ta_input=new JTextArea();
        this.sp_input=new JScrollPane(this.ta_input);
        this.b_Input=new JButton("Stato Ingressi");
    }
    
    private void setComponentInput(){
        this.l_Input.setBounds(400, 10, 80, 20);
        this.sp_input.setBounds(400, 40, 200, 100);
        this.b_Input.setBounds(400, 160, 150, 20);
        this.ta_input.setEditable(false);
    }
    
    private void addComponentInput(){
        this.add(this.l_Input);
        this.add(this.sp_input);
        this.add(this.b_Input);
    }
    
    private void buildComponentiAnalogici(){
        this.l_Analogici=new JLabel("Uscite Analogiche");
        this.sl_a0=new JSlider(JSlider.VERTICAL, 0, 100, 0);
        this.sl_a0.setPaintLabels(true);
        this.sl_a0.setPaintTicks(true);
        this.sl_a0.setPaintTrack(true);
        this.sl_a0.setSnapToTicks(true);
        this.sl_a0.setMinorTickSpacing(2);
        this.sl_a0.setMajorTickSpacing(10);
        this.sl_a1=new JSlider(JSlider.VERTICAL, 0, 100, 0);
        this.sl_a1.setPaintLabels(true);
        this.sl_a1.setPaintTicks(true);
        this.sl_a1.setPaintTrack(true);
        this.sl_a1.setSnapToTicks(true);
        this.sl_a1.setMinorTickSpacing(2);
        this.sl_a1.setMajorTickSpacing(10);
        this.sl_a2=new JSlider(JSlider.VERTICAL, 0, 100, 0);
        this.sl_a2.setPaintLabels(true);
        this.sl_a2.setPaintTicks(true);
        this.sl_a2.setPaintTrack(true);
        this.sl_a2.setSnapToTicks(true);
        this.sl_a2.setMinorTickSpacing(2);
        this.sl_a2.setMajorTickSpacing(10);
        this.sl_a3=new JSlider(JSlider.VERTICAL, 0, 100, 0);
        this.sl_a3.setPaintLabels(true);
        this.sl_a3.setPaintTicks(true);
        this.sl_a3.setPaintTrack(true);
        this.sl_a3.setSnapToTicks(true);
        this.sl_a3.setMinorTickSpacing(2);
        this.sl_a3.setMajorTickSpacing(10);
        this.l_A0=new JLabel("A0");
        this.l_A1=new JLabel("A1");
        this.l_A2=new JLabel("A2");
        this.l_A3=new JLabel("A3");
    }
    
    private void setComponentiAnalogici(){
        this.l_Analogici.setBounds(745, 10, 100, 20);
        this.sl_a0.setBounds(650, 40, 60, 180);
        this.sl_a1.setBounds(720, 40, 60, 180);
        this.sl_a2.setBounds(790, 40, 60, 180);
        this.sl_a3.setBounds(860, 40, 60, 180);
        this.l_A0.setBounds(665, 225, 40, 20);
        this.l_A1.setBounds(735, 225, 40, 20);
        this.l_A2.setBounds(805, 225, 40, 20);
        this.l_A3.setBounds(875, 225, 40, 20);
    }
    
    private void addComponentiAnalogici(){
        this.add(this.l_Analogici);
        this.add(this.sl_a0);
        this.add(this.sl_a1);
        this.add(this.sl_a2);
        this.add(this.sl_a3);
        this.add(this.l_A0);
        this.add(this.l_A1);
        this.add(this.l_A2);
        this.add(this.l_A3);
    }
    
    @Override
    public void bottoniAction(ActionListener l){
        this.b_Connetti.addActionListener(l);
        this.b_Disconnetti.addActionListener(l);
        this.b_Applica.addActionListener(l);
        this.b_Input.addActionListener(l);
    }
    
    public void sliderAction(MouseListener l){
        this.sl_a0.addMouseListener(l);
        this.sl_a1.addMouseListener(l);
        this.sl_a2.addMouseListener(l);
        this.sl_a3.addMouseListener(l);
    }
}
