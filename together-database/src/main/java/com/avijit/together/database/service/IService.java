/*****************************************************************************
 * FILE NAME   : IService.java
 * VERSION     : 1.0
 * AUTHOR      : avijit
 * DATE        : Aug 23, 2017
 * DESCRIPTION : together-server
 ****************************************************************************/
package com.avijit.together.database.service;

import com.avijit.together.core.exception.TogetherException;

/**
 * @author avijit
 *
 */
public interface IService {
    /**
     * @param id
     * @return
     * @throws TogetherException
     */
    boolean delete(String id) throws TogetherException;

    /**
     * @param id
     * @return
     * @throws TogetherException
     */
    boolean isExists(String id) throws TogetherException;

}
