package me.neznamy.tab.shared.features.sorting.types;

import java.util.LinkedHashMap;

import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.shared.TAB;

/**
 * Sorting by primary permission groups
 */
public class Groups extends SortingType {

	//map of sorted groups in config
	private LinkedHashMap<String, String> sortedGroups;
	
	/**
	 * Constructs new instance
	 */
	public Groups() {
		sortedGroups = loadSortingList();
	}

	@Override
	public String getChars(TabPlayer p) {
		String group = p.getGroup();
		String chars = sortedGroups.get(group.toLowerCase());
		if (chars == null) {
			chars = "9";
			if (!group.equals("<null>")) {
				TAB.getInstance().getErrorManager().oneTimeConsoleError(String.format("Group \"&e%s&c\" is not defined in sorting list! This will result in players in that group not being sorted correctly. To fix this, add group \"&e%s&c\" into &egroup-sorting-priority-list in config.yml&c. Your current list: %s", group, group, sortedGroups.keySet()));
			}
			p.setTeamNameNote("&cPlayer's primary group is not in sorting list");
		} else {
			p.setTeamNameNote(String.format("Primary group is #%s in sorting list", Integer.parseInt(chars)));
		}
		return chars;
	}
	
	@Override
	public String toString() {
		return "GROUPS";
	}
}