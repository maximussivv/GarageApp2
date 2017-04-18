package Sevices;
import Model.Window;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark
 */
public class WindowService implements Runnable {

    public WindowService() {
    }

    public static String WindowIsOpen() {
        boolean WindowIsOpen = true;
        Window window = new Window(WindowIsOpen);

        Gson gson = new Gson();
        String json = gson.toJson(window);
        return json;
    }

    @Override
    public void run() {

        try {

            ServerSocket listener = new ServerSocket(9090);
            try {

                // Create a JmDNS instance
                JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

                // Register a service
                ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "Audio Service", 9090, "can't be empty?");
                jmdns.registerService(serviceInfo);
                System.out.println("Engine Service is registered");

                //print message
                while (true) {
                    Socket socket = listener.accept();
                    try {
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        out.println("Engine is on!!!");
                    } finally {
                        socket.close();
                    }
                }
            } finally {
                listener.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FanService.class.getName()).log(Level.SEVERE, null, ex);
        }

        throw new UnsupportedOperationException("Not supported yet.");
    }
}

    

