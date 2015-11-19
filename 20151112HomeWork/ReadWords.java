package com.sp.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.HashSet;

public class ReadWords {
	//把文件内容读取成String,并返回
	public String readFile(String path) {
		String lines = "";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			String nextLine = br.readLine();
			while(nextLine != null) {
				lines = lines + " " + nextLine;
				nextLine = br.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null)
					br.close();
				if(fr != null)
					fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lines;
	}
	
	public String comWords(String lines1, String lines2) {
		String allString = "两文件单词的并集为：";
		String comString = "两文件单词的交集为：";
		String countString1 = "文件1的单词数为：";
		String countString11 = ",属于文件1但不属于文件2的单词比例:";
		String countString2 = "文件2的单词数为：";
		String countString21 = ",属于文件2但不属于文件1的单词比例:";
		double count1 = 0;
		double count2 = 0;
		double count3 = 0;
		HashSet<String> hs = new HashSet<String>();
		lines1 = lines1.trim();
		lines2 = lines2.trim();
		String[] arrWords1 = lines1.split(" ");
		String[] arrWords2 = lines2.split(" ");
		for(int i = 0; i < arrWords1.length; i++) {
			if(hs.add(arrWords1[i])) {
				allString = allString + " " + arrWords1[i];
				count1++;
			}
		}
		countString1 += count1;
		for(int i = 0; i < arrWords2.length; i++) {
			if(hs.add(arrWords2[i])) {
				allString = allString + " " + arrWords2[i];
			} else {
				comString = comString + " " + arrWords2[i];
				count3++;
			}
			count2++;
		}
		countString2 += count2;
		countString11 += (count1 - count3)/ count1 * 100 + "%.";
		countString21 += (count2 - count3)/ count2 * 100 + "%.";
		return allString + "\n" + comString + "\n" + countString1 + countString11 + "\n" + countString2 + countString21;
	}
	public static void main(String[] args){
		ReadWords rw = new ReadWords();
		String lines1 = rw.readFile("f:/a.txt");
		String lines2 = rw.readFile("f:/b.txt");
		System.out.println(rw.comWords(lines1, lines2));
		
	}
}
