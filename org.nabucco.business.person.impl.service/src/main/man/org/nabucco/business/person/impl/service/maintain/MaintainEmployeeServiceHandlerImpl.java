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
package org.nabucco.business.person.impl.service.maintain;

import org.nabucco.business.person.facade.datatype.Employee;
import org.nabucco.business.person.facade.message.EmployeeMsg;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainEmployeeServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainEmployeeServiceHandlerImpl extends MaintainEmployeeServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected EmployeeMsg maintainEmployee(EmployeeMsg msg) throws MaintainException {

        Employee employee = msg.getEmployee();

        try {
            if (employee.getMaster() != null) {
                employee.setMaster(super.getPersistenceManager().persist(employee.getMaster()));
            }

            employee = this.maintainEmployee(employee);

            employee.getAbsenceList().size();
            employee.getRelationList().size();
            employee.getRoleList().size();

        } catch (PersistenceException pe) {
            throw new MaintainException("Error maintaining Employee with id '" + employee.getId() + "'.", pe);
        }

        EmployeeMsg response = new EmployeeMsg();
        response.setEmployee(employee);
        return response;
    }

    /**
     * Maintains the Employee instance into the database.
     * 
     * @param employee
     *            the employee to maintain
     * 
     * @return the maintained employee
     * 
     * @throws PersistenceException
     *             when the employee cannot be maintained
     */
    private Employee maintainEmployee(Employee employee) throws PersistenceException {

        if (employee.getDatatypeState() == DatatypeState.DELETED) {
            employee = super.getPersistenceManager().persist(employee);

            if (employee.getAccountingData() != null) {
                employee.getAccountingData().setDatatypeState(DatatypeState.DELETED);
                super.getPersistenceManager().persist(employee.getAccountingData());
            }
            if (employee.getBankAccount() != null) {
                employee.getBankAccount().setDatatypeState(DatatypeState.DELETED);
                super.getPersistenceManager().persist(employee.getBankAccount());
            }
            if (employee.getContractData() != null) {
                employee.getContractData().setDatatypeState(DatatypeState.DELETED);
                super.getPersistenceManager().persist(employee.getContractData());
            }

        } else {
            if (employee.getAccountingData() != null) {
                employee.setAccountingData(super.getPersistenceManager().persist(employee.getAccountingData()));
            }
            if (employee.getBankAccount() != null) {
                employee.setBankAccount(super.getPersistenceManager().persist(employee.getBankAccount()));
            }
            if (employee.getContractData() != null) {
                employee.setContractData(super.getPersistenceManager().persist(employee.getContractData()));
            }
            employee = super.getPersistenceManager().persist(employee);
        }

        return employee;
    }
}
