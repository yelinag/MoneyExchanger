package manager;

import entity.ProfitEntity;
import entity.RateEntity;
import entity.TransactionEntity;
import service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exchanger {

    public static final String DEFAULT_CURRENCY = "USD";
    public static final String BASED_CURRENCY = "SGD";

    private String ratesFilename;
    private String transactionsFilename;
    private String outputFilename;

    public Exchanger(String ratesFilename, String transactionsFilename, String outputFilename){
        this.ratesFilename = ratesFilename;
        this.transactionsFilename = transactionsFilename;
        this.outputFilename = outputFilename;
    }

    public void process(){
        try {
            CurrencyReader reader = new CurrencyReader();
            List<RateEntity> rates = reader.readRates(this.ratesFilename);
            List<TransactionEntity> transactions = reader.readTransactions(this.transactionsFilename);
            Iterator<TransactionEntity> transactionIterator = transactions.iterator();
            List<ProfitEntity> profitEntityList = new ArrayList<>();
            while (transactionIterator.hasNext()) {
                TransactionEntity transactionEntity = transactionIterator.next();
                double finalRate = RateCalculator.getInstance(rates, DEFAULT_CURRENCY)
                        .getCurrencyFinalRate(transactionEntity);
                double actualRate = CurrencyMatcher.getInstance(rates).getCurrencyActualRate(transactionEntity.getBasedCurrecny(),
                        transactionEntity.getWantedCurrency(), transactionEntity.getTransactionTime());
                profitEntityList.add(ProfitCalculator.getInstance(rates, BASED_CURRENCY)
                        .buildProfitEntity(transactionEntity, actualRate, finalRate));
            }
            ProfitWriter writer = new ProfitWriter();
            writer.writeToOutputFile(outputFilename, profitEntityList);
        }catch(IOException e){
            e.printStackTrace();
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }
    }

}
