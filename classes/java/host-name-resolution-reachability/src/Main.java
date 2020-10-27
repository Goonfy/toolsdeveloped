import javax.imageio.IIOException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String url = "localhost";

        InetAddress address = null;

        try {
            address = InetAddress.getByName(url);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            if (address == null) {
                return;
            }

            System.out.println("HostName: " + url);
            System.out.println("IP: " + address.getHostAddress());
            System.out.println("Host " + url + " reachable: " + address.isReachable(1000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
