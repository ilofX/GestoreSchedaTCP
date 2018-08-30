package View;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Frame extends JFrame  {
    
    private final Pannello mainPanel;
    private final PannelloDeveloper devPanel;
    private JMenuBar mBar;
    private JMenu mMode,mFile,mQuestion;
    private JMenuItem iNormal,iDeveloper,iEsci,iVersion,iCredits,iEE;

    public Frame(Pannello pan,PannelloDeveloper panD) throws HeadlessException {
        super("TCP Connector");
        this.setIconImage(new ImageIcon(this.getClass().getResource("/Icon/networking.png")).getImage());
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.mainPanel=pan;
        this.devPanel=panD;
        this.setNormal();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.buildMenu();
        this.setJMenuBar(this.mBar);
        this.setVisible(true);
    }

    public JMenuItem getiNormal() {
        return this.iNormal;
    }
    public JMenuItem getiDeveloper() {
        return this.iDeveloper;
    }
    public JMenuItem getiEsci() {
        return this.iEsci;
    }
    public JMenuItem getiVersion() {
        return this.iVersion;
    }
    public JMenuItem getiCredits() {
        return this.iCredits;
    }
    public JMenuItem getiEE() {
        return this.iEE;
    }
      
    public final void setDev(){
        this.setVisible(false);
        this.setMinimumSize(new Dimension(725, 300));
        this.setPreferredSize(new Dimension(725, 300));
        this.setMaximumSize(new Dimension(725, 300));
        this.setContentPane(this.devPanel);
        this.setVisible(true);
    }
    
    public final void setNormal(){
        this.setVisible(false);
        this.setMinimumSize(new Dimension(935, 300));
        this.setPreferredSize(new Dimension(725, 300));
        this.setMaximumSize(new Dimension(935, 300));
        this.setContentPane(this.mainPanel);
        this.setVisible(true);
    }
    
    private void buildMenu(){
        this.iNormal=new JMenuItem("Normale");
        this.iDeveloper=new JMenuItem("Sviluppatore");
        this.iEsci=new JMenuItem("Esci");
        this.iCredits=new JMenuItem("Crediti");
        this.iVersion=new JMenuItem("Info");
        this.iEE=new JMenuItem("");
        
        this.mMode=new JMenu("Modalità");
        this.mMode.add(this.iDeveloper);
        this.mMode.add(this.iNormal);
        this.mFile=new JMenu("File");
        this.mFile.add(this.iEsci);
        this.mQuestion=new JMenu("?");
        this.mQuestion.add(this.iVersion);
        //this.mQuestion.add(this.iEE);
        
        this.mBar=new JMenuBar();
        this.mBar.add(this.mFile);
        this.mBar.add(this.mMode);
        this.mBar.add(this.mQuestion);
    }
    
    public void windowAction(WindowListener l){
        this.addWindowListener(l);
    }
    
    public void menuAction(ActionListener l){
        this.iNormal.addActionListener(l);
        this.iDeveloper.addActionListener(l);
        this.iEsci.addActionListener(l);
        this.iVersion.addActionListener(l);
        this.iCredits.addActionListener(l);
        this.iEE.addActionListener(l);
    }
}
