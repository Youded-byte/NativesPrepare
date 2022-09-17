package me.youded.NativesPrepare;

public class Main {
    public static void main(String[] args) {
        if (args != null && args.length > 0)
            extractNatives.extractNativeFiles(String.join("", args));
    }
}
