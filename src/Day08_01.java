    import com.sun.source.tree.Tree;

    import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Day08_01 {

    public static void main(String[] args) throws IOException, FileNotFoundException{
        Path current = Paths.get(".");
        String s = current.toAbsolutePath().toString();
        System.out.println("Path" + s);

        File inputTxt = new File("src/2022/day01/input.txt");
        BufferedReader input = new BufferedReader(new FileReader(inputTxt));
        String string;
        int visibleTrees = 0;

        ArrayList<String> xyList = new ArrayList<>();

        // Get one string so we can tell the size.
        string = input.readLine();
        xyList.add(string);
        // How long is a row of trees?
        int length = string.length();

        System.out.println("Length of row = " + length);

        // All trees on outside are visible
        visibleTrees = length*2 + ((length-2) *2);

        System.out.println("Outside number of visible trees: " + visibleTrees);

        while ((string = input.readLine()) != null){
            xyList.add(string);

        }
        input.close();



        for (String i: xyList) {
            System.out.println(i);
        }

        for (int row = 1; row < length-1; row++) {
            for (int col =1; col <length-1; col++) {
                int treeSize = Character.getNumericValue(xyList.get(row).charAt(col));
                int tallestTree = 0;
                System.out.println("TreeSize: " + treeSize);
                //Look in all directions to the edge
                boolean visible = false;

                //Look up
                int rowLook = row;
                for (rowLook = row -1; rowLook >= 0; rowLook--) {
                    int treeLookSize = Character.getNumericValue(xyList.get(rowLook).charAt(col));
                    //System.out.println("TreeLookSize:" + treeLookSize + " at row/col: " + rowLook + " " + col);
                    if (treeLookSize > tallestTree)
                        tallestTree = treeLookSize;
                }
                if (tallestTree < treeSize) {
                    visible = true;
                }

                //Look down
                rowLook = row;
                tallestTree = 0;

                for (rowLook = row + 1; rowLook < length; rowLook++) {
                    int treeLookSize = Character.getNumericValue(xyList.get(rowLook).charAt(col));
                    //System.out.println("TreeLookSize: " + treeLookSize + " at row/col: " + rowLook + " " + col);
                    if (treeLookSize > tallestTree)
                        tallestTree = treeLookSize;
                }
                if (tallestTree < treeSize) {
                    visible = true;
                }

                //Look left
                int colLook = col;
                tallestTree = 0;

                for (colLook = col - 1; colLook >= 0; colLook--) {
                    int treeLookSize = Character.getNumericValue(xyList.get(row).charAt(colLook));
                    //System.out.println("TreeLookSize: " + treeLookSize + " at row/col: " + row + " " + colLook);
                    if (treeLookSize > tallestTree)
                        tallestTree = treeLookSize;
                }
                if (tallestTree < treeSize) {
                    visible = true;
                }

                //Look right
                colLook = col;
                tallestTree = 0;

                for (colLook = col + 1; colLook < length; colLook++) {
                    int treeLookSize = Character.getNumericValue(xyList.get(row).charAt(colLook));
                    //System.out.println("TreeLookSize: " + treeLookSize + " at row/col: " + row + " " + colLook);
                    if (treeLookSize > tallestTree)
                        tallestTree = treeLookSize;
                }
                if (tallestTree < treeSize) {
                    visible = true;
                }

                // Visible from any side?
                if(visible == true) {
                    visibleTrees++;
                    System.out.println(" Tree at " + row + " " + col+ " is visible");
                }


                //Compare tallest tree and one at the edge
                //System.out.println("Tallest Tree " + tallestTree);
                //System.out.println(" Tree at edge" + xyList.get(0).charAt(col));
            }
        }

        System.out.println("Number of visible trees: " + visibleTrees);





    }

}
