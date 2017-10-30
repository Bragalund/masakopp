package no.bragalund;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester implements Runnable {

    private String urlToRead;
    private Thread t;

    public Requester(String urlToRead) {
        this.urlToRead = urlToRead;
    }

    public String sendGetRequest(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL("http://" + urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public void run() {
        while (true) {
            try {
                long startTime = System.nanoTime();
                String message = sendGetRequest(urlToRead);
                long endTime = System.nanoTime();
                long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
                System.out.println(duration+" ms   "+message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, urlToRead);
            t.start();
        }

    }
}
