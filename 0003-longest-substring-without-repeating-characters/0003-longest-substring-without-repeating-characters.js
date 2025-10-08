/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    const lastIn = new Map();
    let left = 0;
    let maxLength = 0;

    for(let right = 0 ; right < s.length ; right++){
        const ch = s[right]

        if(lastIn.has(ch) && lastIn.get(ch) >= left){
            left = lastIn.get(ch)+1;
        }
        lastIn.set(ch,right)
        maxLength = Math.max(maxLength,right-left+1);
    }
    return maxLength;
};