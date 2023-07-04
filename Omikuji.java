package kadai2;

import java.util.List;

/**
 * Omikuji抽象クラス. <br>
 * Omikuji抽象クラスは、おみくじ周りを管理します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
abstract class Omikuji {
	
	/** 運勢を表します */
	protected String unsei;
	/** 願い事を表します */
	protected String negaigoto;
	/** 商いを表します */
	protected String akinai;
	/** 学問を表します */
	protected String gakumon;
	/** プロパティファイルの中身を表します */
	protected List<String> lines;

	/**
	 * 運勢をセットするメソッド
	 * <br>
	 * 運勢をセットします。	
	 */
	public abstract void setUnsei();
}
