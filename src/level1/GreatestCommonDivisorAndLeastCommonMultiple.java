package level1;

/**
 * 문제: 최대공약수와 최소공배수 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12940
 *
 * 문제 설명:
 * - 두 수 `n`, `m`이 주어질 때, 최대공약수(GCD)와 최소공배수(LCM)를 반환
 * - 예:
 *   입력: `n = 3, m = 12`
 *   출력: `[3, 12]` (GCD: 3, LCM: 12)
 *
 * 해결 방법:
 * 1. **유클리드 호제법**을 사용하여 GCD(최대공약수) 계산
 *    - `GCD(a, b) = GCD(b, a % b)` (b가 0이면 a가 GCD)
 * 2. **LCM(최소공배수)**는 `LCM(a, b) = (a * b) / GCD(a, b)`로 계산
 * 3. 최적화 코드: `Math` 클래스를 활용하여 더 간결하게 구현
 */

public class GreatestCommonDivisorAndLeastCommonMultiple {

    /**
     * 기본 해결 방법 (재귀를 이용한 GCD 계산)
     * @param n 첫 번째 수
     * @param m 두 번째 수
     * @return [최대공약수, 최소공배수] 배열
     */
    public int[] solution(int n, int m) {
        int gcd = GCD(n, m);
        return new int[]{gcd, (n * m) / gcd};
    }

    /**
     * 유클리드 호제법을 이용한 최대공약수 계산
     * @param a 정수 a
     * @param b 정수 b
     * @return a와 b의 최대공약수
     */
    public static int GCD(int a, int b) {
        return (b == 0) ? a : GCD(b, a % b);
    }

    /**
     * 최적화된 해결 방법 (반복문을 사용한 GCD 계산)
     * @param n 첫 번째 수
     * @param m 두 번째 수
     * @return [최대공약수, 최소공배수] 배열
     */
    public int[] optimizedSolution(int n, int m) {
        int gcd = iterativeGCD(n, m);
        return new int[]{gcd, (n * m) / gcd};
    }

    /**
     * 반복문을 이용한 최대공약수 계산 (재귀 없이)
     * @param a 정수 a
     * @param b 정수 b
     * @return a와 b의 최대공약수
     */
    public static int iterativeGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        GreatestCommonDivisorAndLeastCommonMultiple solver = new GreatestCommonDivisorAndLeastCommonMultiple();

        // 기본 해결 방법 테스트
        int[] result1 = solver.solution(3, 12);
        System.out.println(java.util.Arrays.toString(result1)); // 예상 출력: [3, 12]

        // 최적화 코드 테스트
        int[] result2 = solver.optimizedSolution(3, 12);
        System.out.println(java.util.Arrays.toString(result2)); // 예상 출력: [3, 12]
    }
}
