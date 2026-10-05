class Solution {
    public boolean isPalindromic(String s) {

        StringBuilder binary = new StringBuilder();

        for (char ch : s.toCharArray()) {
            String bits = String.format("%8s", 
                Integer.toBinaryString(ch)).replace(' ', '0');

            binary.append(bits);
        }
        int left = 0;
        int right = binary.length() - 1;

        while (left < right) {
            if (binary.charAt(left) != binary.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}