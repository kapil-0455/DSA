class Solution {
    public boolean checkValidString(String s) {

        // Greedy Approch
        int open = 0;
        int close = 0;
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '*'){
                open++;
            }
            else open --;

            if(open < 0) return false;
        }

        for(int i= s.length() - 1 ;i>=0 ;i--){

            char ch = s.charAt(i);
            if(ch == ')' || ch == '*'){
                close++;
            }
            else close--;

            if(close < 0) return false;
        }


        return true;
    }
}