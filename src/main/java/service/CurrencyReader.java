package service;

import entity.EnumClienType;
import entity.RateEntity;
import entity.TransactionEntity;
import util.TimeStampUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class CurrencyReader {

    public List<RateEntity> readRates(String filename){
        List<String> lines = readFile(filename);
        Iterator<String> lineIterator = lines.iterator();
        List<RateEntity> rates = new ArrayList<>();
        try {
            while (lineIterator.hasNext()) {
                List<String> cols = readCsvLine(lineIterator.next());
                rates.add(new RateEntity(cols.get(0), cols.get(1),
                        Double.valueOf(cols.get(2)), TimeStampUtil.convertStringToTimeStamp(cols.get(3))));
            }
            return rates;
        }catch(IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Invalid inputs", e);
        }
    }

    public List<TransactionEntity> readTransactions(String filename){
        List<String> lines = readFile(filename);
        Iterator<String> lineIterator = lines.iterator();
        List<TransactionEntity> transactions = new ArrayList<>();
        lineIterator.next();
        try{
            while(lineIterator.hasNext()){
                List<String> cols = readCsvLine(lineIterator.next());
                transactions.add(new TransactionEntity(cols.get(0), cols.get(1),
                        Float.valueOf(cols.get(2)), EnumClienType.valueOf(cols.get(3).toUpperCase()),
                        TimeStampUtil.convertStringToTimeStamp(cols.get(4))));
            }
            return transactions;
        }catch(IndexOutOfBoundsException e){
            throw new IllegalArgumentException("Invalid inputs", e);
        }
    }


    private List<String> readFile(String filename){
        String line;
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to read file");
        }
    }

    private List<String> readCsvLine(String line){
        String[] columns = line.split(",");
        return Arrays.asList(columns);
    }



}
