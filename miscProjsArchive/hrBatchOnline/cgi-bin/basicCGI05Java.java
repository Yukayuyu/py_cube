import java.io.*;
/*
    CgiHelloJava.java --簡単な CGI のプログラム (Java版)
    ~yas/syspro/www/CgiHelloJava.java
    Created on: 2016/07/29 14:05:12
*/

public class basicCGI05Java {
    static BufferedReader stdin = 
        new BufferedReader( new InputStreamReader(System.in) );
    static PrintStream stdout = System.out;
    static PrintStream stderr = System.err;

    public static void print_header()
    {
        stdout.printf("Content-Type: text/html\n");
        stdout.printf("\n");
    }

    public static void print_content()
    {
        stdout.printf("<HTML><HEAD></HEAD><BODY>\n");
        stdout.printf("hello.\n");
        try{
        stdout.println(stdin.readLine());
        } catch (IOException e){
            stderr.println("ioException, end");
            return;
        }
        stdout.printf("</BODY></HTML>\n");
    }

    public static void main(String argv[])
    {
        print_header();
        print_content();
    }
}
    
