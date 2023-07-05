package common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * ReadWritePropertiesクラス. <br>
 * ReadWritePropertiesクラスは、Propertiesまわりの作業を管理します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class ReadWriteFiles {

	/**
	 * Propertiesファイルを読み込むメソッド
	 * <br>
	 * 読み込んだPropertiesファイルを文字列で返します
	 *
	 * @return Propertiesファイルから読み込んだ文字列
	 *			
	 */
	public static String read() {

		final String FILE_PATH = "kadai2.fortune";

		// ファイル読み込み
		ResourceBundle bundle = ResourceBundle.getBundle(FILE_PATH);

		return bundle.getString("disp_str");
	}

	/**
	 * 占い結果をテキストファイルに出力するメソッド
	 * <br>
	 * 占い結果をテキストファイルに出力します。
	 * 
	 * @throws IOException
	 */
	public static void write(String kekka) throws IOException {
		
		final String FILE_NAME = "uranaiKekka.txt";

		// ファイルを作成し、挿入モードを設定
		BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true));

		try {
			//占い結果を書き込み、改行
			bw.write(kekka);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			bw.close();
		}
	}
}
