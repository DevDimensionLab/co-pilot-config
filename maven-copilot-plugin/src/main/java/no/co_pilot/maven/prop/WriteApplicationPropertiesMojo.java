package no.co_pilot.maven.prop;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

@Mojo(name = "extractDependencyVersions", defaultPhase = LifecyclePhase.COMPILE)
public class WriteApplicationPropertiesMojo extends AbstractMojo {

    @Parameter(required = true)
    private String pomXml;

    @Component
    private Model model;

    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencies = model.getDependencies();

    }
}
