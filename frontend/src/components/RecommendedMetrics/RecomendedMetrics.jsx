import React, { useEffect, useState } from "react";
import { CardsRow } from "../common";
import { CardMetrics } from "../fieldTypes";
import "./RecommendedMetrics.css";
import Model from "../../model/Model";

export const RecommendedMetrics = () => {
  const [metrics, setMetrics] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const metric = new Model("metric");
      const result = await metric.getRecommendedData();
      setMetrics(result);
    };
    fetchData();
  }, []);

  const handelMoreButton = async (e) => {
    const metric = new Model("metric");
    const result = await metric.list();
    setMetrics(result);
  };

  const handelLessButton = async () => {
    const metric = new Model("metric");
    const result = await metric.getRecommendedData();
    setMetrics(result);
  };

  return (
    <CardsRow
      headding="Recommended Metrics"
      name="Metrics"
      onMoreClick={handelMoreButton.bind(this)}
      onLessClick={handelLessButton.bind(this)}
    >
      {metrics.map((metric) => (
        <CardMetrics key={metric.id} data={metric}></CardMetrics>
      ))}
    </CardsRow>
  );
};
