package com.allodoc.tn.covibed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.allodoc.tn.covibed.dao.ITempBedDao;
import com.allodoc.tn.covibed.model.TempBed;

@SpringBootTest
class CovibedApplicationTests {
    @Autowired
    ITempBedDao tdao;
    @Test
    void contextLoads() {

    }

//    @Test
//    void addBed() {
//        System.out.println("------------start");
//        for(int i=1;i<1001;i++) {
//            TempBed b = new TempBed();
//            b.setAvailability(true);
//            b.setGravity(0);
//            b.setIntubation(false);
//            b.setO2(0);
//            b.setType("tmp");
//            b.setLabel("Lit-Tmp-"+i);;
//            tdao.save(b)    ;
//        }
//        System.out.println("------------end");
//
//    }

}
