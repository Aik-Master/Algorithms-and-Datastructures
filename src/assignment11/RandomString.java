package assignment11;

import java.util.Random;

class RandomString{

    private static final char[] symbols = new char[62];

    static{
        for(int i = 0 ; i < 26 ; ++i)
            symbols[i] = (char) ('a' + i);
        for(int i = 26 ; i < 52 ; ++i)
            symbols[i] = (char) ('A' + i - 26);
    }

    private final Random        random  = new Random();

    private final char[]        buf;

    public RandomString(int length){
        if(length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }

    public String nextString(){
        for(int i = 0 ; i < buf.length ; ++i)
            buf[i] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

}