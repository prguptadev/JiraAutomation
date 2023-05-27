package com.learn.Automation.pdf;


import com.learn.Automation.dto.JiraTable;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.utilities.PdfTable;
import com.spire.pdf.utilities.PdfTableExtractor;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class PDFTable2Text {


    public  List<JiraTable> pdf2Table(String pdfPath) throws IOException {
        //Load a sample PDF document
        // String PDF = "C:/Users/SIDHU/Downloads/Network-Vulnerability-Assessment-Report/pdf.pdf";
        Map<String,String> resultMap =  new HashMap<>();
        List<JiraTable> jiraTables = new ArrayList<>();
        int x =0;
        PdfDocument pdf = new PdfDocument(pdfPath);

        //Create a StringBuilder instance
        StringBuilder builder = new StringBuilder();
        //Create a PdfTableExtractor instance
        PdfTableExtractor extractor = new PdfTableExtractor(pdf);

        //Loop through the pages in the PDF
        for (int pageIndex = 0; pageIndex < pdf.getPages().getCount(); pageIndex++) {
            //Extract tables from the current page into a PdfTable array
            PdfTable[] tableLists = extractor.extractTable(pageIndex);

            //If any tables are found
            if (tableLists != null && tableLists.length > 0) {
                //Loop through the tables in the array
                for (PdfTable table : tableLists) {
                    //Loop through the rows in the current table
                    for (int i = 1; i < table.getRowCount(); i++) {
                        //Loop through the columns in the current table
                       // String text2 = table.getText(i, ).replace("\n", " ");
                        JiraTable jiraTable = new JiraTable();

                       // resultMap.put(table.getText(i,1),table.getText(i,0));
                        jiraTable.setId(x++);
                        jiraTable.setCves(table.getText(i,0));
                        jiraTable.setSeverity(table.getText(i,1));
                        String sum = table.getText(i+1,0).length() !=0 ? table.getText(i,2).replace("\n", " ") : table.getText(i,2).replace("\n", " ")+table.getText(i+1,2).replace("\n", " ");
                        jiraTable.setDescription(table.getText(i,2).replace("\n", " "));
                        jiraTables.add(jiraTable);
                        for (int j = 0; j < table.getColumnCount(); j++) {
                            //Extract data from the current table cell and append to the StringBuilder
                            if(j==1) {
                                String text = table.getText(i, j).replace("\n", " ");
                                //+ " | "
                                if(text.length()>0){
                                builder.append(text );}
                            }
                        }
                        builder.append("\n");
                    }
                }
            }
        }

        //Write data into a .txt document
        FileWriter fw = new FileWriter("ExtractTable.txt");
        fw.write(builder.toString());
        fw.flush();
        fw.close();
        return jiraTables;
    }
}