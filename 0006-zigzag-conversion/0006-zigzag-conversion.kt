class Solution {
    fun convert(s: String, numRows: Int): String {

        // Edge case: no zigzag possible
        if (numRows == 1 || numRows >= s.length) {
            return s
        }

        // Create a StringBuilder for each row
        val rows = Array(numRows) { StringBuilder() }

        var currentRow = 0
        var goingDown = false

        // Traverse characters
        for (ch in s) {
            rows[currentRow].append(ch)

            // Change direction at top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown
            }

            currentRow += if (goingDown) 1 else -1
        }

        // Combine all rows
        val result = StringBuilder()
        for (row in rows) {
            result.append(row)
        }

        return result.toString()
    }
}    