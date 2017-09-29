/**
 * 
 */
package com.avijit.together.server.util;

/**
 * @author avijit
 *
 */
public interface IURIConstant {
	/* Rest API URI */
	/**
	 * 
	 */
	String API_BASE = "/api";
	/**
	 * 
	 */
	String API_USERS = API_BASE + "/users";
	/**
	 * 
	 */
	String API_AUTHENTICATION = API_BASE + "/authentications";
	/**
	 * 
	 */
	String API_CONVERSATIONS = API_BASE + "/conversations";
	/**
	 * 
	 */
	String API_CONVERSATION_PARTICIPANTS = API_CONVERSATIONS + "/{conversation_id}/participants";

	/* Chat URI */
	/**
	 * 
	 */
	String URI_BROKER_ENDPOINT = "/together/websocket";
	/**
	 * 
	 */
	String URI_DESTINATION_PREFIX = "/app";
	/**
	 * 
	 */
	String URI_BROKER_TOPIC = "/topic";
	/**
	 * 
	 */
	String URI_BROKER_QUEUE = "/queue";
	/**
	 * 
	 */
	String URI_GROUP_CHAT = "/groupchats";
	/**
	 * 
	 */
	String URI_PERSONAL_CHAT = "/personalchats";
	/**
	 * 
	 */
	String URI_TOPIC_GROUP_CHAT_RESPONSE = "/topic/groupchats.";
	/**
	 * 
	 */
	String URI_QUEUE_PERSONAL_CHAT_RESPONSE = "/queue/personalchats.";
}
