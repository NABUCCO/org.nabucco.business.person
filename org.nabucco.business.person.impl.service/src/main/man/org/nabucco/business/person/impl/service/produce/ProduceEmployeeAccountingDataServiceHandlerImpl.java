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
package org.nabucco.business.person.impl.service.produce;

import org.nabucco.business.person.facade.datatype.EmployeeAccountingData;
import org.nabucco.business.person.facade.message.EmployeeAccountingDataListMsg;
import org.nabucco.business.person.facade.message.produce.EmployeeAccountingDataProduceRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceEmployeeAccountingDataServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class ProduceEmployeeAccountingDataServiceHandlerImpl extends ProduceEmployeeAccountingDataServiceHandler {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected EmployeeAccountingDataListMsg produceEmployeeAccountingData(EmployeeAccountingDataProduceRq msg)
            throws ProduceException {

        EmployeeAccountingDataListMsg response = new EmployeeAccountingDataListMsg();

        for (int i = 0; i < msg.getNumber().getValue(); i++) {
            EmployeeAccountingData datatype = new EmployeeAccountingData();
            datatype.setDatatypeState(DatatypeState.INITIALIZED);

            response.getEmployeeAccountingDataList().add(datatype);
        }

        return response;
    }

}
