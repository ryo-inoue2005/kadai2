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
import common.ReadWriteFiles;
import omikuji.Chukichi;
import omikuji.Daikichi;
import omikuji.Kichi;
import omikuji.Kyo;
import omikuji.Omikuji;
import omikuji.Shokichi;
import omikuji.Suekichi;

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
			System.out.println("誕生日を入力してください(yyyyMMddで入力)");
			Integer day = scanner.nextInt();

			// 日付妥当性チェック
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
			// 存在する日付かどうかチェック
			dFormat.setLenient(false);
			// yyyyMMddになっているかチェック
			dFormat.parse(day.toString());

			// csvを読み込み、一行ずつ運勢を分解したリストを取得
			List<Map<String, String>> unseiList = CsvRead.getUnsei();

			List<Omikuji> omikujis = new ArrayList<>();

			// 運勢ごとにオブジェクトを生成
			for (Map<String, String> unseiMap : unseiList) {

				// おみくじ初期化
				Omikuji omikuji = null;

				switch (unseiMap.get("UNSEI")) {

				case "大吉":
					omikuji = new Daikichi();
					break;

				case "中吉":
					omikuji = new Chukichi();
					break;

				case "吉":
					omikuji = new Kichi();
					break;

				case "小吉":
					omikuji = new Shokichi();
					break;

				case "末吉":
					omikuji = new Suekichi();
					break;

				case "凶":
					omikuji = new Kyo();
					break;

				//一行でもCSVに不正があった場合、強制終了させる
				default:
					System.out.println("不正なおみくじがあります。");
					return;
				}

				// 運勢をセットする
				omikuji.setUnsei(unseiMap.get("NEGAIGOTO"), unseiMap.get("AKINAI"), unseiMap.get("GAKUMON"));

				// リストに追加
				omikujis.add(omikuji);
			}

			//入力された 日にちを元にランダムオブジェクトを生成
			Random random = new Random(day);

			// ランダムにおみくじオブジェクトをおみくじリストからゲットする
			Fortune fortune = omikujis.get(random.nextInt(omikujis.size()));

			// 表示用の文字列
			StringBuilder dispBuilder = new StringBuilder();
			dispBuilder.append(String.format(ReadWriteFiles.read(), "%s") + "\n");
			dispBuilder.append("願い事：" + "%s" + "\n");
			dispBuilder.append("商い：" + "%s" + "\n");
			dispBuilder.append("学問：" + "%s" + "\n");

			// コンソールに出力
			System.out.println(fortune.disp(dispBuilder));

			// テキストファイルに出力
			ReadWriteFiles.write(fortune.disp(dispBuilder));

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
