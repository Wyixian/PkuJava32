package com.edu.pku;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
//文件样例：
//	文件1：
//		apple apple boy candy candy 
//		daily even even fill give 
//	文件2：
//		boy boy candy candy daily 
//		give hello ill juice juice 
//		kill leave mom 
//输出结果为：
//	两个文件总共的词汇表(即所有不重复的单词):
//	ill give fill kill daily mom hello leave candy apple juice even boy 
//	同时出现在两个文件中的交集单词词汇表为:boy  candy  daily  give 
//	文件1包含的单词总数为：10
//	文件2包含的单词总数为：13

//1.读取两个不同的文本文件,输出两个文件总共的词汇表(即所有不重复的单词)
//2.进一步计算同时出现在两个文件中的交集单词词汇表。
//3.统计上述两个文件词汇表中各自包含单词总数。
public class Vocabulary {
		 //读取两个不同的文本文件
		 public static String readTxtFile(String filePath){
             String lineTxt = "";
		        try {
		        	String encoding="GBK";
		            File file=new File(filePath);
		            if(file.isFile() && file.exists()){
		            	InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
		                BufferedReader bufferedReader = new BufferedReader(read);
		                String line = bufferedReader.readLine();
		                while(line != null){
		                    lineTxt = lineTxt + line;
		                    line = bufferedReader.readLine();
		                }
		                read.close();
		            }else{
		                System.out.println("找不到指定的文件");
		            }
		        } catch (Exception e) {
		        	System.out.println("读取文件内容出错");
		        	e.printStackTrace();
		        }
		     return lineTxt;
		 }
		 
		 //1.输出两个文件总共的词汇表(即所有不重复的单词)
		 public HashSet vocabularyNoRepeat(String lineTxt){
			//用于存储总共的词汇表，即不重复的单词
			HashSet hash = new HashSet();
	        //以空白符分割字符串
        	for(int i=0;i<lineTxt.split(" ").length;i++){
            	//将文件内的单词存入HashSet中，利用其不可重复性，获得不重复的单词
            	hash.add(lineTxt.split(" ")[i]);
        	}             
			 System.out.println("两个文件总共的词汇表(即所有不重复的单词):");
			 Iterator it =hash.iterator();
			 while(it.hasNext()){
				 System.out.print(it.next() + " ");
			 }
			 System.out.println();
			 return hash;
		 }
		 
		//2.进一步计算同时出现在两个文件中的交集单词词汇表
		 public void countBoth(String lineTxt1,String lineTxt2){
			 HashSet hash = new HashSet();
	         for(int i=0;i<lineTxt1.split(" ").length;i++){
	        	 hash.add(lineTxt1.split(" ")[i]);
	         }
	         ArrayList list = new ArrayList();
			 for(int i=0;i<lineTxt2.split(" ").length;i++){
				 if(hash.contains(lineTxt2.split(" ")[i])){
					 list.add(lineTxt2.split(" ")[i]+" ");
				 }
			 }			 
			 Collections.sort(list);
			 System.out.print("同时出现在两个文件中的交集单词词汇表为:");
			 for(int i=0;i<list.size()-1;i++){
				 if(!list.get(i).equals(list.get(i+1))){
					 //list.remove(i);
					 System.out.print(list.get(i)+" ");
				 }
			 }
			 System.out.println(list.get(list.size()-1));
			 
		 }
		     
		   
		 public static void main(String argv[]){
		    //mac下文件的绝对路径
			//读取两个不同的文本文件
		    String filePath1 ="/Users/wangyixian/PkuJava32/20151112/vocabularyOne.txt";
		    String filePath2 ="/Users/wangyixian/PkuJava32/20151112/vocabularyTwo.txt";
		    String lineTxt1 = readTxtFile(filePath1);
		    String lineTxt2 = readTxtFile(filePath2);
		    String lineTxt = lineTxt1 + lineTxt2;
	        Vocabulary v = new Vocabulary();
	        //1.输出两个文件总共的词汇表(即所有不重复的单词)
	        HashSet hash = v.vocabularyNoRepeat(lineTxt);
	        //2.进一步计算同时出现在两个文件中的交集单词词汇表
	        v.countBoth(lineTxt1, lineTxt2);
	        //3.统计上述两个文件词汇表中各自包含单词总数
		    System.out.println("文件1包含的单词总数为："+ lineTxt1.split(" ").length);
		    System.out.println("文件2包含的单词总数为："+ lineTxt2.split(" ").length);
	        
		 }
}


