package com.lambda.app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaApp implements RequestHandler<Object, Object> {

    public Object handleRequest(Object o, Context context) {
        System.out.println("Test Lambda");
        return null;
    }
}
