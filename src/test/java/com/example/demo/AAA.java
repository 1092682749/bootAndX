package com.example.demo;

import com.example.demo.model.Protocol;
import com.example.demo.utils.ProtocolToObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public  class AAA {
    private String id;
    static String a = "";
    AAA(int a, int b){
        System.out.println("我是第二个包");
    }
    public static float compute(int x, int y,double size){
        int x2 = x * x;
        int y2 = y * y;
        return (float) ((float) Math.sqrt((x2 + y2)) / size);
    }
    public static void main(String[] args) throws IOException {
        Integer i01=59;
        int i02=59;
        Integer i03=Integer.valueOf(59);
        Integer i04=new Integer(59);
        System.out.println(i01==i02);
        System.out.println(i01==i03);
        System.out.println(i03==i04);
        System.out.println(i02==i04);
//        System.out.println(compute(1920,1080,5));
//        ServerSocket service = new ServerSocket(8080);
//        Socket socket = service.accept();
//        InputStream in = socket.getInputStream();
//        BufferedInputStream bin = new BufferedInputStream(in);
//        byte[] bytes = new byte[1024];
//        StringBuilder sb = new StringBuilder();
//        while((bin.read(bytes)) != -1){
//            sb.append(new String(bytes,"utf-8"));
//        }
//        System.out.println(sb.toString().trim());
//        Protocol p = ProtocolToObject.convert(sb.toString().trim());
    }
}
