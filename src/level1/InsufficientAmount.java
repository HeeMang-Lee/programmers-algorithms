package level1;
/**
 * 문제: 부족한 금액 계산하기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/82612
 *
 * 문제 설명:
 * - 놀이기구를 `count`번 타려면, `price`의 1배, 2배, ..., count배의 금액이 필요함.
 * - 내가 가진 돈 `money`가 부족하면 부족한 금액을 반환하고, 부족하지 않으면 0 반환.
 * - 예: price=3, money=20, count=4
 *   → 필요한 금액: 3+6+9+12 = 30
 *   → 부족한 금액: 30 - 20 = 10
 *
 * 해결 방법:
 * 1. `for`문을 사용하여 1부터 `count`까지 반복하여 총 가격 계산 (`O(n)`)
 * 2. **최적화:** 등차수열 합 공식을 활용하여 `O(1)`로 계산
 *    - `n * (n + 1) / 2`를 사용하면 반복문 없이 총 가격을 구할 수 있음.
 */

public class InsufficientAmount {

    /**
     * 기본 해결 방법 (for문 사용)
     * @param price 이용 요금
     * @param money 내가 가진 돈
     * @param count 이용 횟수
     * @return 부족한 금액 (부족하지 않으면 0)
     */
    public long calculateDeficit(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += i * price;
        }
        return (totalPrice > money) ? totalPrice - money : 0;
    }

    /**
     * 최적화된 해결 방법 (등차수열 합 공식 활용)
     * @param price 이용 요금
     * @param money 내가 가진 돈
     * @param count 이용 횟수
     * @return 부족한 금액 (부족하지 않으면 0)
     */
    public long optimizedCalculateDeficit(int price, int money, int count) {
        long totalPrice = price * (long) count * (count + 1) / 2; // 등차수열 합 공식 적용
        return Math.max(totalPrice - money, 0); // 부족한 금액이 없으면 0 반환
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        InsufficientAmount ia = new InsufficientAmount();

        // 테스트 1 (기본 해결 방법)
        System.out.println(ia.calculateDeficit(3, 20, 4)); // 예상 출력: 10

        // 테스트 2 (최적화 코드)
        System.out.println(ia.optimizedCalculateDeficit(3, 20, 4)); // 예상 출력: 10
    }
}
