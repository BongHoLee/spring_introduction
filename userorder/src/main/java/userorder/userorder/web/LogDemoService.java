package userorder.userorder.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import userorder.userorder.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String testId) {
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + testId );
    }
}
