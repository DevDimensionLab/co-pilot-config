package no.co_pilot.maven.prop;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.apache.maven.plugin.testing.MojoRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.File;

import static org.codehaus.plexus.PlexusTestCase.getTestFile;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(BlockJUnit4ClassRunner.class)
public class WriteApplicationPropertiesMojoTest extends AbstractMojoTestCase {

/*    @Rule
    public MojoRule rule = new MojoRule(this)
    {
        @Override
        protected void before()
        {
        }

        @Override
        protected void after()
        {
        }
    };*/


    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testMojo() throws Exception {
        File pom = getTestFile("src/main/java/resources/pom.xml");

        Mojo mojo = lookupEmptyMojo("install", pom);
        assertNotNull(mojo);
        assertTrue(pom.exists());
        mojo.execute();
    }
}