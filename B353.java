import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author Antonio081014
 * @since Oct 10, 2013, 9:14:04 AM
 */
public class B353 {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int N = 2 * Integer.parseInt(in.readLine());
			ArrayList<Pair> list = new ArrayList<Pair>();
			String[] str = in.readLine().split("\\s");
			ArrayList<ArrayList<Integer>> count = new ArrayList<ArrayList<Integer>>(
					101);
			for (int i = 0; i <= 100; i++)
				count.add(new ArrayList<Integer>());
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(str[i]);
				list.add(new Pair(a, i));
				count.get(a).add(i);
			}

			HashSet<Integer> set1 = new HashSet<Integer>();
			HashSet<Integer> set2 = new HashSet<Integer>();
			int cube = 1;
			for (int i = 10; i <= 100; i++) {
				ArrayList<Integer> tmp = count.get(i);
				if (tmp.size() >= 2) {
					int a = tmp.get(0);
					int b = tmp.get(1);
					set1.add(list.get(a).number);
					set2.add(list.get(b).number);
					list.get(a).cube = 1;
					list.get(b).cube = 2;
					tmp.remove(0);
					tmp.remove(0);

				} else if (tmp.size() == 1) {
					list.get(tmp.get(0)).cube = cube;
					if (cube == 1)
						set1.add(list.get(tmp.get(0)).number);
					else
						set2.add(list.get(tmp.get(0)).number);
					cube = 3 - cube;
					tmp.remove(0);
				}
			}
			for (int i = 10; i <= 100; i++) {
				ArrayList<Integer> tmp = count.get(i);
				while (tmp.isEmpty() == false) {
					list.get(tmp.get(0)).cube = cube;
					cube = 3 - cube;
					tmp.remove(0);
				}
			}

			// System.out.println(set1.size());
			// System.out.println(set2.size());
			System.out.println(set1.size() * set2.size());
			System.out.print(list.get(0).cube);
			for (int i = 1; i < N; i++)
				System.out.print(" " + list.get(i).cube);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void print(ArrayList<Pair> list) {
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).cube);
	}
}

class Pair {
	public int number;
	public int cube;
	public int index;

	public Pair(int n, int index) {
		number = n;
		this.index = index;
	}
}
