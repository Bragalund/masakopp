package no.bragalund;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Requester requester1 = new Requester("localhost:8080/heartbeat");
        requester1.start();

        Requester requester2 = new Requester("localhost:8080/heavyheartbeat");
        requester2.start();

        Requester requester3 = new Requester("localhost:8080/heartbeat");
        requester3.start();

        while(true){
            Requester requester = new Requester("localhost:8080/heartbeat");
            requester.start();
        }

    }
}
