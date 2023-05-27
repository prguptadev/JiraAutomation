package com.learn.Automation;


import com.learn.Automation.dto.JiraTable;
import com.learn.Automation.unzip.UnzipFiles;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.learn.Automation.jiraIntegration.MyJiraClient.createJiraTicket;
import static com.learn.Automation.pdf.PDFTable2Text.pdf2Table;


public class AutomationApplication {

    public static void main(String[] args) throws IOException {

        String zipFilePath = "C:/Users/SIDHU/Downloads/Network-Vulnerability-Assessment-Report.zip";

        String destDir = "C:/Users/SIDHU/Downloads/output/";

        CreateJiraFromZip( zipFilePath, destDir);
    }

    public static void CreateJiraFromZip(String zipPath, String destDir) throws IOException {

        List<String> allpdf = UnzipFiles.unzip(zipPath, destDir);

        for (String pdfPath : allpdf) {
            List<JiraTable> resultMap = pdf2Table(pdfPath);
            for(JiraTable jiraTable : resultMap) {
                System.out.println(jiraTable.toString());
                createJiraTicket(jiraTable);
            }
              //  System.out.println("key = "+ key +"  value = "+resultMap.get(key));

        }
    }

}
