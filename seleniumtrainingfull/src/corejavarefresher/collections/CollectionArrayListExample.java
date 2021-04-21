/* This file explains ArrayList with examples */

package corejavarefresher.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import corejavarefresher.objectorientedprogramming.classNinheritance.Patient;

public class CollectionArrayListExample {

	public static void main(String[] args) {
		/* ArrayList object Creation */
		/*
		 * The below list is also called raw list. You can enter any object in
		 * this list.
		 */
		List putAnythingInIt = new ArrayList();

		/*
		 * This is a generic list which will allow only String to be stored.
		 */
		List<String> genericArrayListString = new ArrayList();

		/*
		 * This is a generic list which stored patients
		 */
		List<Patient> allPatients = new ArrayList();

		/*
		 * The below list we will use when learning WebDriver where we will
		 * store all the WebElements in an arraylist
		 */
		// List<WebElement> allGoogleLinks = new ArrayList();

		/*
		 * in raw list you can add anything and Java will not prevent you. To
		 * add an element in arraylist you use add method.
		 */

		for (int i = 0; i < 5; i++) {
			putAnythingInIt.add(new Integer(i));
			// firstList.add(i);
		}
		putAnythingInIt.add(new Patient("Mr. Goldwin", 74, "Fever"));

		/*
		 * Becaue putAnythingInIt is raw list to extract the object out of the
		 * list you need to typecast it to appropariate object type. In the
		 * below case we need to typecast it back to Patient object.
		 */

		Patient patient1 = (Patient) putAnythingInIt.get(5);

		/*
		 * To access an element, you need to use get() method.
		 */
		Integer b2 = (Integer) putAnythingInIt.get(4);
		/*
		 * Populate arraylist with String
		 */
		genericArrayListString.add("Learn");
		genericArrayListString.add("Test");
		genericArrayListString.add("Automation");
		genericArrayListString.add("Using");
		genericArrayListString.add("Selenium");
		genericArrayListString.add("WebDriver");

		/*
		 * Gets the third element of the arraylist.
		 */
		String tutorialValue = genericArrayListString.get(2);

		/*
		 * Following commented lines will not get compiled. Java prevents us
		 * from storing anything other than String in genericArrayListString
		 * list.
		 */
		// genericArrayListString.add(new Integer(25));
		Patient patient2 = new Patient("Mr. Goldwin", 74, "Fever");
		// genericArrayListString.add(patient2);

		/*
		 * Adding to the allPatients list.
		 */
		allPatients.add(new Patient("Mr. Shivdasan", 24, "Flue"));
		allPatients.add(new Patient("Mr. Matt Goodwin", 67, "BP"));
		allPatients.add(new Patient("Mr. A. B. Chopra"));

		int getThirdPatientAge = allPatients.get(2).getAge();

		/* Iterating through the ArrayList to display the Contents. */
		Iterator genericArrayListStringIterator = genericArrayListString
				.iterator();

		System.out.print("Print putAnythingInIt arraylist - ");
		while (genericArrayListStringIterator.hasNext()) {
			System.out.print(genericArrayListStringIterator.next() + " , ");
		}
		System.out.println();

		/* Searching for an element in the ArrayList */
		int index = genericArrayListString.indexOf("Automation");
		System.out.println("Automation is stored at - " + index
				+ "nd position.");
		System.out.println();

		/* Getting the subList from the original List */
		List subList = genericArrayListString.subList(3,
				genericArrayListString.size());
		System.out.println("Parial List is  " + subList);
		System.out.println();

		/* Sort an ArrayList */
		System.out.print("Sorted List - ");
		Collections.sort(genericArrayListString);
		System.out.println(genericArrayListString);
		System.out.println();

		// Reversing an ArrayList
		System.out.print("Reversed List - ");
		Collections.reverse(genericArrayListString);
		System.out.println(genericArrayListString);
		System.out.println();

		System.out.println("Check if the list is empty  "
				+ genericArrayListString.isEmpty());
		System.out.println();

		/* Comparing if two arrays are equal */

		/* Create a copy of arraylist */
		ArrayList arraylistC = new ArrayList(genericArrayListString);
		System.out.println("Are two lists same - "
				+ genericArrayListString.equals(arraylistC));
		System.out.println();

		/* Converting an ArrayList to an Array */
		Object[] array = genericArrayListString.toArray();
		for (int i = 0; i < array.length; i++) {
			System.out.println("Array Element [" + i + "] = " + array[i]);
		}

		System.out.println();
		/* Clearing Elements in array list */
		genericArrayListString.clear();
		System.out.println("After clearing  : " + genericArrayListString);
		System.out.println();

	}
}