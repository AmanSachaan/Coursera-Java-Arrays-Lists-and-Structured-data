package ReadingLogFiles;
import java.util.ArrayList;

public class UniqueIpTester {
    public void testUniqIp()
    {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("src/ReadingLogFiles/Weblog/short-test_log");
        int uniqIps=la.countUniqueIps();
        System.out.println("There are "+uniqIps+" unique Ips");
        la.printAllHigherThanNum(200);
        ArrayList<String> list=la.uniqueIpVisitsOnDay("Sep 14");
        for(String i:list)
           System.out.println(i);
        System.out.println("No of Ips in range of 200 and 299 are :"+la.countIPsInRange(200,299));
        System.out.println("No of Ips in range of 300 and 399 are :"+la.countIPsInRange(300,399));

    }
    public static void main(String args[]) {
        UniqueIpTester obj=new UniqueIpTester();
        obj.testUniqIp();
    }
}