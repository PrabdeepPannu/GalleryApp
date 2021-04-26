package com.crud.backend.UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.crud.backend.model.Graph;
import com.crud.backend.service.MetricService;

import org.junit.jupiter.api.Test;

public class MetricServiceTests {

    List<Graph> dummyGraphData = Arrays.asList(new Graph(10000.0, new Date(2020, 01, 01), ""),
            new Graph(20000.0, new Date(2020, 01, 01), ""), new Graph(50000.0, new Date(2020, 01, 01), ""),
            new Graph(30000.0, new Date(2020, 01, 01), ""), new Graph(60000.0, new Date(2020, 01, 01), ""),
            new Graph(40000.0, new Date(2020, 01, 01), ""));

    List<Graph> dummyNullValue = Arrays.asList(new Graph());

    List<Graph> dummyEmptyValue = Arrays.asList();

    // run test adding graph
    @Test
    void getMaxValue() {
        MetricService metricSerice = new MetricService();
        double maxValue = metricSerice.getMaxValue(dummyGraphData);
        assertEquals(60000.0, maxValue);
    }

    // run test on null values
    @Test
    void getMaxValueWithNull() {
        MetricService metricSerice = new MetricService();
        double maxValue = metricSerice.getMaxValue(null);
        assertEquals(0.0, maxValue);
    }

    // run test on empty Object
    @Test
    void getMaxValueEmptyGraphData() {
        MetricService metricSerice = new MetricService();
        double maxValue = metricSerice.getMaxValue(dummyNullValue);
        assertEquals(0.0, maxValue);
    }

    // run test on Empty List
    @Test
    void getMaxValueWithEmptyData() {
        MetricService metricSerice = new MetricService();
        double maxValue = metricSerice.getInflation(dummyEmptyValue);
        assertEquals(0.0, maxValue);
    }

    // run test adding graph
    @Test
    void getInflation() {
        MetricService metricSerice = new MetricService();
        double inflation = metricSerice.getInflation(dummyGraphData);
        assertEquals(33.0, inflation);
    }

    // run test on null values
    @Test
    void getInflationWithNull() {
        MetricService metricSerice = new MetricService();
        double inflation = metricSerice.getInflation(null);
        assertEquals(0.0, inflation);
    }

    @Test
    void getInflationEmptyGraphData() {
        MetricService metricSerice = new MetricService();
        double inflation = metricSerice.getInflation(dummyNullValue);
        assertEquals(0.0, inflation);
    }

    @Test
    void getInflationWithEmptyData() {
        MetricService metricSerice = new MetricService();
        double inflation = metricSerice.getInflation(dummyEmptyValue);
        assertEquals(0.0, inflation);
    }

    // run test adding graph
    @Test
    void getHitArray() {
        MetricService metricSerice = new MetricService();
        List<Double> hits = metricSerice.getHitArray(dummyGraphData);
        assertEquals(Arrays.asList(10000.0, 20000.0, 50000.0, 30000.0, 60000.0, 40000.0), hits);
    }

    // run test on null values
    @Test
    void getHitArrayWithNull() {
        MetricService metricSerice = new MetricService();
        List<Double> hits = metricSerice.getHitArray(null);
        assertEquals(Arrays.asList(), hits);
    }

    // run test on empty Object
    @Test
    void getHitArrayEmptyGraphData() {
        MetricService metricSerice = new MetricService();
        List<Double> hits = metricSerice.getHitArray(dummyNullValue);
        assertEquals(Arrays.asList(), hits);
    }

    // run test on Empty List
    @Test
    void getHitArrayWithEmptyData() {
        MetricService metricSerice = new MetricService();
        List<Double> hits = metricSerice.getHitArray(dummyEmptyValue);
        assertEquals(Arrays.asList(), hits);
    }

}
