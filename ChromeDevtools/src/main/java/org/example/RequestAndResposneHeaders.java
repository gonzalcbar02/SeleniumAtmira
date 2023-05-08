package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RequestAndResposneHeaders {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request ->{
            Headers headers = request.getRequest().getHeaders();
            if(!headers.isEmpty()){
                System.out.println("Request headers: ");
                headers.forEach((key,value) ->{
                    System.out.println("   "+key+" = "+value);
                });
            }
        });


        devTools.addListener(Network.responseReceived(), response ->{
            Headers headers = response.getResponse().getHeaders();
            if(!headers.isEmpty()){
                System.out.println("Request headers: ");
                headers.forEach((key,value) ->{
                    System.out.println("   "+key+" = "+value);
                });
            }

            System.out.println("Response: URL is: "+response.getResponse().getUrl()+"  status code is: "+response.getResponse().getStatusText());

        });

        //ADDING CUSTOM HEADERS
        Map<String, Object> headers = new HashMap<>();
        headers.put("customHeaderName","customHeaderValue");
        headers.put("Rahul","Automation Tester");
        devTools.send(Network.setExtraHTTPHeaders((Headers) headers));



        driver.get("https://flipkart.com");

    }
}
