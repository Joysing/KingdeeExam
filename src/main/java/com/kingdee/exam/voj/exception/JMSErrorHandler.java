package com.kingdee.exam.voj.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class JMSErrorHandler implements ErrorHandler {
    private static final Logger LOGGER = LogManager.getLogger(JMSErrorHandler.class);
    @Override
    public void handleError(Throwable t) {
        LOGGER.error("Error in listener", t);
    }
}