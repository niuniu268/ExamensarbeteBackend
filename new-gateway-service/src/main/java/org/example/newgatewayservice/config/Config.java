package org.example.newgatewayservice.config;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class Config implements Ordered {
    @Override
    public int getOrder () {
        return -1;
    }
}
