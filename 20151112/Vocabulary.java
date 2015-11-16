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
//�ļ�������
//	�ļ�1��
//		apple apple boy candy candy 
//		daily even even fill give 
//	�ļ�2��
//		boy boy candy candy daily 
//		give hello ill juice juice 
//		kill leave mom 
//������Ϊ��
//	�����ļ��ܹ��Ĵʻ��(�����в��ظ��ĵ���):
//	ill give fill kill daily mom hello leave candy apple juice even boy 
//	ͬʱ�����������ļ��еĽ������ʴʻ��Ϊ:boy  candy  daily  give 
//	�ļ�1�����ĵ�������Ϊ��10
//	�ļ�2�����ĵ�������Ϊ��13

//1.��ȡ������ͬ���ı��ļ�,��������ļ��ܹ��Ĵʻ��(�����в��ظ��ĵ���)
//2.��һ������ͬʱ�����������ļ��еĽ������ʴʻ��
//3.ͳ�����������ļ��ʻ���и��԰�������������
public class Vocabulary {
		 //��ȡ������ͬ���ı��ļ�
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
		                System.out.println("�Ҳ���ָ�����ļ�");
		            }
		        } catch (Exception e) {
		        	System.out.println("��ȡ�ļ����ݳ���");
		        	e.printStackTrace();
		        }
		     return lineTxt;
		 }
		 
		 //1.��������ļ��ܹ��Ĵʻ��(�����в��ظ��ĵ���)
		 public HashSet vocabularyNoRepeat(String lineTxt){
			//���ڴ洢�ܹ��Ĵʻ�������ظ��ĵ���
			HashSet hash = new HashSet();
	        //�Կհ׷��ָ��ַ���
        	for(int i=0;i<lineTxt.split(" ").length;i++){
            	//���ļ��ڵĵ��ʴ���HashSet�У������䲻���ظ��ԣ���ò��ظ��ĵ���
            	hash.add(lineTxt.split(" ")[i]);
        	}             
			 System.out.println("�����ļ��ܹ��Ĵʻ��(�����в��ظ��ĵ���):");
			 Iterator it =hash.iterator();
			 while(it.hasNext()){
				 System.out.print(it.next() + " ");
			 }
			 System.out.println();
			 return hash;
		 }
		 
		//2.��һ������ͬʱ�����������ļ��еĽ������ʴʻ��
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
			 System.out.print("ͬʱ�����������ļ��еĽ������ʴʻ��Ϊ:");
			 for(int i=0;i<list.size()-1;i++){
				 if(!list.get(i).equals(list.get(i+1))){
					 //list.remove(i);
					 System.out.print(list.get(i)+" ");
				 }
			 }
			 System.out.println(list.get(list.size()-1));
			 
		 }
		     
		   
		 public static void main(String argv[]){
		    //mac���ļ��ľ���·��
			//��ȡ������ͬ���ı��ļ�
		    String filePath1 ="/Users/wangyixian/PkuJava32/20151112/vocabularyOne.txt";
		    String filePath2 ="/Users/wangyixian/PkuJava32/20151112/vocabularyTwo.txt";
		    String lineTxt1 = readTxtFile(filePath1);
		    String lineTxt2 = readTxtFile(filePath2);
		    String lineTxt = lineTxt1 + lineTxt2;
	        Vocabulary v = new Vocabulary();
	        //1.��������ļ��ܹ��Ĵʻ��(�����в��ظ��ĵ���)
	        HashSet hash = v.vocabularyNoRepeat(lineTxt);
	        //2.��һ������ͬʱ�����������ļ��еĽ������ʴʻ��
	        v.countBoth(lineTxt1, lineTxt2);
	        //3.ͳ�����������ļ��ʻ���и��԰�����������
		    System.out.println("�ļ�1�����ĵ�������Ϊ��"+ lineTxt1.split(" ").length);
		    System.out.println("�ļ�2�����ĵ�������Ϊ��"+ lineTxt2.split(" ").length);
	        
		 }
}


