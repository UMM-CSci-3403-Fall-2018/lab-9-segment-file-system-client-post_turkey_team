package segmentedfilesystem;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

    }

}

public class ServerTalk {
  int port = 6014;
  int length = 1028;
  char server = "heartofgold.morris.umn.edu";

  Buffer buf = new Buffer();

  DatagramPacket Converser = new DatagramPacket(byte[], buf, length, server, port);

  DatagramSocket dgs = new DatagramSocket(port, server);

}

public class Process {

ArrayList<Integer> A1 = new ArrayList<Integer>();
ArrayList<Integer> A2 = new ArrayList<Integer>();
ArrayList<Integer> A3 = new ArrayList<Integer>();



}
