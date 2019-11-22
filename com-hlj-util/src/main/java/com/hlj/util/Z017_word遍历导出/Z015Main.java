package com.hlj.util.Z017_word遍历导出;

import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author HealerJean
 * @ClassName Z015Main
 * @date 2019-08-19  21:47.
 * @Description
 */
@Slf4j
public class Z015Main {

    /**
     * 根据模板导出word文件
     *
     * @param map     ReportData对象为数据对象，里面存储Map 数据
     * @param templateName   模板文件路径
     * @param outputFileName 输出文件路径
     */
    public static void reportDoc( Map map, String templateName, String outputFileName) {
        Map<String, Object> params = map;
        InputStream in = null;
        OutputStream outputStream = null;
        IXDocReport report = null;

        try {
            // 1) Load ODT file and set Velocity template engine and cache it to the registry
            in = new FileInputStream(new File(templateName));
            report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);

            // 2) Create Java model context
            IContext context = getReportContext(report, params);
            // 输出文件，文件存在则删除
            File outputFile = new File(outputFileName);
            // 生成新的文件
            outputStream = new FileOutputStream(outputFile);
            report.process(context, outputStream);
        } catch (IOException e) {
            log.warn("文件流获取失败", e);
        } catch (XDocReportException e) {
            log.warn("导出失败", e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                log.warn("文件流关闭失败", e);
            }
        }
    }
    private static IContext getReportContext(IXDocReport report, Map<String, Object> params) throws XDocReportException {
        IContext context = null;
        if (report != null) {
            context = report.createContext();
            FieldsMetadata metadata = new FieldsMetadata();
            for (Iterator iterator = params.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String name = entry.getKey().toString();
                Object value = entry.getValue();
                context.put(name, value);
            }
            report.setFieldsMetadata(metadata);
        }
        return context;
    }



    @Test
    public void testXDocWord() throws Exception {
        Map reportData = new HashMap();
        // reportData.put("name", "张三");
        // reportData.put("age", "2016-6-6");
        //
        // reportDoc(reportData, "/Users/healerjean/Desktop/template.docx", "/Users/healerjean/Desktop/t.docx");


        InputStream in = new FileInputStream( new File("/Users/healerjean/Desktop/template.docx"));
//设置模版类型
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in,TemplateEngineKind.Freemarker) ;
//创建上下文
        IContext context = report.createContext();
//将将输出信息object放入上下文中
        context.put("name", "张三");
//OutputStream输出流，用以输出文件
        OutputStream out = new FileOutputStream(new File("XXX.docx"));
//将生成文件
        report.process(context,out);
        out.flush();


    }




}
