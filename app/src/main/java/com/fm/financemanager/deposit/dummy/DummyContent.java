package com.fm.financemanager.deposit.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample amount for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Deposit> ITEMS = new ArrayList<Deposit>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Deposit> ITEM_MAP = new HashMap<String, Deposit>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i, String.valueOf("Rs " + 1587 * i)));
        }
    }

    private static void addItem(Deposit item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Deposit createDummyItem(int position, String content) {
        return new Deposit(String.valueOf(position), content, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of amount.
     */
    public static class Deposit {
        public  String id;
        public final String amount;
        public final String details;

        public Deposit(String id, String amount, String details) {
            this.id = id;
            this.amount = amount;
            this.details = details;
        }

        @Override
        public String toString() {
            return amount;
        }
    }
}
