package com.sparta.cicdtest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class OssackController {
    private final Environment env;

    @Value("${ossack-module.version}")
    private String version;

    @GetMapping("/")
    public String version() {
        return String.format("Project Version : %s", version);
    }

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);

        // real, real1, real2 중 하나라도 있으면 그 값 반환
        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);
    }


    @GetMapping("/health")
    public String checkHealth() {
        return "healthy";
    }


}
