package level1;

public class FindMiddleCharacter {/**
 * 문제: 가운데 글자 가져오기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12903
 *
 * 문제 설명:
 * - 주어진 문자열의 가운데 글자를 반환합니다.
 * - 문자열의 길이가 홀수이면 가운데 문자 1개 반환
 * - 문자열의 길이가 짝수이면 가운데 문자 2개 반환
 * - 예: "abcde" → "c", "qwer" → "we"
 *
 * 해결 방법:
 * 1. 문자열 길이를 확인하여 짝수/홀수 여부 판별
 * 2. 홀수인 경우: 가운데 문자 1개 반환
 * 3. 짝수인 경우: 가운데 문자 2개 반환
 */

static class Solution {

    /**
     * 수정된 코드 (기존 코드에서 오류 수정)
     * @param s 주어진 문자열 (길이 1 이상, 최대 100)
     * @return 가운데 문자(들)
     */
    public String solution(String s) {
        String answer = "";
        int len = s.length(); // 문자열 길이 저장

        if (len % 2 == 0) {
            // 짝수 길이 → 가운데 두 문자 가져오기
            answer += s.charAt(len / 2 - 1);
            answer += s.charAt(len / 2);
        } else {
            // 홀수 길이 → 가운데 한 문자 가져오기
            answer += s.charAt(len / 2);
        }

        return answer;
    }

    /**
     * 최적화된 코드 (substring() 사용)
     * @param s 주어진 문자열 (길이 1 이상, 최대 100)
     * @return 가운데 문자(들)
     */
    public String optimizedSolution(String s) {
        int mid = s.length() / 2;
        return (s.length() % 2 == 0)
                ? s.substring(mid - 1, mid + 1)  // 짝수 → 2개 문자 반환
                : s.substring(mid, mid + 1);    // 홀수 → 1개 문자 반환
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public void main(String[] args) {
        Solution sol = new Solution();

        // 테스트 1 (수정된 코드)
        System.out.println(sol.solution("abcde")); // 예상 출력: "c"
        System.out.println(sol.solution("qwer")); // 예상 출력: "we"

        // 테스트 2 (최적화 코드)
        System.out.println(sol.optimizedSolution("abcde")); // 예상 출력: "c"
        System.out.println(sol.optimizedSolution("qwer")); // 예상 출력: "we"
    }
}

}
