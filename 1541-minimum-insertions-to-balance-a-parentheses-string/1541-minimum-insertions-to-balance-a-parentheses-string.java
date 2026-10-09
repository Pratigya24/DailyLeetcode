class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int result = 0;

        int count =0;
        int i=0;
        while(i<n){
            if(s.charAt(i) == '('){
                count++;
                i++;
            }else{// ')'
                if(count > 0){
                    count--;
                }else{
                    result++; // add open wala baracket
                }

                if(i+1 < n && s.charAt(i+1) ==')'){
                    i += 2;
                }else{
                    result++; // add closing 
                    i++;
                }
            }
        }
        return result + count*2;
    }
}