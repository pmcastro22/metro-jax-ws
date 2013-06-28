/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package handler.single_handlertube.server;

import static handler.single_handlertube.common.TestConstants.*;
import handler.single_handlertube.common.HandlerTracker;

import java.util.List;


/**
 * @author Rama Pulavarthi
 */
@javax.jws.WebService(serviceName = "Hello", portName="ReportServicePort", targetNamespace="urn:test", endpointInterface="handler.single_handlertube.server.ReportService")
public class ReportService_Impl implements ReportService{

    public void setInstruction(String name, int x) {
        if (HandlerTracker.VERBOSE_HANDLERS) {
            System.out.println("report service setting action " + x +
                    " on handler " + name);
        }
        if (x < 200) {
            HandlerTracker.getServerInstance().setHandlerAction(name, x);
        } else {
            HandlerTracker.getServerInstance().setHandleFaultAction(name, x);
        }
    }

    public List<String> getReport(String reportName) {
        if (reportName.equals(REPORT_CALLED_HANDLERS)) {
            return HandlerTracker.getServerInstance().getCalledHandlers();
        }
        if (reportName.equals(REPORT_CLOSED_HANDLERS)) {
            return HandlerTracker.getServerInstance().getClosedHandlers();
        }
        if (reportName.equals(REPORT_DESTROYED_HANDLERS)) {
            return HandlerTracker.getServerInstance().getDestroyedHandlers();
        }
        System.err.println("ERROR: server didn't understand report type: " +
                reportName);
        throw new RuntimeException("invalid understand report type: " +
                reportName);
    }

    public void clearHandlerTracker() {
        if (HandlerTracker.VERBOSE_HANDLERS) {
            System.out.println("report service clearing tracker");
        }
        HandlerTracker.getServerInstance().clearAll();
    }

    public void clearCalledHandlers() {
        if (HandlerTracker.VERBOSE_HANDLERS) {
            System.out.println("report service clearing called handlers");
        }
        HandlerTracker.getServerInstance().clearCalledHandlers();
    }

    // util

    // todo: does List<String>.toArray make String[] or Object[]?
    private String [] toStringArray(List<String> list) {
        String [] s = new String[list.size()];
        for (int i=0; i< s.length; i++) {
            s[i] = list.get(i);
        }
        return s;
    }

}
