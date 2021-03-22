package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

    public class CensusAnalyserTest {

        private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
        private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
        private static final String WRONG_TYPE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.txt";
        @Test
        public void givenIndianCensusCSVFileReturnsCorrectRecords() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
                System.out.println(numOfRecords);
                Assert.assertEquals(29,numOfRecords);
            } catch (CensusAnalyserException e)
            {
                System.out.println("Exception Occurs");
            }
        }

        @Test
        public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
            } catch (CensusAnalyserException e) {
                Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
            }
        }

        @Test
        public void givenIndiaStateCSV_ShouldReturnExactCount()  {

                try {
                    CensusAnalyser censusAnalyser = new CensusAnalyser();
                    ExpectedException exceptionRule = ExpectedException.none();
                    exceptionRule.expect(CensusAnalyserException.class);
                    censusAnalyser.loadIndiaCensusData(WRONG_TYPE_CSV_FILE_PATH);
                } catch (CensusAnalyserException e) {
                    Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
                }
            }
    }

