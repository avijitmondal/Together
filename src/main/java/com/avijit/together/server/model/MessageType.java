/**
 * 
 */
package com.avijit.together.server.model;

/**
 * @author avijit
 *
 */
public enum MessageType {
	/**
	 * Message contains a Text message
	 */
	TEXT,
	/**
	 * Message contains an Image
	 */
	IMAGE,
	/**
	 * Message contains a Video
	 */
	VIDEO,
	/**
	 * Message contains an Audio
	 */
	AUDIO,
	/**
	 * Message contains a document link
	 */
	DOCUMENT
}
