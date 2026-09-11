class Solution {
    public String removeOccurrences(String s, String part) {
            
        StringBuilder sb = new StringBuilder(s);

        while(sb.length() > 0 && sb.indexOf(part) != -1){
               
            int start = sb.indexOf(part);
            sb.delete(start, start + part.length());
            //end index is not included

        }
        return sb.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna