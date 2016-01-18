package com.badugi.poker.oddscalcu;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.badugi.poker.Card;
import com.badugi.poker.TexasConstant;
import com.badugi.poker.oddscalcu.helper.Combine;

/**
 * author yuesheng.yin createTime 2012-1-4 下午06:02:30
 */
/**
 * 计算�?
 */
public class OddsCalculator implements Serializable {

	private static final long serialVersionUID = -7485023261632067578L;

	private static final int cpuSize = Runtime.getRuntime()
	.availableProcessors();// 计算密集�?

	private static final ExecutorService exeService = Executors
			.newCachedThreadPool();
	/**
	 * 多线程处�?
	 * 
	 * @param sentCards --
	 *            已发出的公共�?逗号分隔
	 * @param unsendCards --
	 *            未发出的公共�?逗号分隔
	 * @param oddsCardInfo --
	 *            每个玩家手中的扑克牌,逗号分隔
	 */
	public static void oddsCalcul(final int[] sentCards,
			final int[] unsendCards, final OddsCardInfo... oddsCardInfo) {
		final int sentCount = (sentCards == null || sentCards.length == 0) ? 0
				: sentCards.length;
		for (OddsCardInfo odds : oddsCardInfo) {
			odds.reset();
		}
		if (sentCount == TexasConstant.POKER_HAND_NUM) {// 全部发完扑克�?
			setTotalCalcus(1, oddsCardInfo);
			calcul(sentCards, oddsCardInfo);
		} else {
			long a = System.nanoTime();
			final List<int[]> strList = Combine.getCombineListQuick(
					unsendCards, 5 - sentCount);
			final int strListSize = strList.size();
			setTotalCalcus(strListSize, oddsCardInfo);
			long b = System.nanoTime();
			System.out.println(cpuSize + " cpuSize " + " e " + strListSize
					+ " ; " + (b - a) / 1000000);
			final CountDownLatch doneSignal = new CountDownLatch(cpuSize);
			final int segment = strListSize / cpuSize;// 分多少片�?
			int result = 0;
			for (int i = 0; i < cpuSize; i++) {
				final int startSeg = i * segment;
				result = (i + 1) * segment;
				if (i == (cpuSize - 1)) {// �?���?���?
					result = strListSize;
				}
				final int endSeg = result;
				final List<int[]> subStrList = strList
						.subList(startSeg, endSeg);
				exeService.execute(new Runnable() {
					public void run() {
						if (sentCount == 0) {
							for (int[] str : subStrList) {
								calcul(str, oddsCardInfo);
							}
						} else {
							int[] fiveCardArr;
							for (int[] str : subStrList) {
								fiveCardArr = new int[5];
								System.arraycopy(str, 0, fiveCardArr, 0,
										str.length);
								System.arraycopy(sentCards, 0, fiveCardArr,
										str.length, sentCards.length);
								calcul(fiveCardArr, oddsCardInfo);
							}
						}
						doneSignal.countDown();
					}
				});
			}
			try {
				doneSignal.await();
			} catch (InterruptedException e) {
				//logger.error(e.getMessage(), e);
			}
			System.out.println((System.nanoTime() - b) / 1000000);
		}
	}

	/**
	 * Main线程处理
	 * 
	 * @param sentCards --
	 *            已发出的公共�?逗号分隔
	 * @param unsendCards --
	 *            未发出的公共�?逗号分隔
	 * @param oddsCardInfo --
	 *            每个玩家手中的扑克牌,逗号分隔
	 */
	public static void oddsCalculMain(final int[] sentCards,
			final int[] unsendCards, final OddsCardInfo... oddsCardInfo) {
		final int sentCount = (sentCards == null || sentCards.length == 0) ? 0
				: sentCards.length;
		for (OddsCardInfo odds : oddsCardInfo) {
			odds.reset();
		}
		if (sentCount == TexasConstant.POKER_HAND_NUM) {// 全部发完扑克�?
			setTotalCalcus(1, oddsCardInfo);
			calcul(sentCards, oddsCardInfo);
		} else {
			long a = System.nanoTime();
			final List<int[]> strList = Combine.getCombineListQuick(
					unsendCards, 5 - sentCount);
			final int strListSize = strList.size();
			setTotalCalcus(strListSize, oddsCardInfo);
			long b = System.nanoTime();
			System.out.println("e : " + strListSize + " ; " + (b - a));
			if (sentCount == 0) {
				for (int[] str : strList) {
					calcul(str, oddsCardInfo);
				}
			} else {
				int[] fiveCardArr;
				for (int[] str : strList) {
					fiveCardArr = new int[5];
					System.arraycopy(str, 0, fiveCardArr, 0, str.length);
					System.arraycopy(sentCards, 0, fiveCardArr, str.length,
							sentCards.length);
					calcul(fiveCardArr, oddsCardInfo);
				}
			}
			System.out.println((System.nanoTime() - b));
		}
	}


	private static String getStr() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 52; i++) {
			sb.append(i).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * 
	 * @param totalCalcus
	 * @param oddsCardInfo
	 */
	private static void setTotalCalcus(int totalCalcus,
			final OddsCardInfo... oddsCardInfo) {
		for (OddsCardInfo oddsCardInfo2 : oddsCardInfo) {
			oddsCardInfo2.setTotalCalcus(totalCalcus);
		}
	}

	/**
	 * 
	 * @param fiveCards
	 *            --- 五张扑克�?
	 * @param oddsCardInfo
	 */
	private static void calcul(final int[] fiveCards,
			final OddsCardInfo... oddsCardInfo) {
		OddsCardInfo[] newOddsCardInfo = new OddsCardInfo[oddsCardInfo.length];
		int i = 0;
		for (OddsCardInfo odds : oddsCardInfo) {
			odds.initFiveCards(Card.newCard(fiveCards[0]), Card
					.newCard(fiveCards[1]), Card.newCard(fiveCards[2]), Card
					.newCard(fiveCards[3]), Card.newCard(fiveCards[4]), Card
					.newCard(odds.getCards()[0]), Card
					.newCard(odds.getCards()[1]));
			newOddsCardInfo[i++] = odds;
		}
		Arrays.sort(newOddsCardInfo, new Comparator<OddsCardInfo>() {
			public int compare(OddsCardInfo o1, OddsCardInfo o2) {
				return -o1.compareTo(o2);
			}
		});
		boolean firstwin = true;
		for (i = 1; i < newOddsCardInfo.length; i++) {
			if (newOddsCardInfo[0].compareTo(newOddsCardInfo[i]) == 0) {
				newOddsCardInfo[i].getTieCounts().incrementAndGet();
				firstwin = false;
			}
			//newOddsCardInfo[i].initCount();
		}
		//newOddsCardInfo[0].initCount();
		if (firstwin) {
			newOddsCardInfo[0].getWinCounts().incrementAndGet();
		} else {
			newOddsCardInfo[0].getTieCounts().incrementAndGet();
		}
	}

	//private static Logger logger = LoggerFactory.getLogger(OddsCalculator.class);
}
