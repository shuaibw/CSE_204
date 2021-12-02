import java.io.*;

//This generates the most difficult test ever possible under the given
//constraints and writes that to input.txt file
public class TestGen {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("src/input.txt"));
        bw.write("100 10000\n");
        for(int i=0;i<100;i++) bw.write(Integer.MAX_VALUE+" ");
        bw.write('\n');
        bw.close();
    }
}
