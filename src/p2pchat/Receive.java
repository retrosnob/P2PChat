/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justin
 */
public class Receive extends Thread {
    
    ServerSocket server;
    int port;
    Updateable form;
    
    public Receive(Updateable form, int port) {
        this.form = form;
        this.port = port;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        Socket client;
        try {
            while ((client = server.accept()) != null) {
                InputStream in = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = reader.readLine();
                if (line != null) {
                    form.update(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
