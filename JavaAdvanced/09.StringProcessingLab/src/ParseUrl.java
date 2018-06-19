import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseUrl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String url = reader.readLine();
        String[] tokens = url.split("://");
        if (tokens.length != 2) {
            System.out.println("Invalid URL");
            return;
        }
        String protocol = tokens[0];
        int index = tokens[1].indexOf("/");
        String server = tokens[1].substring(0, index);
        String resources = tokens[1].substring(index + 1);

        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
