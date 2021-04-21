/*We are learning how can we make multiple Groups of tests.
 * We can execute multiple test cases which are sharing same group.
 * One test case can share multiple groups.
 */
package testNG.groups;

import org.testng.annotations.Test;

@Test (groups="Forest")
public class TestNGGroups {
  
/*
 * Using "group" attribute in Test annotation, we can create group 
 * and assign the test to that group. 
 * 	This test belongs to Organism and Producers group.
 */
@Test(groups = {"Organisms", "Producers"})
  public void plants() {
	System.out.println("All plants are living oraganism and producers");
  }

/*
 * This test belongs to Organism and Consumers group.
 */
@Test(groups = {"Organisms", "Consumers"})
public void animals() {
	System.out.println("All types of animals are living oraganism and consumers");
}

/*
 * This test belongs to Organism and Decomposers group.
 */
@Test(groups = {"Organisms", "Decomposers"})
public void plantOrAnimal() {
	System.out.println("Some plants or living animals are Organisms and decomposers");
}

/*
 * This test belongs to Decomposers and Consumers group.
 */
@Test(groups = {"Consumers", "Decomposers"})
public void insects() {
	System.out.println("Some Animals like insects or bacterias are Consumers and Decomposers");
}

/*
 * This test belongs to Producers and Consumers group.
 */
@Test(groups = {"Producers", "Consumers"})
public void mushroom() {
	System.out.println("Some plants like mushroom are Producers and Consumers");
}

/*
 * This test belongs to Decomposers and MicroOrganisms group.
 */
@Test(groups = {"Decomposers", "MicroOrganisms"})
public void bacteria() {
	System.out.println("Some micro Animals like bacteria are Decomposers and Micro-Organisms");
}


}
