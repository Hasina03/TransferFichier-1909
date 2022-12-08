package sock;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Transfert
{

    public static void transfert(InputStream input, OutputStream output, boolean closeOnExit) throws IOException
    {
        byte buf[] = new byte[1024];

        int n;
        while((n=input.read(buf))!=-1) { output.write(buf,0,n);}

        if (closeOnExit){
            input.close();
            output.close();
        }
    }
  }
