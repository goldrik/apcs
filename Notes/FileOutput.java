import java.io.FileWriter;
import java.io.IOException;

public class FileOutput
{
    public FileOutput()
    {
        
    }

    public void outputToFileScrambled() throws IOException
    {
        FileWriter fout = new FileWriter("text.txt");
        fout.write("ajf");
        fout.close();
    }
}
