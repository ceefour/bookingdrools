package com.sample;

import java.math.BigDecimal;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");

            StockService stockSvc = new StockService();
            PersonKarmaService personKarmaSvc = new PersonKarmaService();
            ksession.setGlobal("stockSvc", stockSvc);
            ksession.setGlobal("personKarmaSvc", personKarmaSvc);
            
            System.out.println("=== Kondisi stock sebelum booking");
            stockSvc.stockReport();
            System.out.println("=== Karma sebelum booking");
            personKarmaSvc.report();
            
            // go !
            ProductRequest[] actions = new ProductRequest[] {
            		new BookProduct("rudi", "zibalabel_t01", 1.0),
            		new BookProduct("atang", "zibalabel_t01", 1.0),
            		new BookProduct("atang", "zibalabel_t02", 1.0),
            		new BookProduct("atang", "zibalabel_t03", 2.0),
            		new CancelProductBooking("atang", "zibalabel_t03", 1.0),
            		new BookProduct("atang", "zibalabel_t03", 1.0),
            };
            System.out.println("=== Memproses booking...");
            for (ProductRequest action : actions) {
            	ksession.insert(action);
                ksession.fireAllRules();
            }
            
            // tampilkan hasil booking
            System.out.println("=== Proses booking selesai, hasilnya adalah...");
            for (Object obj : ksession.getObjects()) {
            	System.out.println(obj);
//            	if (obj instanceof ProductBooking) {
//            		ProductBooking booking = (ProductBooking) obj;
//                	System.out.println(booking);
//            	}
            }
            
            System.out.println("=== Kondisi stock setelah booking");
            stockSvc.stockReport();
            System.out.println("=== Karma setelah booking");
            personKarmaSvc.report();
            
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("booking.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("karma.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
