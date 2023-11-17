class Solution {
    public String solution(String s, String skip, int index) {
        String answer=""; 

        for (char alpha : s.toCharArray()) {
            char newAlpha = alpha;

            for (int i = 0; i < index; i++) {
                char nextAlpha = (char) ((newAlpha - 'a' + 1) % 26 + 'a');

                while (skip.indexOf(nextAlpha) != -1) {
                    nextAlpha = (char) ((nextAlpha - 'a' + 1) % 26 + 'a');
                }
                newAlpha = nextAlpha;   
            }
            answer+=newAlpha; 
        }

        return answer;
    }
}
