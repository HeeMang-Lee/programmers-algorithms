package level1;

/**
 * 문제: 두 배열의 내적 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/70128
 *
 * 문제 설명:
 * - 두 개의 길이가 같은 정수 배열 a, b가 주어짐
 * - 같은 인덱스끼리 곱한 값의 합을 반환 (내적 연산)
 * - 예: a = [1,2,3,4], b = [-3,-1,0,2] → (1*-3) + (2*-1) + (3*0) + (4*2) = 3
 *
 * 해결 방법:
 * 1. 배열 길이를 구하여 반복문을 수행
 * 2. `answer += a[i] * b[i];` 를 통해 각 요소의 곱을 누적
 * 3. 최적화 코드: `IntStream`을 활용하여 한 줄로 해결 가능
 */

public class DotProduct {

    /**
     * 기본 해결 방법 (for문 사용)
     * @param a 첫 번째 정수 배열
     * @param b 두 번째 정수 배열
     * @return 두 배열의 내적 결과값
     */
    public int computeDotProduct(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    /**
     * 최적화된 해결 방법 (Stream API 사용)
     * @param a 첫 번째 정수 배열
     * @param b 두 번째 정수 배열
     * @return 두 배열의 내적 결과값
     */
    public int optimizedDotProduct(int[] a, int[] b) {
        return java.util.stream.IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        DotProduct dp = new DotProduct();

        // 테스트 1 (기본 해결 방법)
        System.out.println(dp.computeDotProduct(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2})); // 예상 출력: 3

        // 테스트 2 (최적화 코드)
        System.out.println(dp.optimizedDotProduct(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2})); // 예상 출력: 3
    }
}
