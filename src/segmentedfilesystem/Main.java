package segmentedfilesystem;

import java.io.*;
import java.util.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;


public class Main {
/*
https://docs.oracle.com/javase/7/docs/api/java/net/DatagramPacket.html

https://docs.oracle.com/javase/7/docs/api/java/net/DatagramSocket.html#receive(java.net.DatagramPacket)

https://docs.oracle.com/javase/7/docs/api/java/net/DatagramSocketImpl.html

https://www.geeksforgeeks.org/java-net-datagramsocket-class-java/
*/
    public static void main(String[] args) throws exception {
      //Datagram socket constructor
      DatagramSocket socket = new DatagramSocket();
      InetAddress address = "heartofgold.morris.umn.edu"
      int port = 6014;
      int length = 1028;
      byte buf[] = { };
      byte buf1[] = new byte[4];
      DatagramPacket dpOUT = new DatagramPacket(buf, 4, length, address, port);
      DatagramPacket dpIN = new DatagramPacket(buf1, 4);

      socket.connect(address, port);

      socket.send(dpOUT);

      //Make loop for receiving packets - Below is just for now
      socket.receive(dpIN);


    }

}


public class Process {

ArrayList<Integer> A1 = new ArrayList<Integer>();
ArrayList<Integer> A2 = new ArrayList<Integer>();
ArrayList<Integer> A3 = new ArrayList<Integer>();
//if (dpIN.getData() == number thing)
if (receive )

}
