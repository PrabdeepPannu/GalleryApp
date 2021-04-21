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
      const result = await metric.list();
      setMetrics(result);
    };
    fetchData();
  }, []);
  return (
    <CardsRow headding="Recommended Metrics" name="Metrics">
      {metrics.map((metric) => (
        <CardMetrics key={metric.id} data={metric}></CardMetrics>
      ))}
    </CardsRow>
  );
};
