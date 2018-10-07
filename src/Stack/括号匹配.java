package Stack;

import java.util.Stack;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/28 16:31
 * Description: Stack.括号匹配
 */
public class 括号匹配 {

    public boolean isvaled(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                characters.push(c);
            } else {
                if(characters.isEmpty()){
                    return false;
                }
                Character peek = characters.pop();
                if (peek == '}' && peek != '{') {
                    return false;
                }
                if (peek == ']' && peek != '[') {
                    return false;
                }
                if (peek == ')' && peek != '(') {
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }
}
