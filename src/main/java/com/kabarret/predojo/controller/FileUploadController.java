package com.kabarret.predojo.controller;

import com.kabarret.predojo.domain.FileUpload;
import com.kabarret.predojo.domain.Rank;
import com.kabarret.predojo.service.RankService;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

public class FileUploadController extends SimpleFormController{
	
	public FileUploadController(){
		setCommandClass(FileUpload.class);
		setCommandName("fileUploadForm");
	}
 
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");

        Rank rank = null;
		if(multipartFile!=null){
            File tmpFile = new File("temp.txt");
            multipartFile.transferTo(tmpFile);
            rank = new RankService().buildRank(tmpFile);
            tmpFile.delete();
        }

        return new ModelAndView("FileUploadSuccess","rank",rank);
	}
}