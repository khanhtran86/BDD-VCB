package vn.vcb;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("vn.vcb")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/report.html")
public class RunCucumberTest {
}
