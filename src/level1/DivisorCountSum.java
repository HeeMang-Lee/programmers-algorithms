package level1;
/**
 * 문제: 약수의 개수와 덧셈 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/77884
 *
 * 문제 설명:
 * - left부터 right까지 모든 수의 약수 개수를 확인
 * - 약수 개수가 짝수이면 더하고, 홀수이면 뺀다.
 * - 예: left=13, right=17 → 결과: 13+14-15+16-17 = 43
 *
 * 해결 방법:
 * 1. `for (int i = left; i <= right; i++)` → 모든 수를 확인
 * 2. `약수 개수`가 **짝수인지 홀수인지** 판별
 * 3. 최적화: **제곱수(완전제곱수)는 약수 개수가 홀수**임을 활용하여 `Math.sqrt(i) % 1 == 0`으로 판별 가능
 */

public class DivisorCountSum {

    /**
     * 기본 해결 방법 (약수 개수 직접 카운트)
     * @param left 시작 숫자
     * @param right 끝 숫자
     * @return 조건에 맞는 값의 합
     */
    public int sumDivisors(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int cnt = 1;

            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0) {
                    cnt++;
                }
            }

            if (cnt % 2 == 0) {
                answer += i; // 약수 개수가 짝수면 더하기
            } else {
                answer -= i; // 약수 개수가 홀수면 빼기
            }
        }
        return answer;
    }

    /**
     * 최적화된 해결 방법 (제곱수 활용)
     * @param left 시작 숫자
     * @param right 끝 숫자
     * @return 조건에 맞는 값의 합
     */
    public int optimizedSumDivisors(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            // 제곱수인지 판별 (제곱수는 약수 개수가 홀수)
            if (Math.sqrt(i) % 1 == 0) {
                answer -= i; // 약수 개수가 홀수면 빼기
            } else {
                answer += i; // 약수 개수가 짝수면 더하기
            }
        }
        return answer;
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        DivisorCountSum dcs = new DivisorCountSum();

        // 테스트 1 (기본 해결 방법)
        System.out.println(dcs.sumDivisors(13, 17)); // 예상 출력: 43

        // 테스트 2 (최적화 코드)
        System.out.println(dcs.optimizedSumDivisors(13, 17)); // 예상 출력: 43
    }
}
