package no.co_pilot.maven.prop;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;

import java.io.File;

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
        File testPom = getTestFile("src/test/resources/pom.xml");

        WriteApplicationPropertiesMojo mojo = new WriteApplicationPropertiesMojo();
        mojo = (WriteApplicationPropertiesMojo) configureMojo(
                    mojo, extractPluginConfiguration("maven-copilot-plugin", testPom
                ));
        mojo.execute();
    }
}