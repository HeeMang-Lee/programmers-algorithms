package level1;

/**
 * 문제: 문자열 다루기 기본 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12918
 *
 * 문제 설명:
 * - 주어진 문자열 `s`가 숫자로만 이루어져 있고, 길이가 4 또는 6인지 확인
 * - 숫자만 포함된 경우 `true` 반환, 아니면 `false` 반환
 *
 * 해결 방법:
 * 1. `s.length() != 4 && s.length() != 6` → 길이가 4 또는 6인지 확인
 * 2. `try-catch(Integer.parseInt(s))` → 숫자로 변환 가능 여부 확인 (예외 발생 시 `false` 반환)
 * 3. 최적화 코드: 정규식 `matches("\\d{4}|\\d{6}")`을 사용해 단순 비교
 */

public class ValidateStringFormat {

    /**
     * 기본 해결 방법 (try-catch 사용)
     * @param s 입력 문자열
     * @return 숫자로만 이루어져 있고 길이가 4 또는 6이면 true, 아니면 false
     */
    public boolean isValidString(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        try {
            Integer.parseInt(s); // 숫자로 변환 가능한지 확인
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 최적화된 해결 방법 (정규식 사용)
     * @param s 입력 문자열
     * @return 숫자로만 이루어져 있고 길이가 4 또는 6이면 true, 아니면 false
     */
    public boolean optimizedIsValidString(String s) {
        return s.matches("\\d{4}|\\d{6}"); // 정규식 사용
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        ValidateStringFormat vs = new ValidateStringFormat();

        // 테스트 1 (기본 해결 방법)
        System.out.println(vs.isValidString("1234")); // 예상 출력: true
        System.out.println(vs.isValidString("a234")); // 예상 출력: false
        System.out.println(vs.isValidString("123456")); // 예상 출력: true
        System.out.println(vs.isValidString("abcdef")); // 예상 출력: false

        // 테스트 2 (최적화 코드)
        System.out.println(vs.optimizedIsValidString("1234")); // 예상 출력: true
        System.out.println(vs.optimizedIsValidString("a234")); // 예상 출력: false
        System.out.println(vs.optimizedIsValidString("123456")); // 예상 출력: true
        System.out.println(vs.optimizedIsValidString("abcdef")); // 예상 출력: false
    }
}
