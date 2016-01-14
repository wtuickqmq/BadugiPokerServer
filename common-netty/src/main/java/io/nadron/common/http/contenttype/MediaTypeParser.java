package io.nadron.common.http.contenttype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MediaTypeParser is useful for parsing Content-Type or Accept HTTP headers to
 * both parse them into an order list of MediaRange preferences and for matching
 * supported MediaRanges to requested ones for serialization.
 */
public class MediaTypeParser {
	/**
	 * Parses a Content-Type or Accept header into an ordered List of MediaRange
	 * instances, which in turn can be used to determine which media type is
	 * most appropriate for serialization.
	 * 
	 * @param mediaType
	 * @return a List of MediaRange instances parsed from the mediaType string.
	 */
	public static List<MediaRange> parse(String mediaType) {
		if (mediaType == null)
			return Collections.emptyList();

		String[] segments = mediaType.split("\\s*,\\s*");
		List<MediaRange> items = new ArrayList<MediaRange>();

		for (String segment : segments) {
			items.add(MediaRange.parse(segment));
		}

		return items;
	}

	/**
	 * Given a List of supported MediaRanges and requested MediaRanges, returns
	 * the single best match in Content-Type header format.
	 * 
	 * @param supportedRanges
	 *            an ordered List of supported MediaRanges.
	 * @param requestedRanges
	 *            an ordered List of MediaRanges that the client desires.
	 * @return the single best MediaRange match in Content-Type header format
	 *         (String). Or null if no match found.
	 */
	public static String getBestMatch(List<MediaRange> supportedRanges,
			List<MediaRange> requestedRanges) {
		List<WeightedMatch> matches = new ArrayList<WeightedMatch>();

		for (MediaRange supportedRange : supportedRanges) {
			WeightedMatch m = getWeightedMatch(supportedRange, requestedRanges);

			if (m != null) {
				matches.add(m);
			}
		}

		if (matches.isEmpty())
			return null;
		if (matches.size() == 1)
			return matches.get(0).mediaRange.asMediaType();

		Collections.sort(matches);
		return matches.get(0).mediaRange.asMediaType();
	}

	/**
	 * Iterates the requested MediaRanges to determine how well the single
	 * supported MediaRange matches.
	 * 
	 * @param supportedRange
	 * @param requestedRanges
	 * @return a WeightedMatch
	 */
	private static WeightedMatch getWeightedMatch(MediaRange supportedRange,
			List<MediaRange> requestedRanges) {
		int maxRank = -1;
		MediaRange bestMatch = null;

		for (MediaRange requestedRange : requestedRanges) {
			int rank = supportedRange.rankAgainst(requestedRange);

			if (rank > maxRank) {
				maxRank = rank;
				bestMatch = supportedRange;
			}
		}

		return (maxRank == -1 ? null : new WeightedMatch(bestMatch, maxRank));
	}

	protected static class WeightedMatch implements Comparable<WeightedMatch> {
		MediaRange mediaRange;
		int rank;

		public WeightedMatch(MediaRange range, int rank) {
			this.mediaRange = range;
			this.rank = rank;
		}

		/**
		 * Reverse-rank natural ordering.
		 */
		@Override
		public int compareTo(WeightedMatch that) {
			int rankSign = (that.rank - this.rank);

			if (rankSign == 0) {
				return (int) ((that.mediaRange.qvalue - this.mediaRange.qvalue) * 10);
			}

			return rankSign;
		}
	}
}
