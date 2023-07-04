package kadai2;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Kyoクラス. <br>
 * Kyoクラスは、凶を設定します。
 *
 * @author Ryo.inoue
 * @version 1.00
 */
public class Kyo extends Omikuji implements Fortune {

	/** コンストラクタ */
	public Kyo() throws IOException {
		this.unsei = "凶";
		// csvを読み込む
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
		
		// おみくじ結果の行をcsvから取得する
		List<Integer> unseiList = CsvRead.unseiLines(unsei, lines);

		// 取得した行をランダムで決める
		Random random = new Random();
		int randomLuck = random.nextInt(unseiList.size());
		
		// ランダムで決めた行のデータを取得する
		String[] unseiResult = CsvRead.unseiResult(randomLuck, lines);

		// 運勢をセット
		this.negaigoto = unseiResult[1];
		this.akinai = unseiResult[2];
		this.gakumon = unseiResult[3];
	}
}
