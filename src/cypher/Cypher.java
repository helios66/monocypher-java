/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypher;

/**
 *
 * @author fdamilola
 */
public class Cypher {

    public static char p[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 
        '[', '-' , '+' , '.' , '^' , '@' , '_' , ':' , '*' ,',' ,']'};
    
    public static char ch[] = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
        'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
        'V', 'B', 'N', 'M', '5', '9', '6', '7','8', '1', '2', '3','0', '4', 
        '-' , '_' , ':' , ',', '[' ,']', '+' , '.' , '^', '*' , '@'};
    
    
    //@todo optimize using maps
    public static String encrypt(String s) {
        //try to remove some special characters from the string as this cypher is not equipped for symbol   
        char c[] = new char[(s.length())];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[j] == s.charAt(i)) {
                    c[i] = ch[j];
                    break;
                }
            }
        }
        return (new String(c));//+">"+generateSpecialCharacterPadding(initial);
    }

    //@todo optimize using maps
    public static String decrypt(String s) {
        //String[] parts = s.split("\\>");
        //String ins = parts[1];
        //s = parts[0];
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] == s.charAt(i)) {
                    p1[i] = p[j];
                    break;
                }
            }
        }
        return (new String(p1));
    }
    
//Algorithm below works as an alternative to inserting every special character you can think of.    
//    private static String buildString(String base, HashMap<Integer, String> spec){
//        StringBuilder sb = new StringBuilder(base);
//        spec.keySet().stream().forEach((s) -> {
//            sb.insert(s, spec.get(s));
//        });
//        return sb.toString();
//    }
//    
//    private static String generateSpecialCharacterPadding(String s){
//        HashMap<Integer, String> positions = new HashMap<>();
//        char[] specialchars = {'-', '+', '.', '^', '@', '_', ':', ','}; //-+.^@_:,
//        for(int i = 0; i < s.length(); i++){
//            for(char sc: specialchars){
//                if(s.charAt(i) == sc){
//                    positions.put(i, String.valueOf(sc));
//                }
//            }
//        }
//        //MapUtils.ambiPrint(MapUtils.unwrap(MapUtils.wrap(positions)));
//        return new String(MapUtils.wrap(positions), StandardCharsets.UTF_8);
//    } 
}
