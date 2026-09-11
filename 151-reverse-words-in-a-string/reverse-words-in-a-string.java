// Condtions =>
// Reverse words in a string 
//  should not contain leading or trailing spaces 
//need to reduce multiple spaces between two words to a single space in the reversed string

class Solution {
    public String reverseWords(String s) {
        int n = s.length();

        String ans = "";

        s = new StringBuilder(s).reverse().toString(); //reverse the str

        for(int i = 0; i < n; i++){
            StringBuilder word = new StringBuilder(""); 

            while(i < n && s.charAt(i) != ' '){
                word.append(s.charAt(i));
                i++;
            }

            word.reverse();

            //If word is Not created Never add extra add on space
            if(word.length() > 0){ 
                ans += " " + word.toString();
            }

        }
        return ans.substring(1); // cut first add on space
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna