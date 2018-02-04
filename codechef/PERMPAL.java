import java.util.*;

public class PERMPAL {
	public static void go(String str) {
		ArrayList <Character> string = new ArrayList <Character>(str.length());
		ArrayList <Integer> indexes = new ArrayList <Integer>(str.length());
		for (int i = 0 ; i < str.length() ; i++) {
			string.add(str.charAt(i));
			indexes.add(i);
		}
		ArrayList <Integer> firstHalf = new ArrayList <Integer>();
		ArrayList <Integer> secondHalf = new ArrayList <Integer>();
		/*StringBuilder firstHalf = new StringBuilder("");
		StringBuilder secondHalf = new StringBuilder("");*/
		int aloneCharacters = 0;
		Character aloneCharacter = ' ';
		int aloneCharacterIndex = -1;
		while (!string.isEmpty()) {
			Character characterRemoved = string.get(0);
			string.remove(0);
			int indexRemoved = indexes.get(0);
			indexes.remove(0);
			int search = string.indexOf(characterRemoved);
			if (search < 0) {
				aloneCharacter = characterRemoved;
				aloneCharacterIndex = indexRemoved;
				aloneCharacters++;
				if (aloneCharacters > 1) {
					System.out.println(-1);
					return;
				}
				continue;
			}
			string.remove(search);
			int searchIndex = indexes.get(search);
			indexes.remove(search);
			firstHalf.add(indexRemoved);
			//firstHalf.append(indexRemoved+1 + " ");
			secondHalf.add(searchIndex);
			//secondHalf.append(searchIndex+1 + " ");
		}
		//secondHalf.reverse();
		//secondHalf.deleteCharAt(0);
		Collections.reverse(secondHalf);
		/*System.out.println(string);
		System.out.println(firstHalf);
		System.out.println(aloneCharacterIndex);
		System.out.println(secondHalf);*/
		StringBuilder output = new StringBuilder("");
		for (Integer i : firstHalf) output.append(Integer.toString(i+1) + " ");
		if (aloneCharacterIndex != -1) output.append(Integer.toString(aloneCharacterIndex+1) + " ");
		for (Integer i : secondHalf) output.append(Integer.toString(i+1) + " ");
		//for (int i = secondHalf.size()-1; i >=0 ; i--) output.append(Integer.toString(secondHalf.get(i)+1)+" ");
		System.out.println(output);
		/*System.out.print(firstHalf);
		if (aloneCharacterIndex != -1) System.out.print(aloneCharacterIndex+1+" ");
		System.out.print(secondHalf);
		System.out.println();*/
	}
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			String str = input.next();
			go(str);
		} 
	}
}
