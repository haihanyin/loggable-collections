package com.github.haihan.lc.support;

import java.io.PrintStream;

abstract public class Logger {
    protected PrintStream output = System.out;
    private boolean logTraceEnabled = false;
    private boolean logStateEnabled = true;
    private int identation = -1;

    public void setOutput(PrintStream output) {
        this.output = output;
    }

    public void setLogTraceEnabled(boolean logTraceEnabled) {
        this.logTraceEnabled = logTraceEnabled;
    }

    public void setLogStateEnabled(boolean logStateEnabled) {
        this.logStateEnabled = logStateEnabled;
    }

    public void logStart() {
        identation = -1;
    }

    public void logEnd() {

    }

    public void logBlockStart() {
        if (logTraceEnabled) {
            identation++;
        }
    }

    public void logBlockStart(String format, Object... objects) {
        if (logTraceEnabled) {
            identation++;
            logTrace(format, objects);
        }
    }

    public void logBlockEnd() {
        if (logTraceEnabled) {
            identation--;
        }
    }

    public void logBlockEnd(String format, Object... objects) {
        if (logTraceEnabled) {
            logTrace(format, objects);
            identation--;
        }
    }

    public void logTrace(String format, Object... objects) {
        if (logTraceEnabled) {
            output.print(makeIdentation());
            output.printf(format, objects);
            output.println();
        }
    }

    public void logState(String format, Object... objects) {
        if (logStateEnabled) {
            output.printf("====== %s ======\n", String.format(format, objects));
            output.println(printState());
        }
    }

    abstract protected String printState();

    protected String firstLine(String text) {
        text.trim();
        int i = text.indexOf('\n');
        if (i>0) {
            return text.substring(0, i);
        }
        return text;
    }

    private String makeIdentation() {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<identation; i++) {
            sb.append("  ");
        }
        return sb.toString();
    }
}
