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

import org.nabucco.business.person.facade.datatype.Applicant;
import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.search.ApplicantSearchRq;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.datatype.utils.BasetypeUtil;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchApplicantServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class SearchApplicantServiceHandlerImpl extends SearchApplicantServiceHandler {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected ApplicantListMsg searchApplicant(ApplicantSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM Applicant d");
        queryString.append(" WHERE d.master.statusType = :statusType");

        if (!BasetypeUtil.isEmpty(msg.getMasterId())) {
            queryString.append(" and d.master.id = :masterId");
        }
        if (msg.getOwner() != null) {
            queryString.append(" AND d.master.owner = :owner");
        }
        if (!msg.getOwnerList().isEmpty()) {
            queryString.append(" AND ( d.master.owner IN " + createOwerList(msg.getOwnerList()) + " )");
        }
        if (!msg.getUserIdList().isEmpty()) {
            queryString.append(" AND ( d.master.userId IN " + createUserIdList(msg.getUserIdList()) + " )");
        }

        try {
            NabuccoQuery<Applicant> query = super.getPersistenceManager().createQuery(queryString.toString());
            query.setParameter("statusType", StatusType.ACTIVE);

            if (!BasetypeUtil.isEmpty(msg.getMasterId())) {
                query.setParameter("masterId", msg.getMasterId().getValue());
            }
            if (msg.getOwner() != null) {
                query.setParameter("owner", msg.getOwner());
            }

            List<Applicant> resultList = query.getResultList();

            ApplicantListMsg response = new ApplicantListMsg();
            response.getApplicantList().addAll(resultList);
            return response;

        } catch (Exception e) {
            throw new SearchException(e);
        }
    }

    private String createOwerList(List<Owner> ownerList) {

        String listString = "(";

        for (Owner owner : ownerList) {
            listString += "'" + owner.getValue() + "', ";
        }

        if (listString.endsWith("', ")) {
            listString = listString.substring(0, listString.length() - 2);
        }

        listString += ")";
        return listString;
    }

    private String createUserIdList(List<UserId> userIdList) {

        String listString = "(";

        for (UserId userId : userIdList) {
            listString += "'" + userId.getValue() + "', ";
        }

        if (listString.endsWith("', ")) {
            listString = listString.substring(0, listString.length() - 2);
        }

        listString += ")";
        return listString;
    }

}
