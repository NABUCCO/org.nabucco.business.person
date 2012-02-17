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

import org.nabucco.business.person.facade.datatype.Employee;
import org.nabucco.business.person.facade.message.EmployeeListMsg;
import org.nabucco.business.person.facade.message.search.EmployeeSearchRq;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.StatusType;
import org.nabucco.framework.base.facade.datatype.security.UserId;
import org.nabucco.framework.base.facade.datatype.utils.BasetypeUtil;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * Service Handler for searching employees.
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 * @author Holger Librenz, PRODYNA AG
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchEmployeeServiceHandlerImpl extends SearchEmployeeServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected EmployeeListMsg searchEmployee(EmployeeSearchRq msg) throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("SELECT d FROM Employee d");
        if (msg.getLoadAbsence().getValue()) {
            queryString.append(" LEFT JOIN FETCH d.absenceListJPA a");
        }

        queryString.append(" WHERE d.master.statusType = :statusType");

        if (!BasetypeUtil.isEmpty(msg.getEmployeeId())) {
            queryString.append(" AND d.employeeId = :employeeId");
        }
        if (!BasetypeUtil.isEmpty(msg.getMasterId())) {
            queryString.append(" and d.master.id = :masterId");
        }
        if (msg.getOwner() != null) {
            queryString.append(" AND d.master.owner = :owner");
        }
        if (!msg.getOwnerList().isEmpty()) {
            queryString.append(" AND ( d.master.owner IN " + this.createOwerList(msg.getOwnerList()) + " )");
        }
        if (!msg.getUserIdList().isEmpty()) {
            queryString.append(" AND ( d.master.userId IN " + this.createUserIdList(msg.getUserIdList()) + " )");
        }
        if ((msg.getBirthdayFrom() != null) && (msg.getBirthdayTill() != null)) {
            queryString.append(" AND d.master.birthday BETWEEN :birthdayFrom AND :birthdayTill");
        }

        try {
            NabuccoQuery<Employee> query = super.getPersistenceManager().createQuery(queryString.toString());
            query.setParameter("statusType", StatusType.ACTIVE);

            if (!BasetypeUtil.isEmpty(msg.getEmployeeId())) {
                query.setParameter("employeeId", msg.getEmployeeId());
            }
            if (!BasetypeUtil.isEmpty(msg.getMasterId())) {
                query.setParameter("masterId", msg.getMasterId().getValue());
            }
            if (msg.getOwner() != null) {
                query.setParameter("owner", msg.getOwner());
            }
            if ((msg.getBirthdayFrom() != null) && (msg.getBirthdayTill() != null)) {
                query.setParameter("birthdayFrom", msg.getBirthdayFrom().getValue(), TemporalType.DATE);
                query.setParameter("birthdayTill", msg.getBirthdayTill().getValue(), TemporalType.DATE);
            }

            List<Employee> resultList = query.getResultList();

            for (Employee employee : resultList) {
                employee.getRoleList().size();
                if (msg.getLoadAbsence().getValue()) {
                    employee.getAbsenceList().size();
                }
            }

            EmployeeListMsg response = new EmployeeListMsg();
            response.getEmployeeList().addAll(resultList);
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
