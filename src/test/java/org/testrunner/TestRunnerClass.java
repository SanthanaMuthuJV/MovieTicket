package org.testrunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\USER\\eclipse-workspace\\TicketBook\\src\\test\\resources\\feature\\ticketbook.feature", 
                 glue = "org\\stepdefinition", 
                 monochrome = true, 
                // dryRun = true,
                 snippets = SnippetType.CAMELCASE
//                 tags =  "@hotel",
                 
//               
//                 plugin = {"pretty","html:HtmlReport",
//                		 "junit:JunitReports\\face.xml",
//                		 "json:Json\\fb.json",
//                		 "rerun:C:\\Users\\USER\\eclipse-workspace\\MavenCu\\src\\test\\resources\\failed.txt"
//                		  }
                  
                 )
                
public class TestRunnerClass {
//@AfterClass
//public static void postReport() {
//	JVMRepo.repo("Json\\fb.json");
//	System.out.println("jvm report created");
//
//}

}

