package com.mutlukodcu.kkka.discovery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthCheckController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.version:1.0.0}")
    private String appVersion;

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> status = new HashMap<>();

        status.put("status", "UP");
        status.put("application", appName);
        status.put("version", appVersion);

        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        status.put("jvmName", runtimeMxBean.getVmName());
        status.put("jvmVersion", runtimeMxBean.getVmVersion());
        status.put("uptime", runtimeMxBean.getUptime() + " ms");
        status.put("startTime", runtimeMxBean.getStartTime());

        return status;
    }
}
