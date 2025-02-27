package com.jjangcute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class day04 {
    public void solution() throws IOException {
        List<String> r = readFile();
        int totalCount = 0; // 총 등장 횟수
        String[] findWord = {"X", "M", "A", "S"}; // 기준 단어 XMAS

        // 2차원 배열 선언 & 문자열을 하나의 원소로 하는 행렬로 초기화
        String[][] strArr = new String[r.size()][];

        for(int i = 0; i < r.size(); i++){
            String[] charArr = r.get(i).split("");
            strArr[i] = new String[charArr.length];

            System.arraycopy(charArr, 0, strArr[i], 0, charArr.length);
        }

        // 검사할 방향 : 총 8 방향
        int[][] eightDirection = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        // 전체 문자열 순회
        for(int n = 0; n < strArr.length; n++){
            for(int m = 0; m < strArr[n].length; m++){
                // 8방향
                if(strArr[n][m].equals("X")){
                    for (int[] ints : eightDirection) {
                        // 이동한 좌표
                        int newN = n;
                        int newM = m;
                        // 문자를 순회하며 일치할 때마다 문자를 담을
                        String checkWord = "";

                        // 한 방향 당 목표 글자수 만큼만 이동
                        for (int k = 0; k < findWord.length; k++) {
                            // !! 기준이 되는 현재 좌표도 포함하도록 계산을 추가함
                            newN = n + ints[0] * k;
                            newM = m + ints[1] * k;
//                            System.out.println("현재위치 : ("+n+","+m+") 좌표 : ("+newN+","+newM+")");

                            // 현재 위치가 배열 범위 이내인가?
                            if (newN >= 0 && newN < strArr.length && newM >= 0 && newM < strArr[n].length) {
                                // XMAS와 일치하는가
                                if (strArr[newN][newM].equals(findWord[k])) {
                                    checkWord += strArr[newN][newM];

                                    // 문자가 XMAS와 완전히 일치하는가?
                                    if (checkWord.equals("XMAS")) {
                                        totalCount++;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("total =====> "+totalCount);


    }

    // 파일 읽기
    public List<String> readFile() throws IOException {
        // 줄바꿈을 구분자로 리스트 형식으로 파싱
        return Files.readAllLines(Paths.get("src/input/day04.txt"));
    }

    public static void main(String[] args) throws IOException {
        // 메인
        day04 r = new day04();
        r.solution();
    }
}
