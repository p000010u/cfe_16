package com.teragrep.cfe_16.event.time.candidates;

import com.teragrep.cfe_16.event.time.Instantiable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public final class HECTimestampCandidateTest {

    @Test
    void test10Digits() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1234567890");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1234567890000L, i.toInstant().toEpochMilli());
    }

    @Test
    void test13Digits() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1234567899999");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1234567899999L, i.toInstant().toEpochMilli());
    }

    @Test
    void test16Digits() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1234567899999999");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1234567899999L, i.toInstant().toEpochMilli());
    }

    @Test
    void test19Digits() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1234567899999999999");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1234567899999L, i.toInstant().toEpochMilli());
    }

    @Test
    void testOtherAmountOfDigits() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("12345678999999999999999");
        Assertions.assertTrue(i.isStub());
    }

    @Test
    void testEndsInPeriod() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1433188255000L, i.toInstant().toEpochMilli());
    }

    @Test
    void test1DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.1");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1433188255100L, i.toInstant().toEpochMilli());
    }

    @Test
    void test2DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.12");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1433188255120L, i.toInstant().toEpochMilli());
    }

    @Test
    void test3DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.123");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1433188255123L, i.toInstant().toEpochMilli());
    }

    @Test
    void test4DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.1234");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(14331882551234L, i.toInstant().toEpochMilli());
    }

    @Test
    void test5DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.12345");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(143318825512345L, i.toInstant().toEpochMilli());
    }

    @Test
    void test6DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.123456");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1433188255123456L, i.toInstant().toEpochMilli());
    }

    @Test
    void test7DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.1234567");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(14331882551234567L, i.toInstant().toEpochMilli());
    }

    @Test
    void test8DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.12345678");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(143318825512345678L, i.toInstant().toEpochMilli());
    }

    @Test
    void test9DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.123456789");
        Assertions.assertFalse(i.isStub());
        Assertions.assertEquals(1433188255123456789L, i.toInstant().toEpochMilli());
    }

    @Test
    void test10DecimalPlaces() {
        final HECTimestampCandidate candidates = new HECTimestampCandidateImpl();
        final Instantiable i = candidates.toInstantiable("1433188255.1234567890");
        Assertions.assertTrue(i.isStub());
    }
}
