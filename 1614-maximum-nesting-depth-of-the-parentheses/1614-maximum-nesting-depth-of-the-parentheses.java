class Solution {
    public int maxDepth(String s) {
        int curr = 0;
        int maxCurr=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                curr++;
                maxCurr=Math.max(maxCurr,curr);
            }else if (ch==')'){
                curr--;
            }
        }
        return maxCurr;
    }
}