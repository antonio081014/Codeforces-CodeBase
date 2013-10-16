import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author Antonio081014
 * @since Oct 10, 2013, 9:05:38 AM
 */
public class A353 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int N = Integer.parseInt(in.readLine());
			int upper = 0;
			int lower = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				String[] str = in.readLine().split("\\s");
				int a = Integer.parseInt(str[0]);
				if (a % 2 == 1)
					upper++;
				int b = Integer.parseInt(str[1]);
				if (b % 2 == 1)
					lower++;
				if (a % 2 != 1 && b % 2 == 1)
					flag = true;
				if (b % 2 != 1 && a % 2 == 1)
					flag = true;
			}
			upper %= 2;
			lower %= 2;
			if (upper + lower == 0)
				System.out.println(0);
			else if (upper + lower == 2 && flag)
				System.out.println(1);
			else
				System.out.println(-1);
		} catch (Exception e) {
		}
	}
}
