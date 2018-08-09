package com.katalon.integration.applitools

import org.openqa.selenium.WebDriver

import com.applitools.eyes.BatchInfo
import com.applitools.eyes.RectangleSize
import com.applitools.eyes.TestResults
import com.applitools.eyes.selenium.Eyes
import com.kms.katalon.core.webui.driver.DriverFactory

public class ApplitoolsProject {

	private WebDriver driver;
	private String server_url;
	private String api_key;
	private String app_name;
	private String web_url;
	private Eyes eyes;

	public ApplitoolsProject(String server_url, String api_key, String app_name, String web_url) {
		this.driver = DriverFactory.getWebDriver();
		this.server_url = server_url;
		this.api_key = api_key;
		this.app_name = app_name;
		this.web_url = web_url;

		URI serverURL;
		try {
			serverURL = new URI(server_url);
		} catch (URISyntaxException e) {
			System.out.println("URI Exception ");
			return;
		}
		this.eyes = new Eyes(serverURL);
		this.eyes.setApiKey(api_key);
		this.eyes.setIgnoreCaret(true);
	}

	public Eyes getEyes() {
		return this.eyes;
	}

	public WebDriver start(RectangleSize view_port_size) {
		return this.eyes.open(this.driver, this.app_name, this.web_url, view_port_size);
	}

	public TestResults close() {
		return eyes.close();
	}

	public String handleResult(TestResults result) {
		String resultStr;
		String url;
		if (result == null) {
			resultStr = "Test aborted";
			url = "undefined";
		} else {
			url = result.getUrl();
			int totalSteps = result.getSteps();
			if (result.isNew()) {
				resultStr = "New Baseline Created: " + totalSteps + " steps";
			} else if (result.isPassed()) {
				resultStr = "All steps passed:     " + totalSteps + " steps";
			} else {
				resultStr = "Test Failed     :     " + totalSteps + " steps";
				resultStr += " matches=" +  result.getMatches();      /*  matched the baseline */
				resultStr += " missing=" + result.getMissing();       /* missing in the test*/
				resultStr += " mismatches=" + result.getMismatches(); /* did not match the baseline */
			}
		}
		resultStr += "\n" + "results at " + url;
		return resultStr;
	}

	private void setBatch(String batch_info) {
		BatchInfo batch = new BatchInfo(batch_info);
		this.eyes.setBatch(batch);
	}
}
