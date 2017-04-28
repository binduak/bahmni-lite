package org.bahmni.deployment.launch;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;

import static java.lang.Integer.valueOf;
import static java.lang.System.getenv;

public class Main {

	public static void main(String[] args) throws LifecycleException, ServletException, IOException {
		 if(args.length != 3){
            printUsage();
            return;
        }

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		
		tomcat.addWebapp("/openmrs", args[0]);
        tomcat.addWebapp("/bahmniapps", args[1]);
        Context context = tomcat.addWebapp("/bahmni_config", args[2]);
		context.setSessionTimeout(120);
		context.setUseHttpOnly(false);
		tomcat.start();
		tomcat.getServer().await();
	}

	private static void printUsage() {
        System.out.println("Expected three arguments.  <openmrs_web_app> <bahmniapps> <bahmni_config>");
        System.out.println("Example:");
        System.out.println("\"/Users/tbindu/bahmni-lite/openmrs/openmrs\" \"/Users/tbindu/bahmni-lite/bahmniapps\" \"/Users/tbindu/bahmni-lite/bahmni_config\"");
    }
}
