package level1;

import java.util.*;

/**
 * 문제: 3진법 뒤집기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68935
 *
 * 문제 설명:
 * - 자연수 `n`을 3진법으로 변환한 후, 숫자를 뒤집고 다시 10진법으로 변환하여 반환
 * - 예:
 *   입력: `n = 45`
 *   1) 45 → 3진법 변환 → "1200"
 *   2) 뒤집기 → "0021" (실제 값은 `210`)
 *   3) 다시 10진법 변환 → `2×3² + 1×3¹ + 0×3⁰ = 7`
 *   4) 출력: `7`
 *
 * 해결 방법:
 * 1. `while` 문을 사용하여 `n`을 3진법으로 변환 후, 각 자리수를 `List`에 저장 (자연스럽게 뒤집힘)
 * 2. 저장된 값을 이용하여 10진법으로 다시 변환 (`Math.pow(3, 지수)`)
 * 3. 최적화 코드: `Integer.toString(n, 3)`를 활용하여 간결하게 구현
 */

public class ConvertAndReverseTernary {

    /**
     * 기본 해결 방법 (리스트 사용)
     * @param n 변환할 자연수
     * @return 뒤집은 3진법을 10진법으로 변환한 결과
     */
    public int solution(int n) {
        List<Integer> list1 = new ArrayList<>();
        int answer = 0;

        // 3진법 변환 (뒤집힌 상태로 저장)
        while (n > 0) {
            list1.add(n % 3);
            n /= 3;
        }

        // 뒤집힌 3진법을 10진법으로 변환
        int size = list1.size();
        for (int i = 0; i < size; i++) {
            answer += list1.get(i) * Math.pow(3, size - 1 - i);
        }

        return answer;
    }

    /**
     * 최적화된 해결 방법 (문자열 변환 활용)
     * @param n 변환할 자연수
     * @return 뒤집은 3진법을 10진법으로 변환한 결과
     */
    public int optimizedSolution(int n) {
        // 3진법으로 변환 후 뒤집기
        String reversedTernary = new StringBuilder(Integer.toString(n, 3)).reverse().toString();

        // 10진법으로 변환
        return Integer.parseInt(reversedTernary, 3);
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        ConvertAndReverseTernary converter = new ConvertAndReverseTernary();

        // 기본 해결 방법 테스트
        System.out.println(converter.solution(45)); // 예상 출력: 7

        // 최적화 코드 테스트
        System.out.println(converter.optimizedSolution(45)); // 예상 출력: 7
    }
}
