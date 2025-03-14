package level1;

/**
 * 문제: 행렬의 덧셈 (프로그래머스 LV.1)
 * 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12950
 *
 * 문제 설명:
 * - 두 개의 같은 크기의 행렬 arr1, arr2가 주어짐
 * - 두 행렬의 같은 위치 요소끼리 더한 값을 새로운 행렬로 반환
 * - 예:
 *   arr1 = [[1,2],[2,3]], arr2 = [[3,4],[5,6]]
 *   → [[1+3, 2+4], [2+5, 3+6]] = [[4,6],[7,9]]
 *
 * 해결 방법:
 * 1. arr1과 arr2의 행과 열 크기를 확인하여 새 배열 선언
 * 2. 이중 for문을 이용하여 각 위치의 요소 합산
 * 3. 최적화 코드: `IntStream`을 활용하여 더 간결하게 표현 가능
 */

public class MatrixAddition {

    /**
     * 기본 해결 방법 (for문 사용)
     * @param arr1 첫 번째 행렬
     * @param arr2 두 번째 행렬
     * @return 두 행렬의 합 결과 행렬
     */
    public int[][] addMatrices(int[][] arr1, int[][] arr2) {
        int rows = arr1.length;
        int cols = arr1[0].length;

        int[][] answer = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    /**
     * 최적화된 해결 방법 (Stream API 사용)
     * @param arr1 첫 번째 행렬
     * @param arr2 두 번째 행렬
     * @return 두 행렬의 합 결과 행렬
     */
    public int[][] optimizedAddMatrices(int[][] arr1, int[][] arr2) {
        return java.util.stream.IntStream.range(0, arr1.length)
                .mapToObj(i -> java.util.stream.IntStream.range(0, arr1[0].length)
                        .map(j -> arr1[i][j] + arr2[i][j])
                        .toArray())
                .toArray(int[][]::new);
    }

    /**
     * 테스트 코드 (메인 메서드)
     */
    public static void main(String[] args) {
        MatrixAddition ma = new MatrixAddition();

        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};

        // 기본 해결 방법 테스트
        int[][] result1 = ma.addMatrices(arr1, arr2);
        printMatrix(result1);

        // 최적화 코드 테스트
        int[][] result2 = ma.optimizedAddMatrices(arr1, arr2);
        printMatrix(result2);
    }

    /**
     * 행렬 출력 메서드
     * @param matrix 출력할 행렬
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
