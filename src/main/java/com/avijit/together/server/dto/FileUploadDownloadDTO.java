/*****************************************************************************
 * FILE NAME   : FileUploadDownloadDTO.java
 * VERSION     : 1.0
 * AUTHOR      : avijit
 * DATE        : Oct 17, 2017
 * DESCRIPTION : together-server
 ****************************************************************************/
package com.avijit.together.server.dto;

/**
 * @author avijit
 *
 */
public class FileUploadDownloadDTO {
	private String message;

	/**
	 * 
	 */
	public FileUploadDownloadDTO() {
		super();
	}

	/**
	 * @param message
	 */
	public FileUploadDownloadDTO(String message) {
		super();
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
