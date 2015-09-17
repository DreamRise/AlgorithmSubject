import java.io.*;
import java.util.*;

/*
ID:fubo0321
LANG:JAVA
TASK:gift1
 */
class gift1{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader=new BufferedReader(new FileReader("gift1.in"));
        PrintWriter printWriter=new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        int personNum=Integer.valueOf(bufferedReader.readLine());
        List<String> personList=new ArrayList<String>();
        Map<String,Integer> map=new HashMap<String,Integer>();
        String person=null;
        for (int i=0;i<personNum;i++) {
            person=bufferedReader.readLine();
            map.put(person, 0);
            personList.add(person);
        }
        for (int i=0;i<personNum;i++){
            String personName=bufferedReader.readLine();
            StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine()," ");
            int money=Integer.valueOf(stringTokenizer.nextToken());
            int giveNum=Integer.valueOf(stringTokenizer.nextToken());
            map.put(personName,map.get(personName)-money);
            if (giveNum==0){
                map.put(personName,map.get(personName)+money);
                continue;
            }
            for(int j=0;j<giveNum;j++){
                String personReceiveName=bufferedReader.readLine();
                map.put(personReceiveName,map.get(personReceiveName)+money / giveNum);
            }
            map.put(personName, map.get(personName) + money-(money/giveNum)*giveNum);
        }
        for (int i=0;i<personNum;i++)
            printWriter.println(personList.get(i)+" "+map.get(personList.get(i)));
        printWriter.close();
    }
}
