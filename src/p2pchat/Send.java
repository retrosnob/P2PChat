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
public class Send extends Thread {
    
    String msg, hostname;
    int port;
    
    public Send(String msg, String hostname, int port) {
        this.msg = msg;
        this.hostname = hostname;
        this.port = port;
    }
    
    @Override
    public void run() {
        try {
            Socket socket = new Socket(hostname, port);
            socket.getOutputStream().write(msg.getBytes());
            socket.close()   ;
        } catch (IOException ex) {
            Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
