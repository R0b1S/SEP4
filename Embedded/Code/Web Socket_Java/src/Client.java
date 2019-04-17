
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


import sun.awt.CharsetString;

import java.util.Arrays;
import java.util.Base64;

import com.google.gson.Gson;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import javax.crypto.Cipher;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.math.BigInteger;

//Client class is responsible for receiving measurements from Loriet server using a socket connection

public class Client
{

   private Socket socket;

   private DataOutputStream out;
   private DataInputStream in;
  
   Gson gson;

   public void connect(String ip, int port)
   {

      try
      {
         socket = new Socket(ip, port);
         out = new DataOutputStream(socket.getOutputStream());
         in = new DataInputStream(socket.getInputStream());
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      gson = new Gson();

      // -----------PROTOCOL START--------------

      
      // ------------ PROTOCOL END ---------------

   }

   //not specified which measurements will be received yet
   public void get(Measurement measurement) throws Exception
   {

      out.read(gson.toJson(measurement).getBytes(StandardCharsets.UTF_8));

   }

   
    //Closing the connection.
    
   public void disconnet()
   {
      try
      {
         out.close();
         in.close();
         socket.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

}
