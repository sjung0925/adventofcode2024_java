package com.jjangcute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class day02 {
    public void solution() throws IOException {
        List<String> input = readFile();
        int totalCount = 0;
        for(String line : input){
            String[] arr = line.split(" ");
            int[] intArr = Arrays.stream(arr)
                    .mapToInt(Integer::parseInt)
                    .toArray();

//            System.out.println(line);
            // 두 조건을 충족하는가
            if((is_increase(intArr) || is_decrease(intArr)) && checkRange(intArr)){
                totalCount++;
            }
        }
        System.out.println(totalCount);
    }

    // 증가
    public boolean is_increase(int[] arr){
        boolean check = true;
        increseLoop:for(int i = 0; i < arr.length - 1; i++){
            if(!(arr[i] < arr[i+1])){
                check = false;
                break increseLoop;
            }
        }
        return check;
    }

    // 감소
    public boolean is_decrease(int[] arr){
        boolean check = true;
        decreaseLoop:for(int i = 0; i < arr.length - 1; i++){
            if(!(arr[i] > arr[i+1])){
                check = false;
                break decreaseLoop;
            }
        }
        return check;
    }

    // 범위 확인
    public boolean checkRange(int[] arr){
        boolean check = true;
        diffLoop:
        for(int i = 0; i < arr.length - 1; i++){
            int diffAbs = Math.abs(arr[i] - arr[i+1]);
            if(diffAbs == 0 || diffAbs > 3){
                check = false;
                break diffLoop;
            }
        }
        return check;
    }
    // 파일 읽기
    public List<String> readFile() throws IOException {
        // 줄바꿈을 구분자로 리스트 형식으로 파싱
        return Files.readAllLines(Paths.get("src/input/day02.txt"));
    }

    public static void main(String[] args) throws IOException {
        // 메인
        day02 r = new day02();
        r.solution();
    }
}
