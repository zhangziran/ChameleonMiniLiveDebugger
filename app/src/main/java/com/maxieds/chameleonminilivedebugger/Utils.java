package com.maxieds.chameleonminilivedebugger;

/**
 * Created by mschmidt34 on 12/31/2017.
 */

public class Utils {

    public static char byte2Ascii(byte b) {

        int decAsciiCode = (int) b;
        if (b >= 32 && b < 127) {
            char ch = (char) b;
            return ch;
        }
        else
            return '.';

    }

    public static String bytes2Ascii(byte[] bytes) {

        StringBuilder byteStr = new StringBuilder();
        for(int b = 0; b < bytes.length; b++)
            byteStr.append(String.valueOf(byte2Ascii(bytes[b])));
        return byteStr.toString();

    }

    public static String bytes2Hex(byte[] bytes) {
        if(bytes == null)
            return "<NULL>";
        else if(bytes.length == 0)
            return "";
        StringBuilder hstr = new StringBuilder();
        hstr.append(String.format("%02x", bytes[0]));
        for(int b = 1; b < bytes.length; b++)
            hstr.append(" " + String.format("%02x", bytes[b]));
        return hstr.toString();
    }

    public static byte[] reverseBytes(byte[] bytes) {
        byte[] revArray = new byte[bytes.length];
        for(int b = 0; b < revArray.length; b++)
            revArray[revArray.length - b - 1] = bytes[b];
        return revArray;
    }

    public static byte reverseBits(byte b) {
        int bint = (int) b;
        int rb = 0x00;
        int mask = 0x01 << 7;
        for(int s = 0; s < 4; s++) {
            rb = rb | ((bint & mask) >> (8 / (b + 1) - 1));
            mask = mask >>> 1;
        }
        //return (byte) rb;
        mask = 0x01;
        for(int s = 0; s < 4; s++) {
            rb = rb | ((bint & mask) << (8 / (b + 1) - 1));
            mask = mask << 1;
        }
        return (byte) rb;
    }

    public static byte[] reverseBits(byte[] bytes) {
        byte[] revBytes = reverseBytes(bytes);
        for(int b = 0; b < bytes.length; b++) {
            revBytes[b] = reverseBits(revBytes[b]);
        }
        return revBytes;
    }




}