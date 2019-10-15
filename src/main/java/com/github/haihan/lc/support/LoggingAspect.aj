package com.github.haihan.lc.support;

import java.io.PrintStream;

public aspect LoggingAspect {
    private PrintStream output = System.out;

    after() : execution(@StateChanged * Loggable+.*(..)) || execution(Loggable+.new(..)) {
        Loggable target = (Loggable) thisJoinPoint.getTarget();
        String state = target.printState();
        String signature = thisJoinPoint.getSignature().toLongString();
        output.println(String.format("===== Executed %s =====", signature));
        output.println(state);
    }
}
