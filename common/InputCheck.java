package common;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * InputCheckクラス. <br>
 * InputCheckクラスは、入力された値をチェックします。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class InputCheck {

	/**
	 * 日付が数値か確認するメソッド
	 * <br>
	 * 入力された日付が数値かどうかチェックします
	 * 
	 * @return チェック結果
	 */
	public static boolean checkStrDate(String value) {

		if (value != null) {
			Pattern pattern = Pattern.compile("^[0-9]+$|-[0-9]+$");
			return pattern.matcher(value).matches();
		}
		return false;
	}

	/**
	 * 日付が正しいか確認するメソッド
	 * <br>
	 * 入力された日付が指定された型、存在するかチェックします
	 * 
	 * @return チェック結果
	 */
	public static boolean checkDate(String birthDay) {

		try {
			// yyyyMMddに設定
			SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");
			// 存在する日付かどうかチェック
			dFormat.setLenient(false);
			dFormat.parse(birthDay);

			return true;

		} catch (Exception e) {

			return false;
		}
	}
}
