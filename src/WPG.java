import worksheet.Worksheet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WPG {

    private Map<Integer, Float> scoreRecord;

    public WPG() {
        scoreRecord = new HashMap<Integer, Float>();
    }

    //각 문제지 마다 점수 저장
    private void addScoreToRecord(Integer worksheetID, Float score) {
        scoreRecord.put(worksheetID, score);
    }

    public static void main(String args[]) {
        WPG wpg = new WPG();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        boolean anotherWorksheet = true;

        //사용자가 종료할 때 까지 반복
        while (anotherWorksheet) {

            //문제지 생성
            Worksheet worksheet = new Worksheet();
            wpg.addScoreToRecord(i, worksheet.getScore());
            System.out.println("\n다시 문제지를 만드시겠습니까? Y/N");
            try {
                String input = br.readLine();
                input = input.replace(" ", "");
                if (!input.equals("Y")) anotherWorksheet = false;
                else i++;
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
    }

}
