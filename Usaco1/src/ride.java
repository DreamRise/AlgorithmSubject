import java.io.*;
import java.util.StringTokenizer;

/*
ID:fubo0321
LANG:JAVA
TASK:ride
 */
class ride {
    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        String text=stringTokenizer.nextToken();
        int sum1=1,sum2=1;
        for (int i=0;i<text.length();i++){
            sum1*=(text.charAt(i)-'A'+1);
        }
        stringTokenizer=new StringTokenizer(bufferedReader.readLine());
        text=stringTokenizer.nextToken();
        for (int i=0;i<text.length();i++){
            sum2*=(text.charAt(i)-'A'+1);
        }
        if ((sum1%47)==(sum2%47)) out.println("GO");
        else out.println("STAY");
        out.close();
    }
}
