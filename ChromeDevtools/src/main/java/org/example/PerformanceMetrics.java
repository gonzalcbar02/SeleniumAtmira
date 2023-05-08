package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.performance.Performance;
import org.openqa.selenium.devtools.v85.performance.model.Metric;

import java.util.List;
import java.util.Optional;

public class PerformanceMetrics {
    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)));

        driver.get("http://google.com");

        List<Metric> metricList = devTools.send(Performance.getMetrics());

        metricList.forEach(metric -> System.out.println(metric.getName()+" : "+metric.getValue()));



    }
}
