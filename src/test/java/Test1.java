import controller.RequestSender;
import org.jetbrains.annotations.TestOnly;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    @Test
    public void httpGet() throws InterruptedException {

        Long start = System.currentTimeMillis();
                String url = "http://localhost:8081/cloudedisk/user/accountExist";
                Map<String,String> header = new HashMap<>();
                header.put("Content-Type", "application/json; charset=utf-8");
                Map<String,String> param = new HashMap<>();
                param.put("account","account");
                String s = RequestSender.get(url, header, param).getMessage();
                System.out.println(s);
                Long end =System.currentTimeMillis();
                System.out.printf(String.valueOf(end-start));


    }

    @Test
    void test1(){
        System.out.println(1);
    }
}
