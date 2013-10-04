/**
 * The only thing needs your attention is you can't break large bill into two to make the change.
 * E.g.
 * 4
 * 25 50 50 100
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Antonio081014
 * @since Oct 4, 2013, 10:08:40 AM
 */
public class A349 {

	public static void main(String[] args) {
		A349 main = new A349();
		main.run();
		System.exit(0);
	}

	private void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			int N = Integer.parseInt(in.readLine());
			String[] str = in.readLine().split("\\s");
			int left1 = 0;
			int left2 = 0;
			int left3 = 0;
			for (int i = 0; i < N; i++) {
				int t = Integer.parseInt(str[i]);
				switch (t) {
				case 25:
					left1++;
					break;
				case 50:
					if (left1 > 0) {
						left1--;
						left2++;
					} else {
						System.out.println("NO");
						return;
					}
					break;
				case 100:
					if (left1 > 0 && left2 > 0) {
						left1--;
						left2--;
						left3++;
					} else if (left1 >= 3) {
						left3++;
						left1 -= 3;
					} else {
						System.out.println("NO");
						return;
					}
					break;
				default:
					break;
				}
			}
			System.out.println("YES");
		} catch (Exception e) {
		}
	}
}
