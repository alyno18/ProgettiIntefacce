package InputOutputBytes.copiaFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FastCopyBytes {
    public static void main(String[] args) throws IOException{
        FileInputStream in = new FileInputStream("./InputOutputBytes/copiaFile/origine.x");
        FileOutputStream out = new FileOutputStream("./InputOutputBytes/copiaFile/destinazione.x");

        byte[] buffer = new byte[1000];
        int bytesNumber;

        while ((bytesNumber = in.read(buffer)) >= 0)
            out.write(buffer, 0, bytesNumber);

        in.close();
        out.close();
    }
}
