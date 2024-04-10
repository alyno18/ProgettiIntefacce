package InputOutputBytes.input;

import java.io.IOException;

public class SimpleInput {

    public static void main(String[] args) throws IOException {
        int count;
        while ((count = System.in.read()) >= 0)
            System.out.write(count);
    }
}