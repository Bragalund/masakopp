package no.bragalund.poorpoorserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @RequestMapping("/heartbeat")
    public String heartbeatFunction(){
        return "<3";
    }

    @RequestMapping("/heavyheartbeat")
    public String heavyHeartBeatFunction(){
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "<3<3";
    }

}
