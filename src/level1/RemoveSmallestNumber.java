package level1;

import java.util.Arrays;

/**
 * 문제: 제일 작은 수 제거하기 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12935
 *
 * 문제 설명:
 * - 주어진 정수 배열에서 가장 작은 수를 제거한 배열을 반환합니다.
 * - 만약 배열이 비어있다면 [-1]을 반환합니다.
 * - 예: arr = [4,3,2,1] → 결과: [4,3,2]
 *       arr = [10] → 결과: [-1]
 *
 * 해결 방법:
 * 1. 배열의 길이가 1이면 [-1]을 반환합니다.
 * 2. 배열에서 최솟값을 찾습니다.
 * 3. 최솟값을 제외한 새로운 배열을 생성하여 반환합니다.
 */
public class RemoveSmallestNumber {

    /**
     * 제일 작은 수를 제거하는 메서드
     *
     * @param arr 주어진 정수 배열 (길이 1 이상)
     * @return 가장 작은 수를 제거한 배열 (빈 배열이면 [-1] 반환)
     */
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1}; // 배열 길이가 1이면 -1 반환
        }

        // 1. 가장 작은 값 찾기
        int minValue = Arrays.stream(arr).min().getAsInt();

        // 2. 가장 작은 값 제거한 배열 생성
        return Arrays.stream(arr)
                .filter(num -> num != minValue)  // 최소값 제외
                .toArray();
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        RemoveSmallestNumber rsn = new RemoveSmallestNumber();

        // 테스트 1
        int[] test1 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(rsn.solution(test1))); // 예상 출력: [4, 3, 2]

        // 테스트 2
        int[] test2 = {10};
        System.out.println(Arrays.toString(rsn.solution(test2))); // 예상 출력: [-1]
    }
}
