class Solution {
    public double myPow(double x, int n) {
        //Corner Cases:

        if(n == 0) return 1.0;
        if(x == 0) return 0.0;
        if(x == 1) return 1.0;
        //Negative no pow is positive if pow is multiple of 2
        if(x == -1 && n%2 == 0) return 1.0;
        // //Negative no pow is Negative if pow is Not multiple of 2
        if(x == -1 && n%2 != 0) return -1.0;


        long binForm = n;

        if(binForm < 0){
            x = 1/x;
            binForm = -binForm;
        }

        double ans = 1;

        while(binForm > 0){
            if(binForm % 2 == 1){
                ans *= x;
            }
            x = x * x;
            binForm /= 2;   
        }
        return ans; 
    }
}