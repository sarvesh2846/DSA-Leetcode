class Solution {

    public static boolean isFreSame(int[] freq1, int[] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        //search string permutation
        int[] freq = new int[26];

        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int windSize = s1.length(); // serching window size
        
        // Multiple window string iteartion
        for(int i = 0; i < s2.length(); i++){ // shift window to left by +1

            //i tells:Where should the window START?
            //idx tells: Which character am I currently reading inside this window? from window
            //windIdx tells:How many characters have I taken so far? fo window...

            int windIdx = 0, idx = i; 
            int[] windFreq = new int[26]; 

            //itearate the calculated wind. and add the frq of chars 
            while(windIdx < windSize && idx < s2.length()){//singlewind
                windFreq[s2.charAt(idx) - 'a']++;
                windIdx++; idx++;
            }

            if(isFreSame(freq, windFreq)){ // found
                return true;
            }

        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna