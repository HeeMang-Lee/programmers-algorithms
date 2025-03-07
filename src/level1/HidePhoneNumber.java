package level1;

/**
 * 문제: 핸드폰 번호 가리기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12948
 *
 * 문제 설명:
 * - 주어진 전화번호에서 마지막 4자리를 제외한 나머지를 '*'로 가려야 합니다.
 * - 예: "01033334444" -> "*******4444"
 * - 전화번호 길이는 4 이상 20 이하입니다.
 *
 * 해결 방법:
 * 1. `StringBuilder`를 사용하여 문자열을 변경 가능하게 만듭니다.
 * 2. 뒷 4자리를 제외한 부분을 `'*'`로 변경합니다.
 * 3. `setCharAt()`을 사용하여 특정 위치의 문자를 변경합니다.
 * 4. 최종 변환된 문자열을 `toString()`을 통해 반환합니다.
 */

public class HidePhoneNumber {

    /**
     * 주어진 전화번호에서 마지막 4자리를 제외한 나머지를 '*'로 변환하는 메서드
     *
     * @param phone_number 원본 전화번호 (길이: 4 ~ 20)
     * @return 뒷 4자리만 남기고 '*'로 마스킹된 전화번호
     */
    public String solution(String phone_number) {
        // 1. StringBuilder를 사용하여 문자열을 변경할 수 있도록 함
        StringBuilder sb = new StringBuilder(phone_number);

        // 2. 마지막 4자리를 제외한 모든 문자를 '*'로 변경
        for (int i = 0; i < phone_number.length() - 4; i++) {
            sb.setCharAt(i, '*');  // 특정 위치의 문자를 '*'로 변경
        }

        // 3. 변환된 문자열 반환
        return sb.toString();
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        HidePhoneNumber hpn = new HidePhoneNumber();

        // 테스트 1
        String result1 = hpn.solution("01033334444");
        System.out.println(result1); // 예상 출력: "*******4444"

        // 테스트 2
        String result2 = hpn.solution("027778888");
        System.out.println(result2); // 예상 출력: "*****8888"
    }
}
