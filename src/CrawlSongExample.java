import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args){
        try{
            //mo stream va dua no vao InputStreamReader
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            //close scanner
            scanner.close();
            //Xoa tat ca new line trong content lay duoc
            content = content.replaceAll("\\n+","");
            //loc noi dung content lay duoc trong tag a chua class name_song va in ra danh sach ten bai hat lay duoc theo dieu kien loc
            //regex
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while(m.find()){
                System.out.println(m.group(1));
            }
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
