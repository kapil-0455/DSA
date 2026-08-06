class Solution {

    public int findProduct(int n){

        int product = 1;
        int newNum = n;
        while(newNum > 0){
            int lastDigit = newNum % 10;
            product *= lastDigit;
            newNum /= 10;
        }

        return product;
    }
    public int smallestNumber(int n, int t) {
        int newNum = n;
        while(true){
            int product = findProduct(newNum);
            if(product % t == 0) return newNum;
            newNum += 1;

        }

    }
}