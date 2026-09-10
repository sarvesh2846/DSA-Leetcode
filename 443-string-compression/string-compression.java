class Solution {
    public int compress(char[] chars) { //O(n) => i is upadating in Both
        int n = chars.length;
        int idx = 0;

        for(int i = 0; i < n; i++) {
            char ch = chars[i];
            int count = 0;

            //Count the consecutive repeating char
            while(i < n && chars[i] == ch){
                count++;
                i++;
            }

            //conditions 
            if(count == 1){
                chars[idx++] = ch;//chars[idx] = ch; //idx++;
            }
            else{
                chars[idx++] = ch;
               
                String str = String.valueOf(count); //int => string
                for (char chr : str.toCharArray()) { // string => charArray => Each char (['count',])
                   chars[idx++] = chr;
                    
                }
            }
            i--;
        }

        return idx; // New length of Array
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna