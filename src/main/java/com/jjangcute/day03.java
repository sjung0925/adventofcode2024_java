package com.jjangcute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day03 {
    public void solution() throws IOException {
        int mul;
        int totalMul = 0;

        String f = readFile();
        String rgx = "mul\\(\\d{1,3},\\d{1,3}\\)"; // mul(숫자,숫자) 를 가려낼 정규표현식

        Pattern pattern = Pattern.compile(rgx);
        Matcher matcher = pattern.matcher(f);

        while (matcher.find()){ // 패턴을 찾을 때 마다
            // 숫자와 콤마만 남기고 공백치환
            String number = matcher.group().replaceAll("([^\\d{1,3},\\d{1,3}])", "");
            String[] arr = number.split(",");

            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);

            mul = n * m;
            totalMul += mul;
        }

        System.out.println(totalMul);
    }

    // 파일 읽기
    public String readFile() throws IOException {
        // 줄바꿈을 구분자로 리스트 형식으로 파싱
        return Files.readString(Paths.get("src/input/day03.txt"));
    }

    public static void main(String[] args) throws IOException {
        // 메인
        day03 r = new day03();
        r.solution();
    }
}
