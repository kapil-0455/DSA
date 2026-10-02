class Solution {
    public void solve (int cl , int open ,StringBuilder op , List<String> res ){
        if(cl == 0 && open == 0){
            res.add(op.toString());
            return ;
        }

        if(open == 0){
            StringBuilder op1 = new StringBuilder(op);
            op1.append(")");

            solve(cl-1 , open , op1 , res );
        }
        else if(cl > open && open != 0){
            StringBuilder op1 = new StringBuilder(op);
            StringBuilder op2 = new StringBuilder(op);
            op1.append("(");
            op2.append(")");

            solve(cl, open -1 , op1 , res);
            solve(cl -1 , open , op2 , res);
        }
        else if(cl == open ){
            StringBuilder op1 = new StringBuilder(op);
            op1.append("(");

            solve(cl , open - 1, op1 , res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> generateParenthesis = new ArrayList<>();
        int close = n;
        int open = n;
        StringBuilder op = new StringBuilder();

        solve(close , open , op ,generateParenthesis);
        return generateParenthesis ;
    }
}