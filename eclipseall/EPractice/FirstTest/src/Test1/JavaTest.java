package Test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class JavaTest {

	BufferedReader br;
	BufferedWriter bw;

	public JavaTest(String[] in) {
		if(in.length!=2) {
			System.exit(0);
		}else {
			try {
				br = new BufferedReader(new FileReader("I:\\ho\\EPractice\\sample_data.txt"));
				bw = new BufferedWriter(new FileWriter("I:\\ho\\EPractice\\result_data.txt"));

				boolean check;
				int count=1;
				int first = Integer.parseInt(in[0]);
				int second = Integer.parseInt(in[1]);
				//			int first = 7;
				//			int second = 10;
				String str = "";
				check = first<second?true:false;
				System.out.println(check);
				if(check==false) {
					System.out.println("[Warning] 시작범위와 종료범위를 변경합니다.");
					int temp=first;
					first=second;
					second=temp;
				}

				String title = "고객코드\t배송차코드\t고객등급\t주유량\t단가\t지역코드\t휴게소방문횟수\t지불코드\t거래점수\t배송거리";
				System.out.println(title);
				bw.write(title+"\r\n");

				while((str=br.readLine())!=null){
					if(count>=first&&count<=second) {
						String st1 = str.substring(0, 8).trim();
						String st2 = str.substring(8, 9).trim();
						String st3 = str.substring(9, 10).trim();
						String st4 = str.substring(10, 13).trim();
						String st5 = str.substring(13, 17).trim();
						String st6 = str.substring(17, 18).trim();
						String st7 = str.substring(18, 21).trim();
						String st8 = str.substring(21, 22).trim();
						String st9 = str.substring(22, 26).trim();
						String st10 = str.substring(26, 32).trim();
						int i4 = Integer.parseInt(st4.trim());
						int i5 = Integer.parseInt(st5.trim());
						int i7 = Integer.parseInt(st7.trim());
						int i9 = Integer.parseInt(st9.trim());
						int i10 = Integer.parseInt(st10.trim());
						String result = st1+"\t"+st2+"\t"+st3+"\t"+i4+"\t"+i5+"\t"+st6+"\t\t"+i7+"\t"+st8+"\t"+i9+"\t"+i10;
						System.out.println(result);
						bw.write(result+"\r\n");
					}
					count++;
				}

				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new JavaTest(args);
	}
}
