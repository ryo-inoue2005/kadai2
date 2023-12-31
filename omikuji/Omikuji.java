package omikuji;

import common.Fortune;

/**
 * Omikuji抽象クラス. <br>
 * Omikuji抽象クラスは、おみくじ周りを管理します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
 public abstract class Omikuji implements Fortune {
	
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
	 * @param negaigoto
	 * 			願い事
	 * @param akinai
	 * 			商い
	 * @param gakumon
	 * 			学問
	 */
	public abstract void setUnsei(String negaigoto, String akinai, String gakumon);
	
	/**
	 * @see Fortune#disp()
	 */
	@Override
	public String disp() {
		
		return String.format(DISP_STR + "\n" + "願い事：%s \n" + "商い：%s \n" + "学問：%s \n",
				this.unsei, this.negaigoto, this.akinai, this.gakumon);
	}
}
