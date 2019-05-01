package tests.services.impl;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TestServiceImpl {
    public Date getTime() {
        return new Date();
    }
}