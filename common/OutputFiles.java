package common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * OutputFilesクラス. <br>
 * OutputFilesクラスは、ファイルまわりの作業を管理します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class OutputFiles {

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
