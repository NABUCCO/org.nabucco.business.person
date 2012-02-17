/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.person.impl.service.search;

import java.util.List;

import org.nabucco.business.person.facade.datatype.PersonMaster;
import org.nabucco.business.person.facade.message.PersonMasterListMsg;
import org.nabucco.business.person.facade.message.search.PersonMasterSearchRq;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.datatype.utils.BasetypeUtil;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchPersonMasterServiceHandlerImpl
 * 
 * @author Holger Librenz, PRODYNA AG
 */
@SuppressWarnings("serial")
public class SearchPersonMasterServiceHandlerImpl extends SearchPersonMasterServiceHandler {

    protected static final NabuccoLogger logger = NabuccoLoggingFactory.getInstance().getLogger(
            SearchPersonMasterServiceHandlerImpl.class);

    /**
     * You can search PersonMaster instances with the help of the service, this class is the service
     * handler implementation for. Currently search by functionalId and / or person master ID is
     * possible. If you do not provide any of them, all active person master entries will be
     * returned.
     * 
     * @param msg
     *            Search request message
     * @return PersonMasterListMsg with 0..* entries of matching (and active) person master entries
     */
    @Override
    protected PersonMasterListMsg searchPersonMaster(PersonMasterSearchRq msg) throws SearchException {

        if (msg == null) {
            String errMsg = "Empty message found.";
            logger.error(errMsg);
            throw new SearchException(errMsg);
        }

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT p FROM PersonMaster p");
        queryString.append(" WHERE statusType = :statusType");

        if (!BasetypeUtil.isEmpty(msg.getMasterId())) {
            queryString.append(" AND p.master.id = :masterId");
        }

        if (!BasetypeUtil.isEmpty(msg.getFunctionalId())) {
            queryString.append(" AND p.functionalId = :functionalId");
        }

        if (BasetypeUtil.isEmpty(msg.getMasterId()) && BasetypeUtil.isEmpty(msg.getFunctionalId())) {
            logger.info("Neither master id nor functional id is given. Will return any active person master.");
        }
        try {
            NabuccoQuery<PersonMaster> query = super.getPersistenceManager().createQuery(queryString.toString());
            query.setParameter("statusType", StatusType.ACTIVE);

            if (!BasetypeUtil.isEmpty(msg.getMasterId())) {
                query.setParameter("masterId", msg.getMasterId());
            }

            if (!BasetypeUtil.isEmpty(msg.getFunctionalId())) {
                query.setParameter("functionalId", msg.getFunctionalId());
            }

            List<PersonMaster> resultList = query.getResultList();

            PersonMasterListMsg responseMsg = new PersonMasterListMsg();
            if (resultList != null && !resultList.isEmpty()) {
                responseMsg.getPersonMasterList().addAll(resultList);
            }

            return responseMsg;
        } catch (Exception e) {
            String errMsg = "Exception with message [" + e.getMessage() + "] occured.";
            logger.error(errMsg);
            throw new SearchException(errMsg, e);
        }
    }

}
