package SimplifyPath;

import java.util.*;

/**
 * Created by Alan on 7/18/15.
 */
public class Solution {
    public static void main(String[] args) {
        String ss = "/home//eer/.././asds/";
        for (String s : ss.split("/")) {
            System.out.println(s);
        }
    }

    public String simplifyPath(String path) {
        Set<String> skip = new HashSet<String>(Arrays.asList("..", "", "."));
        Deque<String> stack = new LinkedList<>();
        for(String name : path.split("/")){
            if(name.equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!skip.contains(name)){
                stack.push(name);
            }
        }
        String res = "";
        for(String dir : stack){
            res = "/" + dir + res;
        }
        return res.isEmpty()? "/" : res;
    }
}
