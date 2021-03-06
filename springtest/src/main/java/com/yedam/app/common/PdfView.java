package com.yedam.app.common;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

//@Component
public class PdfView extends AbstractView {

	//@Autowired DataSource datasource;
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		try {
			// db conn
			Connection conn = datasource.getConnection();

			// 소스 컴파일 jrxml -> jasper
			String src = (String) model.get("filename");
			InputStream stream = getClass().getResourceAsStream(src);
			jasperReport jasperReport = JasperCompileManager.compileReport(stream);

			// pdf 생성해서 출력
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
			JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
