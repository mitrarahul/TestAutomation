package resources;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTestNG {
	ExtentReports extentReportsObject;
		
	public ExtentReports getExterntReport() {
		String reportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter extentSparkReporterObject = new ExtentSparkReporter(reportPath);
		extentSparkReporterObject.config().setDocumentTitle("Extent Report of DemoE2ETesting Project");
		extentSparkReporterObject.config().setReportName("Random Report NameCheck");

		extentReportsObject = new ExtentReports();
		extentReportsObject.attachReporter(extentSparkReporterObject);

		extentReportsObject.setSystemInfo("Tester Name", "Rahul");
		extentReportsObject.setSystemInfo("Deoartment", "QA");
		extentReportsObject.setSystemInfo("Project", "DemoE2ETesting");
		
		return extentReportsObject;
	}
}
