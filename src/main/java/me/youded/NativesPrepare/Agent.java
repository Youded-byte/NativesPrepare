package me.youded.NativesPrepare;

import java.lang.instrument.Instrumentation;

public class Agent {
    public static void premain(String args, Instrumentation inst) {
        if (args != null && !args.isBlank()) {
            extractNatives.extractNativeFiles(args);
        }
    }
}