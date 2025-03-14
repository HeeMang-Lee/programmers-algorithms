package level1;

import java.util.Scanner;

/**
 * 문제: 직사각형 별 출력 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12969
 *
 * 문제 설명:
 * - 가로(`a`)와 세로(`b`) 크기의 직사각형을 별(`*`)로 출력
 * - 예:
 *   입력: `5 3`
 *   출력:
 *   *****
 *   *****
 *   *****
 *
 * 해결 방법:
 * 1. `Scanner`를 이용하여 `a`, `b` 입력 받기
 * 2. 중첩 반복문(`for`)을 이용하여 `b`번 반복하면서 `a`개의 `*` 출력
 * 3. 최적화 코드: `repeat()`를 사용하여 한 줄을 한 번에 생성
 */

public class PrintRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 기본 해결 방법 (for문 사용)
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 최적화된 해결 방법 (String.repeat() 사용)
        System.out.println("\n[최적화 코드]");
        String row = "*".repeat(a);
        for (int i = 0; i < b; i++) {
            System.out.println(row);
        }
    }
}
