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

import org.nabucco.business.person.facade.message.PersonMsg;
import org.nabucco.business.person.facade.message.search.PersonSearchRq;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.exception.service.SearchException;

/**
 * SearchPersonDatatypeServiceHandlerImpl
 * 
 * @author Raffael Bieniek, PRODYNA AG
 */
public class SearchPersonDatatypeServiceHandlerImpl extends SearchPersonDatatypeServiceHandler {

    /**
     * Default serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected PersonMsg searchPersonDatatype(PersonSearchRq rq) throws SearchException {

        NabuccoDatatype datatype = rq.getDatatype();
        try {
            datatype = getPersistenceManager().find(datatype.getClass(), datatype.getId());
        } catch (Exception e) {
            throw new SearchException(e);
        }

        PersonMsg response = new PersonMsg();
        response.setDatatype(datatype);

        return response;
    }

}
