package cn.edu.ldu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author World
 */
public class ClientThread extends Thread {
    private Socket toClientSocket=null;//会话套接字
    private BufferedReader in; //网络输入流
    private PrintWriter out; //网络输出流
    private int clientCounts=0;//在线客户机总数
    public ClientThread(Socket toClientSocket,int clientCounts) { //构造函数
        this.toClientSocket=toClientSocket;
        this.clientCounts=clientCounts;
    }    
    @Override
    public void run(){
        try {          
            // 创建绑定到套接字toClientSocket上的网络输入流与输出流
            in=new BufferedReader(new InputStreamReader(toClientSocket.getInputStream(),"UTF-8"));
            out=new PrintWriter(new OutputStreamWriter(toClientSocket.getOutputStream(),"UTF-8"),true);
            //5. 根据服务器协议，在网络流上进行读写操作
            String recvStr;
            while ((recvStr=in.readLine())!=null){ //只要客户机不关闭，则反复等待和接收客户机消息
               Date date=new Date();
               DateFormat format=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
               String time=format.format(date);
               ServerUI.txtArea.append(toClientSocket.getRemoteSocketAddress()+ " 客户机编号: "+clientCounts+" 消息："+recvStr+" ："+time+"\n"); //解析并显示收到的消息
               //按照echo协议原封不动回送消息
               out.println(toClientSocket.getLocalSocketAddress()+ " 客户机编号: "+clientCounts+" Echo消息："+recvStr+" : "+time);
            }//end while   
            ServerUI.clientCounts--; //客户机总数减1
            //远程客户机断开连接，线程释放资源
            if (in!=null) in.close();
            if (out!=null) out.close();
            if (toClientSocket!=null) toClientSocket.close();             
        }catch (IOException ex) {}
    } //end run
} //end class
