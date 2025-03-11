package level1;
import java.util.Arrays;
import java.util.Collections;

/**
 * 문제: 문자열 내림차순으로 정렬하기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12917
 *
 * 문제 설명:
 * - 문자열의 문자들을 내림차순으로 정렬하여 반환
 * - 예: "Zbcdefg" → "gfedcbZ"
 *
 * 해결 방법:
 * 1. `split("")`을 사용하여 문자열을 문자 배열로 변환
 * 2. `Arrays.sort(배열, Collections.reverseOrder())`를 이용해 내림차순 정렬
 * 3. `StringBuilder`를 사용하여 정렬된 문자들을 하나의 문자열로 결합
 */

public class SortStringDescending {

    /**
     * 기본 해결 방법 (배열을 사용한 내림차순 정렬)
     * @param s 주어진 문자열
     * @return 내림차순으로 정렬된 문자열
     */
    public String sortDescending(String s) {
        String[] str = s.split(""); // 문자열을 문자 배열로 변환
        Arrays.sort(str, Collections.reverseOrder()); // 내림차순 정렬

        StringBuilder sb = new StringBuilder();
        for (String a : str) {
            sb.append(a);
        }
        return sb.toString();
    }

    /**
     * 최적화된 해결 방법 (char 배열 + Arrays.sort() 사용)
     * @param s 주어진 문자열
     * @return 내림차순으로 정렬된 문자열
     */
    public String optimizedSortDescending(String s) {
        char[] chars = s.toCharArray(); // 문자열을 char 배열로 변환
        Arrays.sort(chars); // 오름차순 정렬
        return new StringBuilder(new String(chars)).reverse().toString(); // 뒤집어서 반환
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        SortStringDescending ssd = new SortStringDescending();

        // 테스트 1 (기본 해결 방법)
        System.out.println(ssd.sortDescending("Zbcdefg")); // 예상 출력: "gfedcbZ"

        // 테스트 2 (최적화 코드)
        System.out.println(ssd.optimizedSortDescending("Zbcdefg")); // 예상 출력: "gfedcbZ"
    }
}
