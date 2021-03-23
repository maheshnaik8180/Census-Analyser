package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

    public class CensusAnalyserTest {

        private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
        private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
        private static final String WRONG_DELIMITER_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusDataWrongDelimiter.csv";
        private static final String WRONG_TYPE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.txt";
        private static final String INDIA_STATE_CSV_FILE_PATH = "./src/test/resources/IndiaStateCode.csv";
        private static final String WRONG_HEADER_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusDataWrongHeader.csv";
        private static final String INDIA_STATE_WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";



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
        public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndiaCensusData(WRONG_HEADER_CSV_FILE_PATH);
            } catch (CensusAnalyserException e) {
                Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
            }
        }

        @Test
        public void givenIndiaCensusData_WithWrongDelimiter_ShouldThrowException() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_CSV_FILE_PATH);
            } catch (CensusAnalyserException e) {
                Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
            }
        }


        @Test
        public void given_wrong_file_type_should_ReturnExactCount()  {

                try {
                    CensusAnalyser censusAnalyser = new CensusAnalyser();
                    ExpectedException exceptionRule = ExpectedException.none();
                    exceptionRule.expect(CensusAnalyserException.class);
                    censusAnalyser.loadIndiaCensusData(WRONG_TYPE_CSV_FILE_PATH);
                } catch (CensusAnalyserException e) {
                    Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
                }
            }

        @Test
        public void givenIndiaStateCSV_ShouldReturnExactCount()  {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                int numOfStateCode = censusAnalyser.loadIndianStateCode(INDIA_STATE_CSV_FILE_PATH);
                Assert.assertEquals(37,numOfStateCode);
            } catch (CensusAnalyserException e) {}
        }


        @Test
        public void givenIndiaStateData_WithWrongFile_ShouldThrowException() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndianStateCode(WRONG_TYPE_CSV_FILE_PATH);
            } catch (CensusAnalyserException e) {
                Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
            }
        }





        @Test
        public void givenIndiaStateData_WithWrongType_ShouldThrowException() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndianStateCode(WRONG_TYPE_CSV_FILE_PATH);
            } catch (CensusAnalyserException e) {
                Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
            }
        }





    }

