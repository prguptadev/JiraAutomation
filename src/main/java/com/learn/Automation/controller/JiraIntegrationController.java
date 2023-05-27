package com.learn.Automation.controller;


import com.learn.Automation.dto.Jira;
import com.learn.Automation.dto.JiraTable;
import com.learn.Automation.jiraIntegration.MyJiraClient;
import com.learn.Automation.pdf.PDFTable2Text;
import com.learn.Automation.unzip.UnzipFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@RestController
public class JiraIntegrationController {



    @Autowired
    UnzipFiles unzipFiles;
    @Autowired
    PDFTable2Text pdf2TableText;

    @Autowired
    Jira jira;
    @PostConstruct
    public String createTicket() throws IOException {
        MyJiraClient myJiraClient = new MyJiraClient(jira.getUsername(),jira.getPassword(), jira.getUrl());
        List<String> allpdf = unzipFiles.unzip(jira.getZipPath(), jira.getPdfDesirPath());

        String zipFilePath = "C:/Users/SIDHU/Downloads/Network-Vulnerability-Assessment-Report.zip";

        String destDir = "C:/Users/SIDHU/Downloads/output/";

        for (String pdfPath : allpdf) {
            List<JiraTable> resultMap = pdf2TableText.pdf2Table(pdfPath);
            for (JiraTable jiraTable : resultMap) {
                System.out.println(jiraTable.toString());
                myJiraClient.createJiraTicket(jiraTable ,jira);
            }

        }
        return null;
    }


}
