import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileReader {
    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new java.io.FileReader("file.html"));
            String line = reader.readLine();
            while (line!= null){
                String result = getBetweenStrings(line,"<",">","</");
                if(!result.equals("")){
                    System.out.println(result);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getBetweenStrings(String line,String tagStartMark, String tagEndMark, String cutoffMark) {
        String result = line;
        if (result.contains(cutoffMark)) {
            result = result.substring(0, result.indexOf(cutoffMark));
        }
        if(result.contains(tagStartMark) && result.contains(tagEndMark)) {
            while (result.contains(tagEndMark)) {
                result = result.substring(result.indexOf(tagEndMark) + tagEndMark.length(), result.length());
            }
        }else{
            result="";
        }
        return result;
    }
}
