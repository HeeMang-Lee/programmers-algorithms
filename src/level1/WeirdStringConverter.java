package level1;

/**
 * 문제: 이상한 문자 만들기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12930
 *
 * 문제 설명:
 * - 주어진 문자열에서 각 단어별로 짝수 인덱스 문자는 대문자로, 홀수 인덱스 문자는 소문자로 변환
 * - 공백을 기준으로 단어가 나뉘며, 단어의 인덱스는 0부터 시작
 * - 예:
 *   입력: `"try hello world"`
 *   출력: `"TrY HeLlO WoRlD"`
 *
 * 해결 방법:
 * 1. `StringBuilder`를 사용하여 문자열을 조작
 * 2. `charAt(i)`로 한 글자씩 가져오면서 변환 (`Character.toUpperCase()`, `Character.toLowerCase()`)
 * 3. 공백을 만나면 인덱스를 초기화하여 단어별 변환 유지
 * 4. 최적화 코드: `split(" ", -1)`을 활용하여 각 단어를 따로 변환 후 조합
 */

public class WeirdStringConverter {

    /**
     * 기본 해결 방법 (StringBuilder 활용)
     * @param s 변환할 문자열
     * @return 변환된 문자열
     */
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                sb.append(c);
                index = 0;
            } else {
                sb.append(index % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
                index++;
            }
        }
        return sb.toString();
    }

    /**
     * 최적화된 해결 방법 (split 활용)
     * @param s 변환할 문자열
     * @return 변환된 문자열
     */
    public String optimizedSolution(String s) {
        String[] words = s.split(" ", -1); // -1 옵션으로 공백 유지
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder transformed = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                transformed.append(i % 2 == 0 ? Character.toUpperCase(word.charAt(i)) : Character.toLowerCase(word.charAt(i)));
            }

            result.append(transformed).append(" ");
        }

        return result.toString().trim(); // 마지막 공백 제거
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        WeirdStringConverter converter = new WeirdStringConverter();

        // 기본 해결 방법 테스트
        System.out.println(converter.solution("try hello world")); // 예상 출력: "TrY HeLlO WoRlD"

        // 최적화 코드 테스트
        System.out.println(converter.optimizedSolution("try hello world")); // 예상 출력: "TrY HeLlO WoRlD"
    }
}
