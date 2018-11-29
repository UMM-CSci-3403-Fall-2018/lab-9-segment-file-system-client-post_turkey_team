package segmentedfilesystem;

import java.io.*;
import java.util.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;


public class Main {
// https://www.geeksforgeeks.org/java-net-datagramsocket-class-java/

    public static void main(String[] args) throws IOException {
      //Datagram socket constructor
      int port = 6014;
      DatagramSocket socket = new DatagramSocket(port);
      InetAddress address = InetAddress.getByName("heartofgold.morris.umn.edu");
      int length = 1028;
      byte buf[] = new byte[length];
      DatagramPacket dpOUT = new DatagramPacket(buf, 0, address, port);
      DatagramPacket dpIN = new DatagramPacket(buf, length);

      socket.connect(address, port);

      socket.send(dpOUT);

      //Make loop for receiving packets - Below is just for now
      //while ( !a1Finished || !a2Finished || !a3Finished) {
        socket.receive(dpIN);
        System.out.println(Arrays.toString(dpIN.getData()));
        //length will help us know if a packetis a header or an end packet
        System.out.println(new String(buf, 0, dpIN.getLength()));
    //}


    }

}

public class Process {

boolean a1Finished = false;
boolean a2Finished = false;
boolean a3Finished = false;

ArrayList<Integer> A1 = new ArrayList<Integer>();
ArrayList<Integer> A2 = new ArrayList<Integer>();
ArrayList<Integer> A3 = new ArrayList<Integer>();


}
