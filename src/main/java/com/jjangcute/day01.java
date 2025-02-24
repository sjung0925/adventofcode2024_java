package com.jjangcute;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class day1 {
    public class solution{
        List<Integer> left  = new ArrayList<>(); // 왼
        List<Integer> right = new ArrayList<>(); // 오

        int sumDistance = 0; // 총합
    }

    // 총합
    public Integer getSum() throws IOException {
        List<String> result = readFile();
        solution s = new solution();

        for (String line : result) {
            int x = 0; int y = 0;
            x = Integer.parseInt(line.split("   ")[0]);
            y = Integer.parseInt(line.split("   ")[1]);

            // 두개의 리스트로 분리
            s.left.add(x);
            s.right.add(y);
        }
        // 오름차순 정렬
        s.left.sort(Comparator.naturalOrder());
        s.right.sort(Comparator.naturalOrder());

        for(int i = 0; i < s.left.size(); i++){
            // 쌍 간의 차이와 절댓값
            int distance = s.left.get(i) - s.right.get(i);
            distance = Math.abs(distance);

            // 총합
            s.sumDistance += distance;
        }
        System.out.println("result =====> "+s.sumDistance);
        return s.sumDistance;
    }

    // 파일 읽기
    public List<String> readFile() throws IOException {
        // 줄바꿈을 구분자로 리스트 형식으로 파싱
        List<String> lines = Files.readAllLines(Paths.get("src/input/day01.txt"));
//        System.out.println(lines);
        return lines;
    }
}