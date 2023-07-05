package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	 * csvを読み込み、一行ごとのデータを分解し、格納したリストを返すメソッド
	 * <br>
	 * 読み込んだcsvを一行ごとデータを分解し、格納したリストを返します。
	 * 
	 * @throws IOException
	 *			ファイル未発見例外
	 * @return unseiList
	 * 			読み込んだcsvのListを返す
	 */
	public static List<Map<String, String>> getUnsei() throws IOException {

		// ファイルパスを指定
		final String FILE_PATH = "/Users/r_inoue/Documents/workspaces/uranai/src/kadai2/unsei.csv";

		//CSVデータ読み込み
		File file = new File(FILE_PATH);
		BufferedReader br = new BufferedReader(new FileReader(file));

		try {
			List<Map<String, String>> unseiList = new ArrayList<>();

			// 一行目を読み込む
			String line = br.readLine();

			// 行数がなくなるまで実行し、一行ずつ要素ごとに分解しmapに格納
			while (line != null) {

				Map<String, String> map = new HashMap<>();
				String[] csvData = line.split(",");

				map.put("UNSEI", csvData[0]);
				map.put("NEGAIGOTO", csvData[1]);
				map.put("AKINAI", csvData[2]);
				map.put("GAKUMON", csvData[3]);
				unseiList.add(map);

				// 初期化
				csvData = null;

				// 次の行に移動
				line = br.readLine();
			}
			return unseiList;
			
		} finally {
			br.close();
		}
	}
}