package omikuji;

import common.Fortune;

/**
 * Chukichiクラス. <br>
 * Chukichiクラスは、中吉を設定します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class Chukichi extends Omikuji {

	public Chukichi() {
		
		this.unsei = "中吉";
	}

	/**
	 * @see Fortune#disp()
	 */
	@Override
	public String disp(StringBuilder builder) {
		
		return String.format(builder.toString(), this.unsei, this.negaigoto, this.akinai, this.gakumon);
	}

	/**
	 * @see Omikuji#setUnsei()
	 */
	@Override
	public void setUnsei(String negaigoto, String akinai, String gakumon) {
		
		this.negaigoto = negaigoto;
		this.akinai = akinai;
		this.gakumon = gakumon;
	}
}
