import java.io.*;

/*
ID:fubo0321
LANG:JAVA
TASK:beads
 */
class beads {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("beads.in"));
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int beadsNum = Integer.valueOf(bufferedReader.readLine());
        String beads = bufferedReader.readLine();
        String beadsCopy=beads;
        beadsCopy=beadsCopy.concat(beads);
        char point1,point2;
        int left=0,right=0,sum=0;
        for (int i=1;i<beadsNum*2;i+=right){
            right=1;left=1;
            if (beadsCopy.charAt(i)=='w') continue;
            point1=beadsCopy.charAt(i);
            point2=beadsCopy.charAt(i-1);
            if (point1==point2) continue;
            for (int j=i-1;j>0;j--){
                if (point2=='w'){
                    if (j>=1)
                        point2=beadsCopy.charAt(j-1);
                }
                else {
                    if (beadsCopy.charAt(j-1) == point2 || beadsCopy.charAt(j-1) == 'w') left++;
                    else break;
                }
            }
            for (int k=i;k<beadsNum*2-1;k++){
                if (beadsCopy.charAt(k+1)==point1 || beadsCopy.charAt(k+1)=='w') right++;
                else break;
            }
            if ((left+right)>sum && (left+right)<=beadsNum) sum=left+right;
        }
        if (sum==0) sum=beadsNum;
        printWriter.println(sum);
        printWriter.close();
    }
}
