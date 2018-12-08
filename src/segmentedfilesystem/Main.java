package segmentedfilesystem;

import java.io.*;
import java.util.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

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

      HashMap<Integer, byte[]> files = new HashMap<Integer, byte[]>();
      HashMap<Integer, byte[]> header = new HashMap<Integer, byte[]>();
      HashMap<Integer, byte[]> finalPacket = new HashMap<Integer, byte[]>();
      //HashMap<Integer, byte[]> packetMap = new HashMap<Integer, byte[]>();

      socket.connect(address, port);

      socket.send(dpOUT);

      boolean finalsComplete = false;
      boolean headersComplete = false;
      boolean filesComplete = false;

      int counter = 0;
      int headerCounter = 0;
      int finalsCounter = 0;
      int fileID = dpIN.getData()[1];

      //Make loop for receiving packets
      //while ( !file1Complete || !file2Complete || !file3Complete) {
      while (counter < 500) {
        socket.receive(dpIN);
        counter++;

        //if true, we know it's a header packet
        if (dpIN.getData()[0] % 2 == 0){
            headerCounter++;
            header.put(fileID, dpIN.getData());
        }

        //if this case, we know it's the last data packet
        else if (dpIN.getData()[0] % 4 == 3) {
          finalsCounter++;
           finalPacket.put(fileID, dpIN.getData());
        }

        else {

        //Creating the packet numbers
        int packetNum1, packetNum2;
        if ( dpIN.getData()[2] < 0) {
          packetNum1 = dpIN.getData()[2] + 256;
        } else {
          packetNum1 = dpIN.getData()[2];
        }

        if ( dpIN.getData()[3] < 0) {
          packetNum2 = dpIN.getData()[3] + 256;
        } else {
          packetNum2 = dpIN.getData()[3];
        }

          files.put(counter, dpIN.getData());

        }

          //System.out.println(Arrays.toString((byte[])header.get(fileID)));
          //System.out.println(Arrays.toString((byte[])files.get(fileID)));
          //System.out.println(Arrays.toString((byte[])finalPacket.get(fileID)));

          if (headerCounter == 3) {
            headersComplete = true;
          }

          if (finalsCounter == 2) {
            finalsComplete = true;
          }

          // if (finalPacket.get(fileID) == files.get(counter.dpIN.getData()[1]) && files.size() == finalPacket.get(packetNum1 + packetNum2)) {
          // filesComplete = true;
        //}

        }

        //System.out.println(Arrays.toString(dpIN.getData()));
        //length will help us know if a packetis a header or an end packet
        //System.out.println(new String(buf, 0, dpIN.getLength()));

    }
  }

/*public class IsFileComplete {
  boolean file1Complete = false;
  boolean file2Complete = false;
  boolean file3Complete = false;
  //Check that hashmap is finished
  //Use getLength to check if a packet is last packet
  //Use last packet's packet number to then see if hashmap is full based on other packet packet number
   switch (dpIN.getData()[0]) {
     case 0:
  boolean file1Complete = true;
  //if (stuff) {
  boolean file2Complete = true;
  //if (stuff) {
  boolean file3Complete = true;

}


}*/
