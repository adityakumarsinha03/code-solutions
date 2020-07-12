// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0

import java.util.*;
import java.lang.*;
import java.io.*;

class ReverseWords {
	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {

			String line = br.readLine();
			Stack<String> st = new Stack<String>();

			String s = new String();
			for (int i = 0; i < line.length(); i++) {
				s = new String();
				while (i < line.length() && line.charAt(i) != '.') {
					s += line.charAt(i);
					i++;
				}
				st.push(s);
			}
			String finalLine = new String();
			while (!st.empty()) {
				finalLine += st.peek();
				st.pop();
				if (!st.empty()) {
					finalLine += ".";
				}
			}

			System.out.println(finalLine);
			t--;
		}
	}
}