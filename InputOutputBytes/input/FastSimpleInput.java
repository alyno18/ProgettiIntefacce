package InputOutputBytes.input;

import java.io.IOException;

public class FastSimpleInput {

    public static void main(String[] args) throws IOException {
        byte[] byteArr = new byte[8];
        int count;
        while ((count = System.in.read(byteArr)) >= 0)
            System.out.write(byteArr, 0, count);
    }
}