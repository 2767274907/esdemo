package com.lmf.esdemo.msttest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class test01 {

    @Test
    public void test01(){
        String str = "123456";
        System.out.println("原字符串："+str);
        StringBuffer strs = new StringBuffer();
        for (int i = str.length()-1;i>=0;i--){
            strs.append(str.charAt(i));
        }
        System.out.println("逆序后："+strs.toString());
    }

    @Test
    public void test02() throws UnsupportedEncodingException {
        String ss = "老 sda 历 anjs";
        System.out.println(splitFirst(ss,3));
    }
    public String splitFirst(String str,int num) throws UnsupportedEncodingException {
        int i = 2,n = 0;//bytes的前两个字节是标志位，bytes[0] = -2, bytes[1] = -1, 故从第三位开始
        byte[] bytes = str.getBytes("Unicode");//使用Unicode字符集将字符串编码成byte序列
        for (;i<bytes.length&&n<num;i++){
            if (i%2==1){
                n++;
            }else{
                if (bytes[i] != 0) {
                    n++;
                }
            }
        }
        if(i % 2 == 1) {
            if(bytes[i-1] != 0) {
                i = i -1;
            } else {
                i = i + 1;
            }
        }
        return new String(bytes, 0, i, "Unicode");
    }

    @Test
    public void test03(){
        int [] nums = new int[]{1,50,40,1,5,9,20,4,13,15,6};
        for (int i = 0;i<nums.length;i++){
            for (int j = 0;j<i+1;j++){
                if (nums[i]<nums[j]){
                    int num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                }
            }
        }
        for (int i:nums
             ) {
            System.out.print(i+",");
        }
    }

    @Test
    public void test4(){
        num(1,1,9);
    }

    public void num(int i,int j,int end){
        if (i==j){
            System.out.println(i+"X"+j+"="+(i*j));
        }else{
            System.out.print(i+"X"+j+"="+(i*j)+",");
        }
        if (end==j&&i==end){
            return;
        }
        if (i<j){
            num(i+1,j,end);
        }else{
            i=1;
            num(i,j+1,end);
        }
    }

}
