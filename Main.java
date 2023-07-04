package kadai2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Mainクラス. <br>
 * Mainクラスは、おみくじを実行します
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class Main {

	/**
	 * mainメソッド
	 * <br>
	 * おみくじを実行します
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println("yyyyMMddで入力");
			Integer day = scanner.nextInt();

			// yyyyMMddではなかったら例外を発生させる
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
			dFormat.parse(day.toString());

			//入力された 日にちを元にランダムオブジェクトを生成
			Random random = new Random(day);

			// おみくじリストを生成
			List<Fortune> fortunes = new ArrayList<>();
			fortunes.add(new Daikichi());
			fortunes.add(new Chukichi());
			fortunes.add(new Shokichi());
			fortunes.add(new Kichi());
			fortunes.add(new Suekichi());
			fortunes.add(new Kyo());

			// ランダムにおみくじオブジェクトをおみくじリストからゲットする
			Fortune fortune = fortunes.get(random.nextInt(fortunes.size()));

			// コンソールに出力
			System.out.println(fortune.disp());
			// テキストファイルに出力
			ReadWriteProperties.write(fortune.disp());

		} catch (InputMismatchException e) {
			System.out.println("数値を入力してください");
		} catch (ParseException e) {
			System.out.println("yyyyMMddで入力してください");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
