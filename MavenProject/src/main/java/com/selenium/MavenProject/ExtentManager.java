package com.selenium.MavenProject;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if (report==null) 
		{
			report = new ExtentReports(projectpath + "//HtmlReports//" + filepath+ ".html");
			report.loadConfig(new File(projectpath + "//extentreportconfig.xml//"));
			report.addSystemInfo("Selenium Language Binding", "3.24.5").addSystemInfo("Environment",
					mainProperty.getProperty("env"));
		}
		return report;
	}
}
