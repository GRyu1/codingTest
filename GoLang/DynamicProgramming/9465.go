package DynamicProgramming

import (
	"bufio"
	"fmt"
	"os"
)

// 전 단계 (대각-1 or 대각 -2) + 점수값

var (
	r      int
	n      int
	reader *bufio.Reader
	writer *bufio.Writer
)

func Q9465() {
	reader = bufio.NewReader(os.Stdin)
	writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	fmt.Fscan(reader, &n)
	for i := 0; i < n; i++ {
		fmt.Fscan(reader, &r)
		arr := make([][]int, 2)
		dp := make([][]int, 2)
		for j := 0; j < 2; j++ {
			arr[j] = make([]int, r)
			dp[j] = make([]int, r+1)
			for k := 0; k < r; k++ {
				fmt.Fscan(reader, &arr[j][k])
			}
		}
		dp[0][0] = 0
		dp[1][0] = 0

		dp[0][1] = arr[0][0]
		dp[1][1] = arr[1][0]

		for j := 2; j < r+1; j++ {
			if dp[0][j-2] > dp[0][j-1] {
				dp[1][j] = dp[0][j-2] + arr[1][j-1]
			} else {
				dp[1][j] = dp[0][j-1] + arr[1][j-1]
			}

			if dp[1][j-2] > dp[1][j-1] {
				dp[0][j] = dp[1][j-2] + arr[0][j-1]
			} else {
				dp[0][j] = dp[1][j-1] + arr[0][j-1]
			}
		}
		if dp[0][r] > dp[1][r] {
			fmt.Fprint(writer, dp[0][r])
			fmt.Fprint(writer, "\n")
		} else {
			fmt.Fprint(writer, dp[1][r])
			fmt.Fprint(writer, "\n")
		}
	}

}
