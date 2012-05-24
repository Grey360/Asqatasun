/*
 *  Tanaguru - Automated webpage assessment
 *  Copyright (C) 2008-2011  Open-S Company
 * 
 *  This file is part of Tanaguru.
 * 
 *  Tanaguru is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 * 
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.service.command;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;
import org.apache.commons.httpclient.HttpStatus;
import org.easymock.EasyMock;
import org.opens.tanaguru.contentadapter.AdaptationListener;
import org.opens.tanaguru.entity.audit.Audit;
import org.opens.tanaguru.entity.audit.AuditStatus;
import org.opens.tanaguru.entity.audit.Content;
import org.opens.tanaguru.entity.audit.SSP;
import org.opens.tanaguru.entity.parameterization.Parameter;
import org.opens.tanaguru.entity.reference.Test;
import org.opens.tanaguru.entity.service.audit.AuditDataService;
import org.opens.tanaguru.entity.service.audit.ContentDataService;
import org.opens.tanaguru.entity.service.audit.ProcessResultDataService;
import org.opens.tanaguru.entity.service.parameterization.ParameterDataService;
import org.opens.tanaguru.entity.service.reference.TestDataService;
import org.opens.tanaguru.entity.service.subject.WebResourceDataService;
import org.opens.tanaguru.entity.subject.WebResource;
import org.opens.tanaguru.service.AnalyserService;
import org.opens.tanaguru.service.ConsolidatorService;
import org.opens.tanaguru.service.ContentAdapterService;
import org.opens.tanaguru.service.ProcessorService;
import org.opens.tanaguru.util.MD5Encoder;

/**
 *
 * @author jkowalczyk
 */
public class AuditCommandImplTest extends AuditCommandTestCase {

    public AuditCommandImplTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getAudit method, of class AuditCommandImpl.
     */
    public void testSetGetAudit() {
        System.out.println("getAudit");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        instance.setAudit(mockAudit);
        assertEquals(mockAudit, instance.getAudit());
    }

    /**
     * Test of getAuditDataService method, of class AuditCommandImpl.
     */
    public void testGetAuditDataService() {
        System.out.println("getAuditDataService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();
        
        AuditDataService result = instance.getAuditDataService();
        assertEquals(mockAuditDataService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getTestDataService method, of class AuditCommandImpl.
     */
    public void testGetTestDataService() {
        System.out.println("getTestDataService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();
        
        TestDataService result = instance.getTestDataService();
        assertEquals(mockTestDataService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getParameterDataService method, of class AuditCommandImpl.
     */
    public void testGetParameterDataService() {
        System.out.println("getParameterDataService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        ParameterDataService result = instance.getParameterDataService();
        assertEquals(mockParameterDataService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getWebResourceDataService method, of class AuditCommandImpl.
     */
    public void testGetWebResourceDataService() {
        System.out.println("getWebResourceDataService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        WebResourceDataService result = instance.getWebResourceDataService();
        assertEquals(mockWebResourceDataService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getContentDataService method, of class AuditCommandImpl.
     */
    public void testGetContentDataService() {
        System.out.println("getContentDataService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        ContentDataService result = instance.getContentDataService();
        assertEquals(mockContentDataService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getProcessResultDataService method, of class AuditCommandImpl.
     */
    public void testGetProcessResultDataService() {
        System.out.println("getProcessResultDataService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        ProcessResultDataService result = instance.getProcessResultDataService();
        assertEquals(mockProcessResultDataService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getContentAdapterService method, of class AuditCommandImpl.
     */
    public void testGetContentAdapterService() {
        System.out.println("getContentAdapterService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        ContentAdapterService result = instance.getContentAdapterService();
        assertEquals(mockContentAdapterService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getProcessorService method, of class AuditCommandImpl.
     */
    public void testGetProcessorService() {
        System.out.println("getProcessorService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        ProcessorService result = instance.getProcessorService();
        assertEquals(mockProcessorService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getConsolidatorService method, of class AuditCommandImpl.
     */
    public void testGetConsolidatorService() {
        System.out.println("getConsolidatorService");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        ConsolidatorService result = instance.getConsolidatorService();
        assertEquals(mockConsolidatorService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getAnalyserService method, of class AuditCommandImpl.
     */
    public void testGetAnalyserService() {
        System.out.println("getAnalyserService");
        
        mockInitialisationCalls(true);

        AuditCommandImpl instance = new TestAuditCommandImpl();

        AnalyserService result = instance.getAnalyserService();
        assertEquals(mockAnalyserService, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of getAdaptationListener method, of class AuditCommandImpl.
     */
    public void testGetAdaptationListener() {
        System.out.println("getAdaptationListener");
        
        mockInitialisationCalls(true);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();

        AdaptationListener result = instance.getAdaptationListener();
        assertEquals(mockAdaptationListener, result);
        
        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
    }

    /**
     * Test of adaptContent method, of class AuditCommandImpl.
     */
    public void testAdaptContent() {
        System.out.println("adaptContent");
        
        mockInitialisationCalls(false);

        WebResource mockWr = EasyMock.createMock(WebResource.class);
        
        EasyMock.expect(mockAudit.getId()).andReturn(Long.valueOf(1)).once();
        EasyMock.expect(mockAuditDataService.getAuditWithWebResource(Long.valueOf(1))).andReturn(mockAudit).once();
        EasyMock.expect(mockAudit.getStatus()).andReturn(AuditStatus.CONTENT_ADAPTING).once();
        EasyMock.expect(mockAudit.getSubject()).andReturn(mockWr).times(2);
        EasyMock.expect(mockWr.getId()).andReturn(Long.valueOf(1)).once();
        
        EasyMock.expect(mockContentDataService.getNumberOfSSPFromWebResource(
                mockWr, 
                HttpStatus.SC_OK)).andReturn(Long.valueOf(49)).once();
        
        List<Long> longList = new ArrayList<Long>(25);
        EasyMock.expect(mockContentDataService.getSSPFromWebResource(
                Long.valueOf(1), 
                HttpStatus.SC_OK,
                0, 
                AuditCommandImpl.ADAPTATION_TREATMENT_WINDOW)).andReturn(longList).once();
        
        EasyMock.expect(mockContentDataService.getSSPFromWebResource(
                Long.valueOf(1), 
                HttpStatus.SC_OK,
                AuditCommandImpl.ADAPTATION_TREATMENT_WINDOW, 
                AuditCommandImpl.ADAPTATION_TREATMENT_WINDOW)).andReturn(longList).once();
        
        // the adaptContent must return at least one non empty SSP
        SSP mockSSP = EasyMock.createMock(SSP.class);
        EasyMock.expect(mockSSP.getDOM()).andReturn("Not Empty String").times(3);
        EasyMock.expect(mockSSP.getSource()).andReturn("Not Empty String").times(2);
        try {
            mockSSP.setSource(MD5Encoder.MD5("Not Empty String"));
            EasyMock.expectLastCall().times(2);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuditCommandImplTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AuditCommandImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Content> mockAdaptedContentList = new ArrayList<Content>();
        mockAdaptedContentList.add(mockSSP);
        
        EasyMock.expect(mockContentAdapterService.adaptContent(new ArrayList<Content>())).
                andReturn(mockAdaptedContentList).times(2);
        
        EasyMock.expect(mockContentDataService.saveOrUpdate(mockSSP)).
                andReturn(mockSSP).times(2);
        
        mockAudit.setStatus(AuditStatus.PROCESSING);
        EasyMock.expectLastCall().once();
        
        EasyMock.expect(mockAuditDataService.saveOrUpdate(mockAudit)).andReturn(mockAudit).once();
        
        EasyMock.replay(mockAudit);
        EasyMock.replay(mockWr);
        EasyMock.replay(mockAuditDataService);
        EasyMock.replay(mockContentDataService);
        EasyMock.replay(mockContentAdapterService);
        EasyMock.replay(mockTestDataService);
        EasyMock.replay(mockParameterDataService);
        EasyMock.replay(mockSSP);
        
        AuditCommandImpl instance = new TestAuditCommandImpl();
        
        instance.adaptContent();

        EasyMock.verify(mockAuditDataService);
        EasyMock.verify(mockTestDataService);
        EasyMock.verify(mockContentDataService);
        EasyMock.verify(mockContentAdapterService);
        EasyMock.verify(mockParameterDataService);
        EasyMock.verify(mockAudit);
        EasyMock.verify(mockWr);
        EasyMock.verify(mockSSP);
    }

    /**
     * Test of process method, of class AuditCommandImpl.
     */
    public void testProcess() {
        System.out.println("process");
        AuditCommandImpl instance = null;
//        instance.process();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of consolidate method, of class AuditCommandImpl.
     */
    public void testConsolidate() {
        System.out.println("consolidate");
        AuditCommandImpl instance = null;
//        instance.consolidate();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of analyse method, of class AuditCommandImpl.
     */
    public void testAnalyse() {
        System.out.println("analyse");
        AuditCommandImpl instance = null;
//        instance.analyse();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatusToAudit method, of class AuditCommandImpl.
     */
    public void testSetStatusToAudit() {
        System.out.println("setStatusToAudit");
        AuditStatus auditStatus = null;
        AuditCommandImpl instance = null;
//        instance.setStatusToAudit(auditStatus);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    public class TestAuditCommandImpl extends AuditCommandImpl {

        public TestAuditCommandImpl() {
            super(
                    null, 
                    mockAuditDataService, 
                    mockTestDataService, 
                    mockParameterDataService, 
                    mockWebResourceDataService, 
                    mockContentDataService, 
                    mockProcessResultDataService, 
                    mockContentAdapterService, 
                    mockProcessorService, 
                    mockConsolidatorService, 
                    mockAnalyserService, 
                    mockAdaptationListener);
        }

        @Override
        public void init() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void loadContent() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
