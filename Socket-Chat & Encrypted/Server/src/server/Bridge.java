package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author enes
 */
public class Bridge extends Thread{
    
    private ServerSocket server;
    String text = null;
    int id = 0;
    ArrayList<Clients> threads = new ArrayList<Clients>();
    
    public Bridge(ServerSocket server,String text){
        
        this.server = server;
        this.text = text;
    }

    @Override
    public void run() {
        
        while(true){
            try {
                Socket socket = new Socket();
                socket = server.accept();
                System.out.println(id+" Accept edildi.");
                Clients client = new Clients(socket,id,text); 
                threads.add(id, client);
                client.start();
                id++;
            } catch (Exception e) {
            }
        }
        
    }
    
}
