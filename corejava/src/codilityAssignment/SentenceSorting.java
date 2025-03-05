package codilityAssignment;

import java.util.*;
import java.util.stream.Collectors;

public class SentenceSorting {

    private static int countVowels(String sentence) {
    	 Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
         int count = 0;
         for (char ch : sentence.toCharArray()) {
             if (vowels.contains(ch)) {
                 count++;
             }
         }
         return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of sentences: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter the sentences: ");
        List<String> sentences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sentences.add(sc.nextLine());
        }

        List<String> sortedSentences = sentences.stream()
                .sorted(Comparator.comparingInt(SentenceSorting::countVowels))
                .collect(Collectors.toList());

        sortedSentences.forEach(sentence -> 
            System.out.println(sentence)
        );

        sc.close();
    }
}

