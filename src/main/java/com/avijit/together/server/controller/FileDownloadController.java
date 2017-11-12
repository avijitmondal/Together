/*****************************************************************************
 * FILE NAME   : FileDownloadController.java
 * VERSION     : 1.0
 * AUTHOR      : avijit
 * DATE        : Oct 17, 2017
 * DESCRIPTION : together-server
 ****************************************************************************/
package com.avijit.together.server.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avijit.together.server.dto.FileUploadDownloadDTO;
import com.avijit.together.server.exception.TogetherException;
import com.avijit.together.server.model.FileName;
import com.avijit.together.server.service.ConversationService;
import com.avijit.together.server.service.FileNameService;
import com.avijit.together.server.util.FileNameUtility;

/**
 * @author avijit
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/ftp/{conversation_id}/files")
public class FileDownloadController {

	/**
	 * 
	 */
	@Autowired
	private ConversationService conversationService;

	/**
	 * 
	 */
	@Autowired
	private FileNameService fileNameService;

	/**
	 * @param response
	 * @param fileName
	 * @param conversationId
	 * @throws IOException
	 */
	@RequestMapping(params = { "name", "sid", "tid" }, method = RequestMethod.GET)
	public HttpEntity<?> downloadFile(HttpServletResponse response,
			@PathVariable("conversation_id") String conversationId, @RequestParam("name") String fileName,
			@RequestParam("sid") String sessionId, @RequestParam("tid") String timeId) {
		File sourceFile = null;
		File tempFile = null;
		try {
			if (!conversationService.isExists(conversationId)) {
				return new ResponseEntity<>(new FileUploadDownloadDTO("Conversation does not exists"),
						HttpStatus.NOT_FOUND);
			} else {
				String storedFileName = FileNameUtility.convertFileName(conversationId, sessionId, timeId);
				FileName storedData = fileNameService.findById(storedFileName);
				if (null != storedData && storedData.getOriginalFileName().equals(fileName)) {
					sourceFile = FileNameUtility.getSourceFile(storedFileName);
					tempFile = FileNameUtility.getDownloadableFile(sourceFile, fileName);
				} else {
					throw new FileNotFoundException("file with path: " + fileName + " was not found.");
				}
			}
		} catch (TogetherException togetherException) {
			return new ResponseEntity<>(new FileUploadDownloadDTO("Not a valid conversation ID"),
					HttpStatus.BAD_REQUEST);
		} catch (FileNotFoundException fileNotFoundException) {
			return new ResponseEntity<>(new FileUploadDownloadDTO("File does not exists"), HttpStatus.NOT_FOUND);
		} catch (IOException ioException) {
			return new ResponseEntity<>(new FileUploadDownloadDTO("Unable to read or write"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String mimeType = URLConnection.guessContentTypeFromName(tempFile.getName());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		response.setContentType(mimeType);

		/*
		 * "Content-Disposition : inline" will show viewable types [like
		 * images/text/pdf/anything viewable by browser] right on browser while
		 * others(zip e.g) will be directly downloaded [may provide save as popup, based
		 * on your browser setting.]
		 */
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + tempFile.getName() + "\""));

		response.setHeader("Content-Length", String.valueOf(tempFile.length()));

		try {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(tempFile));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (FileNotFoundException e) {
			return new ResponseEntity<>(new FileUploadDownloadDTO("File does not exists"), HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			return new ResponseEntity<>(new FileUploadDownloadDTO("Unable to read or write"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// Copy bytes from source to destination(outputstream in this example),
		// closes both streams.
		return new ResponseEntity<>(new FileUploadDownloadDTO("File is beign downloaded"), HttpStatus.BAD_REQUEST);
	}
}
