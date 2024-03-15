package DynamicProgramming

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

var (
	t int
)

func Q11066() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscan(reader, &t)
	for i := 0; i < t; i++ {
		var k int
		fmt.Fscan(reader, &k)
		dp := make([][]int, k+1)
		fileSum := make([]int, k+1)
		for j := 1; j <= k; j++ {
			dp[j] = make([]int, k+1)
		}
		fileSum[0] = 0
		for j := 1; j <= k; j++ {
			fmt.Fscan(reader, &fileSum[j])
			fileSum[j] = fileSum[j] + fileSum[j-1]
		}

		for gap := 1; gap < k; gap++ {
			for start := 1; start+gap <= k; start++ {
				end := start + gap
				dp[start][end] = math.MaxInt64

				for mid := start; mid < end; mid++ {
					if dp[start][end] > dp[start][mid]+dp[mid+1][end]+fileSum[end]-fileSum[start-1] {
						dp[start][end] = dp[start][mid] + dp[mid+1][end] + fileSum[end] - fileSum[start-1]
					}
				}
			}
		}
		fmt.Fprint(writer, dp[1][k])
		fmt.Fprint(writer, "\n")
	}
}
