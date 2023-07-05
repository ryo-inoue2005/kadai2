package omikuji;

import common.Fortune;
import common.ReadWriteProperties;

/**
 * Shokichiクラス. <br>
 * Shokichiクラスは、小吉を設定します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class Shokichi extends Omikuji implements Fortune {

	  /**
	   * @see Fortune#disp()
	   */
	@Override
	public String disp() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format(ReadWriteProperties.read(), this.unsei)  + "\n");
		builder.append("願い事：" + this.negaigoto + "\n");
		builder.append("商い：" + this.akinai + "\n");
		builder.append("学問：" + this.gakumon + "\n");

		return builder.toString();
	}

	  /**
	   * @see Omikuji#setUnsei()
	   */
	@Override
	public void setUnsei(String unsei, String negaigoto, String akinai, String gakumon) {
		this.unsei = unsei;
		this.negaigoto = negaigoto;
		this.akinai = akinai;
		this.gakumon = gakumon;
	}
}
