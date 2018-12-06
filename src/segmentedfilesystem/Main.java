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

      HashMap<Integer, HashMap<Integer, byte[]>> files = new HashMap<Integer, HashMap<Integer, byte[]>>();
      HashMap<Integer, byte[]> packetMap = new HashMap<Integer, byte[]>();

      socket.connect(address, port);

      socket.send(dpOUT);

      boolean file1Complete = false;
      boolean file2Complete = false;
      boolean file3Complete = false;


      //Make loop for receiving packets - Below is just for now
      while ( !file1Complete || !file2Complete || !file3Complete) {
        socket.receive(dpIN);

        int fileID = dpIN.getData()[1];

        //add 256 to any neg values
        //256* HOB + LOB

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

        //if (files.get(fileID) == null) {
          files.put(fileID, packetMap.put(((256 * packetNum1) + packetNum2), dpIN.getData()));
        //} else {
          //I don't know yet...
        //}

        }

        System.out.println(Arrays.toString(dpIN.getData()));
        //length will help us know if a packetis a header or an end packet
        System.out.println(new String(buf, 0, dpIN.getLength()));

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
}
