package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int TO_MS = 1_000_000;
	private static final int ELEMS_PER = 1_000_000;
	private static final int ELEMS = 1_000;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	List<Integer> l1 = new ArrayList<>();
    	for(int i = ELEMS; i < 2*ELEMS; i++ ) {
    		l1.add(i);
    	}
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	List<Integer> l2 = new LinkedList<>(l1);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int swap = l1.get(l1.size() - 1);
    	l1.set(l1.size() - 1, l1.get(0));
    	l1.set(0, swap);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for(int el : l1) {
    		System.out.println("Elemento:\t" + el);
    	}
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	List<Integer> l3 = new LinkedList<>(l1);
    	long time = System.nanoTime();
    	for(int i = 0; i<ELEMS_PER; i++) {
    		l3.add(i);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Test Performance 1 :\t" + time / TO_MS + " ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	List<Integer> l5 = new LinkedList<>(l1);
    	List<Integer> l4 = new ArrayList<>(l1);
    	time = System.nanoTime();
    	for(int i = 0; i<1000; i++) {
    		l5.get(l5.size()/2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Test Performance Read LinkedList :\t" + time / TO_MS + " ms");
    	
    	time = System.nanoTime();
    	for(int i = 0; i<1000; i++) {
    		l4.get(l4.size()/2);
    	}
    	time = System.nanoTime() - time;
    	System.out.println("Test Performance Read ArrayList :\t" + time / TO_MS + " ms");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	Map<String, Long> worldPop = new HashMap<>();
    	worldPop.put("Africa", 1_110_635_000L);
    	worldPop.put("Americas", 972_005_000L);
    	worldPop.put("Antarctica", 0L);
    	worldPop.put("Asia", 4_298_723_000L);
    	worldPop.put("Europe", 742_452_000L);
    	worldPop.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
    	long totPop = 0;
    	for(String key : worldPop.keySet()) {
    		System.out.println("Key:\t"+key+" Value:\t" + worldPop.get(key));
    		totPop += worldPop.get(key);
    	}
    	System.out.println("World Population : " + totPop);
    }
}
