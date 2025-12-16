class Solution {
    fun myAtoi(s: String): Int {
        var index = 0 
        val n = s.length
        var sign = 1
        var result = 0

        while (index < n && (s[index] == ' ')){
            index++
        }

        if(index < n && (s[index] == '+' || s[index] == '-')){
            sign = if (s[index] == '-') -1 else 1
            index++
        }

        while(index < n && s[index].isDigit()){
            val digit = s[index] - '0'

            if(result > Int.MAX_VALUE / 10 || (result == Int.MAX_VALUE / 10 && digit > 7)){
                return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
            }

            result = result * 10 + digit 
            index++
        }
        return result * sign
    }
}