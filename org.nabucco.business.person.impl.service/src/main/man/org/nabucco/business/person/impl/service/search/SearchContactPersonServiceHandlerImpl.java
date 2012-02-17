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

import javax.persistence.TemporalType;

import org.nabucco.business.person.facade.datatype.ContactPerson;
import org.nabucco.business.person.facade.message.ContactPersonListMsg;
import org.nabucco.business.person.facade.message.search.ContactPersonSearchRq;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchContactPersonServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class SearchContactPersonServiceHandlerImpl extends SearchContactPersonServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ContactPersonListMsg searchContactPerson(ContactPersonSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM ContactPerson d");
        queryString.append(" WHERE d.master.statusType = :statusType");

        if ((msg.getBirthdayFrom() != null) && (msg.getBirthdayTill() != null)) {
            queryString.append(" AND d.master.birthday BETWEEN :birthdayFrom AND :birthdayTill");
        }

        try {
            NabuccoQuery<ContactPerson> query = super.getPersistenceManager().createQuery(queryString.toString());
            query.setParameter("statusType", StatusType.ACTIVE);
            if ((msg.getBirthdayFrom() != null) && (msg.getBirthdayTill() != null)) {
                query.setParameter("birthdayFrom", msg.getBirthdayFrom().getValue(), TemporalType.DATE);
                query.setParameter("birthdayTill", msg.getBirthdayTill().getValue(), TemporalType.DATE);
            }

            List<ContactPerson> resultList = query.getResultList();

            ContactPersonListMsg response = new ContactPersonListMsg();
            response.getContactPersonList().addAll(resultList);
            return response;

        } catch (Exception e) {
            throw new SearchException(e);
        }
    }

}
