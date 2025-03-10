package level1;

/**
 * 문제: 수박수박수박수? (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12922
 *
 * 문제 설명:
 * - 길이 n만큼 "수박수박수..." 형태로 반복되는 문자열을 생성합니다.
 * - 예: n = 3 → "수박수", n = 4 → "수박수박"
 *
 * 해결 방법:
 * 1. String 대신 `StringBuilder` 사용 (문자열 추가 성능 개선)
 * 2. for문을 사용해 "수"와 "박"을 번갈아가며 추가
 * 3. 최적화 코드: `.repeat()` 사용하여 반복 패턴을 미리 생성 후 `substring()`으로 자르기
 */

public class WatermelonPattern {

    /**
     * 기본 해결 방법 (StringBuilder 사용)
     * @param n 문자열 길이
     * @return "수박수박..." 형식의 문자열
     */
    public String generatePattern(int n) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            answer.append(i % 2 == 0 ? "수" : "박");
        }

        return answer.toString();
    }

    /**
     * 최적화된 해결 방법 (repeat() + substring() 사용)
     * @param n 문자열 길이
     * @return "수박수박..." 형식의 문자열
     */
    public String optimizedPattern(int n) {
        return "수박".repeat(n / 2 + 1).substring(0, n);
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        WatermelonPattern wp = new WatermelonPattern();

        // 테스트 1 (기본 해결 방법)
        System.out.println(wp.generatePattern(3)); // 예상 출력: "수박수"
        System.out.println(wp.generatePattern(4)); // 예상 출력: "수박수박"

        // 테스트 2 (최적화 코드)
        System.out.println(wp.optimizedPattern(3)); // 예상 출력: "수박수"
        System.out.println(wp.optimizedPattern(4)); // 예상 출력: "수박수박"
    }
}
