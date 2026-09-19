class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length - 1;
        int maxArea=0;
        while(left<right){
            int h = Math.min(height[right], height[left]);
            int width = right - left;
            int area = h* width;
            maxArea = Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;




        // int maxArea=0;
        // int n=height.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         int area = Math.min(height[i],height[j]) * (j-i);
        //         maxArea = Math.max(maxArea,area);
        //     }
        // }
        // return maxArea;



    }
}