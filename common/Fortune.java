package common;

/**
 * Fortuneインターフェース. <br>
 * Fortuneインターフェースは、占い結果を表示します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public interface Fortune {

	String DISP_STR = "「プロパティファイルから読込」";

	/**
	 * 占い結果を表示するメソッド
	 * <br>
	 * 占い結果を文字列をとして返します
	 *
	 * @return 占い結果
	 *			
	 */
	String disp();
}
