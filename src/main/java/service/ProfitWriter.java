package service;

import entity.ProfitEntity;
import util.MathUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfitWriter {

    public void writeToOutputFile(String filename, List<ProfitEntity> profitList) throws
            IOException{
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            Iterator<ProfitEntity> iterator = profitList.iterator();
            List<String> titles = new ArrayList<>();
            titles.add("BaseCurrency"); titles.add("WantedCurrency"); titles.add("AmountInBaseCurrency");
            titles.add("StandardRate"); titles.add("FinalRate"); titles.add("ProfitInWantedCurrency");
            titles.add("ProfitInSGD");
            writeLine(writer, titles);
            while(iterator.hasNext()){
                ProfitEntity profitEntity = iterator.next();
                List<String> outputStr = new ArrayList<>();
                outputStr.add(profitEntity.getBasedCcy());
                outputStr.add(profitEntity.getWantedCcy());
                outputStr.add(Double.toString(MathUtil.roundAmount(profitEntity.getAmountInBaseCcy())));
                outputStr.add(Double.toString(MathUtil.roundRate(profitEntity.getStandardRate())));
                outputStr.add(Double.toString(MathUtil.roundRate(profitEntity.getFinalRate())));
                outputStr.add(Double.toString(MathUtil.roundAmount(profitEntity.getProfitInWantedCcy())));
                outputStr.add(Double.toString(MathUtil.roundAmount(profitEntity.getProfitInShopBasedCcy())));
                writeLine(writer, outputStr);
            }
            writer.close();
        } catch (IOException e) {
            throw new IOException("Unable to write file.", e);
        }
    }

    //writing file


    private static final char DEFAULT_SEPARATOR = ',';

    private static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    private static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }

    private static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());
    }




}
