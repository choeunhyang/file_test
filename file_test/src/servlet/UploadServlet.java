package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/up/*")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String tmpPath = System.getProperty("java.io.tmpdir");
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String savePath = "C:\\bdi_study\\workspace\\file_test\\WebContent\\upload";
		System.out.println("니가 요청하는 명령은 : " + cmd);
		DiskFileItemFactory dfac = new DiskFileItemFactory();
		dfac.setRepository(new File(tmpPath));
		
		ServletFileUpload sfu = new ServletFileUpload(dfac);
		try {
			List<FileItem> fList = sfu.parseRequest(request);
			int cnt = 0;
			for(int i=0;i<fList.size();i++) {
				FileItem fi = fList.get(i);
				if(fi.isFormField()) {
					
				}else {
					cnt++;
					String name = fi.getFieldName();
					String fileName = fi.getName();
					File saveFile = new File(savePath + File.separator + fileName);
					try {
						if(!saveFile.exists() && fi.getName().equals("")) {
							fi.write(saveFile);
						}else {
							cnt--;
						}
						fi.write(saveFile);
					} catch (Exception e) {
						cnt--;
						e.printStackTrace();
					}/*System.out.println(name + ":" + fileName);*/
				}/*System.out.println(i + "번째 아이템 : " + fList.get(i));*/
			}
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().append("업로드한 파일갯수는 : " + cnt);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		/* upload.jsp
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String tmpPath = System.getProperty("java.io.tmpdir");
		System.out.println("니 템프디렉토리 : " + tmpPath);
		System.out.println("너 멀티파트방식 : " + isMulti);
		DiskFileItemFactory dfac = new DiskFileItemFactory();
		dfac.setRepository(new File(System.getProperty("java.io.tmpdir")));
		dfac.setSizeThreshold(1024*1024*5); //5MB
		
		ServletFileUpload sfu = new ServletFileUpload(dfac);
		try {
			List<FileItem> fList = sfu.parseRequest(request); // parse는 request를 분석해서 List로 넘겨주는거
			for(FileItem fi : fList) {
				if(fi.isFormField()) { //file은 formfield가 아님
					String name = fi.getFieldName();
					String value = fi.getString("utf-8");
					System.out.println(name + " : " + value);
				}else {
					String name = fi.getFieldName();
					String value = fi.getName();
					System.out.println(name + " : " + value);
					File f = new File("C:\\bdi_study\\workspace\\file_test\\WebContent\\test.jpg");
					fi.write(f); // 같은 이름....하면 덮어씀
				}
				System.out.println(fi.isFormField());
				System.out.println(fi.getFieldName());
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
