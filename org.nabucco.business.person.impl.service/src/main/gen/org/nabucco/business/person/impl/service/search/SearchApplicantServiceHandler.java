/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.person.impl.service.search;

import org.nabucco.business.person.facade.message.ApplicantListMsg;
import org.nabucco.business.person.facade.message.search.ApplicantSearchRq;
import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.ServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandler;
import org.nabucco.framework.base.impl.service.maintain.PersistenceServiceHandlerSupport;

/**
 * SearchApplicantServiceHandler<p/>Search Service for Person<p/>
 *
 * @version 1.2
 * @author Dominic Trumpfheller, Holger Librenz, PRODYNA AG, 2011-07-19
 */
public abstract class SearchApplicantServiceHandler extends PersistenceServiceHandlerSupport implements ServiceHandler,
        PersistenceServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.business.person.impl.service.search.SearchApplicantServiceHandler";

    /** Constructs a new SearchApplicantServiceHandler instance. */
    public SearchApplicantServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<ApplicantSearchRq>.
     * @return the ServiceResponse<ApplicantListMsg>.
     * @throws SearchException
     */
    protected ServiceResponse<ApplicantListMsg> invoke(ServiceRequest<ApplicantSearchRq> rq) throws SearchException {
        ServiceResponse<ApplicantListMsg> rs;
        ApplicantListMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.searchApplicant(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<ApplicantListMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (SearchException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            SearchException wrappedException = new SearchException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new SearchException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method searchApplicant.
     *
     * @param msg the ApplicantSearchRq.
     * @return the ApplicantListMsg.
     * @throws SearchException
     */
    protected abstract ApplicantListMsg searchApplicant(ApplicantSearchRq msg) throws SearchException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
