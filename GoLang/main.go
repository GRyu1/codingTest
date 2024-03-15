package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	var N int
	fmt.Fscan(reader, &N)
	dp := make([][]int, N+1)
	processions := make([][]int, N+1)
	for i := 0; i < N+1; i++ {
		dp[i] = make([]int, N+1)
		processions[i] = make([]int, 2)
	}
	for i := 1; i <= N; i++ {
		fmt.Fscan(reader, &processions[i][0])
		fmt.Fscan(reader, &processions[i][1])
	}

	for i := 1; i < N; i++ {
		dp[i][i+1] = processions[i][0] * processions[i+1][0] * processions[i+1][1]
	}

	for gap := 2; gap < N; gap++ {
		for start := 1; start+gap <= N; start++ {
			end := start + gap
			dp[start][end] = math.MaxInt64
			for mid := start; mid < end; mid++ {
				if dp[start][end] > dp[start][mid]+dp[mid+1][end]+processions[start][0]*processions[mid][1]*processions[end][1] {
					dp[start][end] = dp[start][mid] + dp[mid+1][end] + processions[start][0]*processions[mid][1]*processions[end][1]
				}
			}
		}
	}
	fmt.Fprint(writer, dp[1][N])
}
