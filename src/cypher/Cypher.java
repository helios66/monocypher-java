/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypher;

import java.util.HashMap;

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
    
    
    public static HashMap<Character, Character> forwardMap = new HashMap<> ();
    public static HashMap<Character, Character> reverseMap = new HashMap<> ();
    
    
    static {
        forwardMap = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            forwardMap.put(p[i], ch[i]);
            reverseMap.put(ch[i], p[i]);
        } 
    }
    
    //@Todo optimize using maps
    public static String encrypt(String s) {
        //try to remove some special characters from the string as this cypher is not equipped for symbol   
        char c[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++) {
            c[i] = forwardMap.get(s.charAt(i));
        }
        return (new String(c));
    }

    //@todo optimize using maps
    public static String decrypt(String s) {
        char p1[] = new char[(s.length())];
        for (int i = 0; i < s.length(); i++) {
            p1[i] = reverseMap.get(s.charAt(i));
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
