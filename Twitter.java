import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Twitter {

	private static Map<String, Integer> hashTagMap = new HashMap<>();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isEnded = false;
		while (!isEnded) {
			System.out.println("Enter the option:");
			System.out.println("1.Add a tweet");
			System.out.println("2.Show top 10 tweets");
			System.out.println("3.Exit");
			try {
				int option = in.nextInt();
				switch (option) {
				case 1:
					addTweet();
					break;
				case 2:
					printTop10HashTag();
					break;
				case 3:
					isEnded = true;
					break;

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Enter valid input");
				in.nextLine();

			}

		}

	}

	public static void addTweet() {
		System.out.println("Enter a tweet:");
		in.nextLine();
		String tweet = in.nextLine();

		for (String word : tweet.split(" ")) {
			if (word.startsWith("#")) {
				if (hashTagMap.containsKey(word)) {
					hashTagMap.put(word, hashTagMap.get(word) + 1);
				} else {
					hashTagMap.put(word, 1);
				}
			}
		}
	}

	public static void printTop10HashTag() {
		List<Map.Entry<String, Integer>> hashTagList = new LinkedList<Map.Entry<String, Integer>>(
				hashTagMap.entrySet());

		Collections.sort(hashTagList, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		for (int index = 0; index < 10 && index < hashTagList.size(); index++) {
			System.out.println((index + 1) + ". " + hashTagList.get(index));
		}
	}

}
