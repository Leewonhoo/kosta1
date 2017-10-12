package com.kosta.j0807;

public class StringTest2 {
	public static void main(String[] args) {
		String str = "Java3Pro4gra0mm5ing";
		int j=0;
		
		byte[] b = str.getBytes();
		for(int i=0; i<b.length; i++) {
			if(b[i]<48||b[i]>57) {        //b[i]<'0' || b[i]>'9'
				continue;
			}else {
				j++;
			}
		}
		System.out.println("¼ýÀÚ°¹¼ö : "+j);
		
		j=0;
		char[] c = str.toCharArray();
		for(int i=0; i<c.length; i++) {
			if(c[i]<48||c[i]>57) {        //b[i]<'0' || b[i]>'9'
				continue;
			}else {
				j++;
			}
		}
		System.out.println("¼ýÀÚ°¹¼ö : "+j);
		
		
		String tel = "010-123-4567";
		
		System.out.println("1 : "+tel.substring(0, tel.indexOf('-',1)));
		System.out.println("2 : "+tel.substring((tel.indexOf('-',1)+1), tel.lastIndexOf('-')));
		System.out.println("3 : "+tel.substring(tel.lastIndexOf('-')+1));
		System.out.println("\n");
		System.out.println("1 : "+tel.substring(0, tel.indexOf('-',1)));
		System.out.println("2 : "+tel.substring((tel.indexOf('-',1)+1), (tel.indexOf('-',(tel.indexOf('-',1)+1)))));
		System.out.println("3 : "+tel.substring(tel.lastIndexOf('-')+1));
		
		System.out.println(tel.indexOf('-', 1)+" "+tel.lastIndexOf('-'));
	}
}
