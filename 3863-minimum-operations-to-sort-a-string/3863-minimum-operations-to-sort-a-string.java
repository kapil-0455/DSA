class Solution {
    public int minOperations(String s) {
        int ans=0;
        int lIdx=-1;
        int sIdx=-1;
        char lg='a';
        char sm='z';
        if(isSorted(s))return 0;
        
        if(!isSorted(s) && s.length()==2)return -1;
        
        for(int i=0;i<s.length();i++){ // for checking thee index of largest and samllesr
        
            if(s.charAt(i)>=lg){
                lg=s.charAt(i);
                lIdx=i;
            }
            if(s.charAt(i)<sm){
                sm=s.charAt(i);
                sIdx=i;
            }
        }
        if(lIdx==s.length()-1 || sIdx==0)return 1; // if we need to sort only middle ones 
        if(lIdx==0 && sIdx==s.length()-1)return 3; // if they larget and samllest in first and last then take 3 
        return 2; // otherwise it take 2
    }
    boolean isSorted(String s){
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)>s.charAt(i+1))return false;
        }
        return true;
    }
}