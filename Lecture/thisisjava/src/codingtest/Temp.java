import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Temp {
	private static final Map<Character, String[]> map = Map.ofEntries(
			Map.entry('0', new String[] {"0", "O", "()"}),
		    Map.entry('1', new String[] {"1", "I"}),
		    Map.entry('2', new String[] {"2", "Z", "S", "7_"}),
		    Map.entry('3', new String[] {"3", "E", "B"}),
		    Map.entry('4', new String[] {"4", "A"}),
		    Map.entry('5', new String[] {"5", "Z", "S"}),
		    Map.entry('6', new String[] {"6", "b", "G"}),
		    Map.entry('7', new String[] {"7", "T", "Y"}),
		    Map.entry('8', new String[] {"8", "B", "E3"}),
		    Map.entry('9', new String[] {"9", "g", "q"})
	);
	private static record Pair(int key, String value) {}
    private static List<Pair> isUsed;
    private static List<String> combinations;
    
    
    public static int[] solution(String[] numStrs, String[] words) {
        int[] result = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            isUsed = new LinkedList<>();
            combinations = new ArrayList<>();
            backtrack(word, 0, new Stack<String>());
//            System.out.println(word + ": " + combinations.toString()); // 디버깅용 모든 조합 출력
            int cnt = 0;
            for (String numStr : numStrs) {
            	// 변환 가능한 조합 중 하나라도 있으면 카운트 
            	if (combinations.stream()
            			.anyMatch(target -> numStr.contains(target))) {
            		cnt += 1;
            	}
            }
            result[i] = cnt;
        }
        return result;
    }
    
    /**
     * 백트랙킹을 통해 word에서 변환 가능한 모든 numStr 조합 생성
     */
    private static void backtrack(String word, int idx, Stack<String> stack) {
        if (idx == word.length()) {
        	combinations.add(stack.stream().collect(Collectors.joining()));
        	return;
        }
		
        for (int i = 0; i < map.get(word.charAt(idx)).length; i++) {
        	int num = word.charAt(idx) - '0';
        	String target = map.get(word.charAt(idx))[i];
        	Pair using = new Pair(num, target);
        	
        	// isUsed에 value가 target인데, key가 num이 아닌 경우가 하나라도 있으면 continue
        	if (isUsed.stream()
        			.anyMatch(pair -> pair.value().equals(target) && pair.key() != num)) {
        		continue;
        	}
        	
        	isUsed.add(using);
        	stack.add(target);
        	backtrack(word, idx+1, stack);
        	isUsed.remove(using);
        	stack.pop();
        }
    	return;
    }
}