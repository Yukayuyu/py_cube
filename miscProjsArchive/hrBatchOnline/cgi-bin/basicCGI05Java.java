import java.io.*;
/* 
    CgiHelloJava.java --簡単な CGI のプログラム (Java版)
    ~yas/syspro/www/CgiHelloJava.java
    Created on: 2016/07/29 14:05:12
    Modified by: chnnn
    Modified on: 2020/06/19
*/

public class basicCGI05Java {
    static BufferedReader stdin = 
        new BufferedReader( new InputStreamReader(System.in) );
    static PrintStream stdout = System.out;
    static PrintStream stderr = System.err;

    public static void print_meta() {
        stdout.printf("Content-Type: text/html\n\n");
        stdout.printf("<!DOCTYPE html>\n");
        stdout.printf("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\">\n");
    }

    public static void print_head() {
        stdout.printf(
            "<head>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "<title>Title is title</title>\n" +
            "</head>\n"
        ); 
    }

    public static void print_body(int contentLength) {
        stdout.printf("<body>\n");
        char[] buffer = new char[4096];
        int count = 0;
        int lengthPrinted = 0;
        int lenToRead = 0;
        try{
            stdout.printf("$ContentLength=" + contentLength + "\n");
            // Method1:
            // for(String line=stdin.readLine(); line != null; line=stdin.readLine()){
            //     stdout.println(line);
            // }
            // Method2:
            // while ((count = stdin.read(buffer)) > 0){
            //     stdout.print(buffer);
            // }
            // Method3:
            if(contentLength < buffer.length)
                lenToRead  = contentLength;
            else
                lenToRead = buffer.length;
            while ((count = stdin.read(buffer, 0, lenToRead)) > 0){ 
                stdout.print(buffer);
                lengthPrinted += lenToRead;
                lenToRead = contentLength - lengthPrinted;
            }

        } catch (IOException e){
            throw new RuntimeException("ioException, end");
        }finally{
            stdout.printf("</body>\n");
        }
    }
    public static void print_tail(){
        stdout.printf("</html>\n"); 
    }

    public static void main(String argv[]) {
        int contentLength = Integer.parseInt(argv[0]);
        print_meta();
        print_head();
        try{
            print_body(contentLength);  
        }finally{
            print_tail();
        }
    }
} 