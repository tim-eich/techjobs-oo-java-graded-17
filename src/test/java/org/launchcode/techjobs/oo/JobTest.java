package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();
        assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", newJob.getName());
        // Ask Dan
        assertNotNull(newJob.getName());
        assertEquals("ACME", newJob.getEmployer().getValue());
        assertNotNull(newJob.getEmployer());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertNotNull(newJob.getLocation());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertNotNull(newJob.getPositionType());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());
        assertNotNull(newJob.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJobOne.equals(newJobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(newJobOne.toString().startsWith(System.lineSeparator()));
        assertTrue(newJobOne.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] testString = newJobOne.toString().trim().split(System.lineSeparator());
        assertTrue(testString[0].contains("ID: "));
        assertTrue(testString[0].contains(Integer.toString(newJobOne.getId())));
        assertTrue(testString[1].contains("Name: "));
        assertTrue(testString[1].contains(newJobOne.getName()));
        assertTrue(testString[2].contains("Employer: "));
        assertTrue(testString[2].contains(newJobOne.getEmployer().getValue()));
        assertTrue(testString[3].contains("Location: "));
        assertTrue(testString[3].contains(newJobOne.getLocation().getValue()));
        assertTrue(testString[4].contains("Position Type: "));
        assertTrue(testString[4].contains(newJobOne.getPositionType().getValue()));
        assertTrue(testString[5].contains("Core Competency: "));
        assertTrue(testString[5].contains(newJobOne.getCoreCompetency().getValue()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job blankJob = new Job();
        String expectedString = "OOPS! this job does not seem to exist.";
        assertEquals(blankJob.toString(), expectedString);
    }
}
