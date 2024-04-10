package InputOutputBytes.copiaFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BasicCopyBytes {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream("./InputOutputBytes/copiaFile/origine.x");
        FileOutputStream out = new FileOutputStream("./InputOutputBytes/copiaFile/destinazione.x");

        int c;
        while ((c = in.read()) != -1)
            out.write(c);

        in.close();
        out.close();
    }
}
