package kadai2;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Kichiクラス. <br>
 * Kichiクラスは、吉を設定します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class Kichi extends Omikuji implements Fortune {

	/** コンストラクタ */
	public Kichi() throws IOException {
		this.unsei = "吉";
		this.lines = CsvRead.read();
		setUnsei();
	}

	/**
	 * @see Fortune#disp()
	 */
	@Override
	public String disp() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format(ReadWriteProperties.read(), this.unsei) + "\n");
		builder.append("願い事：" + this.negaigoto + "\n");
		builder.append("商い：" + this.akinai + "\n");
		builder.append("学問：" + this.gakumon + "\n");

		return builder.toString();
	}

	/**
	 * @see Omikuji#setUnsei()
	 */
	@Override
	public void setUnsei() {
		List<Integer> unseiList = CsvRead.unseiLines(unsei, lines);

		Random random = new Random();
		int randomLuck = random.nextInt(unseiList.size());
		String[] unseiResult = CsvRead.unseiResult(randomLuck, lines);

		this.negaigoto = unseiResult[1];
		this.akinai = unseiResult[2];
		this.gakumon = unseiResult[3];
	}
}
