import javax.swing.*;
import java.util.Random;

public class Generate {
    int[] was;
    int[] generated;
    Random random;
    Generate(int dim){
        was = new int[dim+1];
        generated = new int[dim+1];
        random = new Random();
        int x;
        for (int i = 1; i <= dim; i++) {
            x = random.nextInt(dim);
            while (was[x] == 1) {
                x = random.nextInt(dim);
            }
            was[x] = 1;
            generated[i]=x;
        }
    }

    public int[] getGenerated() {
        return generated;
    }
}
