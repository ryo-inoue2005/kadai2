package omikuji;

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

	/**
	 * 運勢をセットするメソッド
	 * <br>
	 * 運勢をセットします。	
	 * 
	 * @param unsei
	 * 			運勢
	 * @param negaigoto
	 * 			願い事
	 * @param akinai
	 * 			商い
	 * @param gakumon
	 * 			学問
	 */
	public abstract void setUnsei(String unsei, String negaigoto, String akinai, String gakumon);
}
