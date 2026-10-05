// class Solution {
//     public boolean isPalindromic(String s) {

//         StringBuilder binary = new StringBuilder();

//         for (char ch : s.toCharArray()) {
//             String bits = String.format("%8s", 
//                 Integer.toBinaryString(ch)).replace(' ', '0');

//             binary.append(bits);
//         }
//         int left = 0;
//         int right = binary.length() - 1;

//         while (left < right) {
//             if (binary.charAt(left) != binary.charAt(right)) {
//                 return false;
//             }

//             left++;
//             right--;
//         }

//         return true;
//     }
// }

class Solution {
    public boolean isPalindromic(String s) {
        int n = s.length();
        int totalBits = n * 8;
        int left = 0;
        int right = totalBits - 1;
        
        while (left < right) {
            // Extract the bit at 'left' position
            int leftBit = (s.charAt(left / 8) >> (7 - (left % 8))) & 1;
            // Extract the bit at 'right' position
            int rightBit = (s.charAt(right / 8) >> (7 - (right % 8))) & 1;
            
            if (leftBit != rightBit) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}