package me.neznamy.tab.shared.features.sorting.types;

import me.neznamy.tab.shared.ITabPlayer;
import me.neznamy.tab.shared.TAB;

/**
 * Sorting by a numeric placeholder from highest to lowest
 */
public class PlaceholderHighToLow extends SortingType {

	/**
	 * Constructs new instance with given parameter
	 * @param sortingPlaceholder - placeholder to sort by
	 */
	public PlaceholderHighToLow(String sortingPlaceholder) {
		super(sortingPlaceholder);
	}

	@Override
	public String getChars(ITabPlayer p) {
		String output = setPlaceholders(p);
		p.setTeamNameNote(p.getTeamNameNote() + "Placeholder returned \"" + output + "\". &r");
		int intValue = TAB.getInstance().getErrorManager().parseInteger(output, 0, "numeric sorting placeholder");
		return String.valueOf(DEFAULT_NUMBER - intValue);
	}
	
	@Override
	public String toString() {
		return "PLACEHOLDER_HIGH_TO_LOW";
	}
}