package Model;

import Model.Thread.Connect;
import Model.Thread.Disconnect;
import Model.Thread.Send;
import View.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connection{
    
    private final Semaphore semPrinter,semReader;
    private String ris;
    private Connect tCon;
    private Disconnect dCon;
    private Send sMessage;
    private boolean Connection;
    private InputStream inFromServer;
    private OutputStream outToServer;
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private Socket socket;
    private InetAddress scheda;
    private final Frame f;

    public Connection(Frame f) {
        this.semPrinter=new Semaphore(1);
        this.semReader=new Semaphore(0);
        this.ris="";
        this.f=f;
        this.Connection=false;
    }

    public Socket getSocket() {
        return this.socket;
    }
    public InetAddress getScheda() {
        return this.scheda;
    }
    public boolean getConnection(){
        return this.Connection;
    }
    public void setScheda(InetAddress scheda) {
        this.scheda = scheda;
    }
    public void setConnection(boolean Connection){
        this.Connection = Connection;
    }
    public void setRis(String ris) {
        this.ris = ris;
    }
    public PrintStream getPrintStream() {
        return this.printStream;
    }
    public BufferedReader getBufferReader() {
        return this.bufferReader;
    }
    public Semaphore getSemPrinter() {
        return this.semPrinter;
    }
    public Semaphore getSemReader() {
        return this.semReader;
    }
    
    public void closeBuffer() throws IOException{
        this.bufferReader.close();
        this.inFromServer.close();
        this.printStream.close();
    }
    
    public void socketToNull(){
        this.socket=null;
    }
    
    public void OpenChannels() throws IOException {
        this.inFromServer=this.socket.getInputStream();
        this.bufferReader=new BufferedReader(new InputStreamReader(this.inFromServer));
        this.outToServer=this.socket.getOutputStream();
        this.printStream=new PrintStream(this.outToServer);
    }
    
    public void connectTo(byte ip1, byte ip2, byte ip3, byte ip4,int port){
        this.socket=new Socket(); 
        this.tCon=new Connect(this, ip1, ip2, ip3, ip4, port,this.f);
        this.tCon.start();
    }
    
    public String sendMessage(String message,int time) {
            this.ris = "";
            this.sMessage=new Send(this,message,this.f,this.semPrinter, this.semReader,time);
            this.sMessage.setName(message);
            this.sMessage.start();   
        try {
            this.semReader.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.ris;
    }
    
    public void closeConnection(){
        this.dCon=new Disconnect(this, this.f);
        this.dCon.start();
    }  
    
}
