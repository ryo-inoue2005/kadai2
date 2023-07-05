package kadai2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import common.CsvRead;
import common.Fortune;
import common.ReadWriteProperties;
import omikuji.Chukichi;
import omikuji.Daikichi;
import omikuji.Kichi;
import omikuji.Kyo;
import omikuji.Shokichi;
import omikuji.Suekichi;

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
			System.out.println("誕生日を入力してください(yyyyMMddで入力)");
			Integer day = scanner.nextInt();

			// 日付妥当性チェック
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
			// 存在する日付かどうかチェック
			dFormat.setLenient(false);
			// yyyyMMddになっているかチェック
			dFormat.parse(day.toString());

			// csvを読み込み、一行ずつ運勢を分解したリストを取得
			List<String> csvList = CsvRead.read();
			List<Map<String, String>> unseiList = CsvRead.getUnsei(csvList);

			List<Fortune> fortunes = new ArrayList<>();

			// 運勢ごとにオブジェクトを生成
			for (int i = 0; i < unseiList.size(); i++) {

				String unsei = unseiList.get(i).get("UNSEI");
				String negaigoto = unseiList.get(i).get("NEGAIGOTO");
				String akinai = unseiList.get(i).get("AKINAI");
				String gakumon = unseiList.get(i).get("GAKUMON");

				switch (unsei) {

				case "大吉":
					Daikichi daikichi = new Daikichi();
					daikichi.setUnsei(unsei, negaigoto, akinai, gakumon);
					fortunes.add(daikichi);
					break;

				case "中吉":
					Chukichi chukichi = new Chukichi();
					chukichi.setUnsei(unsei, negaigoto, akinai, gakumon);
					fortunes.add(chukichi);
					break;

				case "吉":
					Kichi kichi = new Kichi();
					kichi.setUnsei(unsei, negaigoto, akinai, gakumon);
					fortunes.add(kichi);
					break;

				case "小吉":
					Shokichi shokichi = new Shokichi();
					shokichi.setUnsei(unsei, negaigoto, akinai, gakumon);
					fortunes.add(shokichi);
					break;

				case "末吉":
					Suekichi suekichi = new Suekichi();
					suekichi.setUnsei(unsei, negaigoto, akinai, gakumon);
					fortunes.add(suekichi);
					break;

				case "凶":
					Kyo kyo = new Kyo();
					kyo.setUnsei(unsei, negaigoto, akinai, gakumon);
					fortunes.add(kyo);
					break;

				//一行でもCSVに不正があった場合、強制終了させる
				default:
					System.out.println("不正なおみくじがあります。");
					return;
				}
			}

			//入力された 日にちを元にランダムオブジェクトを生成
			Random random = new Random(day);

			// ランダムにおみくじオブジェクトをおみくじリストからゲットする
			Fortune fortune = fortunes.get(random.nextInt(fortunes.size()));

			// コンソールに出力
			System.out.println(fortune.disp());
			
			// テキストファイルに出力
			ReadWriteProperties.write(fortune.disp());

		} catch (InputMismatchException e) {
			System.out.println("数値を入力してください");
		} catch (ParseException e) {
			System.out.println("yyyyMMddではないか、存在しない日付です");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
