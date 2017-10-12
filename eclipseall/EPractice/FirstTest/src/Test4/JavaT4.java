package Test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaT4 {

	int[][] getRotaionSum(int[][] nums){
		int[][] sums = new int[3][3];
		int[][] rou = new int[3][3];
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums[i].length; j++) {
				if(i==0) {
					if(j==0) {
						rou[i+1][j]=nums[i][j];
						continue;
					}
					rou[i][j-1]=nums[i][j];
				}else if(i==1) {
					if(j==0)
						rou[i+1][j]=nums[i][j];
					else if(j==1)
						rou[i][j]=nums[i][j];
					else 
						rou[i-1][j]=nums[i][j];					
				}else if(i==nums.length-1) {
					if(j==nums[i].length-1) {
						rou[i-1][j]=nums[i][j];
						continue;
					}
					rou[i][j+1]=nums[i][j];
				}
			}
		}

		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums.length; j++) {
				sums[i][j] = nums[i][j]+rou[i][j];
			}
		}
		return sums;		
	}

	public static void main(String[] args) throws IOException {
		JavaT4 t4 = new JavaT4();
		int[][] first = {{10,15,20}, {25, 30, 35}, {40, 45, 50}};
		int[][] rou = new int[3][3];
		int[][] sums = new int[3][3];
		int choice=0;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("���� �Է��Ͻðڽ��ϱ�?");
			System.out.print("����:1, �ƴϿ�:2 => ");
			choice=Integer.parseInt(in.readLine());

			switch(choice) {
			case 1:
				for(int i=0; i<first.length; i++) {
					for(int j=0; j<first[i].length; j++) {
						System.out.print("["+i+j+"] = ");
						String a=in.readLine();
						if(a.equals(""))
							a="0";
						first[i][j]=Integer.parseInt(a);
					}
				}
				break;
			case 2:
				break;
			default:
				System.out.println("�ٽ��Է�");
			}
		}while(!(choice==1||choice==2));

		for(int i=0; i<first.length; i++) {
			for(int j=0; j<first[i].length; j++) {
				if(i==0) {
					if(j==0) {
						rou[i+1][j]=first[i][j];
						continue;
					}
					rou[i][j-1]=first[i][j];
				}else if(i==1) {
					if(j==0)
						rou[i+1][j]=first[i][j];
					else if(j==1)
						rou[i][j]=first[i][j];
					else 
						rou[i-1][j]=first[i][j];
				}else if(i==first.length-1) {
					if(j==first[i].length-1) {
						rou[i-1][j]=first[i][j];
						continue;
					}
					rou[i][j+1]=first[i][j];
				}
			}
		}

		System.out.println("=========�ʱⰪ========");
		for(int i=0; i<rou.length; i++) {
			for(int j=0; j<rou[i].length; j++) {
				System.out.print("["+i+", "+j+"]="+rou[i][j]+"\t");
			}
			System.out.println();
		}

		System.out.println("\n\n=========ȸ��========");
		for(int i=0; i<rou.length; i++) {
			for(int j=0; j<rou[i].length; j++) {
				System.out.print("["+i+", "+j+"]="+rou[i][j]+"\t");
			}
			System.out.println();
		}

		System.out.println("\n\n=========���ϱ�========");
		sums=t4.getRotaionSum(first);
		for(int i=0; i<sums.length; i++) {
			for(int j=0; j<sums[i].length; j++) {
				System.out.print("["+i+", "+j+"]="+sums[i][j]+"\t");
			}
			System.out.println();
		}

	}
}
