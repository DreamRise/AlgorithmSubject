import java.io.*;
import java.util.StringTokenizer;

/*
ID:fubo0321
LANG:JAVA
TASK:friday
 */
public class friday {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("friday.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int yearNum = Integer.valueOf(stringTokenizer.nextToken());
        int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] monthDay2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] dateNum = {0,0,0,0,0,0,0};
        int startNum = 13;
        int yearFlag = 0;
        for (int i = 0; i < yearNum; i++) {
            if ((1900 + i) % 4 == 0) {
                if ((1900 + i) % 400 == 0 || (1900 + i) % 100 != 0) yearFlag = 1;
                else yearFlag = 0;
            } else yearFlag = 0;
            if (yearFlag == 0) {
                for (int j = 0; j < 12; j++) {
                    dateNum[startNum%7]++;
                    startNum+=monthDay[j];
                }
            }
            else{
                for (int j=0;j<12;j++){
                    dateNum[startNum%7]++;
                    startNum+=monthDay2[j];
                }
            }
        }
        printWriter.print(dateNum[6]+" ");
        for (int i=0;i<5;i++)
            printWriter.print(dateNum[i]+" ");
        printWriter.println(dateNum[5]);
        printWriter.close();
    }
}
