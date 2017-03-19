package cn.edu.ldu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import javax.swing.JOptionPane;

/**
 * Echo客户机：根据Echo协议，向服务器发送消息，接收服务器回送的消息。
 * @author 董相志，版权所有2016-2018，upsunny2008@163.com
 */
public class ClientUI extends javax.swing.JFrame {
    private Socket clientSocket=null; //声明客户机套接字
    private BufferedReader in;  //声明网络输入流
    private PrintWriter out; //声明网络输出流
    /**
     * Creates new form EchoClient
     */
    public ClientUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRemoteName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRemotePort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnSpeak = new javax.swing.JButton();
        midPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EchoClient客户机--设计：董相志，版权所有，2016--2018");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        topPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "通信面板", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        jLabel1.setText("服务器主机名：");

        txtRemoteName.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        txtRemoteName.setText("localhost");

        jLabel2.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        jLabel2.setText("服务器端口号：");

        txtRemotePort.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        txtRemotePort.setText("7");

        btnConnect.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        btnConnect.setText("连接服务器");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        jLabel3.setText("待发送消息：");

        txtInput.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });

        btnSpeak.setFont(new java.awt.Font("宋体", 1, 16)); // NOI18N
        btnSpeak.setText("发    言");
        btnSpeak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRemoteName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRemotePort, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtInput)))
                .addGap(26, 26, 26)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConnect, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSpeak, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        topPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnConnect, btnSpeak});

        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRemoteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtRemotePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect))
                .addGap(18, 18, 18)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSpeak))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        midPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "服务器Echo消息面板", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 1, 18))); // NOI18N
        midPanel.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(8, 250));

        txtArea.setEditable(false);
        txtArea.setBackground(new java.awt.Color(255, 153, 255));
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        midPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(midPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //连接服务器
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        try {
            //获取服务器参数
            String remoteName=txtRemoteName.getText();
            int remotePort=Integer.parseInt(txtRemotePort.getText());
            //构建服务器Socket格式的地址
            SocketAddress remoteAddr=new InetSocketAddress(InetAddress.getByName(remoteName),remotePort);
            //1. 创建套接字clientSocket并连接到远程服务器
            clientSocket=new Socket();
            clientSocket.connect(remoteAddr);
            txtArea.append("连接服务器成功,会话开始...\n");
            //2. 创建绑定到套接字clientSocket上的网络输入流与输出流
            out=new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(),"UTF-8"),true);
            in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),"UTF-8"));            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "连接错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        btnConnect.setEnabled(false);
    }//GEN-LAST:event_btnConnectActionPerformed
    //向服务器发送消息，并接收服务器的echo消息
    private void btnSpeakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeakActionPerformed
        // TODO add your handling code here:
        //3. 根据服务器协议，在网络流上进行读写操作
        if (clientSocket==null) {
            JOptionPane.showMessageDialog(null, "请先检查服务器连接情况。\n发言之前要确保客户机连接到服务器！", "错误提示", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //获取待发消息
        String outStr=txtInput.getText();
        if (outStr.length()==0) { //待发消息框为空
            JOptionPane.showMessageDialog(null, "请输入发送消息！","提示",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        //发送
        out.println(outStr);
        txtInput.setText("");
        try {
            //按照echo协议，客户机应立即接收服务器回送消息
            String inStr;
            inStr=in.readLine();
            //收到的echo消息加入下面的文本框
            txtArea.append("Echo: "+inStr+"\n");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "客户机接收消息错误！","错误提示",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSpeakActionPerformed
    //按下回车键
    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        btnSpeakActionPerformed(evt); //直接调用btnSpeak按钮的响应函数即可
    }//GEN-LAST:event_txtInputActionPerformed
    //关闭客户机之前的资源释放工作
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            //4. 关闭并销毁网络流
            if (in!=null) in.close();
            if (out!=null) out.close(); 
            //5. 关闭并销毁套接字
            if (clientSocket!=null) clientSocket.close();
        } catch (IOException ex) {   }          
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnSpeak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel midPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtRemoteName;
    private javax.swing.JTextField txtRemotePort;
    // End of variables declaration//GEN-END:variables
}
