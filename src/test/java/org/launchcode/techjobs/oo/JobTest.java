package org.launchcode.techjobs.oo;

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
        assertTrue(newJob.getName() instanceof String);
        assertEquals("ACME", newJob.getEmployer());
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertEquals("Desert", newJob.getLocation() );
        assertTrue(newJob.getLocation() instanceof Location);
        assertEquals("Quality control", newJob.getPositionType());
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertEquals("Persistence", newJob.getCoreCompetency());
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJobOne.equals(newJobTwo));
    }
}
