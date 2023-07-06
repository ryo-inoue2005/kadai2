package kadai2;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import common.CsvRead;
import common.Fortune;
import common.InputCheck;
import common.OutputFiles;
import omikuji.Omikuji;

/**
 * Mainクラス. <br>
 * Mainクラスは、おみくじを実行します。
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
			String birthDay;

			// 入力エラーがあったら再入力させる
			while (true) {

				System.out.println("誕生日を入力してください(yyyyMMddで入力)");
				birthDay = scanner.next();

				// 日付が正しければ、ループを抜ける
				if (!(InputCheck.checkStrDate(birthDay))) {
					System.out.println("数値を入力してください");
				} else {
					if (!(InputCheck.checkDate(birthDay))) {
						System.out.println("yyyyMMddではないか、存在しない日付です");
					} else {
						break;
					}
				}
			}

			// CSV行数分のおみくじオブジェクトが入ったリストを取得する
			List<Omikuji> omikujis = CsvRead.getUnsei();

			// 現在の日付のミリ秒を取得する
			Long longToday = System.currentTimeMillis() / (1000 * 60 * 60 * 24);

			//入力された誕生日と今日の日付を元にランダムオブジェクトを生成
			Random random = new Random(longToday + Integer.parseInt(birthDay));

			// ランダムにおみくじオブジェクトをおみくじリストからゲットする
			Fortune fortune = omikujis.get(random.nextInt(omikujis.size()));

			// コンソールに出力
			System.out.println(fortune.disp());

			// テキストファイルに出力
			OutputFiles.write(fortune.disp());

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
