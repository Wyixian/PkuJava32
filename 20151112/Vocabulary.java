package com.edu.pku;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
//1.求两个文件单词的并集；
//2.求两个文件单词的交集；
//3.假设单词wd，文件A，文件B,求A，B文件中各自单词总数，
//		wd∈A且wd∉B的单词占A文件的百分比和wd∈B且wd∉A的单词占B文件的百分比。
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
    
    //1.求两个文件单词的并集
    public void vocabularyUnion(String lineTxt){
        //用于存储总共的词汇表，即不重复的单词
        HashSet hash = new HashSet();
        //以空白符分割字符串
        for(int i=0;i<lineTxt.split(" ").length;i++){
            //将文件内的单词存入HashSet中，利用其不可重复性，获得不重复的单词
            hash.add(lineTxt.split(" ")[i]);
        }
        System.out.println("1.两个文件单词的并集:");
        Iterator it =hash.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
    
    //2.求两个文件单词的交集
    public void vocabularySimultaneity(String lineTxt1,String lineTxt2){
        HashSet hash = new HashSet();
        for(int i=0;i<lineTxt1.split(" ").length;i++){
            hash.add(lineTxt1.split(" ")[i]);
        }
        ArrayList list = new ArrayList();
        int countBoth = 0;
        for(int i=0;i<lineTxt2.split(" ").length;i++){
            if(hash.contains(lineTxt2.split(" ")[i])){
                countBoth++;
                list.add(lineTxt2.split(" ")[i]+" ");
            }
        }
        Collections.sort(list);
        System.out.print("2.两个文件单词的交集:");
        for(int i=0;i<list.size()-1;i++){
            if(!list.get(i).equals(list.get(i+1))){
                System.out.print(list.get(i)+" ");
            }
        }
        System.out.println(list.get(list.size()-1));
    }
    
    //3.求A、B文件中各自单词总数;wd∈A且wd∉B的单词占A文件的百分比和wd∈B且wd∉A的单词占B文件的百分比
    public void vocabularyPercentage(String lineTxt1,String lineTxt2){
        int total1 = lineTxt1.split(" ").length;
        int total2 = lineTxt2.split(" ").length;
        System.out.println("文件1包含的单词总数为："+ total1);
        System.out.println("文件2包含的单词总数为："+ total2);
        //wd∈A且wd∉B的单词占A文件的百分比
        HashSet hashB = new HashSet();
        for(int i=0;i<total2;i++){
            hashB.add(lineTxt2.split(" ")[i]);
        }
        int countOnlyA = 0;
        for(int i=0;i<total1;i++){
            if(!hashB.contains(lineTxt1.split(" ")[i])){
                countOnlyA++;
            }
        }
        double countOnly_A = (double)countOnlyA;
        double total_1 = (double)total1;
        NumberFormat formatter = new DecimalFormat("0.00");
        Double percentageA=new Double(countOnly_A/total_1);
        String percentage_A = formatter.format(percentageA);
        System.out.println("wd∈A且wd∉B的单词占A文件的百分比:"+percentage_A);
        //wd∈B且wd∉A的单词占B文件的百分比
        HashSet hashA = new HashSet();
        for(int i=0;i<total1;i++){
            hashA.add(lineTxt1.split(" ")[i]);
        }
        int countOnlyB = 0;
        for(int i=0;i<total2;i++){
            if(!hashA.contains(lineTxt2.split(" ")[i])){
                countOnlyB++;
            }
        }
        double countOnly_B = (double)countOnlyB;
        double total_2 = (double)total2;
        NumberFormat formatter2 = new DecimalFormat("0.00");
        Double percentageB=new Double(countOnly_B/total_2);
        String percentage_B = formatter2.format(percentageB);
        System.out.println("wd∈B且wd∉A的单词占B文件的百分比:"+percentage_B);
        
    }
    
    
    
    public static void main(String[] args){
        //mac下文件的绝对路径
        //读取两个不同的文本文件
        String filePath1 ="/Users/wangyixian/PkuJava32/20151112/vocabularyOne.txt";
        String filePath2 ="/Users/wangyixian/PkuJava32/20151112/vocabularyTwo.txt";
        String lineTxt1 = readTxtFile(filePath1);
        String lineTxt2 = readTxtFile(filePath2);
        String lineTxt = lineTxt1 + lineTxt2;
        Vocabulary v = new Vocabulary();
        //1.求两个文件单词的并集
        v.vocabularyUnion(lineTxt);
        //2.求两个文件单词的交集
        v.vocabularySimultaneity(lineTxt1, lineTxt2);
        //3.求A、B文件中各自单词总数
        //wd∈A且wd∉B的单词占A文件的百分比和wd∈B且wd∉A的单词占B文件的百分比
        v.vocabularyPercentage(lineTxt1, lineTxt2);
        
    }
}
//文件样例：
//文件1：
//	apple apple boy candy candy
//	daily even even fill give
//文件2：
//	boy boy candy candy daily
//	give hello ill juice juice 
//	kill leave mom 

//输出结果为：
//	两个文件总共的词汇表(即所有不重复的单词):
//	ill give fill kill daily mom hello leave candy apple juice even boy 
//	同时出现在两个文件中的交集单词词汇表为:boy  candy  daily  give 
//	文件1包含的单词总数为：10
//	文件2包含的单词总数为：13

