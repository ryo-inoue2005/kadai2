package common;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * CSVを一行ずつ分解したデータを格納するメソッド
	 * <br>
	 * リストに格納したCSVデータを一行ずつ分解して格納します
	 *
	 * @return list
	 * 			一行ずつ分解したリストを返します
	 */
	public static List<Map<String, String>> getUnsei(List<String> lines) {
		List<Map<String, String>> list = new ArrayList<>();

		// 一行ずつ、データを分解して格納する
		for (int i = 0; i < lines.size(); i++) {
			Map<String, String> map = new HashMap<>();
			
			String[] csvData = lines.get(i).split(",");
			
			map.put("UNSEI", csvData[0]);
			map.put("NEGAIGOTO", csvData[1]);
			map.put("AKINAI", csvData[2]);
			map.put("GAKUMON", csvData[3]);
			list.add(map);
			
			// 初期化
			csvData = null;
		}
		return list;
	}
	
}