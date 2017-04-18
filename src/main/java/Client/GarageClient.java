package Client;


import Frames.DoorGUI;
import Frames.FanGUI;
import Frames.LightsGUI;
import Frames.WindowGUI;
import Sevices.FanService;
import Sevices.LightsService;
import Sevices.WindowService;
import Sevices.DoorService;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
        

/**
 *
 * @author Mark
 */
public class GarageClient extends javax.swing.JFrame {

    /**
     * Creates new form GarageClient
     */
    public GarageClient() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblTitle = new javax.swing.JLabel();
        btnDoor = new javax.swing.JButton();
        btnFan = new javax.swing.JButton();
        btnLights = new javax.swing.JButton();
        btnWindow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayInfo_txt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLblTitle.setText("GarageApp2");

        btnDoor.setBackground(new java.awt.Color(255, 153, 153));
        btnDoor.setText("Door");
        btnDoor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoorActionPerformed(evt);
            }
        });

        btnFan.setBackground(new java.awt.Color(255, 153, 153));
        btnFan.setText("Fan");
        btnFan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEngineActionPerformed(evt);
            }
        });

        btnLights.setBackground(new java.awt.Color(255, 153, 153));
        btnLights.setText("Lights");
        btnLights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLightsActionPerformed(evt);
            }
        });

        btnWindow.setBackground(new java.awt.Color(255, 153, 153));
        btnWindow.setText("Window");
        btnWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRadioActionPerformed(evt);
            }
        });

        DisplayInfo_txt.setColumns(20);
        DisplayInfo_txt.setRows(5);
        jScrollPane1.setViewportView(DisplayInfo_txt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDoor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(btnLights, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLblTitle)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoor)
                    .addComponent(btnFan)
                    .addComponent(btnLights)
                    .addComponent(btnWindow))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private static class SampleListener implements ServiceListener {

        static DataInputStream dataInputStream;
        static Socket socket;

        @Override
        public void serviceAdded(ServiceEvent event) {
            ServiceInfo info = event.getInfo();
            int port = info.getPort();
            String serverAddress = info.getHostAddresses()[0];
            System.out.println("port = " + port + " host = " + serverAddress);

            try {
                System.out.println(" Service added: " + event.getInfo());
                Socket s = new Socket(serverAddress, port);
                BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));

                String answer = input.readLine();
                //JOptionPane.showMessageDialog(null, answer); 
                DisplayInfo_txt.setText(answer);
                s.close();
                
            } catch (IOException ex) {
                Logger.getLogger(GarageClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void serviceRemoved(ServiceEvent se) {
            System.out.println(se.getName()+" is removed. ");
        }

        @Override
        public void serviceResolved(ServiceEvent se) {
            System.out.println(se.getName()+" is resolved.");
        }
    }


    private void btnDoorActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        DisplayInfo_txt.setText("Please wait...");
        DoorService doorservice = new DoorService();
        Thread t = new Thread(doorservice);
        t.start();
        

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.unregisterAllServices();

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());
            
            DoorGUI doorGUI = new DoorGUI();
            doorGUI.setVisible(true);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }                                       

    private void btnEngineActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        DisplayInfo_txt.setText("Please wait..."); 
        FanService fanService = new FanService();
        Thread t = new Thread(fanService);
        t.start();

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());
            
            FanGUI fanGUI = new FanGUI();
            fanGUI.setVisible(true);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }                                         

    private void btnLightsActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        DisplayInfo_txt.setText("Please wait...");
        LightsService lightsService = new LightsService();
        Thread t = new Thread(lightsService);
        t.start();

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());
            
            LightsGUI lightsGUI = new LightsGUI();
            lightsGUI.setVisible(true);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }                                         

    private void btnRadioActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        DisplayInfo_txt.setText("Please wait...");
        WindowService windowService = new WindowService();
        Thread t = new Thread(windowService);
        t.start();

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Add a service listener
            jmdns.addServiceListener("_http._tcp.local.", new SampleListener());
            
            WindowGUI windowGUI = new WindowGUI();
            windowGUI.setVisible(true);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }                                        

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
            java.util.logging.Logger.getLogger(GarageClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GarageClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GarageClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GarageClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GarageClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private static javax.swing.JTextArea DisplayInfo_txt;
    private javax.swing.JButton btnDoor;
    private javax.swing.JButton btnFan;
    private javax.swing.JButton btnLights;
    private javax.swing.JButton btnWindow;
    private javax.swing.JLabel jLblTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
