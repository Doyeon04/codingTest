class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(char c : s.toCharArray()){
            if(c==' ') answer+= " ";
            else{
                int num = c+n; 
                if(Character.isUpperCase(c) && num > (int)('Z')){
                       num-=26; 
                }else if(Character.isLowerCase(c) && num > (int)('z')){
                       num-=26;
                }
                answer+= (char)(num); 
            }
        }

        return answer;
    }
}

