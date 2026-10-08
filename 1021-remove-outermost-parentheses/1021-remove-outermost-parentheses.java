class Solution {
    public String removeOuterParentheses(String s) {
        int c = 0;
        StringBuilder str  = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(c>0) str.append('(');
                c++;
            }
            else {
                c--;
                if(c>0) str.append(')');
            }
        }
        return str.toString();
    }
}