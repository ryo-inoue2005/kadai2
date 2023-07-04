package kadai2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * CsvReadクラス. <br>
 * CsvReadクラスは、csvまわりの作業を管理します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class CsvRead {

	/**
	 * csvを読み込むメソッド
	 * <br>
	 * 読み込んだcsvをリストで返します
	 *
	 * @throws IOException
	 *			ファイル未発見例外
	 * @return lines
	 * 			読み込んだcsvのListを返す
	 *			
	 */
	public static List<String> read() throws IOException {

		// ファイルパスを指定
		final String FILE_PATH = "/Users/r_inoue/Documents/workspaces/uranai/src/kadai2/unsei.csv";

		// csvファイルから全ての行を取得
		Path path = Paths.get(FILE_PATH);
		List<String> lines = Files.readAllLines(path, Charset.forName("UTF-8"));

		return lines;
	}

	/**
	 * 占い結果を検索するメソッド
	 * <br>
	 * おみくじ結果を元に対象の運勢結果の行を返します。
	 * 
	 * @return result
	 * 			占い結果の行
	 */
	public static List<Integer> unseiLines(String unsei, List<String> lines) {
		List<Integer> result = new ArrayList<>();

		// 全ての行からおみくじに該当する行を抽出
		for (int i = 0; i < lines.size(); i++) {
			String[] csvData = lines.get(i).split(",");

			if (csvData[0].equals(unsei)) {
				result.add(i);
			}
		}
		return result;
	}

	/**
	 * 占い結果を返すメソッド
	 * <br>
	 * 運勢結果を元に対象の占い結果を返します。
	 *
	 * @return csvData
	 * 			占い結果
	 */
	public static String[] unseiResult(int unsei, List<String> lines) {

		String[] csvData;

		// 運勢結果を取得して返す
		for (int i = unsei; i < lines.size(); i++) {
			csvData = lines.get(i).split(",");

			if (csvData.length > 3) {
				return csvData;
			}
		}
		return null;
	}
}