package io.tedcadet.rp.sec02;

import io.tedcadet.rp.courseutil.Util;
import io.tedcadet.rp.sec02.assignment.MycStockPricePublisher;
import io.tedcadet.rp.sec02.assignment.StockPriceSubscriber;

public class Assignment {
    public static void main(String[] args) {
        MycStockPricePublisher mycStockPricePublisher = new MycStockPricePublisher();

        mycStockPricePublisher.publish()
                .subscribeWith(new StockPriceSubscriber());

        Util.sleepSeconds(5);
    }
}
