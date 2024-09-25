package com.service.app.config;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SpringFoxConfigTest {

    @Test
    public void test_springFoxConfig() {
        SpringFoxConfig subject = new SpringFoxConfig();
        assertNotNull(subject.docket());
    }

}