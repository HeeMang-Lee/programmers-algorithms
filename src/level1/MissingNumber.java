package level1;

import java.util.Arrays;

/**
 * 문제: 없는 숫자 구하기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/86051
 *
 * 문제 설명:
 * - 0부터 9까지의 숫자 중, 주어진 배열에 포함되지 않은 숫자의 합을 반환합니다.
 * - 예: numbers = [1,2,3,4,6,7,8,0] → 없는 숫자: [5,9] → 결과: 5 + 9 = 14
 *
 * 해결 방법:
 * 1. 0~9까지의 합이 45임을 활용합니다. (0+1+2+...+9 = 45)
 * 2. 주어진 배열의 숫자 합을 구합니다.
 * 3. `45 - (주어진 숫자 합)`을 계산하여 없는 숫자의 합을 구합니다.
 */
public class MissingNumber {
    /**
     * 없는 숫자의 합을 구하는 메서드
     *
     * @param numbers 주어진 숫자 배열 (0~9 중 일부 포함)
     * @return 없는 숫자들의 합
     */
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum(); // 45에서 주어진 숫자의 합을 뺌
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        MissingNumber sol = new MissingNumber();

        // 테스트 1
        int[] test1 = {1, 2, 3, 4, 6, 7, 8, 0};
        System.out.println(sol.solution(test1)); // 예상 출력: 14 (없는 숫자: 5, 9)

        // 테스트 2
        int[] test2 = {5, 8, 4, 0, 6, 7, 9};
        System.out.println(sol.solution(test2)); // 예상 출력: 6 (없는 숫자: 1, 2, 3)
    }
}
